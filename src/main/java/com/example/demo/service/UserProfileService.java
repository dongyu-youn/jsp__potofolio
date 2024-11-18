package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserRepository repository; // Repository 주입

    // 모든 프로필 가져오기
    public List<User> getAllProfiles() {
        return repository.findAll();
    }

    // 특정 프로필 가져오기
    public User getProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 새 프로필 추가하기
    public User addProfile(User profile) {
        return repository.save(profile);
    }

    // 프로필 업데이트하기
    public User updateProfile(Long id, User updatedProfile) {
        Optional<User> existingProfile = repository.findById(id);
        if (existingProfile.isPresent()) {
            User profile = existingProfile.get();
            profile.setUsername(updatedProfile.getUsername());
            profile.setCertification(updatedProfile.getCertification());
            profile.setEducation(updatedProfile.getEducation());
            profile.setAward(updatedProfile.getAward());
            profile.setGithubLink(updatedProfile.getGithubLink());
            profile.setTechStack(updatedProfile.getTechStack());
            profile.setProjects(updatedProfile.getProjects());
            profile.setStudyExperience(updatedProfile.getStudyExperience());
            return repository.save(profile);
        }
        return null;
    }

    // 프로필 삭제하기
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
