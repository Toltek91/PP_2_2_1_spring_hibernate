package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Mike", "Sokolov", "mike_sok1@mail.ru",new Car("bmw",5));
        User user2 = new User("Andrew", "Barton", "adnrew-bar@gamil.com", new Car("audi", 2));
        User user3 = new User("Nick", "Volt", "nickV@outlook.com",new Car("toyota",8));
        User user4 = new User("Rick", "Morty", "rick_mp@gmail.com",new Car("skoda",4));
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("ID = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println("-------------------------------");
        }
        //userService.findUser("bmw", 5);
        context.close();
    }
}
