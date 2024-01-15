package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);






        Car car1 = new Car("bmw", 1);
        Car car2 = new Car("audi", 2);
        Car car3 = new Car("skoda", 5);
        Car car4 = new Car("nissan", 7);

        User user1 = new User("Mike", "Sokolov", "mike_sok1@mail.ru",car1);
        User user2 = new User("Andrew", "Barton", "adnrew-bar@gamil.com",car2);
        User user3 = new User("Nick", "Volt", "nickV@outlook.com",car3);
        User user4 = new User("Rick", "Morty", "rick_mp@gmail.com",car4);


        userService.add(user1,car1);
        userService.add(user2,car2);
        userService.add(user3,car3);
        userService.add(user4,car4);




        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("ID = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println("-------------------------------");
        }
       userService.getUserCar("audi", 2);
       context.close();
    }
}
