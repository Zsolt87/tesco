package com.tesco.web.test.service.model;

import com.tesco.web.test.CurrencyEnum;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class AggregatedFruitDetail {
    String id;
    String name;
    CurrencyEnum currencyEnum;
    BigDecimal price;
    List<String> availableAt;
}
