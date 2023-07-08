package com.tesco.stock.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ShopStockResponse {
    private String id;
    private long stock;
}
