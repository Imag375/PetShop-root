package ru.mirea;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenValidator {

    static public final String secretKey = "SuperSecretKey";

    static Token Validate(ServletRequest servletRequest) throws IOException {
        String tokenStr = ((HttpServletRequest)servletRequest).getHeader("token");

        if (tokenStr != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Token token = objectMapper.readValue(tokenStr, Token.class);

            String signature = DigestUtils.sha256Hex(token.toString() + secretKey);

            return  token.getSignature().equals(signature) ? token : null;
        }

        return null;
    }
}
