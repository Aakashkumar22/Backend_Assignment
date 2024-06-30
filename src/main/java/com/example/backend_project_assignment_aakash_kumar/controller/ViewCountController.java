package com.example.backend_project_assignment_aakash_kumar.controller;

import com.example.backend_project_assignment_aakash_kumar.Model.ViewCount;
import com.example.backend_project_assignment_aakash_kumar.service.ViewCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("view-counts")
public class ViewCountController {



    @Autowired
    ViewCountService viewCountService;

    @PostMapping
    public ResponseEntity<ViewCount> createViewCount(@RequestBody ViewCount viewCount) {
        ViewCount createdViewCount = viewCountService.createViewCount(viewCount);
        return ResponseEntity.ok(createdViewCount);
    }

}
