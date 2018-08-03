package by.prostrmk.mongocheck.controller;

import by.prostrmk.mongocheck.model.entity.UserRole;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Secured(value = {"ROLE_USER"})
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable String username){
        return new ModelAndView("userPage", "user", repository.findUserByName(username));
    }

}
