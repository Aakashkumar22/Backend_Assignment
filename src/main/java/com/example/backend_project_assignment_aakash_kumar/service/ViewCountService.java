package com.example.backend_project_assignment_aakash_kumar.service;

import com.example.backend_project_assignment_aakash_kumar.Model.ViewCount;
import com.example.backend_project_assignment_aakash_kumar.Repository.ViewCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ViewCountService {

    @Autowired
    ViewCountRepository viewCountRepository;



    public ViewCount createViewCount(ViewCount viewCount) {
        viewCount.setCreatedOn(LocalDateTime.now());
        return viewCountRepository.save(viewCount);
    }

    // Method to update an existing view count (if needed)
    public Optional<ViewCount> findById(Long viewCountId, ViewCount updatedViewCount) {
        Optional<ViewCount> existingViewCount = viewCountRepository.findById(viewCountId);


        // Update logic, if required
        return existingViewCount;
    }

    public Optional<ViewCount> getViewCountById(Long viewCountId) {
        return viewCountRepository.findById(viewCountId);

    }

    public void deleteViewCountById(Long viewCountId) {
        viewCountRepository.deleteById(viewCountId);
    }
}
