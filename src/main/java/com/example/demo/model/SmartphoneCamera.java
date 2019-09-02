package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class SmartphoneCamera{
    private String mainCamera;
    private String mainCameraFuther;
    private String videoRecording;
    private String frontCamera;
    private String frontCameraRecording;

    public String getMain_camera() {
        return mainCamera;
    }

    public void setMain_camera(String main_camera) {
        this.mainCamera = mainCamera;
    }

    public String getMain_camera_futher() {
        return mainCameraFuther;
    }

    public void setMain_camera_futher(String mainCameraFuther) {
        this.mainCameraFuther = mainCameraFuther;
    }

    public String getVideo_recording() {
        return videoRecording;
    }

    public void setVideo_recording(String video_recording) {
        this.videoRecording = videoRecording;
    }

    public String getFront_camera() {
        return frontCamera;
    }

    public void setFront_camera(String front_camera) {
        this.frontCamera = frontCamera;
    }

    public String getFront_camera_recording() {
        return frontCameraRecording;
    }

    public void setFront_camera_recording(String front_camera_recording) {
        this.frontCameraRecording = front_camera_recording;
    }
}
