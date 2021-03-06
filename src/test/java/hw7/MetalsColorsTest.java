package hw7;


import entities.MetalsColors;
import entities.User;
import enums.EpamPagesEnum;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import site.EpamSite;
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
        EpamSite.homePage.headerSection.login(User.PITER_CHAILOVSKII);

        //2 Open Metals & Colors page by Header headerMenu
        EpamSite.homePage.headerSection.headerMenu.mySelect(EpamPagesEnum.METALS_COLORS);
        EpamSite.metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data
        EpamSite.metalsColorsPage.metalsColorsForm.fillMetalsColorsForm(MetalsColors.DEFAULT_DATA);

        //4 Check result section
        EpamSite.metalsColorsPage.metalsColorsResultSection.checkResultSection(MetalsColors.DEFAULT_DATA);
    }
}
