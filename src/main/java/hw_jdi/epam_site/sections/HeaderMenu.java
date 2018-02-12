package hw_jdi.epam_site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import hw_jdi.enums.EpamPagesEnum;

public class HeaderMenu extends Menu {

    public void mySelect(EpamPagesEnum page) {
        super.select(page.text);
    }
}
