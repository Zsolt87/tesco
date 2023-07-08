package com.tesco.web.test.client;

import com.tesco.web.test.client.http.FruitIdResponse;
import com.tesco.web.test.client.http.FruitPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value="fruitFeignClient", url="${fruitAggregatedService.integration.fruitClient.url}")
public interface FruitClient {
    @RequestMapping(method = RequestMethod.GET, value="/{name}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<FruitIdResponse> getFruitIdByName(@PathVariable(name="name") String name);

    @RequestMapping(method = RequestMethod.GET, value="/{id}/price", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<FruitPriceResponse> getPriceByFruitId(@PathVariable(name="id") String id);
}
