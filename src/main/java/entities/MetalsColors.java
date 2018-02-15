package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static enums.MetalsColorsKeysEnum.*;

@Getter
@AllArgsConstructor
public class MetalsColors {
    private Integer[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public static final MetalsColors DEFAULT_DATA = new MetalsColors (
            new Integer[]{3, 8},
            new String[]{"Water", "Fire"},
            "Red",
            "Selen",
            new String[]{"Cucumber", "Tomato"}
    );

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
