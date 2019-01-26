package ru.mirea.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ru.mirea.Balance;

@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @RequestMapping(value = "balance/{userID}", method = RequestMethod.GET)
    @ResponseBody
    public Balance getBalance(@PathVariable int userID)
    {
        return balanceService.getBalance(userID);
    }

    @RequestMapping(value = "balance/{userID}", method = RequestMethod.POST)
    @ResponseBody
    public void getBalance(@PathVariable int userID, @RequestBody Balance balance) {
        balanceService.updateBalance(balance.getMoney(), userID);
    }
}
