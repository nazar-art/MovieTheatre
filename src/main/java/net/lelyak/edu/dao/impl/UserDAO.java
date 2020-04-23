package net.lelyak.edu.dao.impl;

import net.lelyak.edu.dao.BaseDAO;
import net.lelyak.edu.entity.User;
import net.lelyak.edu.utils.Logger;
import net.lelyak.edu.utils.SQLStatements;
import net.lelyak.edu.utils.StringUtilities;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.Arrays;

public class UserDAO extends BaseDAO<User> {

    private static final String USER_TABLE_NAME = "t_user";
    private static final String[] userFields = {"name", "birthday", "email", "password", "role", "enabled"};

    public UserDAO() {
        super(User.class, USER_TABLE_NAME, Arrays.asList(userFields));
    }

    public User getByEmail(String email) {
        String sql = StringUtilities
                .appendStrings(SQLStatements.SELECT_FROM_TABLE_BY_EMAIL, USER_TABLE_NAME);

        MapSqlParameterSource parameters = new MapSqlParameterSource("email", email);

        Logger.debug(StringUtilities.appendStrings("getByEmail( %s ), SQL : [%s] ", email, sql));

        User user = getNamedParameterJdbcTemplate()
                .queryForObject(sql, parameters, new BeanPropertyRowMapper<>(User.class));

        Logger.debug(StringUtilities.appendStrings("getByEmail( %s ) : %s ", email, user.toString()));

        return user;
    }

    public boolean isUserPresented(String email) {
        return existsByEmail(email);
    }
}
