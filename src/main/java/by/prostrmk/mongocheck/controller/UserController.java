package by.prostrmk.mongocheck.controller;

import by.prostrmk.mongocheck.model.entity.UserRole;
import by.prostrmk.mongocheck.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Secured(value = {"ROLE_USER"})
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable String username){
        return new ModelAndView("userPage", "user", repository.findUserByName(username));
    }

    @GetMapping(value = "/roles")
    @ResponseBody
    public String roles(){
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        StringBuilder stringBuilder = new StringBuilder();
        authorities.forEach(auth -> {
            stringBuilder.append(auth.toString());
        });
        return stringBuilder.toString();
    }


}
