package entities;

import enums.MetalsColorsDataEnum;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsKeysEnum.*;

public class MetalsColors {
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public MetalsColors(MetalsColorsDataEnum metalsColorsDataEnum) {
        this.summary = metalsColorsDataEnum.summary;
        this.elements = metalsColorsDataEnum.elements;
        this.color = metalsColorsDataEnum.color;
        this.metals = metalsColorsDataEnum.metals;
        this.vegetables = metalsColorsDataEnum.vegetables;
    }

    public Map<String, String[]> getResultLog() {
        Map<String, String[]> result = new HashMap<>();
        result.put(SUMMARY.text, new String[]{Integer.toString(summary[0] + summary[1])});
        result.put(ELEMENTS.text, elements);
        result.put(COLOR.text, new String[]{color});
        result.put(METAL.text, new String[]{metals});
        result.put(VEGETABLES.text, vegetables);
        return result;
    }
}
