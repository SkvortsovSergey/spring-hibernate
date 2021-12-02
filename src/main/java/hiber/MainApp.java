package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {

    public static void main (String[] args)  {
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
        Car car1 = new Car("lambo", 666);
        Car car2 = new Car("BMW", 777);
        Car car3 = new Car("Jiga", 2107);
        User user1 = new User("Vasia", "Pupkin", "vas@mail.ru");
        User user2 = new User("Grisha", "Sidorov", "vv@mail.ru");
        User user3 = new User("Sergey", "Petrosian", "vdfgas@mail.ru");
        User user4 = new User("Marat", "Fedorov", "vaffgdsbs@mail.ru");
        user1.setCar(car1);
        user2.setCar(car1);
        user3.setCar(car2);
        user4.setCar(car3);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        System.out.println("\nРезультат поиска User по модели и серии авто.\n"
                + userService.findUserByModelAndSeries("lambo", 666));

        context.close();
    }
}
