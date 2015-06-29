package com.asiantech.auction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asiantech.auction.entity.User;
import com.asiantech.auction.entity.User.Role;
import com.asiantech.auction.service.CategoryService;
import com.asiantech.auction.service.ImageService;
import com.asiantech.auction.service.UserService;

@Controller
public class AnynomousController {
	@Autowired
	@Qualifier(CategoryService.NAME)
	CategoryService categorySv;
	@Autowired
	@Qualifier(UserService.NAME)
	UserService userSv;
	@Autowired
	ImageService imageSv;
	@RequestMapping(value={"/","","/index/","/index"})
    public String getHomePage(Model model){
		 
	    model.addAttribute("categories", categorySv.getAll());     
        return "homepage";
    }
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage(){
         
        return "login";
    }
	

	@RequestMapping(value="/register", method=RequestMethod.GET)
    public String getRegisterPage(User user){ 
        return "register";
    }
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerAccount(@Valid User user,
			BindingResult binding,@RequestParam(required = false) MultipartFile image ){  
		 
		if (!image.isEmpty()) {
			user.setImage(imageSv.updateImage(image, "item")); 
		} 
		user.setRole(Role.ROLE_VISITER);
		userSv.saveOrUpdate(user);
		
		return "user/userinfo"; 
		
	}
	@RequestMapping(value="/userinfo", method=RequestMethod.GET)
    public String getUserInfomationPage(@RequestParam(required = false) String id,Model model){ 
		User user = userSv.getById(6);
		model.addAttribute("user", user);
        return "user/userinfo";
    }
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String getAdminHomePage(){
         
        return "admin/home";
    }
}
