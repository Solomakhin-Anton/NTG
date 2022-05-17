package collectionGenerate;

import static collectionGenerate.Data.*;
import static collectionGenerate.JsonTemplates.*;
import static collectionGenerate.TextFormatter.getAllVariables;
import static collectionGenerate.TextFormatter.getFormattedFieldName;

public class Creator {

    public String createCollection() throws Exception {
        return jsonHeader(repoServiceName) + createAllTests() + "}";
    }

    public String createAllTests() throws Exception {
        return createFolder(serviceAddress.split("\\.")[serviceAddress.split("\\.").length-1]) + createNegativeTests() +  jsonItemClose(true);
    }

    public String createNegativeTests() throws Exception {
        return createFolder("Negative") + jsonItemOpen() + ((getRequestExists) ? (jsonCreateFolder("Get") + createNegativeGetTests()) : "") +
                jsonCreateFolder("Create") + createNegativeCreateTests() + jsonCreateFolder("Update") + createNegativeUpdateTests() +
                jsonCreateFolder("Delete") + createNegativeDeleteTests() +
                jsonItemClose(true);
    }

    public String createNegativeGetTests() throws Exception {
        return createNegativeGetAndDeleteMethods(true) + jsonItemClose(!isNextMethodExists("Create"));
    }

    public String createNegativeDeleteTests() throws Exception {
        return createNegativeGetAndDeleteMethods(false) + jsonItemClose(true);
    }

    public String createNegativeCreateTests() throws Exception {
        return createNegativeCreateAndUpdateMethods(true) + jsonItemClose(!isNextMethodExists("Update"));
    }

    public String createNegativeUpdateTests() throws Exception {
        return createNegativeCreateAndUpdateMethods(false) + jsonItemClose(!isNextMethodExists("Delete"));
    }

    public String createNegativeGetAndDeleteMethods(boolean isGetRequest) throws Exception {
        return jsonItemOpen() + jsonCreateFolder(generateNegativeRequestName((isGetRequest ? "Get" : "Delete"), "String", getFormattedFieldName("id"))) +
                TestsGenerate.negativeGetAndDeleteRequests(isGetRequest, true, false, false) + "}," +
                jsonCreateFolder(generateNegativeRequestName((isGetRequest ? "Get" : "Delete"), "Boolean", getFormattedFieldName("id"))) +
                TestsGenerate.negativeGetAndDeleteRequests(isGetRequest, false, false, true) + jsonItemClose(true);
    }

    public String createNegativeCreateAndUpdateMethods(boolean isCreateRequest) throws Exception {
        String json = jsonItemOpen();
        String[] templatesArray = variables.split("\n");
        for (int i = 0; i < templatesArray.length; i++) {
            String field = templatesArray[i].toLowerCase().contains("value") ? templatesArray[i].toLowerCase().split("value")[1].replaceAll(" ", "").split("=")[0] : "id";
            if ((templatesArray[i].toLowerCase().contains("dic_") || templatesArray[i].toLowerCase().contains("_code")) ||
                    (templatesArray[i].toLowerCase().contains("_id") || templatesArray[i].toLowerCase().contains("int"))) {
                json += jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "String", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, true, false, false) + "}," +
                        jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "Boolean", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, false, false, true) +
                        jsonItemClose(i == (templatesArray.length -1));
            } else if (templatesArray[i].toLowerCase().contains("bool")) {
                json += jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "String", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, true, false, false) + "}," +
                        jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "Integer", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, false, true, false) +
                        jsonItemClose(i == (templatesArray.length -1));
            } else if (templatesArray[i].toLowerCase().contains("string")){
                json += jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "Integer", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, false, true, false) + "}," +
                        jsonCreateFolder(generateNegativeRequestName((isCreateRequest ? "Create" : "Update"), "Boolean", getFormattedFieldName(field))) +
                        TestsGenerate.negativeCreateAndUpdateRequests(field, isCreateRequest, false, false, true) +
                        jsonItemClose(i == (templatesArray.length -1));
            }
        }
        return json;
    }

    public String createFolder(String folderName) {
        return jsonItemOpen() + jsonCreateFolder(folderName);
    }

    public String generateNegativeRequestName(String method, String booleanStringOrInteger, String fieldName) {
        return method + "With" + fieldName + "Field" + (booleanStringOrInteger.toLowerCase().contains("empty") ? "IsEmpty" : ("TypeIs" + booleanStringOrInteger));
    }

    public boolean isNextMethodExists(String method) {
        for (String meth : serviceMethods) {
            if (meth.toLowerCase().contains(method.toLowerCase())) return true;
        }
        return false;
    }

    public boolean isNextMethodExists() {
        return serviceMethods.size() != 4;
    }
}
