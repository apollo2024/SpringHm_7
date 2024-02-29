package ru.gb.SpringHm_7.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.SpringHm_7.Services.AdminService;
import ru.gb.SpringHm_7.Services.MainService;
import ru.gb.SpringHm_7.Services.UserService;

@Controller
public class MainController {

    private final MainService mainService;

    private final UserService userService;

    private final AdminService adminService;

    public MainController(MainService homeService, UserService userService, AdminService adminService) {
        this.mainService = homeService;
        this.userService = userService;
        this.adminService = adminService;
    }


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("text", mainService.getText());
        return "index";
    }


    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }


    @GetMapping("/public-data")
    public String publicPage(Model model){
        model.addAttribute("text", userService.getText());
        return "public-data";
    }


    @GetMapping("/private-data")
    public String privatePage(Model model){
        model.addAttribute("text", adminService.getText());
        return "private-data";
    }
}
