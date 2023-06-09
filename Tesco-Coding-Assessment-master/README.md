# Tesco Coding Assessment

This task will assess your ability to write **clean, simple-to-understand and
well-tested** code. 

**Read these instructions carefully before getting started.**

## Prerequisites

* The code must be well-tested, preferably following TDD principles
* Should not use abbreviations
* Should apply SOLID principles
* Should keep all objects small, highly cohesive and isolated

If you wish to use frameworks or libraries other than the ones included, feel free to do so.

## Task

You are building a simple REST API which aggregates and processes data from
various external service APIs which are already implemented for you.

Your task is to create an endpoint that takes a fruit's name, communicates with
the external services, aggregates their responses, and returns
the following information:

* fruit ID
* price and currency
* availability in stores

We're only interested in stores where the fruit is actually available.

* If the fruit is not available in any stores, return an `HTTP 404`.

* If no fruit exists by the name provided, return an `HTTP 400`.

* If the fruit exists and is available in at least one store, return an `HTTP 200`.

The expected response format is:

```
{
    "id": "fruitId",
    "name": "fruitName",
    "currency": "GBP",
    "price": "123.56",
    "availableAt": [
        "shopId1",
        "shopId2"
    ]
}
```

The following are the external services which will supply the data for your aggregation service. Note: these APIs are already implemented, and will be accessible as mocks in your tests (and _only_ in your tests.)

### FruitService

Holds information about fruits (IDs and prices). Example:

```
GET /fruits/{name}

HTTP 200
{
    "id": "fruitId"
}

GET /fruits/{id}/price

HTTP 200
{
    "id": "fruitId",
    "currency": "EUR",
    "price": "120.03"
}
```

### StockService

Holds information about the stock of individual shops, i.e. how many fruits
each shop has. Example:

```
GET /stock/{fruitId}

HTTP 200
[
    {
        "id": "shopId1"
        "stock": 0
    },
    {
        "id": "shopId2"
        "stock": 3
    }
]
```

### Testing

Make sure you write unit tests and integration tests as well. For the integration tests
you can use `WebTestIT` as your superclass which has been pre-configured for your convenience.

The stubs for the external services are provided under `src/test/resources/mappings`.
These are automatically loaded for every test descending from `WebTestIT` and are available
under `localhost:8989`.

For example, if you issue an HTTP GET request to `localhost:8989/fruits/apple`
the following response is returned to you (as defined in `get_fruit_id_by_name_apple.json`):

```
{
  "id": "721fdf98-41b3-4b5d-b0f3-b5e633aa08a0"
}
```

If you call an endpoint that doesn't exist, an `HTTP 404` response is returned.

Feel free to inspect the stubs to get familiar with the APIs.
