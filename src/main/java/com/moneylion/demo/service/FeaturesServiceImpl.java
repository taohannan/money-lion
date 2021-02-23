package com.moneylion.demo.service;

import com.moneylion.demo.model.Features;
import com.moneylion.demo.repository.FeaturesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FeaturesServiceImpl implements FeaturesService{

    private FeaturesRepository featuresRepository;

    public FeaturesServiceImpl(FeaturesRepository featuresRepository) {
        this.featuresRepository = featuresRepository;
    }

   @Override
    public Features getFeatures(String featuresName) {
        return featuresRepository.findByName(featuresName);
    }

    @Override
    public List<Features> findAll() {
        return featuresRepository.findAll();
    }
}
