package mirea.balance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.domain.Cart;
import ru.mirea.domain.Item;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class BalanceController {
    @RequestMapping(value = "tray", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> tray() {

        return Cart.shoppingList;
    }

    @RequestMapping(value = "tray", method = RequestMethod.PUT)
    @ResponseBody
    BigDecimal checkout() {
        BigDecimal a = new BigDecimal("0");
        for (Item item : Cart.shoppingList) {
            // ?
            a = a.add(item.getPrice());
        }
        Cart.shoppingList.clear();
        return a;
    }

    @RequestMapping(value = "tray/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void delete(@PathVariable int id) {

        Cart.deleteFromCart(id);
    }
}
