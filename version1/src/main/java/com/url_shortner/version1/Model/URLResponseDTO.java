package com.url_shortner.version1.Model;
public class URLResponseDTO{
    private String  keycode;
    private String shortenUrl;
    public String getShortenUrl() {
        return shortenUrl;
    }
    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }
    public URLResponseDTO(String keycode,String shortenUrl){
        this.keycode=keycode;
        this.shortenUrl=shortenUrl;
    }
    public String getKeycode() {
        return keycode;
    }
    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }
}
