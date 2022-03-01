package com.coyote.big_city_library.rest_client_public.controllers;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.form_handlers.LoginForm;
import com.coyote.big_city_library.rest_client_public.services.JwtService;
import com.coyote.big_city_library.rest_client_public.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.FeignException.Forbidden;

@Controller
@RequestMapping("/authentification")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;

    private static final String ATTR_JWT = "jwt";
    private static final String ATTR_PSEUDO = "pseudo";
    

    @GetMapping("/connexion")
    public String getLoginForm(Model model) {

        model.addAttribute("login", new LoginForm());

        return "LoginForm";
    }

    @PostMapping("/connexion")
    public String login(HttpSession session, @ModelAttribute LoginForm loginForm, Model model) {
        
        
        try {
            String jwt = loginService.getJWT(loginForm);
            session.setAttribute(ATTR_JWT, jwt);
            String pseudo = jwtService.getUsername(jwt);
            session.setAttribute(ATTR_PSEUDO, pseudo);

            return "redirect:/";

        } catch (Forbidden e) {
            session.removeAttribute(ATTR_JWT);
            session.removeAttribute(ATTR_PSEUDO);

            model.addAttribute("error", "Pseudo/Mot de passe invalide");
            model.addAttribute("login", loginForm);

            return "LoginForm";
        }

    }

    @GetMapping("/deconnexion")
    public String logout(HttpSession session) {

        session.removeAttribute(ATTR_JWT);
        session.removeAttribute(ATTR_PSEUDO);

        return "redirect:/";
    }
    
}
