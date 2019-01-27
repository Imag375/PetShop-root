package ru.mirea.auth;

import org.springframework.jdbc.core.RowMapper;
import ru.mirea.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("userID");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        String role = resultSet.getString("role");

        return new User(id, login, password, role);
    }
}
