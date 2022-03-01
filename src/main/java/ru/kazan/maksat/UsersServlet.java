package ru.kazan.maksat;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import ru.kazan.maksat.models.User;
import ru.kazan.maksat.repositories.UsersRepository;
import ru.kazan.maksat.repositories.UsersRepositoryJdbcImpl;
import ru.kazan.maksat.services.UserService;
import ru.kazan.maksat.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/users")

public class UsersServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("qwertyuiop123");
        hikariConfig.setMaximumPoolSize(10);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        this.userService = new UserServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(userService.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
