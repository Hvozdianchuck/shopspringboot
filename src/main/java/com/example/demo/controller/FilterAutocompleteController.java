package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class FilterAutocompleteController {
   @Autowired
    ProductServiceImpl productService;
    @RequestMapping(value = "/filterAutocompleteName", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteName(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterByName(term);
    }
    @RequestMapping(value = "/filterAutocompletePrice", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompletePrice(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterByPrice(new Double(term)).stream().map(x->x+"").collect(Collectors.toList());
    }
    @RequestMapping(value = "/filterAutocompleteOperativeMemoryVolume", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteOperativeMemoryVolume(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterBySmartphoneMemoryOperativeMemoryVolume(term);
    }
    @RequestMapping(value = "/filterAutocompleteBuildMemory", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteBuildMemory(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterBySmartphoneMemoryBuildMemory(term);
    }
    @RequestMapping(value = "/filterAutocompleteMainCamera", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteMainCamera(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterBySmartphoneCameraMainCamera(term);
    }
//

    @RequestMapping(value = "/filterAutocompleteProcessorNumbersCore", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteProcessorNumbersCore(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterBySmartphoneProcessorProcessorNumbersCore(term);
    }

    @RequestMapping(value = "/filterAutocompleteDisplay_diagonal", method = RequestMethod.GET)
    @ResponseBody
    public List<String> filterAutocompleteDisplay_diagonal(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        return productService.filterBySmartphoneDisplayDisplay_diagonal(term);
}}
