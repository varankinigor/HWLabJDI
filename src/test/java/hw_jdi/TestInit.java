package hw_jdi;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw_jdi.epam_site.EpamSite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebSite.init(EpamSite.class);
    }
}
