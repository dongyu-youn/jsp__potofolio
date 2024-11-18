package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`") // 테이블 이름이 예약어인 경우, 백틱을 사용해 감쌉니다.
public class User {

    // 기본 정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String certification;
    private String education;
    private String award;
    @Column(name = "github_link")
    private String githubLink;
    private String techStack; // 배열을 List<String>로 변경하지 않음 (단순 문자열로 처리)

    @ElementCollection
    private List<String> projects;

    @ElementCollection
    private List<String> studyExperience;

    // 기본 생성자
    public User() {
    }

    // 생성자
    public User(String username, String certification, String education, String award, String githubLink, String techStack, List<String> projects, List<String> studyExperience) {
        this.username = username;
        this.certification = certification;
        this.education = education;
        this.award = award;
        this.githubLink = githubLink;
        this.techStack = techStack;
        this.projects = projects;
        this.studyExperience = studyExperience;
    }

    // Getter와 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getStudyExperience() {
        return studyExperience;
    }

    public void setStudyExperience(List<String> studyExperience) {
        this.studyExperience = studyExperience;
    }
}
