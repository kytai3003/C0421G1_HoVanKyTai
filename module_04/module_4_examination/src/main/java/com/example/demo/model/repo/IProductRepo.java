package com.example.demo.model.repo;

import com.example.demo.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {

    @Query(value= "select * from product p inner join type_product tp on p.type_product_id = tp.type_product_id inner join order_product op on op.order_id = p.order_id\n" +
            "where op.order_date between '2021-12-12' and '2021-12-12'", nativeQuery = true)
    Page<Product> findAllByDate(Pageable pageable, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
