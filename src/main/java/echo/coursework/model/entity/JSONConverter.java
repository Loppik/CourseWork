package echo.coursework.model.entity;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static Object convertJsonToObject(String jsonData, Class needClass) {
        Object object = null;
        try {
            object = objectMapper.readValue(jsonData, needClass);
        } catch(Exception e) {
            System.out.println(e);
        }
        return object;
    }

    public static String convertObjectToJson(Object object) {
        String json = "";
        try {
            json = objectMapper.writeValueAsString(object);
        } catch(Exception e) {
            System.out.println(e);
        }
        return json;
    }
}
