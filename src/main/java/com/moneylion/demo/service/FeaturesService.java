package com.moneylion.demo.service;

import com.moneylion.demo.model.Features;

import java.util.List;

public interface FeaturesService {

    Features getFeatures(String featuresName);

    List<Features> findAll();
}
