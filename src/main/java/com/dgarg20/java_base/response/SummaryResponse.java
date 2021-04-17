package com.dgarg20.java_base.response;

import com.dgarg20.java_base.dtos.UserShare;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Deepanshu Garg on 17/12/20.
 */
@AllArgsConstructor
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
@Getter
public class SummaryResponse {
    private List<UserShare> owedTo;
    private List<UserShare> owedFrom;
}
