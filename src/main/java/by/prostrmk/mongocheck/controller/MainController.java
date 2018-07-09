package by.prostrmk.mongocheck.controller;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class MainController {

    @Autowired
    UserRepository repository;

    @GetMapping(value = "/{username}", produces = "application/json")
    public User getUserInfo(@PathVariable String username) {
        return repository.findUserByName(username);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView getAuth() {
        return new ModelAndView("auth", "user", new User());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String postAuth(HttpSession session, User user) {

        return null;
    }

    @GetMapping("/add")
    @ResponseBody
    public String add(){
        repository.save(new User("Roman", "123"));
        repository.save(new User("Andrey", "321"));
        return "classno sohranilos";
    }

}
