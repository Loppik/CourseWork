package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.Answer;
import echo.coursework.model.entity.JSONConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ViewAnswersController {
    @RequestMapping(value="/question/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewAnswers(@PathVariable("id") int questionId) {
        ArrayList<Answer> answers = InformStorageModel.getDao().getAnswers(questionId);
        return JSONConverter.convertObjectToJson(answers);
    }
}
