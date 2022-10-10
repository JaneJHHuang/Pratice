package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;
import java.util.UUID;

@Getter
@JsonDeserialize(builder = PersonResponse.PersonResponseBuilder.class)
@FieldNameConstants
@Builder(toBuilder = true)
public class PersonResponse {
    @ApiModelProperty("The unique ID of person")
    @JsonProperty("person_id")
    @NotNull
    protected final UUID userId;

    @ApiModelProperty("The first name of person")
    protected final String firstName;

    @ApiModelProperty("The last name of Person")
    protected final String lastName;

    @ApiModelProperty("Date of birth")
    protected final Date dateOfBirth;
}
