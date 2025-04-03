package com.Cancer.ColonCancerCapstone.Controller;


import com.Cancer.ColonCancerCapstone.Service.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/predict")
public class CancerDetectionController {

    @Autowired
    private DetectionService detectionService;

    // Endpoint to handle file upload and make prediction
    @PostMapping("/colon-cancer")
    public ResponseEntity<Map<String, Object>> predictTumor(@RequestParam("file") MultipartFile file) {
        try {
            Map<String, Object> result = detectionService.predictColonCancer(file);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Failed to process the image"));
        }
    }
}
