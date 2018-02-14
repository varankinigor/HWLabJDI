package site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColors;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsForm extends Form {

    @FindBy(css = "#odds-selector p")
    private RadioButtons oddsSelector;

    @FindBy(css = "#even-selector p")
    private RadioButtons evenSelector;

    @FindBy(css = "#elements-checklist p")
    private CheckList elementsCheckList;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li")
    )
    private Dropdown colorsDropdown;

    @JComboBox(
            root = @FindBy(css = ".metals"),
            list = @FindBy(tagName = "li"),
            expand = @FindBy(css = ".caret")
    )
    private ComboBox metalsComboBox;

    @JDropdown(

            root = @FindBy(css = "#salad-dropdown"),
            list = @FindBy(css = "ul li"),
            value = @FindBy(css = ".btn"),
            expand= @FindBy(css = ".caret")
    )
    private Dropdown vegetablesDropdown;

    @FindBy(css = "#submit-button")
    private Button submitButton;

    public void fillMetalsColorsForm(MetalsColors metalsColors) {
        oddsSelector.select(metalsColors.summary[0].toString());
        evenSelector.select(metalsColors.summary[1].toString());

        elementsCheckList.check(metalsColors.elements);

        colorsDropdown.select(metalsColors.color);

        metalsComboBox.select(metalsColors.metals);

        // TODO you should create you own UI Element for this purpose...
        // TODO maybe it will be better to extends it from Dropdown or smth else ?
        // done
        if (!vegetablesDropdown.getValue().equals("")) {
            for (String vegetable : vegetablesDropdown.getText().split(", ")) {
                vegetablesDropdown.select(vegetable);
            }
        }
        for (String vegetable : metalsColors.vegetables) {
            vegetablesDropdown.select(vegetable);
        }

        submitButton.click();
    }
}
