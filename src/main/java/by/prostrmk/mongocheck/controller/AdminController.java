package by.prostrmk.mongocheck.controller;

import by.prostrmk.mongocheck.model.entity.User;
import by.prostrmk.mongocheck.model.entity.UserRole;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import by.prostrmk.mongocheck.model.service.UserCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Secured(value = "ROLE_ADMIN")
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserCustomService userCustomService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getListOfUsers(){
        List<User> users = userCustomService.getUsers();
        return new ModelAndView("adminListOfUsers", "users", users);
    }

    @RequestMapping(value = "/delete/{id}")
    public String removeUser(@PathVariable String id){
        User userById = repository.findUserById(id);
        if (userById!=null){
            repository.delete(userById);
        }
        return "redirect:/admin";
    }


}
