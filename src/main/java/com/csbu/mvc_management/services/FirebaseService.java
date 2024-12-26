package com.csbu.mvc_management.services;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseService {
    public String upload(MultipartFile imgFile, String fileName) throws IOException {
        InputStream inputStream = imgFile.getInputStream();
        Bucket bucket = StorageClient.getInstance().bucket();
        String folderPath = "software_design_storage/transactions/";
        String fullFileName = folderPath + fileName;
        Blob blob= bucket.create(fullFileName, inputStream,imgFile.getContentType());
        return String.format(
                "https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                bucket.getName(),
                blob.getName().replaceAll("/", "%2F")
        );
    }
}
