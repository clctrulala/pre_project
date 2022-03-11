package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl sao = new UserServiceImpl();
        sao.createUsersTable();

        List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Dominik", "Orero", (byte) 18),
            new User("Roberta", "Potter", (byte) 55),
            new User("Abraham", "Livenshtein", (byte) 38),
            new User("Nikita", "Novikov", (byte) 6)
        ));
        for (User user : userList) {
            sao.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем - %s добавлен в базу\n", user.getName());
        }

        for (User user : sao.getAllUsers()) {
            System.out.println(user);
        }

        sao.cleanUsersTable();
        sao.dropUsersTable();
    }
}
