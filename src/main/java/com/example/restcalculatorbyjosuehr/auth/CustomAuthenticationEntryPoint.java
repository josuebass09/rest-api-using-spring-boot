package com.example.restcalculatorbyjosuehr.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Override the commence function in order to make a custom authentication response
     * @param req
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.getOutputStream().print("{\"error\":\"Unauthorized.. Please Authenticate..\"}");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
