package entities;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsKeysEnum.*;

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
