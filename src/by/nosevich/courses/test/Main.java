package by.nosevich.courses.test;

import by.nosevich.courses.test.config.BeanConfiguration;
import by.nosevich.courses.test.dao.UserDao;
import by.nosevich.courses.test.dto.UserDto;
import by.nosevich.courses.test.exception.UserSavingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws UserSavingException {
        //Application Context, Bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        UserDto user = new UserDto(1L, "Test", "Test", true);
        userDao.save(user);
    }
}