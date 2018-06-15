package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.JSONConverter;
import echo.coursework.model.entity.users.User;
import echo.coursework.model.jsondata.SigninData;
import echo.coursework.model.jsondata.SignupData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public String signIn(@RequestBody String data) {
        String response = "";
        System.out.println("Post request '/signin', data: " + data);
        SigninData signinData = (SigninData)JSONConverter.convertJsonToObject(data, SigninData.class);
        if (InformStorageModel.getDao().checkUser(signinData.login, signinData.password)) {
            User user = InformStorageModel.getDao().getUser(signinData.login);
            if (user != null) {
                response = "{\"message\": \"OK\", \"redirect\": \"questions\"}";
            } else {
                response = "{\"message\": \"Error on server\"";
            }
        } else {
            response = "{\"message\": \"wrong login or password\"}";
        }
        System.out.println(response);
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(@RequestBody String data) {
        String response = "";
        System.out.println("Post request '/signup', data: " + data);
        SignupData signupData = (SignupData)JSONConverter.convertJsonToObject(data, SignupData.class);
        if (!InformStorageModel.getDao().checkUser(signupData.login, signupData.password)) {
            User user = InformStorageModel.getDao().addUser(signupData.login, signupData.password);
            if (user != null) {
                response = "{\"message\": \"OK\", \"redirect\": \"questions\"}";
            } else {
                response = "{\"message\": \"Error on server\"";
            }

        } else {
            response = "{\"message\": \"wrong login or email\"}";
        }
        System.out.println(response);
        return response;
    }
}
