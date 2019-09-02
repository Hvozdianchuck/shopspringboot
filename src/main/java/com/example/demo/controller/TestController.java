package com.example.demo.controller;

import com.example.demo.dao.NewProductParse;


import com.example.demo.model.Smartphone;
import com.example.demo.repository.SetFields;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import com.memetix.mst.language.Language;
//import com.memetix.mst.translate.Translate;
@Controller
public class TestController {




    public static void main(String[] args) throws Exception {
//        System.out.println(new Locale("Ukrainian", "uk").getCountry());
//        ITesseract iTesseract = new Tesseract();
//        System.out.println(iTesseract.doOCR(new File("C:\\Users\\Назар\\IdeaProjects\\shopspring\\src\\main\\resources\\Знімок.png")));
//        Stream<String> stringStreams = Files.lines(Paths.get("C:\\Users\\Назар\\IdeaProjects\\shopspring\\src\\main\\resources\\product.txt"));
//        NewProductParse testController = new NewProductParse();
//         testController.getnewProductValue(stringStreams.collect(Collectors.toList())).forEach(x-> System.out.println(x));
////             List<Field> fields = Arrays.asList(Smartphone.class.getDeclaredFields());
//        System.out.println(testController.setProductField(products,fields).getArticle());


       //        TestController testController = new TestController();
//        System.out.println(testController.increment(1));
//        System.out.println(testController.increment(2));
//        System.out.println(testController.increment(3));
//        System.out.println(testController.increment(4));
//        System.out.println(testController.increment(5));
//        System.out.println(testController.increment(10));
    }


}
