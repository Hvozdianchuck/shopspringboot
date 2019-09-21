package com.example.demo.controller;

import com.example.demo.dao.NewProductParse;

import com.example.demo.model.Computer;
import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping(value = "/adminSmartphone", method = RequestMethod.POST)
    public String setNewSmartphone(@ModelAttribute("newSmartphone") Smartphone smartphone, @RequestParam("files") MultipartFile[] files){
        System.out.println("test adminSmartphone");
        productService.addNewSmartphone(smartphone, files);
        return "admin";
 }
    @RequestMapping(value = "/adminComputer", method = RequestMethod.POST)
    public void setNewComputer(@ModelAttribute("newComputer") Computer computer, @RequestParam("files") MultipartFile[] files){

    }

    @RequestMapping("/admin")
    public String admin(Model model){

        model.addAttribute("newSmartphone", new Smartphone());
        return "admin";
    }
}
