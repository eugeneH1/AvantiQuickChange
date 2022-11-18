import functionality.JsonEditor;
import functionality.json.jsonFunction;
import functionality.text.StringFunctions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//parse option to show only valid options *
//if value is string ask to edit
//edit value

public class Main {

    static List<String> validOption = List.of("MainToolbar", "Columns", "Rows", "Title", "Widgets", "Tooltip", "Icon");
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (var reader = new FileReader("C:\\RND800\\BASE\\SAMPLES\\UX_APP_WIPPGILZ.JSON");
             var scanner = new Scanner(System.in)) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonFile = (JSONObject) obj;
//            List<String> options;
            jsonFunction.searchLoop(obj, scanner, validOption);



            } catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }

        }



}