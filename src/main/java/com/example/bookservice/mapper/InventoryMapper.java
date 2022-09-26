package com.example.bookservice.mapper;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.example.bookservice.converter.BookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class InventoryMapper {

    private final String TABLE_NAME = "Inventory";

    private final String INDEX_NAME = "BookQuantityIndex";

    private final DynamoDB dynamoDB;

    private final Table table;

    @Autowired
    public InventoryMapper(AmazonDynamoDB amazonDynamoDB, BookConverter bookConverter) {
        dynamoDB = new DynamoDB(amazonDynamoDB);
        table = dynamoDB.getTable(TABLE_NAME);
    }

    public int getBookQuantity(String bookUuid) {
        int quantity = 0;

        Index index = table.getIndex(INDEX_NAME);
        QuerySpec querySpec = new QuerySpec()
                .withHashKey("BookUuid", bookUuid);
        ItemCollection<QueryOutcome> items = index.query(querySpec);
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            quantity += iterator.next().getInt("Quantity");
        }

        return quantity;
    }
}
