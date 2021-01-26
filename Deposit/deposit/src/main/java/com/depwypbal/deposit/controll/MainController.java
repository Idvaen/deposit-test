package com.depwypbal.deposit.controll;


import com.depwypbal.deposit.repo.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String home(Model model){
    model.addAttribute("title","Main page");
        return "home";
    }

}
