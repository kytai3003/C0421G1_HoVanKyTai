// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

import "./lib/Address.sol";
import "./lib/SafeMath.sol";
import "./RequestVRFNumber.sol";
import "@openzeppelin/contracts-upgradeable/token/ERC20/ERC20Upgradeable.sol";
import "@openzeppelin/contracts-upgradeable/access/OwnableUpgradeable.sol";
import "@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol";

contract LotteryUpgradable is 
    Initializable,
    OwnableUpgradeable,
    ERC20Upgradeable
{

    //-----------------------------------------Chainlink----------------------------------------
    RequestVRFNumber requestContract;
    uint public randomResult;

    //-----------------------------------------Libraries----------------------------------------
    using SafeMath for uint;
    using Address for address;

    //-----------------------------------------Variable----------------------------------------
    address payable[] public players;
    address payable public winner;
    uint256 public lotteryID;
    uint256 public costPerTicket;
    uint256 public startingTimestamp;
    uint256 private closingTimestamp;
    bool public isWinnerWithdraw;
    bool isRequest;
    uint256[] private _randomNumbers;
    uint private availableCount;
    uint private count;
    
    //-----------------------------------------Structs----------------------------------------
    struct LotteryInfo {
        uint256 _lotteryID;
        uint256 _costPerTicket;
        uint256 _startingTimestamp;
        uint256 _closingTimestamp;
        address _winner;
        uint256 _randomResult;
    }
    LotteryInfo public currentLottery;

    //-----------------------------------------Enums----------------------------------------
    enum Status {
        NOT_STARTED, // The lottery is not started yet
        OPEN, // The lottery is open for ticket purchases
        CLOSED, // The lottery is no longer open for ticket purchases
        COMPLETED // The lottery has been closed and the winner picked
    }
    Status public lotteryStatus;

    //-----------------------------------------Events----------------------------------------
    event ClaimedReward(uint256 lotteryId);
    event CompletedLottery(uint256 lotteryId);
    event OpenedLottery(uint256 lotteryId);
    event RequestedRandomWords(uint256 requestId);
    event Bought(uint amount);

    //-----------------------------------------Mappings----------------------------------------
    mapping (address => uint[]) public playerTicketNumbers;
    mapping (uint => LotteryInfo) public allLotteries;
    mapping (uint => address) public choosenNumber;
    mapping (address => uint) public limitedAmount;

    //-----------------------------------------Modifiers---------------------------------------  
    modifier onlyWinnerOrOwner() {
        require(
            msg.sender == winner || msg.sender == owner(),
            "Only winner can claim reward!"
        );
        _;
    }

    modifier onlyPlayer() {
        require(msg.sender != owner(),
         "Owner can not join."
         );
         _;
    }

    modifier limitedBuy(uint _ticketAmount) {
        require(limitedAmount[msg.sender] + _ticketAmount <= 20,
        "Maximum limited."
        );
        _;
    }

    modifier ifNotStarted() {
        require(lotteryStatus == Status.NOT_STARTED,
        "Previous lottery is not ended."
        );
        _;
    }

    modifier ifOpen() {
        require(
            lotteryStatus == Status.OPEN,
            "The lottery has not started yet!"
        );
        require(
            block.timestamp < closingTimestamp,
            "Time is over!"
        );
        _;
    }

    modifier ifCompleted() {
        require(
            lotteryStatus == Status.COMPLETED,
            "The lottery has not completed yet!"
        );
        _;
    }

    modifier outOfTicket(uint _ticketNum) {
        require(
            availableCount >= _ticketNum,
            "Out of ticket."
        );
        _;
    }

    uint public x;
    address public y;
    uint public z;


    //-----------------------------------------Constructor-------------------------------------
    function initialize(string memory _name, string memory _symbol) external initializer {
            __Ownable_init();
            __ERC20_init(_name, _symbol);
            requestContract = RequestVRFNumber(0x5Ed1fDFA194f30CB9e28F126A843d1368F82DEcB);
            fillTheNumber();
            shuffleNumbers();
            lotteryStatus = Status.NOT_STARTED;
            availableCount = 99;
            count = 0;
        }

    //  ------------------------------------------------------------------------------------------
    //  |                                              |                                          |
    //  |                                          Functions                                      |
    //  |                                              |                                          |
    //  ------------------------------------------------------------------------------------------
    function startNewLottery(uint256 _costPerTicket) external onlyOwner ifNotStarted {
        require(_costPerTicket > 0, "Invalid input.");
        costPerTicket = _costPerTicket;
        startingTimestamp = block.timestamp;
        closingTimestamp = startingTimestamp + 5 minutes;

        currentLottery._lotteryID = lotteryID;
        currentLottery._costPerTicket = _costPerTicket;
        currentLottery._startingTimestamp = startingTimestamp;
        currentLottery._closingTimestamp = closingTimestamp;

        lotteryStatus = Status.OPEN;
        isWinnerWithdraw = false;
        emit OpenedLottery(lotteryID);
    }

    function getPlayerNumbers() public view returns(uint[] memory) {
        return playerTicketNumbers[msg.sender];
    }

    function getCurrentGame() public view returns(LotteryInfo memory) {
        return currentLottery;
    }

    function getLotteryInfo(uint lottery) public view returns (LotteryInfo memory) {
        return allLotteries[lottery];
    }

    function fillTheNumber() private {
        for(uint i = 1; i <= 99; i++) {
            _randomNumbers.push(i);
        }
    }
    
    function shuffleNumbers() private {
        uint256 timestamp = block.timestamp;
        for(uint256 i = _randomNumbers.length - 1 ; i > 0; i--) {
            uint256 swapIndex = timestamp % (_randomNumbers.length - i);
            uint256 currentIndex = _randomNumbers[i];
            uint256 indexToSwap = _randomNumbers[swapIndex];
            _randomNumbers[i] = indexToSwap;
            _randomNumbers[swapIndex] = currentIndex;
        }
    }

    function getTotalPlayer() public view returns(uint) {
        return players.length;
    }

    function getAvailableTicket() public view returns(uint) {
        return availableCount;
    }

    function buyTickets(uint _ticketAmount) public limitedBuy(_ticketAmount) outOfTicket(_ticketAmount) ifOpen onlyPlayer {
        uint totalToken = _ticketAmount * costPerTicket;
        require(getPlayerTokenBalance() >= totalToken, "Not enough token.");
        require(_ticketAmount > 0, "Must not be zero.");
        require(_ticketAmount <= 20, "Maximum 20 tickets per time.");
        for (uint i = 0; i < _ticketAmount; i++) {
            uint number = _randomNumbers[count];
            playerTicketNumbers[msg.sender].push(number);
            choosenNumber[number] = msg.sender;
            count++;
            availableCount--;
        }
        transfer(address(this), totalToken);
        limitedAmount[msg.sender] = limitedAmount[msg.sender].add(_ticketAmount);
        players.push(payable(msg.sender));
    }


    function getContractTokenBalance() public onlyOwner view returns(uint256){
       return balanceOf(address(this));
   }

   function getPlayerTokenBalance() public view returns(uint256){ 
       return balanceOf(msg.sender);
   }

    function getLotteryPrize() public onlyWinnerOrOwner  {
        require(isWinnerWithdraw == false, "Prize is withdrawn.");
        require(lotteryStatus == Status.CLOSED, "No winner or lotterry is not closed yet.");
        if (winner != address(0)) {
            transferFrom(owner(), winner, balanceOf(address(this)));
            _burn(address(this), balanceOf(address(this)));
            isWinnerWithdraw = true;
        }
        lotteryStatus == Status.COMPLETED;
        _addLottery();
        _reset();
        emit ClaimedReward(lotteryID);
    }

    function bingo() public onlyOwner {
        require(lotteryStatus == Status.CLOSED, "Lotterry is not closed yet.");
        randomResult = requestContract.randomResult();
        winner = payable(choosenNumber[randomResult]);
        if (winner != address(0)) {
            approve(winner, balanceOf(address(this)));
        } else {
            _addLottery();
            _reset();
        }
        emit CompletedLottery(lotteryID);
    }

    function closeLottery() public onlyOwner {
        require(block.timestamp > closingTimestamp, "Not ended.");
        require(isRequest == false, "Requested!.");
        uint requestID = requestContract.requestRandomWords();
        isRequest = true;
        lotteryStatus = Status.CLOSED;
        emit RequestedRandomWords(requestID);
    }

    function _addLottery() private {
        allLotteries[lotteryID++] = LotteryInfo(
            lotteryID,
            costPerTicket,
            startingTimestamp,
            closingTimestamp,
            winner,
            randomResult
        );
    }

    function _reset() private {
        fillTheNumber();
        shuffleNumbers();
        _resetPlayerData();
        isWinnerWithdraw = false;
        isRequest = false;
        availableCount = 99;
        count = 0;
        closingTimestamp = 0;
        costPerTicket = 0;
        lotteryStatus = Status.NOT_STARTED;
        players = new address payable[](0);
        delete currentLottery;
        randomResult = 0;
        startingTimestamp = 0;
        winner = payable(address(0));
    }

    function _resetPlayerData() private {
        for (uint256 i = 0; i < players.length; i++) {
            delete playerTicketNumbers[players[i]];
            limitedAmount[players[i]] = 0;
            delete choosenNumber[i];
        }
    }

    function buyToken() public payable {
        uint amountBuy = msg.value;
        require(amountBuy > 0, "Invalid value.");
        payable(owner()).transfer(amountBuy);
        _mint(msg.sender, amountBuy);
        emit Bought(amountBuy);
    }
}