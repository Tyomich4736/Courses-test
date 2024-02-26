package by.nosevich.courses.test.config;

import by.nosevich.courses.test.dao.DbUserDao;
import by.nosevich.courses.test.dao.UserDao;
import by.nosevich.courses.test.logger.ConsoleLogger;
import by.nosevich.courses.test.logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserDao userDao() {
        DbUserDao dbUserDao = new DbUserDao();
        dbUserDao.setDbUrl("jdbc:postgresql://localhost:5432/postgres");
        dbUserDao.setDbUsername("test_user");
        dbUserDao.setDbPassword("password");
        dbUserDao.setLogger(logger());
        return dbUserDao;
    }

    @Bean
    public Logger logger() {
        return new ConsoleLogger();
    }
}
