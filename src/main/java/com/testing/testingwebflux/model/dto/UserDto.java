package com.testing.testingwebflux.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    @NonNull
    private Long id;
    private String username;
    @NonNull
    private String email;

}
