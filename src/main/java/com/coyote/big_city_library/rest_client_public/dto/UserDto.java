package com.coyote.big_city_library.rest_client_public.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter 
public class UserDto {

    private Integer id;

    private String pseudo;

    private String email;

    private String password;

}
