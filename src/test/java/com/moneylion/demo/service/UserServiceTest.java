package com.moneylion.demo.service;

import com.moneylion.demo.DemoApplication;
import com.moneylion.demo.model.Features;
import com.moneylion.demo.model.User;
import com.moneylion.demo.repository.FeaturesRepository;
import com.moneylion.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class UserServiceTest {

    private static  final Long id = 1L;
    private static  final Long id2 = 2L;
    private static final String name = "Test User";
    private static final String email = "test@email.com";
    private static final String feature_name1 = "feature_1";
    private static final String feature_name2 = "feature_2";
    private static final String feature_name3 = "feature_3";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeaturesRepository featuresRepository;

    private User user1;
    private User user2;
    private Features feature1;
    private Features feature2;


    @BeforeEach
    public void init(){
        user1 = new User();
        user1.setEmail(email);
        user1.setId(id);
        user1.setName(name);
        feature1 = new Features();
        feature1.setName(feature_name1);
        feature1.setId(id);
        feature2 = new Features();
        feature2.setName(feature_name2);
        feature2.setId(id2);
        Set<Features> features = new HashSet<>();
        features.add(feature1);
        features.add(feature2);
        user1.setFeature(features);

//        user2 = new User();
//        user2.setEmail(email);
//        user2.setId(id2);
//        user2.setName(name);
//        user2.setFeature(features);
    }

    @Test
    @Transactional
    public void assertThatFeatureIsTrue() {

        featuresRepository.saveAndFlush(feature1);
        featuresRepository.saveAndFlush(feature2);
        userRepository.saveAndFlush(user1);
        Boolean canAccessFeature1 = userService.checkFeatureAccess(email, feature_name1);
        assertTrue(canAccessFeature1);
        Boolean canAccessFeature2 = userService.checkFeatureAccess(email,feature_name2);
        assertTrue(canAccessFeature2);

    }

    @Test
    @Transactional
    public void assertThatFeatureIsFalse() {
        user2 = new User();
        user2.setEmail(email);
        user2.setId(id2);
        user2.setName(name);
        Features feat = new Features();
        feat.setId(3L);
        feat.setName(feature_name1);
        featuresRepository.saveAndFlush(feat);
        Set<Features> feature = new HashSet<>();
        feature.add(feat);
        user2.setFeature(feature);
        userRepository.saveAndFlush(user2);
        Boolean canAccessFeature3 = userService.checkFeatureAccess(email, feature_name3);
        assertFalse(canAccessFeature3);
    }
}
