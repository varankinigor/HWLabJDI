package entities;

import com.epam.commons.DataClass;
import enums.UserEnum;

public class User extends DataClass {
    public final String login;
    public final String password;
    public final String name;

    public User(UserEnum userEnum) {
        this.login = userEnum.login;
        this.password = userEnum.password;
        this.name = userEnum.name;
    }
}
