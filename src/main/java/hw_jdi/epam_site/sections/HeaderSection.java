package hw_jdi.epam_site.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw_jdi.entities.User;
import hw_jdi.epam_site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class HeaderSection extends Section{

    @FindBy(css = ".m-l8")
    public HeaderMenu headerMenu;

    @FindBy(css = ".profile-photo")
    public Button expanderButton;

    public LoginForm loginForm;

    @Step
    public void login(User user) {
        expanderButton.click();
        loginForm.loginAs(user);
        expanderButton.should(Condition.text(user.name));
    }
}
