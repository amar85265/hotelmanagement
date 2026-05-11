package com.hotel.HotelAdminBackend.controller;

import com.hotel.HotelAdminBackend.dto.FeedbackRequest;
import com.hotel.HotelAdminBackend.dto.FeedbackResponse;
import com.hotel.HotelAdminBackend.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public FeedbackResponse createFeedback(
            @RequestBody FeedbackRequest request) {

        return feedbackService.createFeedback(request);
    }

    @GetMapping
    public List<FeedbackResponse> getAllFeedbacks() {

        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/{feedbackId}")
    public FeedbackResponse getFeedbackById(
            @PathVariable Integer feedbackId) {

        return feedbackService.getFeedbackById(feedbackId);
    }

    @PutMapping("/{feedbackId}")
    public FeedbackResponse updateFeedback(
            @PathVariable Integer feedbackId,
            @RequestBody FeedbackRequest request) {

        return feedbackService.updateFeedback(feedbackId, request);
    }

    @DeleteMapping("/{feedbackId}")
    public String deleteFeedback(
            @PathVariable Integer feedbackId) {

        feedbackService.deleteFeedback(feedbackId);

        return "Feedback deleted successfully";
    }
}