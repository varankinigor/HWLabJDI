package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    public static final User PITER_CHAILOVSKII = new User("epam", "1234", "Piter Chailovskii");

    private String login;
    private String password;
    private String name;
}
