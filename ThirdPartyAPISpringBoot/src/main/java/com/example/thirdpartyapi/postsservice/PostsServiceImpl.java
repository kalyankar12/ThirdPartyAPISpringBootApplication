package com.example.thirdpartyapi.postsservice;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostsServiceImpl implements PostsService{

  // String baseUrl="https://jsonplaceholder.typicode.com/";
   //StringBuilder stringBuilder=new StringBuilder(baseUrl);
   // String POST="/posts";
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = "/posts";


   @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Map<String, Object>> getPosts() {
        String url = BASE_URL + POSTS_ENDPOINT;
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<List> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        String url = BASE_URL + POSTS_ENDPOINT+ "/" + id;
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> insertPost(Map<String, Object> paylod) {
        String url = BASE_URL + POSTS_ENDPOINT;
        HttpEntity<Map> httpEntity = new HttpEntity<>(paylod,getHttpHeaders());
        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePosts(Map<String, Object> paylod, int id) {
        String url = BASE_URL + POSTS_ENDPOINT + "/" + id;
        HttpEntity<Map> httpEntity = new HttpEntity<>(paylod,getHttpHeaders());
        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> deletePosts(int id) {
        String url = BASE_URL + POSTS_ENDPOINT + "/" + id;
        HttpEntity<Map> httpEntity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);

        return response.getBody();
    }


    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
