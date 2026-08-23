package com.url_shortner.version1.Service;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;
import com.url_shortner.version1.Model.*;
import com.url_shortner.version1.Repository.URLRepository;
import com.url_shortner.version1.Exception.NotFoundHandler;
@Service
public class URLService {
    private final String charpool ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom random= new SecureRandom();
    private URLRepository urlRepository;
    public URLService(URLRepository urlRepository){
        this.urlRepository=urlRepository;
    }
    private String randomGenerator(int size){
        StringBuilder str  = new StringBuilder();
        for(int i=0;i<size;i++){
            int randomindex=random.nextInt(charpool.length());
            str.append(charpool.charAt(randomindex));
        }
        return str.toString();
        
    }
    public URLResponseDTO assignUrl(URLRequestDTO urldetails){
        String original=urldetails.getOriginalUrl();
        URLDetails details=urlRepository.findByOriginalUrl(original);
        if(details!=null){
            System.out.println("Already Exists"+details.getKeycode());
            return new URLResponseDTO(details.getKeycode(),details.getShortenUrl());
        }
        String key=this.randomGenerator(3);
        URLDetails shortenurl= new URLDetails(original,key,"http://localhost:8080/api/v1/"+key);
        urlRepository.save(shortenurl);
        return new URLResponseDTO(shortenurl.getKeycode(),shortenurl.getShortenUrl());
    }
    public String getUrl(String keycode){
    
        URLDetails urldetails = urlRepository.findByKeyCode(keycode);
        if(urldetails==null){
            throw new NotFoundHandler("The url doesn't exist");
        }
        return urldetails.getOriginalUrl();
    }
    public List<URLDetails> getall() {
        return urlRepository.findAll();
    }
}
