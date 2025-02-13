package com.example.techinalTest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(Object data, String message, HttpStatus status){
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("data", data);
        res.put("message", message);
        res.put("status", status);
        return new ResponseEntity<>(res, status);
    }
}
