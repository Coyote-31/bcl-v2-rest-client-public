package com.coyote.big_city_library.rest_client_public.form_handlers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchBookForm {

    private String bookTitle;

    private String authorName;

    private String publisherName;
    
}
