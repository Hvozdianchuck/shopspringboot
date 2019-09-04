package com.example.demo.controller;

import com.example.demo.dao.NewProductParse;
import com.example.demo.dao.ProductFilter;
import com.example.demo.model.Computer;
import com.example.demo.model.Product;

import com.example.demo.model.Smartphone;

import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
@RequestMapping("/user")
//@Scope("request")
public class WebController {

    @Autowired
    ProductServiceImpl productService;
@Autowired
SmartphoneRepository smartphoneRepository;
private  static final Logger logger = LoggerFactory.getLogger(WebController.class);
private String parameter;

@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
@ResponseBody
public List<String> searchAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "") String term){
    smartphoneRepository.findAll().forEach(x-> System.out.println(x.getName()));
    return productService.mainSearch(term);
}



    @PostMapping("/search")
    public String search(@RequestParam("parameterSearch") String parameterSearch ){
        if (parameterSearch.equals("admin")){
            return "redirect:/admin";
        }
        System.out.println("///////////test"+parameterSearch);
        parameter=parameterSearch;

        return "redirect:/user/searchPage";
    }
    @RequestMapping("/searchPage")
    public String searchPage(Model model){
        System.out.println("searchPage");
        System.out.println(parameter);

        model.addAttribute("parameterSearch", smartphoneRepository.findByName(parameter));

        model.addAttribute("smartphoneForSearch",new Smartphone());
        model.addAttribute("computerForSearch",new Computer());
        model.addAttribute("smartphoneFilter",new Smartphone());
        model.addAttribute("priceDown",new String());
        model.addAttribute("priceUp",new String());
        model.addAttribute("photos", productService.getImage(productService.getAllSmartphones()));
        model.addAttribute("service",productService);

        return "searchPage";
    }
    @PostMapping("/searchPage")
    public String searchPage(@ModelAttribute("smartphoneFilter") Smartphone smartphone, HttpSession session,@ModelAttribute("priceDown") String priceDown,@ModelAttribute("priceUp") String priceUp, Model model){

        System.out.println("post method searchPage "+smartphone.getName());
        model.addAttribute("service2",productService);
        model.addAttribute("filterSmartphoneList", productService.mainFilterForSmartphones(smartphone, priceDown, priceUp));

      model.addAttribute("selectSmartphone", new Smartphone());
        return "searchPage";
    }
    @GetMapping("/selectSmartphone")
     public String selectSmartphone(@RequestParam("selectSmartphone") Integer id, Model model){

        model.addAttribute("selectSmartphone", smartphoneRepository.findById(id).get());


        model.addAttribute("service2",productService);
        return "selectSmartphone";
    }
    @GetMapping("/addProductInCart")
    public String addProductInCart(@RequestParam("selectSmartphone") Integer id, Model model){

        model.addAttribute("selectSmartphone", smartphoneRepository.findById(id).get());
productService.addProduct(smartphoneRepository.findById(id).get());

        model.addAttribute("service2",productService);
        return "selectSmartphone";
    }
    @GetMapping("/cart")
    public String cart(Model model){

      model.addAttribute("cartProduct", productService.getProducts());
        return "cart";
    }

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("service",productService);
        model.addAttribute("smartphones",productService.getAllSmartphones());
       model.addAttribute("newProductParse", new NewProductParse());
        model.addAttribute("photos", productService.getImage(productService.getAllSmartphones()));
        return "main";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/testPage")
    public String testPage(){
        return "testPage";
    }
//    @RequestMapping("/getSmartphone")
//    public void getSmartphone(@ModelAttribute("newSmartphone") Smartphone smartphone){
//
//
//    }




}
