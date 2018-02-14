package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.MetalsColors;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Map;

public class DataLoader {

    public Object[][] data;

    @SneakyThrows
    public DataLoader() {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/main/resources/ex8_jdi_metalsColorsDataSet.json")).getAsJsonObject();
        Map<String, MetalsColors> metalsColorsData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, MetalsColors>>() {
        }.getType());

        // TODO i don't get it, what is the point of two-dimensional array ??
        // TODO why don't you return just a metalsColorsData.values() ? What a story, Mark ?
        data = new Object[metalsColorsData.size()][];
        Object[] values = metalsColorsData.values().toArray();
        for (int i = 0; i < values.length; i++) {
            // TODO is that not enough 'data[i][0] = values[i]' ?
            data[i] = new Object[]{values[i]};
        }
    }
}
