package com.dgarg20.dropwizardcrud.api;

import io.dropwizard.jackson.JsonSnakeCase;
import io.dropwizard.validation.MaxSize;
import io.dropwizard.validation.MinSize;
import lombok.Data;

import java.util.List;

@Data
@JsonSnakeCase
public class Users {
    private int page;
    private int perPage;
    private int total;

    @MinSize(1)
    @MaxSize(10)
    private List<User> users;
    }
