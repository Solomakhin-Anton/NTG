package collectionGenerate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextFormatter {

    public static int randomInt(int min, int max) {
        return (int) (min + Math.random()*max);
    }

    public static String dayFormatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static String getFormattedFieldName(String fieldName) {
        String result = "";
        String[] toArray = fieldName.split("_");
        for (String word : toArray) {
            result += word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        return result;
    }

    public static String getAllVariables() {
        String[] templatesArray = Data.variables.split("\n");
        List<String> formatted = new ArrayList<>();
        for (String temp : templatesArray){
            if (temp.toLowerCase().contains("value")) {
                String field = temp.toLowerCase().split("value")[1].replaceAll(" ", "").split("=")[0];
                if ((field.contains("dic_") || field.contains("_code")) || (field.contains("_id") || temp.toLowerCase().contains("int"))) {
                    if (!field.equalsIgnoreCase("id")) {
                        formatted.add("\\n  \"" + field + "\": {\"value\": \"" + randomInt(1,100) + "\"}");
                    } else {
                        formatted.add("\\n  \"id\": \"0\"");
                    }
                } else if (field.contains("date")) {
                    formatted.add("\\n  \"" + field + "\": {\"value\": \"" + dayFormatter(LocalDate.now()) + "\"}");
                } else if (temp.toLowerCase().contains("bool")) {
                    formatted.add("\\n  \"" + field + "\": {\"value\": \"" + false + "\"}");
                } else {
                    formatted.add("\\n  \"" + field + "\": {\"value\": \"" + field + "\"}");
                }
            } else {
                Assertions.assertTrue("У переменной " + temp + " не указана обертка. Без обертки может быть толлько id",
                        temp.contains(" id "));
                formatted.add("\\n  \"id\": \"0\"");
            }
        }
        return "{" + formatted.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",")) + "\\n}";
    }

    public static String idFormatter(String id) throws Exception {
        String[] templatesArray = Data.variables.split("\n");
        for (String temp : templatesArray){
            if (temp.contains(" id ")) {
                if (temp.toLowerCase().contains("value")) {
                    return "{\\\"value\\\": " + id + "}";
                } else {
                    return id;
                }
            }
        }
        throw new Exception("Не найдено поле \"id\"");
    }

    public static String getAllVariables(String variable, String value) {
        String[] templatesArray = Data.variables.split("\n");
        List<String> formatted = new ArrayList<>();
        for (String temp : templatesArray){
            if (temp.toLowerCase().contains("value")) {
                String field = temp.toLowerCase().split("value")[1].replaceAll(" ", "").split("=")[0];
                if (field.equalsIgnoreCase(variable)) {
                    formatted.add("\\n  \"" + field + "\": {\"value\": " + value + "}");
                } else {
                    if ((field.contains("dic_") || field.contains("_code")) || (field.contains("_id") || temp.toLowerCase().contains("int"))) {
                        if (!field.equalsIgnoreCase("id")) {
                            formatted.add("\\n  \"" + field + "\": {\"value\": \"" + randomInt(1,100) + "\"}");
                        } else {
                            formatted.add("\\n  \"id\": \"0\"");
                        }
                    } else if (field.contains("date")) {
                        formatted.add("\\n  \"" + field + "\": {\"value\": \"" + dayFormatter(LocalDate.now()) + "\"}");
                    } else if (temp.toLowerCase().contains("bool")) {
                        formatted.add("\\n  \"" + field + "\": {\"value\": \"" + false + "\"}");
                    } else {
                        formatted.add("\\n  \"" + field + "\": {\"value\": \"" + field + "\"}");
                    }
                }
            } else {
                Assertions.assertTrue("У переменной " + temp + " не указана обертка. Без обертки может быть толлько id",
                        temp.contains(" id "));
                if (temp.contains(" " + variable + " ")) {
                    formatted.add("\\n  \"" + variable + "\": {\"value\": " + value + "}");
                } else {
                    formatted.add("\\n  \"id\": \"0\"");
                }
            }
        }
        return "{" + formatted.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(",")) + "\\n}";
    }
}
