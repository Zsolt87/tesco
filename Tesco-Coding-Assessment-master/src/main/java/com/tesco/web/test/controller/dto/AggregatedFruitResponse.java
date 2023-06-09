package com.tesco.web.test.controller.dto;

import com.tesco.web.test.CurrencyEnum;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class AggregatedFruitResponse {
    String id;
    String name;
    CurrencyEnum currencyEnum;
    BigDecimal price;
    List<String> availableAt;
}
