package com.arrow.sharemarketbackend.model;

public record ExceptionModel(String uuid, String errorMessage, Integer statusCode) {
}
