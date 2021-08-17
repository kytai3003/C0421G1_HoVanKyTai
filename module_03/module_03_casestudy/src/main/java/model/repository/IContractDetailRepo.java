package model.repository;

import model.bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailRepo {
    void addNewContractDetail(ContractDetail contract) throws SQLException;

    List<ContractDetail> selectAllContractDetail();
}
