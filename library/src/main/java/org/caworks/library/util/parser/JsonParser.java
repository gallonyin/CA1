package org.caworks.library.util.parser;

import android.util.Log;

import org.caworks.library.util.GLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Jsoon格式化，默认debug
 */
public class JsonParser {

    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(GLog.JSON_INDENT);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(GLog.JSON_INDENT);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        LogLineUtil.printLine(tag, true);
        message = headString + GLog.LINE_SEPARATOR + message;
        String[] lines = message.split(GLog.LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        LogLineUtil.printLine(tag, false);
    }
}
