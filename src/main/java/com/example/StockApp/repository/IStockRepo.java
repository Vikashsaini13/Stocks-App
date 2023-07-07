package com.example.StockApp.repository;

import com.example.StockApp.model.Stock;
import com.example.StockApp.model.StockType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepo extends CrudRepository<Stock, Long> {

    List<Stock> findByStockTypeOrderByStockPriceDesc(StockType type);

    List<Stock> findByOrderByIpoDate();


    @Modifying
    @Query(value = "update stock set stock_price=(stock_price + stock_price * (:hike)) where stock_type=:type",nativeQuery = true)
    void updateStockByType(String type, Float hike);

    @Modifying
    @Query(value = "select * from stock where stock_price >= :price",nativeQuery = true)
    List<Stock> getStockAbovePrice(Double price);
}
