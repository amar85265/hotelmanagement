package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.FeedbackRequest;
import com.hotel.HotelAdminBackend.dto.FeedbackResponse;

import java.util.List;

public interface FeedbackService {

    FeedbackResponse createFeedback(FeedbackRequest request);

    List<FeedbackResponse> getAllFeedbacks();

    FeedbackResponse getFeedbackById(Integer feedbackId);

    FeedbackResponse updateFeedback(Integer feedbackId, FeedbackRequest request);

    void deleteFeedback(Integer feedbackId);
}