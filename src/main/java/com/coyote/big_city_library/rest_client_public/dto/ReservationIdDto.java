package com.coyote.big_city_library.rest_client_public.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class ReservationIdDto {

    @NonNull
    private Integer bookId;

    @NonNull
    private Integer userId;

}
