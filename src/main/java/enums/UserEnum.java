package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserEnum {
    PITER_CHAILOVSKII("epam","1234","Piter Chailovskii");

    public final String login;
    public final String password;
    public final String name;
}
