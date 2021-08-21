package model.repository;

import model.bean.Catelogy;

import java.util.List;

public interface ICatelogyRepo {
    List<Catelogy> selectAll();
}
