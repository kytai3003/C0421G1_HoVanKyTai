package model.service;

import model.bean.Contract;

import java.sql.SQLException;
import java.util.List;

public interface IContractService {
    void addNewContract(Contract contract) throws SQLException;

    List<Contract> selectAllContract();

    List<Contract> searchByStartDay(String date);
}
