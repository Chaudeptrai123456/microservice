package com.example.serverUser.Repostitory;

import com.example.serverUser.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value="SELECT * FROM category c WHERE c.name = :name",nativeQuery = true)
    public Category findByName(String name);

}
