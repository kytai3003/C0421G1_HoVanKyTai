const { ethers, upgrades } = require("hardhat");

async function main() {
    const lottery = await ethers.getContractFactory("LotteryUpgradable");
    console.log("Deploying Lottery...");
    const lotteryContract = await upgrades.deployProxy(lottery, ["LotteryToken", "LTK"], {
        initializer: "initialize",
    });
    await lotteryContract.deployed();
    console.log("Lottery deployed to:", lotteryContract.address);
}

main()
    .then(() => process.exit(0))
    .catch((error) => {
    console.error(error);
    process.exit(1);
  });