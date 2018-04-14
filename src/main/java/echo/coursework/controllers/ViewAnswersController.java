package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewAnswersController {
    @RequestMapping(value="/question/{id}", method = RequestMethod.GET)
    public ModelAndView viewAnswers(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("answers");
        mv.addObject("question", "Question " + (id + 1));
        mv.addObject("answers", InformStorageModel.getDao().getAnswers(id));
        // mv.addObject("userName", )
        return mv;
    }
}
