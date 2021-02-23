package com.moneylion.demo.service;

import com.moneylion.demo.controller.vm.RequestDto;

public interface UserService {
    Boolean checkFeatureAccess(String email, String featureName);

    void updateFeatures(RequestDto requestDto) throws Exception;
}
