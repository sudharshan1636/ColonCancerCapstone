package com.Cancer.ColonCancerCapstone.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DetectionService {

    // Set the URL to the Flask endpoint
    private final String FLASK_SERVER_URL = "http://127.0.0.1:5000/train_and_predict";

    public Map<String, Object> predictColonCancer(MultipartFile file) throws IOException {
        Map<String, Object> response = new HashMap<>();

        // Convert MultipartFile to ByteArrayResource
        ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };

        // Set headers for multipart/form-data
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Prepare request body with the image file
        HttpEntity<ByteArrayResource> requestEntity = new HttpEntity<>(byteArrayResource, headers);
        RestTemplate restTemplate = new RestTemplate();

        // Send POST request to Flask server
        ResponseEntity<Map> flaskResponse = restTemplate.postForEntity(FLASK_SERVER_URL, requestEntity, Map.class);

        // Process the response
        if (flaskResponse.getStatusCode().is2xxSuccessful()) {
            response.putAll(flaskResponse.getBody());
        } else {
            response.put("error", "Prediction failed. Unable to process the image.");
        }

        return response;
    }
}
