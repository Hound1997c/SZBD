package com.memorynotfound.spring.security.web;

import com.memorynotfound.spring.security.model.Role;
import com.memorynotfound.spring.security.model.User;
import com.memorynotfound.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String root() {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //User user = userService.findByEmail(auth.getName());
        //System.out.println("email " + user.getEmail());
        return "";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/loggedIn")
    public String userIndex() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        System.out.println("email " + user.getEmail());
        Collection<Role> usersRoles= user.getRoles();
        for (Role role: usersRoles
             ) {
            if(role.getName().equals("ROLE_ADMIN")){
                return "admin/adminIndex";
            }
            else if(role.getName().equals("ROLE_USER")){
                    return "user/userIndex";
            }
            else if(role.getName().equals("ROLE_DEALER")){
                return "dealer/dealerIndex";
            }
        }
        return "index";
    }
}
