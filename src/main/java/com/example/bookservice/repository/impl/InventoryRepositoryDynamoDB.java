package com.example.bookservice.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public class InventoryRepositoryDynamoDB implements InventoryRepository {

    private final DynamoDB dynamoDB;

    private final Table table;

    @Autowired
    public InventoryRepositoryDynamoDB(AmazonDynamoDB amazonDynamoDB, BookMapper bookConverter) {
        dynamoDB = new DynamoDB(amazonDynamoDB);
        table = dynamoDB.getTable(TABLE_NAME);
    }

    public int getBookQuantity(String bookUuid) {
        int quantity = 0;

        Index index = table.getIndex(INDEX_NAME);
        QuerySpec querySpec = new QuerySpec()
                .withHashKey(InventoryRepository.INVENTORY_BOOK_UUID, bookUuid);
        ItemCollection<QueryOutcome> items = index.query(querySpec);
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            quantity += iterator.next().getInt(InventoryRepository.INVENTORY_QUANTITY);
        }

        return quantity;
    }
}
