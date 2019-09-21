package com.example.demo.controller;

import com.example.demo.dao.NewProductParse;


import com.example.demo.model.Smartphone;

import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.ProductServiceImpl;
import com.mastercard.merchant.checkout.PaymentDataApi;
import com.mastercard.merchant.checkout.model.Address;
import com.mastercard.merchant.checkout.model.PaymentData;
import com.mastercard.sdk.core.util.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.StreamSupport;


@Controller
@RequestMapping("/user")
//@Scope("request")
public class WebController {

    @Autowired
    ProductServiceImpl productService;
@Autowired
SmartphoneRepository smartphoneRepository;
@Autowired
    PurchaseRepository purchaseRepository;
private  static final Logger logger = LoggerFactory.getLogger(WebController.class);
private String parameter;

    @Value("${masterpass.merchant.checkoutId}")
    private String merchantCheckoutId;

    @Value("${masterpass.merchant.callbackUrl}")
    private String callBackUrl;
    private String cartId;
    @Async
@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
@ResponseBody
public CompletableFuture<List<String>> searchAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "") String term){
    smartphoneRepository.findAll().forEach(x-> System.out.println(x.getName()));
    return CompletableFuture.completedFuture(productService.mainSearch(term));
}



    @PostMapping("/search")
    @Async
    public CompletableFuture<String> search(@RequestParam("parameterSearch") String parameterSearch ){
        if (parameterSearch.equals("admin")){
            return CompletableFuture.completedFuture("redirect:/admin");
        }
        System.out.println("///////////test"+parameterSearch);
        parameter=parameterSearch;
        System.out.println("buying test ");
        StreamSupport.stream(purchaseRepository.findAll().spliterator(), false).forEach(x->x.getProducts().forEach(y-> System.out.println("name "+y.getName())));

        return CompletableFuture.completedFuture("redirect:/user/searchPage");
    }
    @Async
    @RequestMapping("/searchPage")
    public CompletableFuture<String> searchPage(Model model){
        System.out.println("searchPage");
        System.out.println(parameter);

        model.addAttribute("parameterSearch", smartphoneRepository.findByName(parameter));

        model.addAttribute("smartphoneForSearch",new Smartphone());

        model.addAttribute("smartphoneFilter",new Smartphone());
        model.addAttribute("priceDown",new String());
        model.addAttribute("priceUp",new String());
        model.addAttribute("photos", productService.getImage(productService.getAllSmartphones()));
        model.addAttribute("service",productService);

        return CompletableFuture.completedFuture("searchPage");
    }
    @Async
    @PostMapping("/searchPage")
    public CompletableFuture<String> searchPage(@ModelAttribute("smartphoneFilter") Smartphone smartphone, HttpSession session,@ModelAttribute("priceDown") String priceDown,@ModelAttribute("priceUp") String priceUp, Model model){

        System.out.println("post method searchPage "+smartphone.getName());
        model.addAttribute("service2",productService);
        model.addAttribute("filterSmartphoneList", productService.mainFilterForSmartphones(smartphone, priceDown, priceUp));

      model.addAttribute("selectSmartphone", new Smartphone());
        System.out.println("filter");
        return CompletableFuture.completedFuture("searchPage");
    }
    @Async
    @GetMapping("/selectSmartphone")
     public CompletableFuture<String> selectSmartphone(@RequestParam("selectSmartphone") Integer id, Model model){
        ModelAndView mv = new ModelAndView("selectSmartphone");
        model.addAttribute("selectSmartphone", smartphoneRepository.findById(id).get());

        model.addAttribute("service2",productService);
        mv.addObject("selectSmartphone", smartphoneRepository.findById(id).get());

        return CompletableFuture.completedFuture("selectSmartphone");
    }
    @Async
    @GetMapping("/addProductInCart")
    public CompletableFuture<String> addProductInCart(@RequestParam("selectSmartphone") Integer id, Model model){
       Smartphone smartphone = smartphoneRepository.findById(id).get();
       if(smartphone.getNumber()>1){
        model.addAttribute("selectSmartphone", smartphone);
productService.addProduct(smartphoneRepository.findById(id).get());
       }
        model.addAttribute("service2",productService);
        return CompletableFuture.completedFuture("selectSmartphone");
    }
    @Async
    @GetMapping("/cart")
    public CompletableFuture<ModelAndView> cart(Model model){
        ModelAndView mv = new ModelAndView("cart");
        cartId = UUID.randomUUID().toString();
        mv.addObject("cart_id",cartId);
        mv.addObject("checkout_id",merchantCheckoutId);
        mv.addObject("amount",productService.addition()+"");
        System.out.println(productService.addition()+"");
        productService.getProducts().forEach(x-> System.out.println("name product "+x.getName()));
        mv.addObject("callback_url",callBackUrl);
      model.addAttribute("cartProduct", productService.getProducts());

        return CompletableFuture.completedFuture(mv);
    }
    @Async
    @RequestMapping("/checkout")
    public   CompletableFuture<ModelAndView> checkout(@RequestParam("mpstatus") String status, @RequestParam(value = "oauth_token", required = false) String oauthToken,
                                   @RequestParam(value = "oauth_verifier", required = false) String oauthVerifier,
                                   @RequestParam(value = "checkout_resource_url", required = false) String checkoutResourceUrl, HttpSession httpSession) {
        System.out.println("oauthVerifier");
        if(status.equals("success")){

            httpSession.setAttribute("oauth_verifier",oauthVerifier);

        }

        return CompletableFuture.completedFuture(new ModelAndView("redirect:success"));
    }
    @Async
    @RequestMapping("/success")
    public CompletableFuture<ModelAndView> success(HttpSession httpSession) {

        ModelAndView mv = new ModelAndView("success");
        mv.addObject("transactionId",httpSession.getAttribute("oauth_verifier"));

        System.out.println("null " );
        System.out.println(cartId);
        System.out.println("work " );
        QueryParams queryParams = new QueryParams()
                .add("checkoutId", merchantCheckoutId)
                .add("cartId", cartId);
        System.out.println(queryParams.toString());
        System.out.println(httpSession.getAttribute("oauth_verifier").toString());
        PaymentData paymentData = PaymentDataApi.show(httpSession.getAttribute("oauth_verifier").toString(), queryParams);
        httpSession.setAttribute("paymentData", paymentData);
        System.out.println("Card number is "+paymentData.getCard().getAccountNumber());

        Address shippingAdd = paymentData.getShippingAddress();
        productService.savePurchase(productService.getProducts(), paymentData.getPersonalInfo().getRecipientName(), productService.getProducts().size(),paymentData.getPersonalInfo().getRecipientPhone());

        List<String> shippingAddress = new ArrayList<>();

        if(shippingAdd != null){

            if(shippingAdd.getLine1() != null){

                shippingAddress.add(shippingAdd.getLine1());

            }
            if(shippingAdd.getLine2() != null){

                shippingAddress.add(shippingAdd.getLine2());

            }
            if(shippingAdd.getLine3() != null){

                shippingAddress.add(shippingAdd.getLine3());

            }

            if(shippingAdd.getCity() != null){

                shippingAddress.add(shippingAdd.getCity());


            }

            if(shippingAdd.getCountry() != null){

                shippingAddress.add(shippingAdd.getCountry());
            }

            if(shippingAdd.getPostalCode()!=null){
                shippingAddress.add(shippingAdd.getPostalCode());
            }

        }

        mv.addObject("shippingAddress",shippingAddress);
        System.out.println("success");
         productService.clearCart();
        return CompletableFuture.completedFuture(mv);
    }
    @Async
    @GetMapping("/removeProductFromCart")
    public CompletableFuture<String> removeProductFromCart(@RequestParam("product") Integer smartphoneId, Model model){
   productService.removeProduct(smartphoneId);
        System.out.println("select products");
        productService.getProducts().forEach(x-> System.out.println(x.getName()));
        model.addAttribute("cartProduct", productService.getProducts());

        return CompletableFuture.completedFuture("cart");
    }
@Async
    @RequestMapping("/main")
    public CompletableFuture<String> main(Model model){
        model.addAttribute("service",productService);
        model.addAttribute("smartphones",productService.getAllSmartphones());
        productService.getAllSmartphones().forEach(x-> System.out.println("name "+x.getName()));
       model.addAttribute("newProductParse", new NewProductParse());
        model.addAttribute("photos", productService.getImage(productService.getAllSmartphones()));
        return CompletableFuture.completedFuture("main");
    }
    @Async
    @RequestMapping("/login")
    public CompletableFuture<String> login(){
        return CompletableFuture.completedFuture("login");
    }
    @Async
    @RequestMapping("/testPage")
    public CompletableFuture<String> testPage(){
        return CompletableFuture.completedFuture("testPage");
    }
//    @RequestMapping("/getSmartphone")
//    public void getSmartphone(@ModelAttribute("newSmartphone") Smartphone smartphone){
//
//
//    }




}
