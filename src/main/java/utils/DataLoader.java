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
    @SneakyThrows
    public static Object[] getData() {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/main/resources/ex8_jdi_metalsColorsDataSet.json")).getAsJsonObject();
        Map<String, MetalsColors> metalsColorsData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, MetalsColors>>() {
        }.getType());

        return metalsColorsData.values().toArray();
    }
}
