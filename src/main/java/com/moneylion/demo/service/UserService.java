package com.moneylion.demo.service;

public interface UserService {
    Boolean checkFeatureAccess(String email, String featureName);
}
