package com.example.profile.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.profile.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    //all crud methods

    
}
