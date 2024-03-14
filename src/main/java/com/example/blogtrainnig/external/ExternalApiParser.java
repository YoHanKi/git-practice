package com.example.blogtrainnig.external;

import com.example.blogtrainnig.dto.AddArticleRequest;
import com.example.blogtrainnig.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;


@Slf4j
@Component
public class ExternalApiParser {

    BlogService blogService;

    public ExternalApiParser(BlogService blogService) {
        this.blogService = blogService;
    }

    public void parserAndSave() {
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List> response = restTemplate.getForEntity(URL, List.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            List<LinkedHashMap<String, Object>> list = response.getBody();

            //title, body 받기
            for (LinkedHashMap<String, Object> map : list) {
                String title = (String) map.get("title");
                String content = (String) map.get("body");

                blogService.save(new AddArticleRequest(title, content));
            }
        }
    }
}
