package com.example.demo.service;

import com.example.demo.dao.NewProductParse;
import com.example.demo.dao.ProductFilter;
import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    SmartphoneRepository smartphoneRepository;
    @Autowired
    NewProductParse newProductParse;
    @Autowired
    ProductFilter productFilter;
    @Override
    public List<String> mainSearch(String keyword) {
    return smartphoneRepository.search(keyword);
    }

    @Override
    public List<String> filterByName(String name) {

        return smartphoneRepository.filterName(name);
    }

    @Override
    public List<Double> filterByPrice(Double price) {
        return null;
    }

    @Override
    public List<Smartphone> mainFilter(Smartphone smartphone) {
        return null;
    }

    @Override
    public String getImage(byte[] image) {
        return newProductParse.getImage(image);
    }

    @Override
    public List<Smartphone> mainFilterForSmartphones(Smartphone smartphone, String priceDown, String priceUp) {
        System.out.println("post method searchPage 2 "+smartphone.getName());
        return productFilter.mainFilterSmartphone(smartphone, priceDown, priceUp);
    }


    @Override
    public List<String> filterBySmartphoneMemoryOperativeMemoryVolume(String operativeMemoryVolume) {
        return smartphoneRepository.filterSmartphoneMemoryOperativeMemoryVolume(operativeMemoryVolume).stream().map(x->x.getSmartphoneMemory().getOperative_memory_volume()).collect(Collectors.toList());
    }

    @Override
    public List<String> filterBySmartphoneMemoryBuildMemory(String build_memory) {

        return smartphoneRepository.filterSmartphoneMemoryBuildMemory(build_memory).stream().map(x->x.getSmartphoneMemory().getBuild_memory()).collect(Collectors.toList());
    }

    @Override
    public List<String> filterBySmartphoneProcessorProcessorNumbersCore(String numbersCore) {

        return  smartphoneRepository.filterSmartphoneProcessorProcessorNumbersCore(numbersCore).stream().map(x->x.getSmartphoneProcessor().getProcessor_numbers_core()).collect(Collectors.toList());
    }

    @Override
    public List<String> filterBySmartphoneCameraMainCamera(String main_camera) {

        return smartphoneRepository.filterSmartphoneCameraMainCamera(main_camera).stream().map(x->x.getSmartphoneCamera().getMain_camera()).collect(Collectors.toList());
    }

    @Override
    public List<String> filterBySmartphoneDisplayDisplay_diagonal(String display_diagonal) {

        return  smartphoneRepository.filterSmartphoneDisplayDisplayDiagonal(display_diagonal).stream().map(x->x.getSmartphoneDisplay().getDisplay_diagonal()).collect(Collectors.toList());
    }

    @Override
    public void addNewSmartphone(Smartphone smartphone, MultipartFile... files) {
        List<MultipartFile> list  = Arrays.asList(files);
        list.forEach(x-> newProductParse.save(x));
        if (list.size()==6){
            try {
                System.out.println(list.get(0).getBytes());
                smartphone.setImage_front(list.get(0).getBytes());
                System.out.println(list.get(1).getBytes());
                smartphone.setImage_back(list.get(1).getBytes());
                System.out.println(list.get(2).getBytes());
                smartphone.setImage_bottom(list.get(2).getBytes());
                System.out.println(list.get(3).getBytes());
                smartphone.setImage_top(list.get(3).getBytes());
                System.out.println(list.get(4).getBytes());
                smartphone.setImage_left_side(list.get(4).getBytes());
                System.out.println(list.get(5).getBytes());
                smartphone.setImage_right_side(list.get(5).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }}
        smartphoneRepository.save(smartphone);

        System.out.println(smartphone.getName());
    }

    @Override
    public List<Smartphone> getAllSmartphones() {

        return   StreamSupport.stream(smartphoneRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<String>> getImage(List<Smartphone> products) {
        return newProductParse.getImage(products);
    }
}
