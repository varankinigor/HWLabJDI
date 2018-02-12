package hw_jdi.epam_site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import hw_jdi.enums.EPAM_PAGES;

public class HeaderMenu extends Menu {

    public void mySelect(EPAM_PAGES page) {
        super.select(page.text);
    }
}
