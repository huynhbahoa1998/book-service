package com.example.bookservice.repository;

public interface InventoryRepository {

    String TABLE_NAME = "Inventory";

    String INDEX_NAME = "BookQuantityIndex";

    String INVENTORY_BOOK_UUID = "BookUuid";

    String INVENTORY_QUANTITY = "Quantity";

    int getBookQuantity(String bookUuid);
}
