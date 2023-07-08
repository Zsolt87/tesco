package com.tesco.web.test.service;

import com.tesco.web.test.CurrencyEnum;
import com.tesco.web.test.client.FruitClient;
import com.tesco.web.test.client.StockClient;
import com.tesco.web.test.client.http.FruitIdResponse;
import com.tesco.web.test.client.http.FruitPriceResponse;
import com.tesco.web.test.client.http.ShopStockResponse;
import com.tesco.web.test.controller.dto.AggregatedFruitResponse;
import com.tesco.web.test.service.exception.ClientResponseNotSuccessfulException;
import com.tesco.web.test.service.model.AggregatedFruitDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FruitService {

    private final FruitClient fruitClient;
    private final StockClient stockClient;

    public FruitService(FruitClient fruitClient, StockClient stockClient) {
        this.fruitClient = fruitClient;
        this.stockClient = stockClient;
    }

    public AggregatedFruitDetail getAggregatedFruitResponse(String name){
        log.info("Getting fruit details");
        ResponseEntity<FruitIdResponse> fruitIdByNameResponse = fruitClient.getFruitIdByName(name);
        handleUnsuccessfulResponse(fruitIdByNameResponse, "Unable to retrieve fruit id by name");

        String fruitId = fruitIdByNameResponse.getBody().getId();

        ResponseEntity<FruitPriceResponse> priceByFruitIdResponse = fruitClient.getPriceByFruitId(fruitId);
        handleUnsuccessfulResponse(priceByFruitIdResponse, "Unable to retrieve fruit price by id");

        log.info("Getting stock details");
        ResponseEntity<List<ShopStockResponse>> stockResponse = stockClient.getStocksByFruitId(fruitId);
        handleUnsuccessfulResponse(stockResponse, "Unable to retrieve stock info by id");

        FruitPriceResponse priceByFruitId = priceByFruitIdResponse.getBody();
        List<ShopStockResponse> shopStock = stockResponse.getBody();
        log.info("Aggregate results");
        AggregatedFruitDetail result = new AggregatedFruitDetail(fruitId,
                name,
                CurrencyEnum.valueOf(priceByFruitId.getCurrency()),
                new BigDecimal(priceByFruitId.getPrice()),
                shopStock.stream().map(s -> s.getId()).collect(Collectors.toList()));

        log.debug("{}", result);

        return result;
    }

    private void handleUnsuccessfulResponse(ResponseEntity<?> responseEntity, String message){
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            String m = message + " " + responseEntity.getStatusCode();
            log.error(m);
            throw new ClientResponseNotSuccessfulException(m);
        }
    }
}
