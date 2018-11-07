package com.warung.makmi.warungapi.handler;

import com.warung.makmi.warungapi.dto.User;
import com.warung.makmi.warungapi.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private MasterUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        handle(httpServletRequest,httpServletResponse,authentication);
        clearAuthenticationAttributes(httpServletRequest);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
        String username = authentication.getName();

        response.setHeader(HttpHeaders.LOCATION, request.getServletContext().getContextPath() + "/#/");

        String role = new String();

        for (GrantedAuthority value : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            role = value.getAuthority();
        }

        User user = new User();
        try {
            user = userService.findByEmail(username);
        }catch (Exception e){

        }

        try {
            try (PrintWriter writer = response.getWriter()) {
                writer.write("{\"status\":\"success"
                        + "\", \"email\":\"" + user.getEmail() + ""
                        + "\", \"namaLengkap\":\"" + user.getNamaLengkap() + ""
                        + "\", \"roles\":\"" + role + "\"}");
                writer.flush();
                writer.close();
            }
        }catch (Exception e){
            response.setStatus(401);
            try (PrintWriter writer = response.getWriter()) {
                writer.write("{\"status\":\"error"
                        + "\", \"data\":\"" + e.getMessage() + "\"}");
                writer.flush();
                writer.close();
            }
        }

    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
