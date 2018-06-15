package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.JSONConverter;
import echo.coursework.model.entity.Question;
import echo.coursework.model.jsondata.SearchData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class SearchController {
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public String signIn(@RequestBody String data) {
        String response = "";
        System.out.println("Post request '/signin', data: " + data);
        SearchData searchData = (SearchData)JSONConverter.convertJsonToObject(data, SearchData.class);
        ArrayList<Question> questions = (ArrayList<Question>)InformStorageModel.getDao().searchQuestionsByTitle(searchData.text);
        return JSONConverter.convertObjectToJson(questions);
    }
}
