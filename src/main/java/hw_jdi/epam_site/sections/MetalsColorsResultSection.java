package hw_jdi.epam_site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import hw_jdi.entities.MetalsColors;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetalsColorsResultSection extends Section {

    @FindBy(css = ".results li")
    public TextList resultList;

    public void checkResultSection(MetalsColors metalsColors) {
        Map<String, String[]> expectedLog = metalsColors.getResultLog();

        Map<String, String[]> actualLog = new HashMap<>();

        List<String> actualLogList = resultList.getTextList();
        for (String actualLogString : actualLogList) {
            for (String key : expectedLog.keySet()) {
                if (actualLogString.startsWith(key)) {
                    actualLog.put(key, actualLogString.substring(key.length() + 2).split(", "));
                }
            }
        }

        for (String key : actualLog.keySet()) {
            Assert.arrayEquals(actualLog.get(key), expectedLog.get(key), "Wrong " + key);
        }
    }
}
