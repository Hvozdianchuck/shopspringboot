package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Object> {
    @Query("SELECT name FROM Smartphone where name like %:keyword%")
    List<String> search(@Param("keyword") String keyword);
    @Query("SELECT name FROM Product where name like %:name%")
    List<String> filterName(@Param("name")String name);
    List<Product> findByName(String name);
    @Query("SELECT s FROM Product s where s.price > ?1  and s.price<?2")
    List<Product> filterPrice(Double priceDown,Double priceUp);
    @Query("SELECT s  FROM Product s where s.smartphoneMemory.operativeMemoryVolume like %:operativeMemoryVolume%")
    List<Product> filterSmartphoneMemoryOperativeMemoryVolume(@Param("operativeMemoryVolume")String operativeMemoryVolume);
    @Query("SELECT  n  FROM Product n where n.smartphoneMemory.buildMemory like %:buildMemory%")
    List<Product> filterSmartphoneMemoryBuildMemory(@Param("buildMemory")String buildMemory);
    @Query("SELECT s FROM Product s where s.smartphoneProcessor.processorNumbersCore like %:processorNumbersCore%")
    List<Product> filterSmartphoneProcessorProcessorNumbersCore(@Param("processorNumbersCore")String processorNumbersCore);
    @Query("SELECT s FROM Product s where s.smartphoneCamera.mainCamera like %:mainCamera%")
    List<Product> filterSmartphoneCameraMainCamera(@Param("mainCamera")String mainCamera);
    @Query("SELECT s FROM Product s where s.smartphoneDisplay.displayDiagonal like %:displayDiagonal%")
    List<Product> filterSmartphoneDisplayDisplayDiagonal(@Param("displayDiagonal")String displayDiagonal);
}
