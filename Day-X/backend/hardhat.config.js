require("@nomiclabs/hardhat-ethers");
require("@openzeppelin/hardhat-upgrades");
require("@nomiclabs/hardhat-etherscan");


module.exports = {
  solidity: "0.8.10",
  networks: {
    rinkeby: {
      url: `https://rinkeby.infura.io/v3/870fa56fb7454ceb9b2d17d8822962a8`,
      accounts: ['76cf5f02c0435f5b69050e50f2c11be7bcedcd439607f308f6784f8ddb174e89'],
    },
  },
  etherscan: {
    apiKey: '2PCWPFVUSQ5THFYDS3URVFX894XH85CJRQ',
  },
};