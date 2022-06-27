const { ethers, upgrades } = require("hardhat");

async function main() {
    const lotteryProxy = "0x187539773441907f1807Ea5f501eBB5112a065B3";
    console.log("Lottery address: ", lotteryProxy); 
    const lotteryUpgradable = await ethers.getContractFactory("LotteryUpgradable");
    console.log("Deploying Lottery upgradable...");
    const lotteryUpgradableContract = await upgrades.upgradeProxy(lotteryProxy, lotteryUpgradable);
    console.log("Lottery upgradable deployed to:", lotteryUpgradableContract.address);
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error(error);
    process.exit(1);
  });