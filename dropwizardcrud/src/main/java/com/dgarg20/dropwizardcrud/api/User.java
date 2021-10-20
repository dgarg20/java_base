package com.dgarg20.dropwizardcrud.api;

import io.dropwizard.jackson.JsonSnakeCase;
import io.dropwizard.validation.MaxSize;
import io.dropwizard.validation.MinSize;
import lombok.Data;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonSnakeCase

public class User {
    @NotNull
    private String name;

    @NotNull
    private String sex;

    @NotNull
    private String mobileNo;

    @NotNull
    @MaxSize(13)
    @MinSize(10)
    private String emailId;

    @NotNull
    @Size(min = 1, max = 99)
    private int age;
}
