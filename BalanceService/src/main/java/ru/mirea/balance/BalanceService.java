package ru.mirea.balance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mirea.Balance;

import java.math.BigDecimal;

@Service
public class BalanceService {

    private BalanceDAO balanceDAO;

    @Autowired
    public BalanceService(BalanceDAO balanceDAO){
        this.balanceDAO = balanceDAO;
    }

    public Balance getBalance(int userID) {
        return balanceDAO.getBalanceByUserID(userID).get(0);
    }

    public void updateBalance(BigDecimal newBalance, int userID) {
        balanceDAO.updateUserBalance(newBalance, userID);
    }
}
