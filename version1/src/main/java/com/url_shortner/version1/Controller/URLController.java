package com.url_shortner.version1.Controller;
import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url_shortner.version1.Model.URLDetails;
import com.url_shortner.version1.Model.URLRequestDTO;
import com.url_shortner.version1.Model.URLResponseDTO;
import com.url_shortner.version1.Service.URLService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//DOCUMENTATION(AVAILABLE API'S)

//api/v1/ GET  -- returns all the url in the db
//api/v1/ POST  -- shorten the url
//api/v1/{key} -- redirects to the original url 


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class URLController {
    //@Autowired
    public URLService urlService;
    public URLController(URLService urlService){
        this.urlService = urlService;
    }
    @GetMapping("/")
    public ResponseEntity<List<URLDetails>> getall() {
        return new ResponseEntity<>(urlService.getall(),HttpStatus.OK);
    }
    
    //@RequestMapping(value = "/get",method=RequestMethod.GET,params={"url"})
    @GetMapping("/{key}")
    public ResponseEntity<Void> getShortenURL(@PathVariable String key) {
        //url = url.replace("\\", "");
        URI uri = URI.create(urlService.getUrl(key));
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(uri).build();
    }
    //@RequestMapping(value="/post",method=RequestMethod.POST)
    @PostMapping("/")
    public ResponseEntity<URLResponseDTO> postMethodName(@RequestBody URLRequestDTO url) {
         return ResponseEntity.status(HttpStatus.CREATED).body(urlService.assignUrl(url));
    }
    
}
