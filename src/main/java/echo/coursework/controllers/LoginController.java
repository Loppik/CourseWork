package echo.coursework.controllers;

import echo.coursework.model.InformStorageModel;
import echo.coursework.model.entity.users.RegUser;
import echo.coursework.model.entity.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public void signIn(@RequestParam("name") String userName, @RequestParam("password") String userPassword, Model model, HttpServletResponse response) {
        if (InformStorageModel.getDao().checkUser(userName, userPassword)) {
            User user = new RegUser(0,userName, userPassword, 4); // get user data from db
            model.addAttribute("user", user);
            try {
                response.sendRedirect("/questions");
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            // inform user about wrong input data
            try {
                response.sendRedirect("/");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public void signUp(@RequestParam("name") String userName, @RequestParam("password") String userPassword, Model model, HttpServletResponse response) {
        if (!InformStorageModel.getDao().checkUser(userName, userPassword)) {
            User user = new RegUser(1,userName, userPassword, 0);
            InformStorageModel.getDao().addUser(user);
            model.addAttribute("user", user);
            try {
                response.sendRedirect("/questions");
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            // inform user about wrong input data
            try {
                response.sendRedirect("/");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
