package com.tesco.stock.controller;

import com.tesco.stock.controller.dto.ShopStockResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class StockController {

        @RequestMapping(method = RequestMethod.GET, value = "/stock/{id}", produces = APPLICATION_JSON_VALUE)
        public ResponseEntity<List<ShopStockResponse>> getStocksByFruitId(@PathVariable String id) {
                return ResponseEntity.ok(List.of(new ShopStockResponse("test", 1)));
        }
}
