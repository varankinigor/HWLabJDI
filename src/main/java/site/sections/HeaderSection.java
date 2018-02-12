package site.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import site.forms.LoginForm;

public class HeaderSection extends Section {

    @FindBy(css = ".m-l8")
    public HeaderMenu headerMenu;

    @FindBy(css = ".profile-photo")
    public Button expanderButton;

    @FindBy(css = ".logout .btn-login")
    public Button logoutButton;

    public LoginForm loginForm;

    @Step
    public void login(User user) {
        expanderButton.click();
        loginForm.loginAs(user);
        expanderButton.should(Condition.text(user.name));
    }

    @Step
    public void logout() {

        expanderButton.click();
        logoutButton.click();
    }
}