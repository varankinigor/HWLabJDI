package hw7;


import entities.MetalsColors;
import entities.User;
import enums.EpamPagesEnum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import site.EpamSite;
import site.sections.MetalsColorsResultSection;
import test_base.TestInit;

//@Listeners(listeners.AllureAttachmentListener.class)
public class MetalsColorsTest extends TestInit {

    @BeforeMethod
    public void openHomePage() {
        EpamSite.homePage.open();
        EpamSite.homePage.checkOpened();
    }

    @AfterMethod
    public void tearDown() {
        EpamSite.metalsColorsPage.headerSection.logout();
    }

    @Test
    public void submitMetalsColorsForm() {
        //1 Login on JDI site as User
        // TODO create a CONSTANT for this particular user.
        EpamSite.homePage.headerSection.login(new User());

        //2 Open Metals & Colors page by Header headerMenu
        EpamSite.homePage.headerSection.headerMenu.mySelect(EpamPagesEnum.METALS_COLORS);
        EpamSite.metalsColorsPage.checkOpened();

        // TODO you should make a CONSTANT for this particular data, like User
        //3 Fill form Metals & Colors by data
        MetalsColors defaultMetalsColors = new MetalsColors();
        EpamSite.metalsColorsPage.metalsColorsForm.fillMetalsColorsForm(defaultMetalsColors);

        // TODO this should not be here, encapsulate it in one of the UI Elements
        // TODO take a look on login feature...
        //4 Submit form Metals & Colors
        EpamSite.metalsColorsPage.metalsColorsForm.submitButton.click();

        // TODO i assume that this test should be passed...
        // 51:05.974 ERROR: Wrong Elements
        // at site.sections.MetalsColorsResultSection.checkResultSection(MetalsColorsResultSection.java:24)
        // at hw7.MetalsColorsTest.submitMetalsColorsForm(MetalsColorsTest.java:48)
        //5 Check result section
        EpamSite.metalsColorsPage.metalsColorsResultSection.checkResultSection(defaultMetalsColors);
    }
}
