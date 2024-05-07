package id.my.pabeanapiaccount.service;

import id.my.pabeanapiaccount.model.UserProfile;
import id.my.pabeanapiaccount.dto.UserProfileRequest;
import id.my.pabeanapiaccount.dto.UserProfileResponse;

public interface ProfileService {
    UserProfileResponse getUserProfile(UserProfileRequest request);
    void setUserProfile(UserProfileResponse userProfileDto);
}
