package com.coyote.big_city_library.rest_client_public.form_handlers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class LoginForm {

    @NonNull
    private String username;

    @NonNull
    private String password;
    
}
