package hw_jdi.utils;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import hw_jdi.enums.MetalsColorsKeysEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogWork {

    public static Map<String, String[]> prepareLog (TextList textList) {
        Map<String, String[]> resultLog = new HashMap<>();

        List<String> logList = textList.getTextList();

        for (String log : logList) {
            for (MetalsColorsKeysEnum key : MetalsColorsKeysEnum.values()) {
                if (log.startsWith(key.text)) {
                    resultLog.put(key.text, log.substring(key.text.length() + 2).split(", "));
                }
            }
        }
        return resultLog;
    }
}
