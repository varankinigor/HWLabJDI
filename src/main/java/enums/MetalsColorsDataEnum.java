package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MetalsColorsDataEnum {
    DEFAULT_DATA(new Integer[]{3, 8}, new String[]{"Water", "Fire"}, "Red", "Selen", new String[]{"Cucumber", "Tomato"});

    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;
}
