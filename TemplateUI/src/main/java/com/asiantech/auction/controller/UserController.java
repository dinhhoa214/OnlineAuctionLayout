package com.asiantech.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;   
import com.asiantech.auction.service.BidService;
import com.asiantech.auction.service.CategoryService;
import com.asiantech.auction.service.ItemService;

@Controller
public class UserController {
	@Autowired
	@Qualifier(CategoryService.NAME)
	CategoryService categorySv;
	@Autowired
	@Qualifier(BidService.NAME)
	BidService bidSv;
	@Autowired
	@Qualifier(ItemService.NAME)
	ItemService itemSv;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String getHomePage(Model model){
		 
	    model.addAttribute("categories", categorySv.getAll());     
        return "homepage";
    }
	/*@RequestMapping(value="/category", method=RequestMethod.GET)
    public String getHomePageCategories(@RequestParam(required = false) String cate,Model model){
	    Category ca = categorySv.getByName(cate);
	    System.out.println("-------"+ ca.getId());
		model.addAttribute("categories", categorySv.getAll());     
        return "homepage";
    }*/
	@RequestMapping(value="/category", method=RequestMethod.GET)
    public String getCategoryPage(){
         
        return "category";
    }
	@RequestMapping(value="/cruditem", method=RequestMethod.GET)
    public String getCrudItemPage(){
         
        return "cruditem";
    }
	@RequestMapping(value="/item", method=RequestMethod.GET)
    public String getItemPageForBid(){
         
        return "item";
    }
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage(){
         
        return "login";
    }
	@RequestMapping(value="/register", method=RequestMethod.GET)
    public String getRegisterPage(){
         
        return "register";
    }
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String getAdminHomePage(){
         
        return "admin/home";
    }
}
