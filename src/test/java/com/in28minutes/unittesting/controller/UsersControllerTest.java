package com.art.app.api.users.ui.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class UsersControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    public static List<String> token;


    public void contextLoads() {
        String req = "{" +
                "    \"phone\":\"emdadgar-p\"," +
                "    \"password\":\"6d071901727aec1ba6d8e2497ef5b709\"," +
                "    \"appType\":2" +
                "}";
        ResponseEntity<String> response = testRestTemplate.postForEntity("/users/login", req, String.class);
        token = response.getHeaders().get("token");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void getUserId() {
        contextLoads();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+token.get(0));

        ResponseEntity<String>  result = testRestTemplate.exchange(
                "/users/getUserId", HttpMethod.GET, new HttpEntity<Object>(headers),
                String.class);

        assertEquals(200, result.getStatusCodeValue());
    }

//    @Test
//    public void getRoleId(){
//         HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer "+token.get(0));
//
//        ResponseEntity<String>  result = testRestTemplate.exchange(
//                "/users/getUserId", HttpMethod.GET, new HttpEntity<Object>(headers),
//                String.class);
//
//        assertEquals(200, result.getStatusCodeValue());
//
//    }
}
