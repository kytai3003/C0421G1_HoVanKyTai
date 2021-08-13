package model.repository;

import model.bean.Contract;
import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    void addNewContract(Contract contract) throws SQLException;

    List<Contract> selectAllContract();

    List<Contract> searchByStartDay(String date);
}
