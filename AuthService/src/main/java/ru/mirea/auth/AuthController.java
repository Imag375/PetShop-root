package ru.mirea.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.Token;
import ru.mirea.User;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value ="user", method = RequestMethod.POST)
    @ResponseBody
    public Token getToken(@RequestBody User auth){
        return authService.getToken(auth);
    }
}
