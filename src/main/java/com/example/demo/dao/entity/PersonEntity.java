package com.example.demo.dao.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "person")
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonEntity {
    private static final String KEY_GENERATOR_NAME = "surrogateKeyGenerator";
    private static final String KEY_GENERATOR_TYPE = "uuid2";
    @Id
    @GeneratedValue(generator = KEY_GENERATOR_NAME)
    @GenericGenerator(name = KEY_GENERATOR_NAME, strategy = KEY_GENERATOR_TYPE)
    @Column(name = "id", columnDefinition = "UUID", unique = true, nullable = false)
    protected UUID id;

    @Column
    protected String firstName;

    @Column
    protected String lastName;

    @Column
    protected Date dateOfBirth;

    @Builder(toBuilder = true)
    protected PersonEntity(final UUID id, final String firstName, final String lastName, final Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public static class PersonEntityBuilder {}
}
