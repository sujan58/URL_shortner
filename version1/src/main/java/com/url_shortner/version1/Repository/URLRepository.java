package com.url_shortner.version1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.url_shortner.version1.Model.URLDetails;
public interface URLRepository extends JpaRepository<URLDetails,Long>{
    @Query("SELECT p FROM URLDetails p WHERE p.originalUrl = :originalUrl")
    public URLDetails findByOriginalUrl(@Param("originalUrl") String originalUrl);
    
    @Query("Select p from URLDetails p where p.keycode =:keycode")
    public URLDetails findByKeyCode(@Param("keycode") String keycode);
}
