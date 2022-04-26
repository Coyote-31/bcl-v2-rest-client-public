package com.coyote.big_city_library.rest_client_public.feign_clients;

import java.util.List;

import com.coyote.big_city_library.rest_client_public.dto.LoanDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "BigCityLibrary-RestServer-loan", url = "${feign_clients.url}", path = "/api/loans")
public interface LoanClient {

    @GetMapping("/user/{pseudo}")
    List<LoanDto> findLoansByUserPseudo(
            @RequestHeader("Authorization") String bearerJwt,
            @PathVariable String pseudo);

    @PutMapping("/extend/{id}")
    void extendLoan(
            @RequestHeader("Authorization") String bearerJwt,
            @PathVariable Integer id);

}
