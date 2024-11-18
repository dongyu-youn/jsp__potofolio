package com.example.demo.repository; // 패키지 경로는 프로젝트에 맞게 설정하세요

import com.example.demo.model.User; // User 모델을 import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// UserRepository 인터페이스
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository를 상속받아 기본적인 CRUD 메서드를 사용할 수 있습니다
    @Query("SELECT u FROM User u WHERE u.username = :name")
    List<User> findByName(@Param("name") String name);
}
