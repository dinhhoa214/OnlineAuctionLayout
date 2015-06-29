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
    public String getItemPageForBid(Model model){
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = sdf.format(new Date()); 
		System.out.println(date); //15/10/2013
*/		String dateInString = "2015/06/24 17:13:15"; 
		model.addAttribute("endtime",dateInString);
		/*Date date2;
		try {
			date2 = sdf.parse(dateInString);
			Date end = date - date2;
			System.out.println(sdf.format(date2)); 
		} catch (ParseException e) {
			 
			e.printStackTrace();
		}*/
		
        return "item";
    }
	
}
