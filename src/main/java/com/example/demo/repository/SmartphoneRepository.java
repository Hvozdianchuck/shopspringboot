package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Object> {
@Query("SELECT name FROM Smartphone where name like %:keyword%")
      List<String> search(@Param("keyword") String keyword);
    @Query("SELECT name FROM Smartphone where name like %:name%")
       List<String> filterName(@Param("name")String name);
    List<Smartphone> findByName(String name);
    @Query("SELECT price FROM Smartphone where price > ?1  and price<?2")
      List<Double> filterPrice(Double priceDown,Double priceUp);
@Query("SELECT s  FROM Smartphone s where s.smartphoneMemory.operativeMemoryVolume like %:operativeMemoryVolume%")
      List<Smartphone> filterSmartphoneMemoryOperativeMemoryVolume(@Param("operativeMemoryVolume")String operativeMemoryVolume);
    @Query("SELECT  n  FROM Smartphone n where n.smartphoneMemory.buildMemory like %:buildMemory%")
      List<Smartphone> filterSmartphoneMemoryBuildMemory(@Param("buildMemory")String buildMemory);
    @Query("SELECT smartphoneProcessor.processorNumbersCore FROM Smartphone where smartphoneProcessor.processorNumbersCore like %:processorNumbersCore%")
      List<String> filterSmartphoneProcessorProcessorNumbersCore(@Param("processorNumbersCore")String processorNumbersCore);
    @Query("SELECT smartphoneCamera.mainCamera FROM Smartphone where smartphoneCamera.mainCamera like %:mainCamera%")
      List<String> filterSmartphoneCameraMainCamera(@Param("mainCamera")String mainCamera);
    @Query("SELECT smartphoneDisplay.displayDiagonal FROM Smartphone where smartphoneDisplay.displayDiagonal like %:displayDiagonal%")
      List<String> filterSmartphoneDisplayDisplayDiagonal(@Param("displayDiagonal")String displayDiagonal);
//    @Query("SELECT s FROM Smartphone s where s.smartphoneMemory.operativeMemoryVolume like %:operativeMemoryVolume%")
//    List<Smartphone> selectSmartphoneMemoryOperativeMemoryVolume(@Param("operativeMemoryVolume")String operativeMemoryVolume);
//




}
