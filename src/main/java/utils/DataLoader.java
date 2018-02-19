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

    public Object[] data;

    // TODO you can do it in this way, but from my perspective,
    // TODO DataLoader should have static method for this purpose. It is not make a sense to create an instance of this class
    // TODO you should not load any data more than once
    @SneakyThrows
    public DataLoader() {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/main/resources/ex8_jdi_metalsColorsDataSet.json")).getAsJsonObject();
        Map<String, MetalsColors> metalsColorsData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, MetalsColors>>() {
        }.getType());

        data = metalsColorsData.values().toArray();
    }
}
