package com.coyote.big_city_library.rest_client_public.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter 
@Setter 
public class LibraryDto {

    private Integer id;

    private String name;

    private String address;

    private String phone;

}
