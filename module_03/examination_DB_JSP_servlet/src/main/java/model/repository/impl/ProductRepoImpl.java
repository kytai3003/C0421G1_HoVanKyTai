package model.repository.impl;

import model.bean.Product;
import model.repository.IProductRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IProductRepo {
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product" + "  (name_product, price, amount, color, description, id_catelogy) VALUES " +
            " (?, ?, ?, ?, ?, ? );";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id_product =?";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id_product = ?";
    private static final String UPDATE_PRODUCT_SQL = "update product set name_product = ?, price = ?,amount = ?, color = ?, description = ?, id_catelogy = ? where id_product = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from product where name_product like concat('%', ? , '%') and price = ?;";
    private static final String SELECT_CUSTOMER_BY_NAME2 = "select * from product where name_product like concat('%', ? , '%');";
    private static final String SELECT_Product_BY_NAME3 = "select * from product where price = ?;";

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
    public void addNew(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColorProduct());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCatelogy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name_product");
                double price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int catelogy = resultSet.getInt("id_catelogy");
                product = new Product(id,name, price, amount, color, description, catelogy);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_PRODUCT);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int idCatelogy = resultSet.getInt("id_catelogy");
                productList.add(new Product(id, name, price, amount, color, description, idCatelogy));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(DELETE_PRODUCT_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(UPDATE_PRODUCT_SQL);
            System.out.println(statement);
            statement.setString(1, product.getNameProduct());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getAmount());
            statement.setString(4, product.getColorProduct());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getIdCatelogy());
            statement.setInt(7, product.getIdProduct());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Product> searchByName(String name, double price) throws SQLException {
            List<Product> products = new ArrayList<>();
            PreparedStatement preparedStatement;
            if (name.equals("")) {
                preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_Product_BY_NAME3);
                preparedStatement.setDouble(1, price);
            } else if (price == 0.0) {
                preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_NAME2);
                preparedStatement.setString(1, name);
            } else {
                preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_NAME);
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, price);
            }
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String names = resultSet.getString("name_product");
                double prices = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int idCatelogy = resultSet.getInt("id_catelogy");
                products.add(new Product(id, names, prices, amount, color, description, idCatelogy));
            }
            return products;

    }


}
