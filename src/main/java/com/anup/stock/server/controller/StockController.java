package com.anup.stock.server.controller;

import com.anup.stock.dto.GenericResponseWrapper;
import com.anup.stock.dto.StockDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjit Shakya <manjit.shakya@f1soft.com>
 */
@RestController
@RequestMapping("stock")
public class StockController {
    private List<StockDTO> stocks;

    public StockController() {
        stocks = new ArrayList<>();
        stocks.add(new StockDTO("Facebook", 319.08));
        stocks.add(new StockDTO("Google", 319.08));
        stocks.add(new StockDTO("Tesla", 319.08));
        stocks.add(new StockDTO("Microsoft", 319.08));
        stocks.add(new StockDTO("Uber", 319.08));
    }

    @GetMapping("{stockName}")
    public GenericResponseWrapper getStock(@PathVariable String stockName) {
        GenericResponseWrapper response = new GenericResponseWrapper();
        for (StockDTO stock : stocks) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                response.setResultCode(1);
                response.setResultDescription("Stock fetched");
                response.setData(stock);
                return response;
            }
        }
        response.setResultCode(0);
        response.setResultDescription("Stock not found");
        return response;
    }

    @GetMapping("all")
    public GenericResponseWrapper getAllStocks() {
        System.out.println("Get All Stocks called...");
        GenericResponseWrapper response = new GenericResponseWrapper();
        response.setResultCode(1);
        response.setResultDescription("Stock fetched");
        response.setData(stocks);
        return response;
    }
}
