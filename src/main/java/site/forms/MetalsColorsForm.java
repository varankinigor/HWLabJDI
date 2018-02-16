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

    @FindBy(css = "#elements-checklist p label")
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
            value = @FindBy(css = ".filter-option"),
            list = @FindBy(tagName = "li")
    )
    private Dropdown colorsDropdown = new Dropdown() {
        @Override
        protected void selectAction(String name) {
            if (!name.equals("")) {
                super.selectAction(name);
            }
        }
    };

    @JComboBox(
            root = @FindBy(css = ".metals"),
            list = @FindBy(tagName = "li"),
            expand = @FindBy(css = ".caret")
    )
    private ComboBox metalsComboBox = new ComboBox() {
        @Override
        protected void selectAction(String name) {
            if (!name.equals("")) {
                super.selectAction(name);
            }
        }
    };

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            value = @FindBy(css = ".btn"),
            list = @FindBy(css = ".checkbox"),
            expand = @FindBy(css = ".caret")
    )
    private Dropdown vegetablesDropdown = new Dropdown() {
        @Override
        protected void selectAction(String name) {
            if (!name.equals("")) {
                super.selectAction(name);
            }
        }
    };

    @FindBy(css = "#submit-button")
    private Button submitButton;

    public void fillMetalsColorsForm(MetalsColors metalsColors) {
        if (metalsColors.getSummary().length == 2) {
            oddsSelector.select(metalsColors.getSummary()[0].toString());
            evenSelector.select(metalsColors.getSummary()[1].toString());
        }

        elementsCheckList.check(metalsColors.getElements());

        colorsDropdown.select(metalsColors.getColor());

        metalsComboBox.select(metalsColors.getMetals());

        // TODO you should create you own UI Element for this purpose...
        // TODO maybe it will be better to extends it from Dropdown or smth else ?
        // TODO what dou you mean 'done' ? I do not see any difference...
        // TODO take a look on elementsCheckList, i refactored it for you...
        for (String vegetable : vegetablesDropdown.getText().split(", ")) {
            vegetablesDropdown.select(vegetable);
        }
        for (String vegetable : metalsColors.getVegetables()) {
            vegetablesDropdown.select(vegetable);
        }

        submitButton.click();
    }
}