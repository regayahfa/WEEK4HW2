package com.example.week4hw2.Repostry;
import com.example.week4hw2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostry extends JpaRepository<User, Integer > {
}
