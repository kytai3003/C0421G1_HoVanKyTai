package model.service.impl;

import model.bean.Contract;
import model.repository.IContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements IContractService {

    IContractRepository iContractRepository = new ContractRepositoryImpl();
    @Override
    public void addNewContract(Contract contract) throws SQLException {
        this.iContractRepository.addNewContract(contract);
    }

    @Override
    public List<Contract> selectAllContract() {
        return this.iContractRepository.selectAllContract();
    }

    @Override
    public List<Contract> searchByStartDay(String date) {
        return this.iContractRepository.searchByStartDay(date);
    }
}
