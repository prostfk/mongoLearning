package by.prostrmk.mongocheck.repository;

import by.prostrmk.mongocheck.MongocheckApplication;
import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongocheckApplication.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Before
    public void setUp() throws Exception {
//        User user = new User("Roman", "123");
//        User user1 = new User("Vova", "13223");
//        User user2 = new User("Valera", "1sdgdf23");
//        User user3 = new User("Igor", "12gdfgd3");
//        User user4 = new User("Andrey", "123dgfdfg");
    }

    @Test
    public void findUserByName() {
        System.out.println("FIND USER BY NAME");
        User roman = repository.findUserByName("Roman");
        System.out.println(roman);
        assertEquals("123", roman.getPassword());
    }

    @Test
    public void findUserByNameIgnoreCase() {
        System.out.println("FIND USER BY NAME IGNORE CASE");
        User roMAn = repository.findUserByNameIgnoreCase("roMAn");
        System.out.println(roMAn);
        assertEquals("123", roMAn.getPassword());
    }

    @Test
    public void findUsersByNameLikeTestIgnoreCase() {
        List <User> all = repository.findUsersByNameLikeIgnoreCase("va");
        System.out.println("FIND USERS BY NAME LIKE IGNORE CASE TEST");
        all.forEach(System.out::println);
    }

    @Test
    public void findUsersByNameEndsWith() {
        System.out.println("FIND USERS BY NAME ENDS WITH");
        List<User> a = repository.findUsersByNameEndsWith("a");
        assertEquals(2,a.size());
    }
}
