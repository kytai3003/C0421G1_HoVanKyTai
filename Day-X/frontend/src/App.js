// Importing modules
import React, { useState } from "react";
import { ethers } from "ethers";
import "./App.css";
import { Button, Card } from "react-bootstrap";
import Background from "./img/background.jpg"
import "bootstrap/dist/css/bootstrap.min.css";
import LotteryContract from "./utils/LotteryUpgradable.json"

const lotteryAddress = `0xe2ef8D04dfbCfbbf398791F975409Ddf1C787D85`;
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

  const [ticketPrice, setTicketPrice] = useState();
  const [ticketAmount, setTicketAmount] = useState();

  let isCurrentGame;

  async function startNewLottery() {
    try {
      const transaction = await lotteryContract.startNewLottery(ticketPrice);
      await transaction.wait();
      alert("Success.");
    } catch(error) {
      alert("Error: " + error);
    }
  }

  async function currentLottery() {
      const currentLot = await lotteryContract.getCurrentGame();
      const ticketRemaning = await lotteryContract.getAvailableTicket();
      const toDatetimeStart = new Date(currentLot[2] * 1000);
      const toDatetimeClose = new Date(currentLot[3] * 1000);
      startTime();
      if (currentLot[1] > 0) {  
        isCurrentGame = true;
        document.getElementById('price').innerHTML = 'Price: <strong>' +  currentLot[1] + '</strong>';
        document.getElementById('startTime').innerHTML = 'Starting time: <strong>'  + toDatetimeStart.getHours()+ ":" +toDatetimeStart.getMinutes()+":"+ toDatetimeStart.getSeconds() + '</strong>';
        document.getElementById('closeTime').innerHTML = 'Closing time: <strong>' + toDatetimeClose.getHours()+ ":" +toDatetimeClose.getMinutes()+":"+ toDatetimeClose.getSeconds() + '</strong>';
        document.getElementById('ticketNum').innerHTML = 'Available ticket: <strong>' + ticketRemaning + '</strong>';
      } else {
        document.getElementById('price').innerHTML = '<h4>No game is running.</h4>';
        document.getElementById('startTime').innerHTML = '';
        document.getElementById('closeTime').innerHTML = '';
        document.getElementById('ticketNum').innerHTML = '';
      }
  }

  async function getNumbers() {
    try {
      const ticketArray = await lotteryContract.getPlayerNumbers();
      if (ticketArray.length > 0) {
        alert("Your number(s): " + ticketArray);
      } else {
        alert("Buy ticket to join us.");
      }
    } catch (error) {
      alert("Error.");
    }
  }

  async function buyTickets() {
    try {
      const transaction = await lotteryContract.buyTickets(ticketAmount);
      await transaction.wait();
      const ticketArray = await lotteryContract.getPlayerNumbers();
      alert("Your number(s): " + ticketArray);
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
        </Card.Body>
      </Card>
       <br />
       <div onLoad={currentLottery()}>
          <h2>RUNNING GAME INFO</h2>
          <div>
            <h4>Current time: <strong id="txt"></strong></h4>
          </div>
           <p id="price"></p>  
           <p id="startTime"></p>  
           <p id="closeTime"></p>  
           <p id="ticketNum"></p> 
           <input onChange={e => setTicketAmount(e.target.value)} placeholder="Amount" /> <br />
           <Button variant="primary my-3 mx-3" onClick={buyTickets}>Buy</Button>
           <Button variant="primary" onClick={getNumbers}>Get your number</Button>    
        </div>
    </div>
  );
}

export default App;