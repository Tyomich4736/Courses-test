package by.nosevich.courses.test.dao;

import by.nosevich.courses.test.dto.UserDto;
import by.nosevich.courses.test.exception.UserGettingException;
import by.nosevich.courses.test.exception.UserSavingException;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void save(UserDto user) throws UserSavingException;

    void update(UserDto user);

    Optional<UserDto> getById(Long id) throws UserGettingException;

    List<UserDto> getAll();
}
