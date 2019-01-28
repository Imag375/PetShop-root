package ru.mirea.auth;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.Token;
import ru.mirea.User;

@Service
public class AuthService {



    private AuthDAO authDAO;

    @Autowired
    public AuthService(AuthDAO authDAO){
        this.authDAO = authDAO;
    }

    public Token getToken(User auth) {
        User user = authDAO.getUserByLogin(auth.getLogin());
        String secretKey = "SuperSecretKey";
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
