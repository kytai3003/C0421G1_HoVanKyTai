package model.repository.impl;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.IContractDetailRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepoImpl implements IContractDetailRepo {
    private static final String INSERT_CONTRACT_DETAIL = "INSERT INTO contract_detail" + "  (contract_id, attach_service_id, quantity) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_ALL_CONTRACT = "select * from contract_detail";
    BaseRepository baseRepository = new BaseRepository();

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void addNewContractDetail(ContractDetail contract) throws SQLException {
        System.out.println(INSERT_CONTRACT_DETAIL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contract.getContractId());
            preparedStatement.setInt(2, contract.getAttachServiceId());
            preparedStatement.setInt(3, contract.getQuantity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        List<ContractDetail> contractDetails = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_CONTRACT);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("contract_detail_id");
                int contactId = resultSet.getInt("contract_id");
                int attachId = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetails.add(new ContractDetail(id, contactId, attachId, quantity));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetails;
    }
}
