// SPDX-License-Identifier: MIT
// An example of a consumer contract that relies on a subscription for funding.
pragma solidity ^0.8.7;

import "./lib/Address.sol";
import "./lib/SafeMath.sol";
import "@chainlink/contracts/src/v0.8/interfaces/VRFCoordinatorV2Interface.sol";
import "@chainlink/contracts/src/v0.8/VRFConsumerBaseV2.sol";

contract RequestVRFNumber is VRFConsumerBaseV2(0x6168499c0cFfCaCD319c818142124B7A15E857ab) {

  using SafeMath for uint;
  using Address for address;

  VRFCoordinatorV2Interface constant COORDINATOR =
        VRFCoordinatorV2Interface(0x6168499c0cFfCaCD319c818142124B7A15E857ab);
  bytes32 constant KEY_HASH =
        0xd89b2bf150e3b9e13446986e571fb9cab24b13cea0a43ea20a6049a85cc807cc;
  uint64 constant SUBSCRIPTION_ID = 6827; // https://vrf.chain.link
  uint32 constant CALLBACK_GAS_LIMIT = 1000000;
  uint32 constant NUM_WORDS = 1;
  uint16 constant REQUEST_CONFIRMATIONS = 3;

  uint256[] public s_randomWords;
  uint256 public s_requestId;
  uint public randomResult;
  address s_owner;

  constructor()  {
    s_owner = msg.sender;
  }

  function requestRandomWords() public returns (uint) {
    s_requestId = COORDINATOR.requestRandomWords(
      KEY_HASH,
      SUBSCRIPTION_ID,
      REQUEST_CONFIRMATIONS,
      CALLBACK_GAS_LIMIT,
      NUM_WORDS
    );
    return s_requestId;
  }
  
  function fulfillRandomWords(
    uint256, /* requestId */
    uint256[] memory randomWords
  ) internal override {
    s_randomWords = randomWords;
    randomResult = randomWords[0].mod(100).add(1);
  }

  modifier onlyOwner() {
    require(msg.sender == s_owner);
    _;
  }

  function getResult() public view returns (uint) {
    return randomResult;
  }
}