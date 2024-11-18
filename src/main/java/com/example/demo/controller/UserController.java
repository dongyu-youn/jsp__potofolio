package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserProfileService userService; // Service 계층 주입

    // 모든 사용자 프로필 가져오기
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllProfiles();
        model.addAttribute("users", users); // 뷰에 데이터를 전달
        return "userList"; // "userList.jsp" 뷰 반환
    }

    // 특정 사용자 프로필 가져오기
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getProfileById(id);
        model.addAttribute("user", user); // 뷰에 데이터를 전달
        return "userDetail"; // "userDetail.jsp" 뷰 반환
    }

    // 새 사용자 프로필 추가 페이지
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User()); // 빈 User 객체를 뷰에 전달
        return "addUser"; // "addUser.jsp" 뷰 반환
    }

    // 새 사용자 프로필 추가 처리
    @PostMapping("/users")
    public String addUser(User user) {
        userService.addProfile(user); // 사용자 추가
        return "redirect:/users"; // 사용자 목록 페이지로 리디렉션
    }
}
