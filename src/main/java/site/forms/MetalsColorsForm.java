package site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
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

    @FindBy(css = ".salad .btn")
    private Button expandVegetablesButton;

    @FindBy(css = ".salad ul li")
    private CheckList vegetablesCheckList;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    public void fillMetalsColorsForm(MetalsColors metalsColors) {
        oddsSelector.select(metalsColors.summary[0].toString());
        evenSelector.select(metalsColors.summary[1].toString());

        elementsCheckList.check(metalsColors.elements);

        colorsDropdown.select(metalsColors.color);

        metalsComboBox.select(metalsColors.metal);

        // TODO you should create you own UI Element for this purpose...
        // TODO maybe it will be better to extends it from Dropdown or smth else ?
        expandVegetablesButton.click();
        if (!expandVegetablesButton.getText().equals("")) {
            String[] chosenVegetables = expandVegetablesButton.getText().split(", ");
            for (String vegetable : chosenVegetables) {
                vegetablesCheckList.check(vegetable);
            }
        }
        vegetablesCheckList.check(metalsColors.vegetables);
    }
}
