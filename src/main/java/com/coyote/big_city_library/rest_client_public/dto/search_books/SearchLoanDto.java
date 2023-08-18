package com.coyote.big_city_library.rest_client_public.dto.search_books;

import java.time.LocalDate;

import com.coyote.big_city_library.rest_client_public.dto.UserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SearchLoanDto {

    private Integer id;

    private LocalDate returnDate;

    private LocalDate loanDate;

    private Boolean extend = false;

    private SearchExemplaryDto exemplary;

    private UserDto user;

}
