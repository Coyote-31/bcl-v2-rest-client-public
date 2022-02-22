package com.coyote.big_city_library.rest_client_public.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.dto.LoanDto;
import com.coyote.big_city_library.rest_client_public.feign_clients.LoanClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanClient loanClient;

    @Autowired
    private JwtService jwtService;

    public List<LoanDto> findLoansByUserPseudo(HttpSession session, String pseudo) {

        String bearerJwt = jwtService.getBearerJwt(session);

        return loanClient.findLoansByUserPseudo(bearerJwt, pseudo);
    }
    
}
