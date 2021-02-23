package com.moneylion.demo.service;

import com.moneylion.demo.controller.vm.RequestDto;
import com.moneylion.demo.model.Features;
import com.moneylion.demo.model.User;
import com.moneylion.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private FeaturesService featuresService;

    public UserServiceImpl(UserRepository userRepository, FeaturesService featuresService) {
        this.userRepository = userRepository;
        this.featuresService = featuresService;
    }

    @Override
    public Boolean checkFeatureAccess(String email, String featureName) {
        User userDetails = userRepository.findByEmail(email).orElse(null);
        Set<Features> feature = userDetails.getFeature();
        return feature.stream().anyMatch(x -> x.getName().equalsIgnoreCase(featureName));

    }

    @Override
    public void updateFeatures(RequestDto requestDto) throws Exception {
        User userDetails = userRepository.findByEmail(requestDto.getEmail()).orElse(null);
        List<Features> featuresDetails = featuresService.findAll();
        Set<Features> features = userDetails.getFeature();

        if(requestDto.getEnable()){
            if (featuresDetails.stream().anyMatch(x -> x.getName().equalsIgnoreCase(requestDto.getFeatureName()))) {
                Features feature = featuresService.getFeatures(requestDto.getFeatureName());
                userDetails.addFeatures(feature);
                userRepository.save(userDetails);
            }else{
                throw new Exception();
            }
        }else{
            if (featuresDetails.stream().anyMatch(x -> x.getName().equalsIgnoreCase(requestDto.getFeatureName()))) {
                Features feature = featuresService.getFeatures(requestDto.getFeatureName());
                userDetails.removeFeatures(feature);
                userRepository.save(userDetails);
            }else{
                throw new Exception();
            }
        }

    }

}
