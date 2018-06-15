package echo.coursework.controllers;

import echo.coursework.model.entity.JSONConverter;
import echo.coursework.model.jsondata.SignupData;

public class JacksonTestController {
    public static void main(String[] args) {
        /*User user = new RegUser(0, "Alex", "123", 0);
        System.out.println(user);
        System.out.println(User.class);
        String userJson = JSONConverter.convertObjectToJson(user);
        System.out.println(userJson);
        User user2 = (RegUser)JSONConverter.convertJsonToObject(userJson, RegUser.class);
        System.out.println(user2);*/
        System.out.println("**************");
        String data = "{\"login\":\"a\",\"password\":\"123\",\"email\":\"asdf\"}";
        SignupData s = (SignupData)JSONConverter.convertJsonToObject(data, SignupData.class);
        System.out.println(s);
    }
}
