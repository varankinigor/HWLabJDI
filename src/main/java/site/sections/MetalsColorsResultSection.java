package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import entities.MetalsColors;
import org.openqa.selenium.support.FindBy;
import utils.LogWork;

import java.util.Map;

public class MetalsColorsResultSection extends Section {

    @FindBy(css = ".results li")
    private TextList actualResultTextList;

    public void checkResultSection(MetalsColors metalsColors) {
        Map<String, String> expectedLogMap = metalsColors.getResultLog();
        Map<String, String> actualLogMap = LogWork.prepareLog(actualResultTextList);

        Assert.arrayEquals(actualLogMap.keySet().toArray(), expectedLogMap.keySet().toArray());

        for (String key : expectedLogMap.keySet()) {
            // TODO message should contains expected and actual results...
            // TODO done ?? Where is the ERROR message with data ? You just get "java.lang.AssertionError: Check that Collections are equal failed" !!
            Assert.assertEquals(actualLogMap.get(key), expectedLogMap.get(key),
                    "Key: " + key + " Actual log: " + actualLogMap.get(key) + " Expected log: " + expectedLogMap.get(key) + " in data with summary " + expectedLogMap.get("Summary"));
        }
    }
}
