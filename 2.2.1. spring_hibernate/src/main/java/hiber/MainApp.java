package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("User5", "Lastname5", "user5@mail.ru");
      User user2 = new User("User6", "Lastname6", "user6@mail.ru");
      User user3 = new User("User7", "Lastname7", "user7@mail.ru");
      User user4 = new User("User8", "Lastname8", "user8@mail.ru");

      user1.setCar(new Car("Toyota", 0));
      user2.setCar(new Car("Jetta", 2));
      user3.setCar(new Car("Audi", 80));
      user4.setCar(new Car("Astra", 3));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      List<User> userList = userService.listUsers();
      System.out.println(userList);
      userList.forEach(user -> System.out.println(user.getCar()));

      System.out.println(userService.getUserByCar("Jetta", 2));



//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
