package model.repository.impl;

import model.bean.Catelogy;
import model.repository.ICatelogyRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatelogyRepoImpl implements ICatelogyRepo {
    private final String SELECT_ALL_Catelogy = "select * from catelogy";
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Catelogy> selectAll() {
        List<Catelogy> catelogies = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_Catelogy);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_catelogy");
                String name = resultSet.getString("name_catelogi");
                catelogies.add(new Catelogy(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return catelogies;
    }
}
