package hw_jdi;

import hw_jdi.entities.MetalsColors;
import hw_jdi.entities.User;
import hw_jdi.enums.EPAM_PAGES;
import hw_jdi.epam_site.EpamSite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(hw_jdi.listeners.AllureAttachmentListener.class)
public class MetalsColorsTest extends TestInit {

    @BeforeMethod
    public void openHomePage() {
        EpamSite.homePage.open();
        EpamSite.homePage.checkOpened();
    }

    @Test
    public void submitMetalsColorsForm() {
        //1 Login on JDI site as User
        EpamSite.homePage.headerSection.login(new User());

        //2 Open Metals & Colors page by Header headerMenu
        EpamSite.homePage.headerSection.headerMenu.mySelect(EPAM_PAGES.METALS_COLORS);
        EpamSite.metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data
        MetalsColors defaultMetalsColors = new MetalsColors();
        EpamSite.metalsColorsPage.metalsColorsForm.fillMetalsColorsForm(defaultMetalsColors);

        //4 Submit form Metals & Colors
        EpamSite.metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Check result section
        EpamSite.metalsColorsPage.metalsColorsResultSection.checkResultSection(defaultMetalsColors);
    }

}
