package com.example.demo;

import com.example.demo.model.Smartphone;
import com.sun.org.glassfish.gmbal.NameValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;


import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

public class TestMeth {
  ModelAndView modelAndView;

    private String v;
//    ModelAndView test(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.ad
//        return
//    }
    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        System.out.println(smartphone.getImage_bottom());
    }


}
