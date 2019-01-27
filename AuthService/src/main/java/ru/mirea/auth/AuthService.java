package ru.mirea.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mirea.Token;
import ru.mirea.User;

public class AuthService {

    private final String secretKey = "SuperSecretKey";

    private AuthDAO authDAO;

    @Autowired
    public AuthService(AuthDAO authDAO){
        this.authDAO = authDAO;
    }

    public Token getToken(User auth)
    {
        User user = authDAO.getUserByLogin(auth.getLogin());

        if (user.getPassword().equals(auth.getPassword())){

            Token token = new Token(user.getId(), user.getRole());
            String signature = DigestUtils.sha256Hex(token.toString() + secretKey);
            token.setSignature(signature);

            return token;
        }
        else
            return null;
    }
}
