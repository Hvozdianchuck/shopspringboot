package com.example.demo;

import com.example.demo.model.Smartphone;
import com.sun.org.glassfish.gmbal.NameValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;


import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> smartphones=new ArrayList<>();
        smartphones.add(1);
        smartphones.add(2);
        List<Integer> smartphones2=new ArrayList<>();
        smartphones2.add(1);
        smartphones2.add(2);
        smartphones2.retainAll(smartphones);
        smartphones2.forEach(x-> System.out.println(x));
    }


}
