package by.nosevich.courses.test.dao;

import by.nosevich.courses.test.dto.UserDto;
import by.nosevich.courses.test.exception.UserGettingException;
import by.nosevich.courses.test.exception.UserSavingException;
import by.nosevich.courses.test.logger.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class DbUserDao implements UserDao {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private Logger logger;

    @Override
    public void save(UserDto user) throws UserSavingException {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement("insert into users (id, first_name, surname, is_active) values (?, ?, ?, ?)")) {
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getSurname());
            statement.setBoolean(4, user.getActive());

            statement.execute();
            logger.printMessage("User with id=" + user.getId() + " has been saved successfully");
        } catch (SQLException e) {
            logger.printMessage("Error on user saving occurred: " + e.getMessage());
            throw new UserSavingException(e);
        }
    }

    @Override
    public void update(UserDto user) {
        //TODO
    }

    @Override
    public Optional<UserDto> getById(Long id) throws UserGettingException {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement("select id, first_name, surname, is_active from users where id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return Optional.empty();
            }
            UserDto userDto = new UserDto();
            userDto.setId(resultSet.getLong("id"));
            userDto.setFirstName(resultSet.getString("first_name"));
            userDto.setSurname(resultSet.getString("surname"));
            userDto.setActive(resultSet.getBoolean("is_active"));
            return Optional.of(userDto);
        } catch (SQLException e) {
            logger.printMessage("Error on user getting occurred: " + e.getMessage());
            throw new UserGettingException(e);
        }
    }

    @Override
    public List<UserDto> getAll() {
        return null; //TODO
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
