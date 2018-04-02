package echo.coursework.controllers;

import echo.coursework.services.GetQuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ViewQuestionsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewQuestions() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("secondPage");
        ArrayList<String> questions = GetQuestionsService.getQuestion();
        System.out.println(questions);
        mv.addObject("questions", questions);
        return mv;
    }
}
