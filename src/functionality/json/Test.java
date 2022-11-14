package functionality.json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {

        JSONParser jsonParser = new JSONParser();
        try (var reader = new FileReader("C:\\RND800\\BASE\\SAMPLES\\UX_APP_WIPPGILZ.JSON");
            var scanner = new Scanner(System.in)) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonFile = (JSONObject) obj;
//            JSONObject widget = getToolbarWidget((JSONObject) jsonFile.get("MainToolbar"), 0, 0);
            System.out.println("Would you like to edit the toolbar? (y/n)");
            String input = scanner.next();
            Object currentJson;
            if(input.equals("y")) {
                currentJson =  jsonFile.get("MainToolbar");
                System.out.println("is array: " + (currentJson instanceof JSONArray));
//                assert currentJson instanceof JSONObject;
                loopThroughJson(currentJson);
            }
            else {
                currentJson =  jsonFile.get("Columns");
                loopThroughJson(currentJson);
            }
            while(!input.equals("0")) {
                System.out.println("Enter '0' to quit or \n");
                input = scanner.next();
                if(input.charAt(0) <= 57) {
//                    loopThroughJson()

                }
//                currentJson = (JSONObject) currentJson.get();


            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    //pass Toolbar.get("MainToolbar");
    private static JSONObject getToolbarWidget(JSONObject toolbar, int column, int widgetIndex) {
        var cols = (JSONArray) toolbar.get("Columns");
        var col = (JSONObject) cols.get(column);
        var widgets = (JSONArray) col.get("Widgets");
        return (JSONObject) widgets.get(widgetIndex);
    }

    // pass jsonFile.get("Columns")
    private static JSONObject getWidget(JSONArray columns, int columnIndex, int widgetIndex) {
        var column = (JSONObject) columns.get(columnIndex);
        var widgets = (JSONArray) column.get("Widgets");
        return  (JSONObject) widgets.get(widgetIndex);
    }

    private static HashMap<List<Integer>, String> getIcons (JSONObject jsonFile) {
        return new HashMap<>();
    }

    private static List<String> loopThroughJson(Object jsonObject) {
        Iterator keys;
        if(jsonObject instanceof JSONArray) {
            keys =  ((JSONArray) jsonObject).iterator();
        } else keys = ((JSONObject) jsonObject).keySet().iterator();
        List<String> keyList = new ArrayList<>();
        int index = 0;
        keyList.add("Quit");
        while(keys.hasNext()) {
            keyList.add(keys.next().toString());
            System.out.println(++index + ": " + keyList.get(index));
        }
        return keyList;
    }
}
