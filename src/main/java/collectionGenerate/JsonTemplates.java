package collectionGenerate;

import static collectionGenerate.Data.*;
import static collectionGenerate.TextFormatter.*;

public class JsonTemplates {

    Data data = new Data();

    public static String jsonHeader(String repoServiceName) {
        return "{\n" +
                "\t\"info\": {\n" +
                "\t\t\"name\": \"" + repoServiceName + "\",\n" +
                "\t\t\"schema\": \"https://schema.getpostman.com/json/collection/v2.1.0/collection.json\"\n" +
                "\t},\n";
    }

    public static String jsonItemOpen() {
        return "\n\t\"item\": [\n";
    }

    public static String jsonItemClose(boolean isTheLastClose) {
        return "}" + ((isTheLastClose) ? "\n\t]" : ",");
    }

    public static String jsonCreateFolder(String folderName) {
        return "\t\t{\n\t\t\"name\": \"" + folderName + "\",";
    }

    public static String jsonSnippets(String snippet) {
        return  "\"event\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"listen\": \"test\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"script\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"exec\": [" + snippet + "],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"text/javascript\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t],";
    }

    public static String jsonEmptyResponse() {
        return "\"response\": []\n";
    }

    public static String jsonGetAndDeleteRequest(String serviceMethod, boolean isString, boolean isInteger, boolean isBoolean) {
        String id = isString ? "\\\"String\\\"" : (isInteger ? String.valueOf(TextFormatter.randomInt(1,10000)) : (isBoolean ? "true" : ""));
        String raw = serviceMethod.toLowerCase().contains("get") ?
                (isIdInGetRequest ? "\\\"id\\\": {\\\"value\\\": " + id + "}" : "\\\"value\\\": " + id) :
                (isIdInDeleteRequest ? "\\\"id\\\": {\\\"value\\\": " + id + "}" : "\\\"value\\\": " + id);
        return "\"request\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"method\": \"POST\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"header\": [],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"body\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"mode\": \"raw\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"raw\": \"{\\n    " + raw + "\\n}\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"raw\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"language\": \"json\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"url\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"raw\": \"" + ((isLocalhost) ? "localhost" : "host.docker.internal") + ":12044/grpc/" + serviceAddress + "/" + serviceMethod + "\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"host\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + ((isLocalhost) ? "localhost" : "host.docker.internal") + "\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"port\": \"12044\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"path\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"grpc\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + serviceAddress + "\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + serviceMethod + "\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},";
    }

    public static String jsonCreateAndUpdateRequest(String serviceMethod, String variable, boolean isString, boolean isInteger, boolean isBoolean) throws Exception {
        String value = isString ? "\"String\"" : (isInteger ? String.valueOf(TextFormatter.randomInt(1,10000)) : (isBoolean ? "true" : ""));
        return "\"request\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"method\": \"POST\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\"header\": [],\n" +
                "\t\t\t\t\t\t\t\t\t\t\"body\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"mode\": \"raw\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"raw\": \"" + getAllVariables(variable, value).replaceFirst("\"0\"", idFormatter("\"0\"")).replaceAll("\"", "\\\\\"") + "\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"options\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"raw\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"language\": \"json\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"url\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"raw\": \"" + ((isLocalhost) ? "localhost" : "host.docker.internal") + ":12044/grpc/" + serviceAddress + "/" + serviceMethod + "\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"host\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + ((isLocalhost) ? "localhost" : "host.docker.internal") + "\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"port\": \"12044\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"path\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"grpc\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + serviceAddress + "\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"" + serviceMethod + "\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},";
    }
}
