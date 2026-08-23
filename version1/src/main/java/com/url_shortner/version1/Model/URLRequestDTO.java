package com.url_shortner.version1.Model;
public class URLRequestDTO {
    private String originalUrl;
    public URLRequestDTO(String originalUrl){
        this.originalUrl=originalUrl;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
