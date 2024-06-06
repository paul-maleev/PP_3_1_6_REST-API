package work;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class GetCode {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = applicationContext.getBean("communication", Communication.class);
        String key = "";
        List<String> cookie = communication.getCookie();
        System.out.println("Cookie: " + cookie);

        User user1 = new User(3L, "James", "Brown", (byte) 3);
        String part1 = communication.saveUser(user1, cookie);
        key += part1;
        System.out.println("Первая часть кода: " + part1);

        User user2 = new User(3L, "Thomas", "Shelby", (byte) 3);
        String part2 = communication.editUser(user2, cookie);
        key += part2;
        System.out.println("Вторая часть кода: " + part2);

        String part3 = communication.deleteUser(3, cookie);
        key += part3;
        System.out.println("Третья часть кода: " + part3);

        // 5ebfebe7cb975dfcf9
        System.out.println("Код полностью: " + key + " Длинна: " + key.length());
    }
}
