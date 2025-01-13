//package com.csbu.mvc_management.config;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Configuration
//public class FireBaseConfig {
//
//    @Bean
//    public FirebaseApp initializeFirebase() throws IOException {
//        String serviceAccountPath = System.getProperty("user.dir")+"/src/main/java/com/csbu/mvc_management/config/spring-boot-firebase.json";
//        FileInputStream serviceAccountStream = new FileInputStream(serviceAccountPath);
//
//        FirebaseOptions options= FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
//                .setStorageBucket("bcu-study-spaces.appspot.com")
//                .build();
//        return FirebaseApp.initializeApp(options);
//    }
//
//}
