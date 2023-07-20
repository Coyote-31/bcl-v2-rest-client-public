package com.coyote.big_city_library.rest_client_public.dto.search_books;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SearchLibraryDto {

    private Integer id;

    private String name;

    private String address;

    private String phone;

    private Set<SearchExemplaryDto> exemplaries;

}
