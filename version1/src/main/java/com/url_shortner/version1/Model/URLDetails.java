package com.url_shortner.version1.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="urlDetails")
public class URLDetails{
    public Long getId() {
        return id;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getKeycode() {
        return keycode;
    }
    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }
    public String getShortenUrl() {
        return shortenUrl;
    }
    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String originalUrl;
    @Nonnull
    private String keycode;
    @Nonnull
    private String shortenUrl;
    public URLDetails(String originalUrl,String keycode,String shortenUrl){
        this.originalUrl=originalUrl;
        this.keycode=keycode;
        this.shortenUrl=shortenUrl;
    }
    public URLDetails(){}
}