package com.coyote.big_city_library.rest_client_public.controllers;

import javax.servlet.http.HttpSession;

import com.coyote.big_city_library.rest_client_public.form_handlers.LoginForm;
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

    @GetMapping("/connexion")
    public String getLoginForm(Model model) {

        model.addAttribute("login", new LoginForm());

        return "LoginForm";
    }

    @PostMapping("/connexion")
    public String login(HttpSession httpSession, @ModelAttribute LoginForm loginForm, Model model) {
        
        
        try {
            String jwt = loginService.getJWT(loginForm);
            httpSession.setAttribute("jwt", jwt);
            httpSession.setAttribute("pseudo", loginForm.getUsername());

            return "redirect:/";

        } catch (Forbidden e) {
            httpSession.removeAttribute("jwt");
            httpSession.removeAttribute("pseudo");

            model.addAttribute("error", "Pseudo/Mot de passe invalide");
            model.addAttribute("login", loginForm);

            return "LoginForm";
        }

    }
    
}
