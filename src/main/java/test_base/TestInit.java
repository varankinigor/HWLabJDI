package test_base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        // TODO and where is the driver ??
        // gitignore ate it
        // done
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebSite.init(site.EpamSite.class);
    }
}
