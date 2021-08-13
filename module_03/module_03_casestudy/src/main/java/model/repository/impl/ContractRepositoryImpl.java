package model.repository.impl;

import model.bean.Contract;
import model.bean.Customer;
import model.repository.IContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements IContractRepository {
    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract" + "  (contract_start_day, contract_end_day, contract_deposit, contract_total_money, employee_id, customer_id, service_id) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CONTRACT_BY_MONTH = "select * from contract where month(contract_start_day) = ?";
    private static final String SELECT_ALL_CONTRACT = "select * from contract";

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
    public void addNewContract(Contract contract) throws SQLException {
        System.out.println(INSERT_CONTRACT_SQL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_CONTRACT_SQL);
            preparedStatement.setString(1, contract.getContractStartDay());
            preparedStatement.setString(2, contract.getContractEndDay());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotal());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_CONTRACT);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String start = resultSet.getString("contract_start_day");
                String end = resultSet.getString("contract_end_day");
                double deposit = resultSet.getDouble("contract_deposit");
                double total = resultSet.getDouble("contract_total_money");
                int employee = resultSet.getInt("employee_id");
                int customer = resultSet.getInt("customer_id");
                int service = resultSet.getInt("service_id");
                contractList.add(new Contract(id, start, end, deposit, total, employee, customer, service));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public List<Contract> searchByStartDay(String date) {
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_CONTRACT_BY_MONTH);
            preparedStatement.setString(1, date);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("contract_id");
                String start = resultSet.getString("contract_start_day");
                String end = resultSet.getString("contract_end_day");
                double deposit = resultSet.getDouble("contract_deposit");
                double total = resultSet.getDouble("contract_total_money");
                int employee = resultSet.getInt("employee_id");
                int customer = resultSet.getInt("customer_id");
                int service = resultSet.getInt("service_id");
                contracts.add(new Contract(id, start, end, deposit, total, employee, customer, service));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contracts;
    }
}
