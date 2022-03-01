package ru.kazan.maksat.services;

import ru.kazan.maksat.models.User;
import ru.kazan.maksat.repositories.UsersRepository;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {

        return usersRepository.findAll();
    }
}
