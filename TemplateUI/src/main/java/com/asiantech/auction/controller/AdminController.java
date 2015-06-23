package com.asiantech.auction.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value="/adminTablePage", method=RequestMethod.GET)
    public String getAdminTablePage(){  
        return "admin/tablepage";
    }
	@RequestMapping(value="/adminBlankPage", method=RequestMethod.GET)
    public String getAdminBlankPage(){  
        return "admin/blankpage";
    }
	@RequestMapping(value="/adminUsers", method=RequestMethod.GET)
    public String getAdminUsersPage(){  
        return "admin/adminuser";
    }
}
