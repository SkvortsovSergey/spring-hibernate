package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main (String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        userService.add(new User("Vasia", "Pupkin", "vas@mail.ru", new Car("lambo", 666)));
        userService.add(new User("Grisha", "Sidorov", "vv@mail.ru", new Car("BMW", 777)));
        userService.add(new User("Sergey", "Petrosian", "vdfgas@mail.ru", new Car("BMW", 777)));
        userService.add(new User("Marat", "Fedorov", "vaffgdsbs@mail.ru", new Car("Jiga", 2107)));
        System.out.println("\nРезультат поиска User по модели и серии авто.\n"
                + userService.findUserByModelAndSeries("lambo", 666));

        context.close();
    }
}
