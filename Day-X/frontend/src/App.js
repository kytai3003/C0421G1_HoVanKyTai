// Importing modules
import React, { useState } from "react";
import { ethers } from "ethers";
import "./App.css";
import { Button, Card } from "react-bootstrap";
import Background from "./img/background.jpg"
import "bootstrap/dist/css/bootstrap.min.css";
import LotteryContract from "./utils/LotteryUpgradable.json"

const lotteryAddress = `0x5739b378130Ed59F79063A8Ac1B0B712E083C402`;
const ownerAddress = `0xf9e9db76dbd52be6f07a8a61756567fea5c451c1`;
const provider = new ethers.providers.Web3Provider(window.ethereum);
let walletSigner = provider.getSigner();
const lotteryContract = new ethers.Contract(lotteryAddress, LotteryContract.abi, walletSigner);

function App() {
  // usetstate for storing and retrieving wallet details
  const [data, setdata] = useState({
    address: "",
    Balance: null,
  });

  let countdown = 60;

  async function startNewLottery() {
    try {
      if (data.account !== ownerAddress) {
        alert("Only owner can create new game.");
      } else {
        const price = parseInt(prompt("Ticket price: "));
        if (price > 0) {
          const transaction = await lotteryContract.startNewLottery(price);
          await transaction.wait();
          alert("Success.");
          // window.location.reload();
          currentLottery();
        } else {
          alert("Invalid input.")
        }
      }
    } catch(error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function getTokenBalance() {
    try {
      const tokenBalance = await lotteryContract.getPlayerTokenBalance();
      document.getElementById('tokenBalance').innerHTML = tokenBalance;
    } catch (error) {
      alert("Error.");
    }
  }

  async function bingo() {
    try {
      if (data.account !== ownerAddress) {
        alert("Only owner function.");
      } else {
        const result = await lotteryContract.getResult();
        const winner = await lotteryContract.getWinner();
        const transaction = await lotteryContract.bingo();
        await transaction.wait();
        alert("Lucky number is: " + result + "\r\nWinner: " + ((winner === '0x0000000000000000000000000000000000000000') ? "No winner." : winner));
        window.location.reload();
        btnhandler();
      }
    } catch (error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function closeLottery() {
    try {
      if (data.account !== ownerAddress) {
        alert("Only owner function.");
      } else {
        countdown = 60;
        const transaction = await lotteryContract.closeLottery();
        await transaction.wait();
        alert("Success. Wait > 40s for Bingo.");
        disableBingo();
        countdownBingo();
      }
    } catch (error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function getPrize() {
    try {
      const transaction = await lotteryContract.getLotteryPrize();
      await transaction.wait();
      alert("Success.");
      window.location.reload();
      btnhandler();
    } catch (error) { 
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function getLotteriesInfo() {
    try {
      const num = parseInt(prompt("Lottery id: "));
      if (isNaN(num) || num < 0) {
        alert("Input valid id.");
      } else {
        const previousLot = await lotteryContract.getLotteryInfo(num);
        if (previousLot[1] == 0) {
          alert("No info for lottery id " + num);
        } else {
          alert("Id: " + previousLot[0] + "\r\nTicket price: " + previousLot[1] + "\r\nWinner: " + ((previousLot[4] === '0x0000000000000000000000000000000000000000') ? "No winner." : previousLot[4]) + "\r\nLucky number: " + previousLot[5]);
        }
      }
    } catch (error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function currentLottery() {
      const currentLot = await lotteryContract.getCurrentGame();
      const ticketRemaning = await lotteryContract.getAvailableTicket();
      const prizePool = await lotteryContract.getContractTokenBalance();
      const toDatetimeStart = new Date(currentLot[2] * 1000);
      const toDatetimeClose = new Date(currentLot[3] * 1000);
      startTime();
      if (currentLot[1] > 0) {  
        document.getElementById('id').innerHTML = 'ID: <strong>' +  currentLot[0] + '</strong>';
        document.getElementById('price').innerHTML = 'Price: <strong>' +  currentLot[1] + '</strong>';
        document.getElementById('startTime').innerHTML = 'Starting time: <strong>'  + toDatetimeStart.getHours()+ ":" +toDatetimeStart.getMinutes()+":"+ toDatetimeStart.getSeconds() + '</strong>';
        document.getElementById('closeTime').innerHTML = 'Closing time: <strong>' + toDatetimeClose.getHours()+ ":" +toDatetimeClose.getMinutes()+":"+ toDatetimeClose.getSeconds() + '</strong>';
        document.getElementById('prizePool').innerHTML = 'Prize pool: <strong>' + prizePool + '</strong>';
        document.getElementById('ticketNum').innerHTML = 'Available ticket: <strong>' + ticketRemaning + '</strong>';
      } else {
        document.getElementById('price').innerHTML = '<h4>No game is running.</h4>';
        document.getElementById('prizePool').innerHTML = 'Prize pool: <strong>' + prizePool + '</strong>';
        document.getElementById('startTime').innerHTML = '';
        document.getElementById('closeTime').innerHTML = '';
        document.getElementById('ticketNum').innerHTML = '';
      }
  }

  function disableBingo() {
  const btn = document.getElementById("bingoBtn");
  btn.disabled = true;
  setTimeout(()=>{
    btn.disabled = false;
    }, 40000)
  }

  async function getNumbers() {
    try {
      const ticketArray = await lotteryContract.getPlayerNumbers();
      if (ticketArray.length > 0) {
        alert("Your number(s): " + ticketArray);
      } else if (data.account === ownerAddress) {
        alert("Onwer can not join.");
      } else {
        alert("Buy ticket to join us.");
      }
    } catch (error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  async function buyTickets() {
    try {
      if (data.account === ownerAddress) {
        alert("Onwer can not join.");
      } else {
        const amount = parseInt(prompt("Input ticket amount:", "1"));
        if (amount > 0) {
          const transaction = await lotteryContract.buyTickets(amount);
          await transaction.wait();
          const ticketArray = await lotteryContract.getPlayerNumbers();
          alert("Your number(s): " + ticketArray);
          currentLottery();
          btnhandler();
        } else {
          alert("Number only.");
        }
      }
    } catch (error) {
      alert("Error: " + error.error.message.replace('execution reverted:',''));
    }
  }

  // Button handler button for handling a
  // request event for metamask
  const btnhandler = () => {
  
    // Asking if metamask is already present or not
    if (window.ethereum) {
  
      // res[0] for fetching a first wallet
      window.ethereum
        .request({ method: "eth_requestAccounts" })
        .then((res) => accountChangeHandler(res[0]));
    } else {
      alert("install metamask extension!!");
    }
  };
  
  // getbalance function for getting a balance in
  // a right format with help of ethers
  const getbalance = (address) => {
  
    // Requesting balance method
    window.ethereum
      .request({ 
        method: "eth_getBalance", 
        params: [address, "latest"] 
      })
      .then((balance) => {
        // Setting balance
        setdata({
          account: address,
          Balance: ethers.utils.formatEther(balance),
        });
      });
  };
  
  // Function for getting handling all events
  const accountChangeHandler = (account) => {
    setdata({
      address: account,
    });
      getbalance(account);
      getTokenBalance();
  };

  function startTime() {
    const today = new Date(); 
    let h = today.getHours();
    let m = today.getMinutes();
    let s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =  h + ":" + m + ":" + s;
    setTimeout(startTime, 1000);
  }

  function countdownBingo() {
    countdown -= 1;

    if (countdown < 0) {
      document.getElementById('bingoBtn').innerHTML = "<strong>Bingo</strong>";
    } else {
      document.getElementById('bingoBtn').innerHTML = "(" + countdown + ")" + "<strong>Bingo</strong>";
    }
    setTimeout(countdownBingo, 1000);
  }
  
  function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
  };

  return (
    <div className="App" style={{backgroundImage: `url(${Background})`}}>
      <Card className="text-center">
        <Card.Body>
          <Button onClick={btnhandler} variant="dark">
            Connect to wallet
          </Button><br />
          <strong>Address: </strong>
          {data.account}
          <br />
          <strong>Balance: </strong>
            {data.Balance}
            <br />
          <strong>Lottery token balance: </strong>
          <span id="tokenBalance"></span>
        </Card.Body>
      </Card>
       <br />
       <div onLoad={currentLottery()}>
        <div className="text-center">
          <h2>RUNNING LOTTERY</h2>
          <div>
            <h4>Current time: <strong id="txt"></strong></h4>
          </div>
        </div>
        <div>
           <p id="id"></p>  
           <p id="price"></p>  
           <p id="startTime"></p>  
           <p id="closeTime"></p>  
           <p id="prizePool"></p>  
           <span id="ticketNum"></span><Button variant="info mx-3 " onClick={currentLottery}>Refresh</Button>
        </div>
           <Button disabled={data.account === ownerAddress} variant="primary" onClick={buyTickets}><strong>Buy ticket</strong></Button>
           <Button disabled={data.account === ownerAddress} variant="info my-3 mx-3" onClick={getNumbers}><strong>Get your number</strong></Button>
           <Button disabled={data.account === ownerAddress} variant="success" onClick={getPrize}><strong>Get your prize</strong></Button>
           <br />  
           <Button disabled={data.account !== ownerAddress}  variant="warning" onClick={startNewLottery}><strong>New game</strong></Button>
           <Button disabled={data.account !== ownerAddress} variant="warning my-3 mx-3" onClick={closeLottery}><strong>Close game</strong></Button>  
           <Button disabled={data.account !== ownerAddress} variant="warning my-3 mx-3" id="bingoBtn" onClick={bingo}><strong>Bingo</strong></Button>
           <Button variant="warning" onClick={getLotteriesInfo}><strong>Get info</strong></Button>
        </div>
    </div>
  );
}

export default App;