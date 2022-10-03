package com.example.bookservice.feignclient;

import com.example.bookservice.dto.AuthorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "authorService", url = "${app.url.authorService}")
public interface AuthorFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<AuthorResponse> getAuthorById(@PathVariable("id") String uuid);
}
