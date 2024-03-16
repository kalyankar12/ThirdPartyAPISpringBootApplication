package com.example.thirdpartyapi.postsservice;

import java.util.List;
import java.util.Map;

public interface PostsService {

    List<Map<String,Object>> getPosts();
    Map<String,Object> getPostById(int id);
    Map<String,Object> insertPost(Map<String,Object> paylod);
    Map<String,Object> updatePosts(Map<String,Object> paylod, int id);

    Map<String,Object> deletePosts(int id);
}
