package hiber;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Вагнер", "Лав", "qwere@wwww.com");
      User user2 = new User("Володя", "Старый дед", "wwww@qqqq.com");
      User user3 = new User("Пригожкин", "Рогожкин", "wertd@huuuuu.com");
      User user4 = new User("Песков", "Безвводный", "pioyh@dffgg.com");

      Car car1 = new Car("Карета", 22);
      Car car2 = new Car("На жопе", 111);
      Car car3 = new Car("Самолет", 7);
      Car car4 = new Car("С божью помощью", 35);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());}
      System.out.println(userService.getUserByCar(" На жопе", 1111));
      context.close();
   }
}