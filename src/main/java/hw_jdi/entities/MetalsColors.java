package hw_jdi.entities;

import java.util.HashMap;
import java.util.Map;

import static hw_jdi.enums.MetalsColorsKeysEnum.*;

public class MetalsColors {
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metal;
    public String[] vegetables;

    public MetalsColors() {
        summary = new Integer[]{3, 8};
        elements = new String[]{"Water", "Fire"};
        color = "Red";
        metal = "Selen";
        vegetables = new String[]{"Cucumber", "Tomato"};
    }

    public MetalsColors(Integer[] summary, String[] elements, String color, String metals, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metal = metals;
        this.vegetables = vegetables;
    }

    public Map<String, String[]> getResultLog() {
        Map<String, String[]> result = new HashMap<>();
        result.put(SUMMARY.text, new String[]{Integer.toString(summary[0] + summary[1])});
        result.put(ELEMENTS.text, elements);
        result.put(COLOR.text, new String[]{color});
        result.put(METAL.text, new String[]{metal});
        result.put(VEGETABLES.text, vegetables);
        return result;
    }
}
