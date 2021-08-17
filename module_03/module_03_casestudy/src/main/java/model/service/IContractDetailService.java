package model.service;

import model.bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailService {
    void addNewContractDetail(ContractDetail contract) throws SQLException;

    List<ContractDetail> selectAllContractDetail();
}
