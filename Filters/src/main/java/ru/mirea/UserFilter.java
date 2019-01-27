package ru.mirea;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class UserFilter {

    static void CheckUserToken(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Token token = TokenValidator.Validate(servletRequest);
        if (token != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
