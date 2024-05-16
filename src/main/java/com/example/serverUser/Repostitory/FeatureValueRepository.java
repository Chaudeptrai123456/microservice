package com.example.serverUser.Repostitory;

import com.example.serverUser.Entity.FeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureValueRepository extends JpaRepository<FeatureValue,Long> {
    public FeatureValue findByName(String name);
}
