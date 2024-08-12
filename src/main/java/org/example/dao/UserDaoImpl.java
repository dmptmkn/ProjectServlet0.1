package org.example.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.entity.User;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    private static final String SAVE_QUERY = """
            INSERT INTO user (name, last_name, age, login, password)
            VALUES (?, ?, ?, ?, ?)
            """;
    private static final String FIND_ALL_QUERY = """
            SELECT * FROM user
            """;
    private static final String FIND_BY_ID_QUERY = FIND_ALL_QUERY + """
            WHERE id = ?
            """;
    private static final String UPDATE_QUERY = """
            UPDATE user
            SET name      = ?,
                last_name = ?,
                age       = ?,
                login     = ?,
                password  = ?
            WHERE id = ?
            """;
    private static final String DELETE_QUERY = """
            DELETE
            FROM user
            WHERE id = ?
            """;

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    @SneakyThrows
    public boolean save(User user) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_QUERY)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());

            int rowCount = preparedStatement.executeUpdate();
            return rowCount != 0;
        }
    }

    @Override
    @SneakyThrows
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = preparedStatement.getResultSet()) {
            while (resultSet.next()) {
                User user = buildUser(resultSet);
                users.add(user);
            }
        }

        return users;
    }


    @Override
    @SneakyThrows
    public User findById(Long id) {
        User user = null;

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = preparedStatement.getResultSet()) {
            preparedStatement.setLong(1, id);
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
        }

        return user;
    }

    @Override
    @SneakyThrows
    public boolean update(Long id, User user) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setLong(4, id);

            int rowCount = preparedStatement.executeUpdate();
            return rowCount != 0;
        }
    }

    @Override
    @SneakyThrows
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);

            int rowCount = preparedStatement.executeUpdate();
            return rowCount != 0;
        }
    }

    @SneakyThrows
    private User buildUser(ResultSet resultSet) {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .lastName(resultSet.getString("last_name"))
                .age(resultSet.getInt("age"))
                .login(resultSet.getString("login"))
                .password(resultSet.getString("password"))
                .build();
    }
}
