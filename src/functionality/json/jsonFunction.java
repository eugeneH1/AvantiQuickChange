package functionality.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class jsonFunction {
    public static boolean isJsonArray(Object obj) {
        return obj instanceof JSONArray;
    }

    public static boolean isJsonObject(Object obj) {
        return obj instanceof JSONObject;
    }

    public static void editJson(JSONObject widgetObject, String property, String value) {
        widgetObject.put(property, value);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printList(List<String> list) {
        int i = 0;
        for(String s : list) {
            System.out.println(i++ + ": " + s + " ");
        }
    }

    public static Object updateJsonObject(String option, Object obj) {
        if(isJsonArray(obj)) {
            JSONArray arr = (JSONArray) obj;
            return arr.get(Integer.parseInt(option) - 1);
        } else if(isJsonObject(obj)) {
            JSONObject json = (JSONObject) obj;
            return json.get(option);
        }
        return null;
    }


    public static void searchLoop(Object ob, Scanner in, List<String> validOption) {
        boolean searching = true;
        while (searching) {
            List<String> options = new ArrayList<>();
//            options.add("Edit");
            clearScreen();
            System.out.println("Enter a negative number to quit and 0 to edit");
            if(isJsonObject(ob)) {
                        options = getObjectKeys(ob, validOption);
            } else if(isJsonArray(ob)) options = jsonFunction.getArrayKey(ob);
            else {
                System.out.println("Editing: " + ob);
                editJson(ob, in);
            }

            int input;
            if (options.size() > 2) {
                jsonFunction.printList(options);
                input = in.nextInt();
            } else input = 1; //index zero

            if (input < 0) searching = false;
            if (input == 0) {
                editJson(ob, in);
                searching = false;
            } else {
                if(options.size() > 0) {
                    ob = updateJsonObject(options.get(input), ob);
                } else {
                    System.out.println("Edited: " + ob + "\nPress -1 to quit");
                    searching = false;
                    input = 0;
                }
                }

            }
//            ob = jsonFunction.updateJsonObject(options.get(input), ob);

    }

    public static List<String> getArrayKey(Object obj) {
        List<String> options = new ArrayList<>();
        options.add("Edit");
        JSONArray arr = (JSONArray) obj;
        for(int i = 0; i < arr.size(); i++) {
            options.add(String.valueOf(i + 1));
        }
        return options;
    }

    public static List<String> getObjectKeys(Object obj, List<String> vOptions) {
        JSONObject json = (JSONObject) obj;
        List<String> options = new ArrayList<>();
        int index = 0;
        options.add("Edit");

        for(Object key : json.keySet()) {
            if(vOptions.contains(key.toString())) {
                options.add(key.toString());
            }
            System.out.println(key);
//            map.put(index, (String) key);
        }
        return options;
    }

    public static void editJson(Object obj, Scanner in) {
        if(isJsonObject(obj)) {
            JSONObject json = (JSONObject) obj;
            json.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
        }
        if(obj instanceof String) {
            obj = in.next();
        }

//        for(Object key : json.keySet()) {
//            System.out.println(key);
//        }
    }

//    public static List<String> getKeys(Object obj) {
//        List<String> options = new ArrayList<>();
//        options.add("Edit");
//        if(isJsonObject(obj)) {
//            JSONObject json = (JSONObject) obj;
//            for(Object key : json.keySet()) {
//                options.add((String) key);
//            }
//        } else if(isJsonArray(obj)) {
//            JSONArray arr = (JSONArray) obj;
//            for(int i = 0; i < arr.size(); i++) {
//                options.add("Column - " + (i + 1));
//            }
//        }
//    }


}




