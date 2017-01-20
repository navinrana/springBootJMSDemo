package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.OrderService;

public class AppController {

@Autowired
OrderService orderService;

@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
public String prepareProduct(Model model){
	return "index";
}
}
