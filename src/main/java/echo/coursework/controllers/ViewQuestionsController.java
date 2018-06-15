package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.JSONConverter;
import echo.coursework.model.entity.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ViewQuestionsController {
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    @ResponseBody
    public String viewLastQuestions() {
        System.out.println("Get request /questions");
        ArrayList<Question> questions = InformStorageModel.getDao().getLastQuestions(10);
        return JSONConverter.convertObjectToJson(questions);
    }
}
