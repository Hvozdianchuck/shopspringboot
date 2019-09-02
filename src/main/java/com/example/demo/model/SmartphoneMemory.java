package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class SmartphoneMemory{

    private String operativeMemoryVolume;
    private String cartsMemory;
    private String volumeOfMemory;
    private String buildMemory;

    public String getBuild_memory() {
        return buildMemory;
    }

    public void setBuild_memory(String buildMemory) {
        this.buildMemory = buildMemory;
    }

    public String getOperative_memory_volume() {
        return operativeMemoryVolume;
    }

    public void setOperative_memory_volume(String operativeMemoryVolume) {
        this.operativeMemoryVolume = operativeMemoryVolume;
    }

    public String getCarts_memory() {
        return cartsMemory;
    }

    public void setCarts_memory(String carts_memory) {
        this.cartsMemory = cartsMemory;
    }

    public String getVolume_of_memory() {
        return volumeOfMemory;
    }

    public void setVolume_of_memory(String volume_of_memory) {
        this.volumeOfMemory = volume_of_memory;
    }
}
