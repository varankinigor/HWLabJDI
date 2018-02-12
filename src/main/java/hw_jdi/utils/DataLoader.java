package hw_jdi.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw_jdi.entities.MetalsColors;
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

        data = new Object[metalsColorsData.size()][];
        Object[] values = metalsColorsData.values().toArray();
        for (int i = 0; i < values.length; i++) {
            data[i] = new Object[]{values[i]};
        }
    }
}
