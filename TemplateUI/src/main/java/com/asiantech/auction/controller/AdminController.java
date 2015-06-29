package com.asiantech.auction.controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asiantech.auction.entity.Category;
import com.asiantech.auction.entity.Item;
import com.asiantech.auction.entity.User;
import com.asiantech.auction.service.CategoryService;
import com.asiantech.auction.service.ItemService;
import com.asiantech.auction.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	@Qualifier(UserService.NAME)
	UserService userSv;
	
	@Autowired
	@Qualifier(CategoryService.NAME)
	CategoryService categorySv;
	
	@Autowired
	@Qualifier(ItemService.NAME)
	ItemService itemSv;
	
	
	@RequestMapping(value="/adminUsers", method=RequestMethod.GET)
    public String getAdminUsersPage(@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer maxRows,
			User user,Model model){  
		int pageDefault = (page != null) ? page - 1 : 0;
		int sizePageDefault = (maxRows != null) ? maxRows : 5; 
		Page<User> usersPage = userSv.getAllUserAndPagination(new PageRequest(
				pageDefault, sizePageDefault, new Sort(new Order(Direction.ASC,"userId"))));  
		model.addAttribute("users",usersPage);
		model.addAttribute("totalRecord",usersPage.getTotalPages());
		model.addAttribute("sizePageDefault",sizePageDefault);
		model.addAttribute("numCountRows", usersPage.getTotalElements()); 
		model.addAttribute("numOfPage", pageDefault + 1 );
		 
		model.addAttribute(user);
        return "admin/adminuser";
    }
	@RequestMapping("/newUser")
	public String newUser(User user,Model model) {
		user = new User();
		return getAdminUsersPage(1,5,user,model);
	}
	@RequestMapping("/editUser")
	public String editUser(@RequestParam int id,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer maxRows,
			Model model) { 
			//redirectAttrs.addAttribute(userSv.getById(id));
		return getAdminUsersPage(page,maxRows,userSv.getById(id),model);
	}
	@RequestMapping("/deleteUser")
	public String getDeleteUser(@RequestParam int id,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer maxRows,User user,
			Model model) { 
		userSv.deleteById(id); 
		return getAdminUsersPage(page,maxRows,user,model);
	}
	/*@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String postDeleteUser(@RequestParam int id) { 
		userSv.deleteById(id); 
		return "";
	}*/
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user,
			Model model) {    
		return getAdminUsersPage(1,5,userSv.saveOrUpdate(user),model);
	}
	@RequestMapping(value="/adminCategories", method=RequestMethod.GET)
    public String getAdminCategoriesPage(Category category,Model model){  
		 
		model.addAttribute("listCategory",categorySv.getAll());  
		model.addAttribute(category);
        return "admin/admincategories";
    }
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category,BindingResult bindingResult,Model model)
			throws Exception {
    	if (bindingResult.hasErrors()) { 
			model.addAttribute("listCategory",categorySv.getAll());  
			model.addAttribute(category);
	        return "admin/admincategories";
		}
    	categorySv.saveOrUpdate(category);
    	return "redirect:adminCategories";
	}
    @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public String editCategory(@RequestParam int id,RedirectAttributes redirectAttrs) { 
    	redirectAttrs.addFlashAttribute(categorySv.getById(id));
		return "redirect:adminCategories";
	}
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam int id){ 
    	categorySv.deleteById(id);
		return "redirect:adminCategories";
	}
	@RequestMapping(value="/adminItems", method=RequestMethod.GET)
    public String getAdminItemsPage(@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer maxRows,
			Item item,Model model){  
		int pageDefault = (page != null) ? page - 1 : 0;
		int sizePageDefault = (maxRows != null) ? maxRows : 5; 
		Page<Item> itemsPage = itemSv.getAllItemAndPagination(new PageRequest(
				pageDefault, sizePageDefault, new Sort(new Order(Direction.ASC,"itemId"))));  
		model.addAttribute("items",itemsPage);
		model.addAttribute("totalRecord",itemsPage.getTotalPages());
		model.addAttribute("sizePageDefault",sizePageDefault);
		model.addAttribute("numCountRows", itemsPage.getTotalElements()); 
		model.addAttribute("numOfPage", pageDefault + 1 );
		 
		model.addAttribute(item); 
        return "admin/adminitems";
    }
	@RequestMapping(value="/adminBids", method=RequestMethod.GET)
    public String getAdminBidsPage(){  
        return "admin/adminitems";
    }
	@RequestMapping(value="/adminStPanels", method=RequestMethod.GET)
    public String getAdminStpanelsPage(){  
        return "admin/stpanels";
    }
	@RequestMapping(value="/adminStIcons", method=RequestMethod.GET)
    public String getAdminSticonsPage(){  
        return "admin/sticons";
    }
	
	@RequestMapping(value="/adminStTypography", method=RequestMethod.GET)
    public String getAdminSttypoPage(){  
        return "admin/sttypography";
    }

	@RequestMapping(value="/adminTablePage", method=RequestMethod.GET)
    public String getAdminTablePage(){  
        return "admin/tablepage";
    }
	@RequestMapping(value="/adminBlankPage", method=RequestMethod.GET)
    public String getAdminBlankPage(){  
        return "admin/blankpage";
    }
}
