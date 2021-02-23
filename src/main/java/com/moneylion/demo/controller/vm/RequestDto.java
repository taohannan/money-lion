package com.moneylion.demo.controller.vm;

import java.lang.invoke.SerializedLambda;

public class RequestDto  {

    private String featureName;
    private String email;
    private Boolean enable;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
