package com.example.bookservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Book")
public class Book {

    @DynamoDBHashKey(attributeName = "Uuid")
    private String uuid;

    @DynamoDBAttribute(attributeName = "Title")
    private String title;

    @DynamoDBAttribute(attributeName = "Isbn")
    private String isbn;

    @DynamoDBAttribute(attributeName = "AuthorUuid")
    private String authorUuid;
}
