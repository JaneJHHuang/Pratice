package com.example.demo.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Getter
@JsonDeserialize(builder = PersonRequest.PersonRequestBuilder.class)
public class PersonRequest {

    protected final String firstName;

    protected final String lastName;

    protected final Date dateOfBirth;


    @Builder(toBuilder = true)
    protected PersonRequest(final String firstName, final String lastName, final Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class PersonRequestBuilder{}
}
