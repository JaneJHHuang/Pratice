package com.example.demo.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

@Getter
@JsonDeserialize(builder = IdentifiedPersonRequest.IdentifiedPersonRequestBuilder.class)
public class IdentifiedPersonRequest {

    protected final UUID id;

    protected final String firstName;

    protected final String lastName;

    protected final Date dateOfBirth;


    @Builder(toBuilder = true)
    protected IdentifiedPersonRequest(final UUID id, final String firstName, final String lastName, final Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class IdentifiedPersonRequestBuilder{}
}
