package com.SpringBootStorageS3Gcp.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@RestController
@RequestMapping("/gcp/")
public class GcpStorageDemo {

    @Autowired
    private Storage storage;

    public String uploadBlobFile() throws IOException{

        BlobId blobId= BlobId.of("spring-boot-gcp-s3-storage-bucket2", "demofile.txt");
        BlobInfo blobInfo= BlobInfo.newBuilder(blobId).build();

        File file= new File("testFile.txt");
        byte[] arr= Files.readAllBytes(Paths.get(file.toURI()));
        storage.create(blobInfo, arr);

        return "File is uploaded!";
    }



}
