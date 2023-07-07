package com.example.StockApp.service;

import com.example.StockApp.model.Stock;
import com.example.StockApp.model.StockType;
import com.example.StockApp.repository.IStockRepo;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepo iStockRepo;
    public List<Stock> getAllStocks() {
        return (List<Stock>) iStockRepo.findAll();
    }

    public String addStocks(List<Stock> stocks) {
        iStockRepo.saveAll(stocks);

        return  " Stocks Added";
    }

    public String deleteStockByStockId(Long id) {
        iStockRepo.deleteById(id);
        return "stock deleted";
    }

    public List<Stock> getStockByStockTypeDescSorted(StockType type) {
        return iStockRepo.findByStockTypeOrderByStockPriceDesc(type);
    }

    public List<Stock> getStockByTimeStamp() {
        return iStockRepo.findByOrderByIpoDate();
    }

    @Transactional
    public String updateStockByType(StockType type, Float hike) {
        iStockRepo.updateStockByType(type.name(),hike);
        return "updated";
    }

    @Transactional
    public List<Stock> getStockAbovePrice(Double price) {
        return iStockRepo.getStockAbovePrice(price);
    }
}
