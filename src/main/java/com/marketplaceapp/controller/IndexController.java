package com.marketplaceapp.controller;

import com.marketplaceapp.model.university.University;
import com.marketplaceapp.model.user.User;
import com.marketplaceapp.model.user.UserRepository;
import com.marketplaceapp.model.university.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @GetMapping(path = "/")
    public @ResponseBody String index() {
        String message = "Hello";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message += " From host: " + ip;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return message;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        User n = new User();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @PostMapping(path = "/add-university")
    public @ResponseBody String addNewUniversity(@RequestParam String name, @RequestParam String address) {
        University n = new University();
        n.setName(name);
        n.setAddress(address);
        universityRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
