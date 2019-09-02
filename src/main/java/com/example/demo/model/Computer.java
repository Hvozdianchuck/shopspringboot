package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Computer    {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private int number;
    private boolean available;
    private String text_information;
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
    private String display_diagonal;
    private String display_max_resolution;
    private String video_card_integrated;
    private String video_card_discrete;
    private String video_size_of_memory;
    private String builtin_drive;
    private String preinstalled_os;
    private String laptop_weight_without_ram;
    private String shading_code;

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

    public String getDisplay_diagonal() {
        return display_diagonal;
    }

    public void setDisplay_diagonal(String display_diagonal) {
        this.display_diagonal = display_diagonal;
    }

    public String getDisplay_max_resolution() {
        return display_max_resolution;
    }

    public void setDisplay_max_resolution(String display_max_resolution) {
        this.display_max_resolution = display_max_resolution;
    }

    public String getVideo_card_integrated() {
        return video_card_integrated;
    }

    public void setVideo_card_integrated(String video_card_integrated) {
        this.video_card_integrated = video_card_integrated;
    }

    public String getVideo_card_discrete() {
        return video_card_discrete;
    }

    public void setVideo_card_discrete(String video_card_discrete) {
        this.video_card_discrete = video_card_discrete;
    }

    public String getVideo_size_of_memory() {
        return video_size_of_memory;
    }

    public void setVideo_size_of_memory(String video_size_of_memory) {
        this.video_size_of_memory = video_size_of_memory;
    }

    public String getBuiltin_drive() {
        return builtin_drive;
    }

    public void setBuiltin_drive(String builtin_drive) {
        this.builtin_drive = builtin_drive;
    }

    public String getPreinstalled_os() {
        return preinstalled_os;
    }

    public void setPreinstalled_os(String preinstalled_os) {
        this.preinstalled_os = preinstalled_os;
    }

    public String getLaptop_weight_without_ram() {
        return laptop_weight_without_ram;
    }

    public void setLaptop_weight_without_ram(String laptop_weight_without_ram) {
        this.laptop_weight_without_ram = laptop_weight_without_ram;
    }

    public String getShading_code() {
        return shading_code;
    }

    public void setShading_code(String shading_code) {
        this.shading_code = shading_code;
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
}
