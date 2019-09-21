package com.example.demo;

import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class TestMeth {

    public static void main(String[] args) {

        TestMultithreading testMultithreading =  new TestMultithreading();
        testMultithreading.getTest("7");
        testMultithreading.getTest("6");
//        for (int i = 0; i < 1000; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    URLConnection urlConnection = null;
//                    try {
//                        urlConnection = new URL("http://localhost:8080/user/main").openConnection();
//                        Scanner scanner = new Scanner(urlConnection.getInputStream());
//                        while(scanner.hasNext()) {
//                            System.out.println(scanner.next());
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
//        }

    }

}
class TestMultithreading{
    public   void   getRequest(String url){
        System.out.println("unit "+ url);
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("-------------");
        URLConnection urlConnection = null;
        try {
            urlConnection = new URL("http://localhost:8080/user/"+url).openConnection();
            Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNext()){
            System.out.println(scanner.next());}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void getTest(String product){
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public   void start() {
                    getRequest("selectSmartphone?selectSmartphone="+product);
                    getRequest("addProductInCart?selectSmartphone="+product);
                    getRequest("cart");
                }
            }.start();

        }
    }
}