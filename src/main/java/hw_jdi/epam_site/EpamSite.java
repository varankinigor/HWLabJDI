package hw_jdi.epam_site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import hw_jdi.epam_site.pages.HomePage;
import hw_jdi.epam_site.pages.MetalsColorsPage;

@JSite("https://epam.github.io/JDI")
public class EpamSite extends WebSite {

    @JPage(url = "index.html", title = "Home Page")
    public static HomePage homePage;

    @JPage(url = "metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;
}
