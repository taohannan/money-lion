package com.moneylion.demo.service;

import com.moneylion.demo.model.Features;
import com.moneylion.demo.model.User;
import com.moneylion.demo.repository.FeaturesRepository;
import com.moneylion.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private FeaturesRepository featuresRepository;

    public UserServiceImpl(UserRepository userRepository, FeaturesRepository featuresRepository) {
        this.userRepository = userRepository;
        this.featuresRepository = featuresRepository;
    }

    @Override
    public Boolean checkFeatureAccess(String email, String featureName) {
        User userDetails = userRepository.findByEmail(email).orElse(null);
        Set<Features> feature = userDetails.getFeature();
        return feature.stream().anyMatch(x -> x.getName().equalsIgnoreCase(featureName));

    }

}
