package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import enums.EpamPagesEnum;

public class HeaderMenu extends Menu {

    public void mySelect(EpamPagesEnum page) {
        // TODO i guess page.toString will be better
        super.select(page.text);
    }
}
