package ru.mirea.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;
import ru.mirea.CartItem;
import ru.mirea.price.TotalPrice;
import ru.mirea.price.TotalPriceRowMapper;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CartDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CartItem> findAll(int userID) {
        return jdbcTemplate.query("select * from Cart where userID = " + userID, new ItemRowMapper());
    }

    public void addItem(int userID, int itemID, String name, BigDecimal price) {
        if (!jdbcTemplate.query("select * from Cart where userID = " + userID +
                " and itemID = " + itemID, new ItemRowMapper()).isEmpty()) {
            jdbcTemplate.execute("update Cart set price = price + " + price +
                    " where userID = " + userID + " and itemID = " + itemID);
            jdbcTemplate.execute("update Cart set" +
                    " count = count + 1 where userID = " + userID + " and itemID = " + itemID);
        }
        else
            jdbcTemplate.execute("insert into Cart values(" +
                    userID + ", " +
                    itemID + ", '" +
                    name + "', " +
                    price + ", " +
                    1 + ")");
    }

    public void deleteItem(int itemID, int userID) {
        if (jdbcTemplate.query("select * from Cart where userID = " + userID +
                " and itemID = " + itemID, new ItemRowMapper()).get(0).getCount() > 1)
            jdbcTemplate.execute("update Cart set" +
                    " count = count - 1 where userID = " + userID + " and itemID = " + itemID);
        else
            jdbcTemplate.execute("delete from Cart where itemID =" + itemID + " and userID = " + userID);
    }

    public void deleteAll(int userID) {
        jdbcTemplate.execute("delete from Cart where userID = " + userID);
    }

    public TotalPrice getTotalPrice(int userID) {
        String query = "select sum(price) as TotalPrice from Cart where userID = " + userID;

        List<TotalPrice> totalPrice = jdbcTemplate.query(query, new TotalPriceRowMapper());

        return totalPrice.get(0);
    }
}
