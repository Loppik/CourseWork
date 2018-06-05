package echo.coursework.controllers;

import echo.coursework.dao.HardCodeDao;
import echo.coursework.dao.MySqlDao;
import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.Question;
import echo.coursework.model.entity.users.Guest;
import echo.coursework.model.entity.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ViewQuestionsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        User user = new Guest();
        return new ModelAndView("main", "user", user);
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public ModelAndView viewLastQuestions() {
        ArrayList<Question> questions = InformStorageModel.getDao().getLastQuestions(10);
        return new ModelAndView("main", "questions", questions);
    }
}
