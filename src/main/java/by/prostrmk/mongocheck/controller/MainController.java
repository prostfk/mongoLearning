package by.prostrmk.mongocheck.controller;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository repository;

    @GetMapping(value = "/{username}/{password}", produces = "application/json")
    @ResponseBody
    public User getIndex(HttpSession session, @PathVariable String username, @PathVariable String password){
        User user = new User(username,password);
        repository.save(user);
        return user;
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public List getUserInfo() {
        return repository.findAll();
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView getAuth() {
        return new ModelAndView("auth", "user", new User());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String postAuth(HttpSession session, User user) {
        if (user.getPassword()!=null && user.getName()!=null){
            repository.save(user);
            session.setAttribute("user", user);
        }
        return "redirect:/";
    }



}
