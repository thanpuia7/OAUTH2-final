package com.thanpuia.oath2.msegs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadRestController {
	
	//private static String UPLOADED_FOLDER = "E://Boot//tmp//";
	
	private static String UPLOADED_FOLDER = "/Users/lalthanpuiafanai/Desktop/RestImage/profile/";
	private static String UPLOADED_SIGNATURE = "/Users/lalthanpuiafanai/Desktop/RestImage/signature/";
	private static String UPLOADED_THUMBPRINT = "/Users/lalthanpuiafanai/Desktop/RestImage/thumbprint/";
	
	@PostMapping("/uploadprofile")
	public Object uploadrest(@RequestParam("fileupload") MultipartFile file) {


        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
          //  File file1=new File(UPLOADED_FOLDER+"/sam");
            File file1=new File(UPLOADED_FOLDER);
            if (!file1.exists()) {
				file1.mkdirs();
			}
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
           System.out.println(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
	
	@PostMapping("/uploadsignature")
	public Object uploadsignature(@RequestParam("fileupload") MultipartFile file) {


        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
       
            File file1=new File(UPLOADED_SIGNATURE);
            if (!file1.exists()) {
				file1.mkdirs();
			}
            Path path = Paths.get(UPLOADED_SIGNATURE + file.getOriginalFilename());
           System.out.println(UPLOADED_SIGNATURE + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
	
	
	@PostMapping("/uploadthumbprint")
	public Object uploadthumbprint(@RequestParam("fileupload") MultipartFile file) {


        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
       
            File file1=new File(UPLOADED_THUMBPRINT);
            if (!file1.exists()) {
				file1.mkdirs();
			}
            Path path = Paths.get(UPLOADED_THUMBPRINT + file.getOriginalFilename());
           System.out.println(UPLOADED_THUMBPRINT + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
