package ru.mirea.cart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.mirea.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private Map<String, String> config;
    private CartDAO cartDAO;
    private HttpHeaders headers;

    @Autowired
    public CartService(CartDAO cartDAO) throws JsonProcessingException {
        this.cartDAO = cartDAO;

        RestTemplate restTemplate = new RestTemplate();
        config = restTemplate.getForObject("http://localhost:8085/config", Map.class);

        Token token = new Token(4, User.Role.Admin);
        String signature = DigestUtils.sha256Hex(token.toString() + "SuperSecretKey");
        token.setSignature(signature);
        ObjectMapper objectMapper = new ObjectMapper();
        String tokenHeader = objectMapper.writer().writeValueAsString(token);

        headers = new HttpHeaders();
        headers.add("Token" , tokenHeader);

    }


    public void putPet(int id, int userID) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<Pet[]> pet = restTemplate.exchange(config.get("Item") + "/pet/" + id, HttpMethod.GET, httpEntity, Pet[].class);

        if (pet.getBody().length != 0 && pet.getBody()[0].getCount() != 0) {
            restTemplate.exchange(config.get("Item") + "/item/" + pet.getBody()[0].getId() + "/sub", HttpMethod.POST, httpEntity, Item.class);
            cartDAO.addItem(userID, id, pet.getBody()[0].getName(), pet.getBody()[0].getPrice());
        }
    }

    public void putStaff(int id, int userID) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<Stuff[]> stuff = restTemplate.exchange(config.get("Item") + "/staff/" + id, HttpMethod.GET, httpEntity, Stuff[].class);

        if (stuff.getBody().length != 0 && stuff.getBody()[0].getCount() != 0) {
            restTemplate.exchange(config.get("Item") + "/item/" + stuff.getBody()[0].getId() + "/sub", HttpMethod.POST, httpEntity, Item.class);
            cartDAO.addItem(userID, id, stuff.getBody()[0].getName(), stuff.getBody()[0].getPrice());
        }
    }

    public void deleteItem(int id, int userID) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(headers);
        restTemplate.exchange(config.get("Item") + "/item/" + id + "/add", HttpMethod.POST, httpEntity, Item.class);
        cartDAO.deleteItem(id , userID);
    }

    public List<CartItem> getItems(int userID) {
        return cartDAO.findAll(userID);
    }

    public String buyItems(int userID) {
        BigDecimal totalPrice = cartDAO.getTotalPrice(userID);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<Balance> balanceResponseEntity = restTemplate.exchange(config.get("Balance") + "/balance/" + userID, HttpMethod.GET, httpEntity, Balance.class);
        Balance balance = balanceResponseEntity.getBody();

        if (balance.getMoney().compareTo(totalPrice) == -1) {
            return "Error! Small balance!";
        }

        Balance newBalance = new Balance(userID, balance.getMoney().subtract(totalPrice));
        HttpEntity httpEntityWithBody = new HttpEntity(newBalance, headers);
        restTemplate.exchange(config.get("Balance") + "/balance/" + userID, HttpMethod.POST, httpEntityWithBody, Balance.class);

        cartDAO.deleteAll(userID);
        return "OK";
    }
}
