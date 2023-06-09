package com.tesco.web.test.client;

import com.tesco.web.test.client.http.FruitIdResponse;
import com.tesco.web.test.client.http.FruitPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="fruitFeignClient", url="${fruitAggregatedService.integration.fruitClient.url}")
public interface FruitClient {
    @RequestMapping(method = RequestMethod.GET, value="/{name}", consumes = "application/json")
    ResponseEntity<FruitIdResponse> getFruitIdByName(@PathVariable String name);

    @RequestMapping(method = RequestMethod.GET, value="/{id}/price", consumes = "application/json")
    ResponseEntity<FruitPriceResponse> getPriceByFruitId(@PathVariable String id);
}
