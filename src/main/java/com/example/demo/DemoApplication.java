package com.example.demo;


import com.example.demo.dao.ProductFilter;


import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SmartphoneRepository;

import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=  { SmartphoneRepository.class})
@EnableAsync
 public class DemoApplication extends SpringBootServletInitializer implements   CommandLineRunner {
@Autowired
SmartphoneRepository smartphoneRepository;
@Autowired
    PurchaseRepository purchaseRepository;
@Autowired
ProductRepository repository;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductFilter productFilter;
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(100);
        threadPoolTaskExecutor.setMaxPoolSize(200);
        threadPoolTaskExecutor.setQueueCapacity(1000);
        return threadPoolTaskExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
//
//

//        repository.deleteById(5);
//        repository.deleteById(10);
//        repository.deleteById(11);
//        repository.deleteById(12);
//        repository.deleteById(13);
//        repository.deleteById(14);



//        NewProductParse.readNewProducts();
//       List<Product> list = NewProductParse.getProduct_from_file();
//       shopService.saveListProducts(list,x->x.forEach(y->productRepository.save(y)));
//        shopService.addP("Asus");
//        shopService.addP("Lenovo");
//        System.out.println(shopService.getP(1));
//         shopService.getProductRepository().findAll().forEach(x-> System.out.println(x.getName()));
//        Product product= new Phone();
//        product.setName("Motorolla");
//        product.setPrice(2000);
//        Product product2= new Phone();
//        product.setName("LG");
//        product.setPrice(3000);
//        Product product3= new Phone();
//        product.setName("Apple");
//        product.setPrice(10000);
//        productRepository.save(product);
//        productRepository.save(product2);
//        productRepository.save(product3);
//        productRepository.findAll().forEach(x-> System.out.println(x.getName()));


    }
}
class
TestLazy{
    private int i;
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public TestLazy met1(){
        i++;
        System.out.println("me1"+i);
        return this;
    }
    public TestLazy met2(){
        i++;
        System.out.println("me2"+i);
        return this;
    }

    public static void main(String[] args) {
       TestLazy testLazy=new TestLazy();
       testLazy.setI(1);
        System.out.println(testLazy.met1().met2().getI());
        Stream<Integer> stream = Stream.of(1,5,3,8,7,9);
        stream.sorted().filter(y->y<4).forEach(x-> System.out.println(x));
    }
}