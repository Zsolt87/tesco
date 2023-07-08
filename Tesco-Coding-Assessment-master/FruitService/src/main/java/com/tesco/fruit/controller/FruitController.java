package com.tesco.fruit.controller;

import com.tesco.fruit.controller.dto.FruitIdResponse;
import com.tesco.fruit.controller.dto.FruitPriceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class FruitController {

        @RequestMapping(method = RequestMethod.GET, value = "/fruit/{name}", produces = APPLICATION_JSON_VALUE)
        public ResponseEntity<FruitIdResponse> getFruitIdByName(@PathVariable(name = "name") String name) {
                return ResponseEntity.ok(new FruitIdResponse(UUID.randomUUID().toString()));
        }

        @RequestMapping(method = RequestMethod.GET, value = "/fruit/{id}/price", produces = APPLICATION_JSON_VALUE)
        public ResponseEntity<FruitPriceResponse> getPriceByFruitId(@PathVariable(name = "id") String id) {
                return ResponseEntity.ok(new FruitPriceResponse(id, "USD", "19.0"));
        }
}
