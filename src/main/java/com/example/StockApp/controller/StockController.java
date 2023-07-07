package com.example.StockApp.controller;

import com.example.StockApp.model.Stock;
import com.example.StockApp.model.StockType;
import com.example.StockApp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    //get all stocks
    @GetMapping("Stocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

    //post all stocks
    @PostMapping("stocks")
    public String addStocks(@RequestBody List<Stock> stocks){
        return stockService.addStocks(stocks);
    }

    //delete stock by stock id
    @DeleteMapping("stock/id/{id}")
    public String deleteStockByStockId(@PathVariable Long id){
        return stockService.deleteStockByStockId(id);
    }

    //get the stocks by stock type and desc in price
    @GetMapping("stock/type/{type}")
    public List<Stock> getStockByStockTypeDescSorted(@PathVariable StockType type){
        return stockService.getStockByStockTypeDescSorted(type);
    }

    //get all stock based od ipo date
    @GetMapping("stocks/timestamp")
    public List<Stock> getStockByTimeStamp(){
        return stockService.getStockByTimeStamp();
    }

    //updating the stock price of a particular type based on some hike
    @PutMapping("stock/type/{type}/hike/{hike}")
    public String updateStockByType(@PathVariable StockType type, @PathVariable Float hike){
        return stockService.updateStockByType(type,hike);
    }

    //get all the stock ,their price above a particular price
    @GetMapping("stocks/price/{price}")
    public List<Stock> getStockAbovePrice(@PathVariable Double price){
        return stockService.getStockAbovePrice(price);
    }

}
