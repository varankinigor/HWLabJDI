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
    private CheckList elementsCheckList = new CheckList() {
        @Override
        protected void selectListAction(String... names) {
            if (names.length != 0) {
                super.selectListAction(names);
            }
        }
    };

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
            expand = @FindBy(css = ".caret")
    )
    private Dropdown vegetablesDropdown;

    @FindBy(css = "#submit-button")
    private Button submitButton;

    public void fillMetalsColorsForm(MetalsColors metalsColors) {
        if (metalsColors.getSummary().length == 2) {
            oddsSelector.select(metalsColors.getSummary()[0].toString());
            evenSelector.select(metalsColors.getSummary()[1].toString());
        }

//        if (metalsColors.getElements().length != 0) {
//            elementsCheckList.check(metalsColors.getElements());
//        }
        elementsCheckList.check(metalsColors.getElements());

        if (metalsColors.getColor().length() != 0) {
            colorsDropdown.select(metalsColors.getColor());
        }

        if (metalsColors.getMetals().length() != 0) {
            metalsComboBox.select(metalsColors.getMetals());
        }
        // TODO you should create you own UI Element for this purpose...
        // TODO maybe it will be better to extends it from Dropdown or smth else ?
        // done
        // TODO what dou you mean 'done' ? I do not see any difference...
        // TODO take a look on elementsCheckList, i refactored it for you...
        if (!vegetablesDropdown.getValue().equals("")) {
            for (String vegetable : vegetablesDropdown.getText().split(", ")) {
                vegetablesDropdown.select(vegetable);
            }
        }

        for (String vegetable : metalsColors.getVegetables()) {
            vegetablesDropdown.select(vegetable);
        }

        submitButton.click();
    }
}