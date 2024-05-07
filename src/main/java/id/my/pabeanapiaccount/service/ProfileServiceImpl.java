package id.my.pabeanapiaccount.service;

import id.my.pabeanapiaccount.model.UserProfile;
import id.my.pabeanapiaccount.dto.UserProfileResponse;
import id.my.pabeanapiaccount.dto.UserProfileRequest;
import id.my.pabeanapiaccount.exceptions.NoUserProfileExistException;
import id.my.pabeanapiaccount.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.my.pabeanapiaccount.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfileResponse getUserProfile(UserProfileRequest request) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByEmail(request.getEmail());
        UserProfile userProfile = userProfileOptional.orElse(null);
        if (userProfile == null) {
            throw new NoUserProfileExistException();
        }

        return UserProfileResponse.builder()
                .id(userProfile.getId())
                .userName(userProfile.getUserName())
                .email(userProfile.getEmail())
                .address(userProfile.getAddress())
                .phoneNumber(userProfile.getPhoneNumber())
                .about(userProfile.getAbout())
                .build();
    }

    @Override
    public void setUserProfile(UserProfileResponse userProfileDto) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByEmail(userProfileDto.getEmail());
        UserProfile userProfile = userProfileOptional.orElse(null);
        if (userProfile == null) {
            throw new NoUserProfileExistException();
        }

        userProfile.setUserName(userProfileDto.getUserName());
        userProfile.setEmail(userProfileDto.getEmail());
        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setPhoneNumber(userProfileDto.getPhoneNumber());
        userProfile.setAbout(userProfileDto.getAbout());

        userProfileRepository.save(userProfile);
    }
}