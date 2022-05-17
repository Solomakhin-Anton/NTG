package collectionGenerate;

import java.util.List;

import static collectionGenerate.JsonTemplates.*;

public class TestsGenerate {

    public static String negativeGetAndDeleteRequests(boolean isGetRequest,  boolean isString, boolean isInteger, boolean isBoolean) {
        return jsonSnippets(Snippets.NEGATIVE.snippetError) +
                jsonGetAndDeleteRequest(getMethodName((isGetRequest ? "Get" : "Delete"), Data.serviceMethods), isString, isInteger, isBoolean) + jsonEmptyResponse();
    }

    public static String negativeCreateAndUpdateRequests(String variable, boolean isCreateRequest,  boolean isString, boolean isInteger, boolean isBoolean) throws Exception {
        return jsonSnippets(Snippets.NEGATIVE.snippetError) +
                jsonCreateAndUpdateRequest(getMethodName((isCreateRequest ? "Create" : "Update"), Data.serviceMethods), variable, isString, isInteger, isBoolean) + jsonEmptyResponse();
    }

    public static String getMethodName(String methodName, List<String> serviceMethods) {
        return serviceMethods.stream()
                .filter(s -> s.toLowerCase().contains(methodName.toLowerCase()))
                .findFirst()
                .map(Object::toString)
                .orElse("");
    }
}
