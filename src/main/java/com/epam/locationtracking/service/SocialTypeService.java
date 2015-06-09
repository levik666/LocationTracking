package com.epam.locationtracking.service;

import com.epam.locationtracking.entity.SocialType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialTypeService {

    public UserService getUserServiceByType(final String currentSocialType, final List<UserService> userServices){
        final SocialType[] socialTypes = SocialType.values();

        for(final SocialType socialType : socialTypes){
            final String type = socialType.getType();
            if (socialType.name().equals(currentSocialType)){
                for (UserService userService : userServices){
                    final String toString = userService.toString();
                    if (toString != null){
                        if (userService.toString().contains(type)){
                            return userService;
                        }
                    }
                }
            }
        }
        return null;
    }
}
