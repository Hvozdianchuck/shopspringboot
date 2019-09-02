package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class SmartphoneDisplay{
    private String displayDiagonal;
    private String displayMaximumResolution;
    private String displayMatrixType;
    private String displayPixelDensityPerInch;
    private String displaySecurity;

    public String getDisplay_diagonal() {
        return displayDiagonal;
    }

    public void setDisplay_diagonal(String display_diagonal) {
        this.displayDiagonal = displayDiagonal;
    }

    public String getDisplay_maximum_resolution() {
        return displayMaximumResolution;
    }

    public void setDisplay_maximum_resolution(String displayMaximumResolution) {
        this.displayMaximumResolution = displayMaximumResolution;
    }

    public String getDisplay_matrix_type() {
        return displayMatrixType;
    }

    public void setDisplay_matrix_type(String display_matrix_type) {
        this.displayMatrixType = displayMatrixType;
    }

    public String getDisplay_pixel_density_per_inch() {
        return displayPixelDensityPerInch;
    }

    public void setDisplay_pixel_density_per_inch(String displayPixelDensityPerInch) {
        this.displayPixelDensityPerInch = displayPixelDensityPerInch;
    }

    public String getDisplay_security() {
        return displaySecurity;
    }

    public void setDisplay_security(String displaySecurity) {
        this.displaySecurity = displaySecurity;
    }
}
