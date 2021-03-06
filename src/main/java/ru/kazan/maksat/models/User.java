package ru.kazan.maksat.models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder

public class User {
    private Long id;
    private String firstName;
    private String lastName;
}
