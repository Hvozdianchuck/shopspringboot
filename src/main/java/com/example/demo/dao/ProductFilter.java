package com.example.demo.dao;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Component
public class ProductFilter  {
@Autowired
SmartphoneRepository smartphoneRepository;
public List<Smartphone> mainFilterSmartphone(Smartphone smartphone, String priceDown, String priceUp){
    System.out.println("post method searchPage 3 "+smartphone.getName());
   List<Smartphone> smartphones;
    smartphones= addForMainFilterSmartphone(smartphone, priceDown, priceUp);
    if (smartphone.getName()!=null&&!smartphone.getName().equals("")){
       smartphones.retainAll(smartphoneRepository.findByName(smartphone.getName()));
        System.out.println("post method searchPage 5 ");
        smartphones.forEach(x-> System.out.println(x.getName()));
    }
    if (smartphone.getSmartphoneMemory().getOperative_memory_volume()!=null&&!smartphone.getSmartphoneMemory().getOperative_memory_volume().equals("")){
        smartphones.retainAll(smartphoneRepository.filterSmartphoneMemoryOperativeMemoryVolume(smartphone.getSmartphoneMemory().getOperative_memory_volume()));
    }
    if (smartphone.getSmartphoneMemory().getBuild_memory()!=null&&!smartphone.getSmartphoneMemory().getBuild_memory().equals("")){
        smartphones.retainAll(smartphoneRepository.filterSmartphoneMemoryBuildMemory(smartphone.getSmartphoneMemory().getBuild_memory()));
    }
    if (smartphone.getSmartphoneProcessor().getProcessor_numbers_core()!=null&&!smartphone.getSmartphoneProcessor().getProcessor_numbers_core().equals("")){
        smartphones.retainAll(smartphoneRepository.filterSmartphoneProcessorProcessorNumbersCore(smartphone.getSmartphoneProcessor().getProcessor_numbers_core()));
    }
    if (smartphone.getSmartphoneCamera().getMain_camera()!=null&&!smartphone.getSmartphoneCamera().getMain_camera().equals("")){
        System.out.println("camera");
        System.out.println(smartphone.getSmartphoneCamera().getMain_camera());
        smartphones.retainAll(smartphoneRepository.filterSmartphoneCameraMainCamera(smartphone.getSmartphoneCamera().getMain_camera()));
    }
    if (smartphone.getSmartphoneDisplay().getDisplay_diagonal()!=null&&!smartphone.getSmartphoneDisplay().getDisplay_diagonal().equals("")){
        smartphones.retainAll(smartphoneRepository.filterSmartphoneDisplayDisplayDiagonal(smartphone.getSmartphoneDisplay().getDisplay_diagonal()));
    }
    if (priceDown!=null&&priceUp!=null&&!priceDown.equals("")&&priceUp.equals("")){
        smartphones.retainAll(smartphoneRepository.filterPrice(new Double(priceDown),new Double("1000000")));
    }
    if (priceDown!=null&&priceUp!=null&&!priceUp.equals("")&&priceDown.equals("")){
        smartphones.retainAll(smartphoneRepository.filterPrice(new Double("0"),new Double(priceUp)));
    }
    if (priceDown!=null&&priceUp!=null&&!priceUp.equals("")&&!priceDown.equals("")){
        smartphones.retainAll(smartphoneRepository.filterPrice(new Double(priceDown),new Double(priceUp)));
    }
   return smartphones;
}
    private List<Smartphone> addForMainFilterSmartphone(Smartphone smartphone, String priceDown, String priceUp){
        List<Smartphone> smartphones;
        System.out.println("post method searchPage 4 "+smartphone.getName());
        if (smartphone.getName()!=null&&!smartphone.getName().equals("")){
            smartphones=smartphoneRepository.findByName(smartphone.getName());
            return smartphones;
        }
        if (smartphone.getSmartphoneMemory().getOperative_memory_volume()!=null&&!smartphone.getSmartphoneMemory().getOperative_memory_volume().equals("")){
            smartphones=smartphoneRepository.filterSmartphoneMemoryOperativeMemoryVolume(smartphone.getSmartphoneMemory().getOperative_memory_volume());
            return smartphones;
        }
        if (smartphone.getSmartphoneMemory().getBuild_memory()!=null&&!smartphone.getSmartphoneMemory().getBuild_memory().equals("")){
            smartphones=smartphoneRepository.filterSmartphoneMemoryBuildMemory(smartphone.getSmartphoneMemory().getBuild_memory());
            return smartphones;
        }
        if (smartphone.getSmartphoneProcessor().getProcessor_numbers_core()!=null&&!smartphone.getSmartphoneProcessor().getProcessor_numbers_core().equals("")){
            smartphones=smartphoneRepository.filterSmartphoneProcessorProcessorNumbersCore(smartphone.getSmartphoneProcessor().getProcessor_numbers_core());
            return smartphones;
        }
        if (smartphone.getSmartphoneCamera().getMain_camera()!=null&&!smartphone.getSmartphoneCamera().getMain_camera().equals("")){
            smartphones=smartphoneRepository.filterSmartphoneCameraMainCamera(smartphone.getSmartphoneCamera().getMain_camera());
            return smartphones;
        }
        if (smartphone.getSmartphoneDisplay().getDisplay_diagonal()!=null&&!smartphone.getSmartphoneDisplay().getDisplay_diagonal().equals("")){
            smartphones=smartphoneRepository.filterSmartphoneDisplayDisplayDiagonal(smartphone.getSmartphoneDisplay().getDisplay_diagonal());
            return smartphones;
        }
        if (priceDown!=null&&priceUp!=null&&!priceDown.equals("")&&priceUp.equals("")){
            smartphones=smartphoneRepository.filterPrice(new Double(priceDown),new Double("1000000"));
            return smartphones;
        }
        if (priceDown!=null&&priceUp!=null&&!priceUp.equals("")&&priceDown.equals("")){
            smartphones=smartphoneRepository.filterPrice(new Double("0"),new Double(priceUp));
            return smartphones;
        }
        if (priceDown!=null&&priceUp!=null&&!priceUp.equals("")&&!priceDown.equals("")){
            smartphones=smartphoneRepository.filterPrice(new Double(priceDown),new Double(priceUp));
            return smartphones;
        }
        return StreamSupport.stream(smartphoneRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
