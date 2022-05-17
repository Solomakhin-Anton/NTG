package collectionGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    // Название репозитория сервиса - так будет называться коллекция
    public static final String repoServiceName = "rpu-common-person.FlSnilsInfoService";

    // Адресс сервиса из метадаты
    public static final String serviceAddress = "ru.gov.pfr.ecp.ebr.rpu.common.fl.SnilsInfoService";

    // Методы сервиса из метадаты
    public static final List<String> serviceMethods = new ArrayList<>(Arrays.asList(
            "Create", "Update", "GetById", "Delete"
    ));

    // Поля с указанием обертки из grpcCox'а
    public static final String variables = ".google.protobuf.Int64Value fl_base_data_id = 1;\n" +
            "  .google.protobuf.Int64Value id = 2;\n" +
            "  .google.protobuf.StringValue snils = 3;\n" +
            "  .google.protobuf.StringValue date_start = 4;\n" +
            "  .google.protobuf.StringValue date_end = 5;\n" +
            "  .google.protobuf.Int64Value dic_ils_cancelation_id = 6;\n" +
            "  .google.protobuf.Int64Value dic_ils_status_id";

    // Если Get-запрос у сервиса существует - ставим true (в тестах сгенерируются тесты на Get). В противном случае - false
    public static boolean getRequestExists = true;

    // Если ставить true - будет адрес localhost:12044, в противном случае - host.docker.internal (в адресной строке постмана)
    public static boolean isLocalhost = true;

    // Если true - то в методе Get запрос с полем id ({"id": {"value": ""}"}), если false - то просто с value без id ({"value": ""})
    public static boolean isIdInGetRequest = false;

    // Если true - то в методе Delete запрос с полем id ({"id": {"value": ""}"}), если false - то просто с value без id ({"value": ""})
    public static boolean isIdInDeleteRequest = false;
}
