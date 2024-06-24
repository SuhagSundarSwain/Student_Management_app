package com.suhag_rest_api.suhag_rest_api.MainController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.suhag_rest_api.suhag_rest_api.Services.FileUploadServices;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadServices fileUploadServices;

    @PostMapping("/upload-profile-pic")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("profile-pic") MultipartFile file) {

        Map<String, Object> responseMessage = new HashMap<>();

        // Uncomment the following block to collect and include file info in the
        // response
        // Map<String, String> fileInfo = new HashMap<>();
        // fileInfo.put("file-name", file.getOriginalFilename());
        // fileInfo.put("file-size", file.getSize() + " Bytes");
        // fileInfo.put("file-type", file.getContentType());
        // fileInfo.put("file-param-name", file.getName());
        // responseMessage.put("info", fileInfo);

        if (file.isEmpty()) {
            responseMessage.put("error-message", "File can't be empty. Please upload a file.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
        }

        String contentType = file.getContentType();
        if (contentType == null || !(contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
            responseMessage.put("error-message", "Only 'image/jpeg' and 'image/png' are allowed.");
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(responseMessage);
        }

        try {
            boolean fileUploadedStatus = fileUploadServices.uploadFile(file);
            if (fileUploadedStatus) {
                responseMessage.put("message", "File uploaded successfully.");
                return ResponseEntity.ok(responseMessage);
            } else {
                responseMessage.put("error-message", "File upload failed.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseMessage.put("error-message", "An error occurred during file upload: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }
}
