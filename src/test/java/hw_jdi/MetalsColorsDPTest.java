package hw_jdi;

import hw_jdi.entities.MetalsColors;
import hw_jdi.entities.User;
import hw_jdi.enums.EpamPagesEnum;
import hw_jdi.epam_site.EpamSite;
import hw_jdi.utils.DataLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//@Listeners(hw_jdi.listeners.AllureAttachmentListener.class)
public class MetalsColorsDPTest extends TestInit {
    @BeforeMethod
    public void openHomePage() {
        EpamSite.homePage.open();
        EpamSite.homePage.checkOpened();
    }

    @AfterMethod
    public void tearDown() {
        EpamSite.metalsColorsPage.headerSection.logout();
    }

    @DataProvider
    public Object[][] getData() {
        DataLoader dataLoader = new DataLoader();
        return dataLoader.data;
    }

    @Test(dataProvider = "getData")
    public void submitMetalsColorsWithDP(MetalsColors metalsColors) {
        //1 Login on JDI site as User
        EpamSite.homePage.headerSection.login(new User());

        //2 Open Metals & Colors page by Header headerMenu
        EpamSite.homePage.headerSection.headerMenu.mySelect(EpamPagesEnum.METALS_COLORS);
        EpamSite.metalsColorsPage.checkOpened();

        //3 Fill form Metals & Colors by DataProvider
        EpamSite.metalsColorsPage.metalsColorsForm.fillMetalsColorsForm(metalsColors);

        //4 Submit form Metals & Colors
        EpamSite.metalsColorsPage.metalsColorsForm.submitButton.click();

        //5 Result sections should contains data from DataProvider
        EpamSite.metalsColorsPage.metalsColorsResultSection.checkResultSection(metalsColors);
    }
}
