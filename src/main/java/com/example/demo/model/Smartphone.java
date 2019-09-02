package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Smartphone   {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private int number;
    private boolean available;
    private String sim_cart_mode;
    @Lob
    private String text_information;
//    private byte[] text_information2;
    @Lob
    private byte[] image_front;
    @Lob
    private byte[] image_back;
    @Lob
    private byte[] image_top;
    @Lob
    private byte[] image_bottom;
    @Lob
    private byte[] image_right_side;
    @Lob
    private byte[] image_left_side;

    private String article;
    private String model_range;
    private String class_SmartPhone;


    private String number_0f_sim_carts;
    private String format_sim_carts;
    private String standards_transfer_data;
    private String standard_conection;
    private String lte;
@Embedded
SmartphoneProcessor smartphoneProcessor;
@Embedded
SmartphoneCamera smartphoneCamera;
    @Embedded
    SmartphoneMemory smartphoneMemory;
    @Embedded
    SmartphoneDisplay smartphoneDisplay;
    private String security;
    private String OS;
    private String version_OS;
    private String charging_technologies;
    private String battery;
private String battery_capacity;
  private String wireless_technologies;
  private String WLAN;
  private String bluetooth;
  private String NFC_chip;
 private String satellite_system;
 private String case_material;
 private  String dust_wet_protect;
 private String shockproof;
 private String main_color;
private String thickness;
private String total_width_of_the_product;
 private String total_hight_of_the_product;
 private String weight;
 private String interfaces;
private String graduation_year;
private String model_line;
private String model_line_second_level;
private String guarantee;
private String radio;
private String screen_position_sensor;
private String light_sensor;
private String proximity_sensor;
private String producing_country;
private String bar_code;

    public Smartphone() {
    }
    public Smartphone(String article) {
        this.article=article;
    }

    public String getSim_cart_mode() {
        return sim_cart_mode;
    }

    public void setSim_cart_mode(String sim_cart_mode) {
        this.sim_cart_mode = sim_cart_mode;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getModel_range() {
        return model_range;
    }

    public void setModel_range(String model_range) {
        this.model_range = model_range;
    }

    public String getClass_SmartPhone() {
        return class_SmartPhone;
    }

    public void setClass_SmartPhone(String class_SmartPhone) {
        this.class_SmartPhone = class_SmartPhone;
    }


    public SmartphoneMemory getSmartphoneMemory() {
        return smartphoneMemory;
    }

//    public byte[]  getText_information2() {
//        return text_information2;
//    }
//
//    public void setText_information2(byte[] text_information2) {
//        this.text_information2 = text_information2;
//    }

    public void setSmartphoneMemory(SmartphoneMemory smartphoneMemory) {
        this.smartphoneMemory = smartphoneMemory;
    }

    public String getNumber_0f_sim_carts() {
        return number_0f_sim_carts;
    }

    public void setNumber_0f_sim_carts(String number_0f_sim_carts) {
        this.number_0f_sim_carts = number_0f_sim_carts;
    }

    public String getFormat_sim_carts() {
        return format_sim_carts;
    }

    public void setFormat_sim_carts(String format_sim_carts) {
        this.format_sim_carts = format_sim_carts;
    }

    public String getStandards_transfer_data() {
        return standards_transfer_data;
    }

    public void setStandards_transfer_data(String standards_transfer_data) {
        this.standards_transfer_data = standards_transfer_data;
    }

    public String getStandard_conection() {
        return standard_conection;
    }

    public void setStandard_conection(String standard_conection) {
        this.standard_conection = standard_conection;
    }

    public String getLte() {
        return lte;
    }

    public void setLte(String lte) {
        this.lte = lte;
    }

    public SmartphoneProcessor getSmartphoneProcessor() {
        return smartphoneProcessor;
    }

    public void setSmartphoneProcessor(SmartphoneProcessor smartphoneProcessor) {
        this.smartphoneProcessor = smartphoneProcessor;
    }

    public SmartphoneCamera getSmartphoneCamera() {
        return smartphoneCamera;
    }

    public void setSmartphoneCamera(SmartphoneCamera smartphoneCamera) {
        this.smartphoneCamera = smartphoneCamera;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getVersion_OS() {
        return version_OS;
    }

    public void setVersion_OS(String version_OS) {
        this.version_OS = version_OS;
    }

    public String getCharging_technologies() {
        return charging_technologies;
    }

    public void setCharging_technologies(String charging_technologies) {
        this.charging_technologies = charging_technologies;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(String battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getWireless_technologies() {
        return wireless_technologies;
    }

    public void setWireless_technologies(String wireless_technologies) {
        this.wireless_technologies = wireless_technologies;
    }

    public String getWLAN() {
        return WLAN;
    }

    public void setWLAN(String WLAN) {
        this.WLAN = WLAN;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getNFC_chip() {
        return NFC_chip;
    }

    public void setNFC_chip(String NFC_chip) {
        this.NFC_chip = NFC_chip;
    }

    public String getSatellite_system() {
        return satellite_system;
    }

    public void setSatellite_system(String satellite_system) {
        this.satellite_system = satellite_system;
    }

    public String getCase_material() {
        return case_material;
    }

    public void setCase_material(String case_material) {
        this.case_material = case_material;
    }

    public String getDust_wet_protect() {
        return dust_wet_protect;
    }

    public void setDust_wet_protect(String dust_wet_protect) {
        this.dust_wet_protect = dust_wet_protect;
    }

    public String getShockproof() {
        return shockproof;
    }

    public void setShockproof(String shockproof) {
        this.shockproof = shockproof;
    }

    public String getMain_color() {
        return main_color;
    }

    public void setMain_color(String main_color) {
        this.main_color = main_color;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getTotal_width_of_the_product() {
        return total_width_of_the_product;
    }

    public void setTotal_width_of_the_product(String total_width_of_the_product) {
        this.total_width_of_the_product = total_width_of_the_product;
    }

    public String getTotal_hight_of_the_product() {
        return total_hight_of_the_product;
    }

    public void setTotal_hight_of_the_product(String total_hight_of_the_product) {
        this.total_hight_of_the_product = total_hight_of_the_product;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(String graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getModel_line() {
        return model_line;
    }

    public void setModel_line(String model_line) {
        this.model_line = model_line;
    }

    public String getModel_line_second_level() {
        return model_line_second_level;
    }

    public void setModel_line_second_level(String model_line_second_level) {
        this.model_line_second_level = model_line_second_level;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getScreen_position_sensor() {
        return screen_position_sensor;
    }

    public void setScreen_position_sensor(String screen_position_sensor) {
        this.screen_position_sensor = screen_position_sensor;
    }

    public String getLight_sensor() {
        return light_sensor;
    }

    public void setLight_sensor(String light_sensor) {
        this.light_sensor = light_sensor;
    }

    public String getProximity_sensor() {
        return proximity_sensor;
    }

    public void setProximity_sensor(String proximity_sensor) {
        this.proximity_sensor = proximity_sensor;
    }

    public String getProducing_country() {
        return producing_country;
    }

    public void setProducing_country(String producing_country) {
        this.producing_country = producing_country;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getText_information() {
        return text_information;
    }

    public void setText_information(String text_information) {
        this.text_information = text_information;
    }

    public byte[] getImage_front() {
        return image_front;
    }

    public void setImage_front(byte[] image_front) {
        this.image_front = image_front;
    }

    public byte[] getImage_back() {
        return image_back;
    }

    public void setImage_back(byte[] image_back) {
        this.image_back = image_back;
    }

    public byte[] getImage_top() {
        return image_top;
    }

    public void setImage_top(byte[] image_top) {
        this.image_top = image_top;
    }

    public byte[] getImage_bottom() {
        return image_bottom;
    }

    public void setImage_bottom(byte[] image_bottom) {
        this.image_bottom = image_bottom;
    }

    public byte[] getImage_right_side() {
        return image_right_side;
    }

    public void setImage_right_side(byte[] image_right_side) {
        this.image_right_side = image_right_side;
    }

    public byte[] getImage_left_side() {
        return image_left_side;
    }

    public void setImage_left_side(byte[] image_left_side) {
        this.image_left_side = image_left_side;
    }

    public SmartphoneDisplay getSmartphoneDisplay() {
        return smartphoneDisplay;
    }

    public void setSmartphoneDisplay(SmartphoneDisplay smartphoneDisplay) {
        this.smartphoneDisplay = smartphoneDisplay;
    }
}

