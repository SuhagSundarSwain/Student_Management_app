package com.suhag_rest_api.suhag_rest_api.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServices {

    // STATIC DIRECTORY
    // private final String UPLOAD_DIR = "src/main/resources/static/images";

    // DYNAMIC DIRECTORY
    private final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();//If directory not present please create

    public FileUploadServices() throws IOException {
    }

    // Uncomment the following block to use the alternative upload method
    /*
     * public boolean uploadFile(MultipartFile multipartFile) {
     * File uploadDir = new File(UPLOAD_DIR);
     * if (!uploadDir.exists()) {
     * uploadDir.mkdirs();
     * }
     * 
     * try (InputStream inputStream = multipartFile.getInputStream();
     * FileOutputStream fileOutputStream = new FileOutputStream(
     * UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename())) {
     * 
     * byte[] buffer = new byte[1024];
     * int bytesRead;
     * while ((bytesRead = inputStream.read(buffer)) != -1) {
     * fileOutputStream.write(buffer, 0, bytesRead);
     * }
     * 
     * fileOutputStream.flush();
     * return true;
     * 
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * return false;
     * }
     */

    public boolean uploadFile(MultipartFile multipartFile) {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        try {
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
