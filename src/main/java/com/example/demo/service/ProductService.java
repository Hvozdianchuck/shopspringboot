package com.example.demo.service;

import com.example.demo.model.Smartphone;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<String> mainSearch(String keyword);
    List<String> filterByName(String name);
    List<Double> filterByPrice(Double price);
List<Smartphone> mainFilter(Smartphone smartphone);
    String getImage(byte[] image);
    void addProduct(Smartphone smartphone);
    List<Smartphone> getProducts();
    List<Smartphone> mainFilterForSmartphones(Smartphone smartphone, String priceDown, String priceUp);
    List<String> filterBySmartphoneMemoryOperativeMemoryVolume(String operativeMemoryVolume);
    List<String> filterBySmartphoneMemoryBuildMemory(String build_memory);
    List<String> filterBySmartphoneProcessorProcessorNumbersCore(String build_memory);
    List<String> filterBySmartphoneCameraMainCamera(String main_camera);
    List<String> filterBySmartphoneDisplayDisplay_diagonal(String display_diagonal);
    void addNewSmartphone(Smartphone smartphone, MultipartFile... files);
    List<Smartphone> getAllSmartphones();
      Map<String,List<String>> getImage(List<Smartphone> products);

}
