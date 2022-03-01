package ru.kazan.maksat.services;

import ru.kazan.maksat.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws SQLException;
}
