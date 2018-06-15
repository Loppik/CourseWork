package echo.coursework.controllers;

import echo.coursework.model.entity.users.Guest;
import echo.coursework.model.entity.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String main() {
        System.out.println("Get request '/'");
        User user = new Guest();
        //return new ModelAndView("main", "user", user);
        return "login: ALEX";
    }
}
