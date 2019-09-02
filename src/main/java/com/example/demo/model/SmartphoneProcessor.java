package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class SmartphoneProcessor{
    private String processorNumbersCore;
    private String processorProducer;
    private String processorModel;
    private String processorClockFrequency;
    private String graphicProcessor;

    public String getProcessor_numbers_core() {
        return processorNumbersCore;
    }

    public void setProcessor_numbers_core(String processorNumbersCore) {
        this.processorNumbersCore = processorNumbersCore;
    }

    public String getProcessor_producer() {
        return processorProducer;
    }

    public void setProcessor_producer(String processor_producer) {
        this.processorProducer = processorProducer;
    }

    public String getProcessor_model() {
        return processorModel;
    }

    public void setProcessor_model(String processor_model) {
        this.processorModel = processorModel;
    }

    public String getProcessor_clock_frequency() {
        return processorClockFrequency;
    }

    public void setProcessor_clock_frequency(String processorClockFrequency) {
        this.processorClockFrequency = processorClockFrequency;
    }

    public String getGraphic_processor() {
        return graphicProcessor;
    }

    public void setGraphic_processor(String graphicProcessor) {
        this.graphicProcessor = graphicProcessor;
    }
}
