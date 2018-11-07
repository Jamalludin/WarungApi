package com.warung.makmi.warungapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, e.getMessage());

        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write("{\"status\":\"error"
                    + "\", \"data\":\"" + e.getMessage() + "\"}");
            writer.flush();
            writer.close();
        }
    }
}
