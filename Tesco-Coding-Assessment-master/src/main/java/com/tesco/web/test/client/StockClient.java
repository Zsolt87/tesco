package com.tesco.web.test.client;

import com.tesco.web.test.client.http.ShopStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="stockFeignClient", url="${fruitAggregatedService.integration.stockClient.url}")
public interface StockClient {
    @RequestMapping(method = RequestMethod.GET, value="/{id}", consumes = "application/json")
    ResponseEntity<List<ShopStockResponse>> getStocksByFruitId(@PathVariable String id);
}
