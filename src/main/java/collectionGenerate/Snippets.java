package collectionGenerate;

public enum Snippets {

    POSITIVE("\"var jsonData = pm.response.json()\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка времени ответа от сервера\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.responseTime).to.be.below(2000);\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что статус = 200\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.response.to.have.status(200);\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что result = success\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.text()).to.include(\\\"info\\\");\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(jsonData.info.result).to.eql(\\\"SUCCESS\\\");\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что error_message пустой\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(jsonData.info.error_message).to.empty;\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\"",
            "\"var jsonData = pm.response.json()\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка времени ответа от сервера\\\", function () {\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.responseTime).to.be.below(2000);\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что статус = 200\\\", function () {\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.response.to.have.status(200);\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что result = error\\\", function () {\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.text()).to.include(\\\"info\\\");\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(jsonData.info.result).to.eql(\\\"ERROR\\\");\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что error_message пустой\\\", function () {\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(jsonData.info.error_message).to.empty;\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что result_mesage не пустой\\\", function () {\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(jsonData.info.result_mesage).to.not.empty;\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\""),
    NEGATIVE("\"const jsonData = pm.response.json();\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка времени ответа от сервера\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.responseTime).to.be.below(2000);\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что статус = 500\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.response.to.have.status(500);\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что header Connection = close\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.headers.get (\\\"Connection\\\")).to.eql(\\\"close\\\");\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"pm.test(\\\"Проверка что в теле ответа есть текст \\\\\\\"error\\\\\\\"\\\", function () {\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"    pm.expect(pm.response.text()).to.include(\\\"error\\\");\",\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\"});\"");

    Snippets(String snippetSuccess, String snippetError) {
        this.snippetSuccess = snippetSuccess;
        this.snippetError = snippetError;
    }

    Snippets(String snippetError) {
        this.snippetError = snippetError;
        snippetSuccess = null;
    }

    public final String snippetSuccess;
    public final String snippetError;
}
