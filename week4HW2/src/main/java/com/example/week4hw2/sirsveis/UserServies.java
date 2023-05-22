package com.example.week4hw2.sirsveis;
import com.example.week4hw2.Repostry.UserRepostry;
import com.example.week4hw2.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServies {
    private final UserRepostry userRepostry;

    public List<User> getAlluser(){

        return userRepostry.findAll();
    }
    public void adduser(User user){

        userRepostry.save(user);
    }
    public boolean updateuser(Integer ID,User user){
        User oldUser=userRepostry.getReferenceById(ID);
        if (oldUser==null){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        oldUser.setPassowrd(user.getPassowrd());
        userRepostry.save(oldUser);
        return true;
    }
}
