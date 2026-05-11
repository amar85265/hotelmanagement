package com.hotel.HotelAdminBackend.service;

import com.hotel.HotelAdminBackend.dto.FeedbackRequest;
import com.hotel.HotelAdminBackend.dto.FeedbackResponse;
import com.hotel.HotelAdminBackend.model.Feedback;
import com.hotel.HotelAdminBackend.repository.FeedbackRepository;
import com.hotel.HotelAdminBackend.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    public FeedbackResponse createFeedback(FeedbackRequest request) {

        Feedback feedback = Feedback.builder()
                .reservationId(request.getReservationId())
                .guestId(request.getGuestId())
                .rating(request.getRating())
                .comment(request.getComment())
                .feedbackDate(LocalDateTime.now())
                .build();

        Feedback savedFeedback = feedbackRepository.save(feedback);

        return mapToResponse(savedFeedback);
    }

    @Override
    public List<FeedbackResponse> getAllFeedbacks() {

        return feedbackRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public FeedbackResponse getFeedbackById(Integer feedbackId) {

        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return mapToResponse(feedback);
    }

    @Override
    public FeedbackResponse updateFeedback(
            Integer feedbackId,
            FeedbackRequest request) {

        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        feedback.setReservationId(request.getReservationId());
        feedback.setGuestId(request.getGuestId());
        feedback.setRating(request.getRating());
        feedback.setComment(request.getComment());

        Feedback updatedFeedback = feedbackRepository.save(feedback);

        return mapToResponse(updatedFeedback);
    }

    @Override
    public void deleteFeedback(Integer feedbackId) {

        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        feedbackRepository.delete(feedback);
    }

    private FeedbackResponse mapToResponse(Feedback feedback) {

        return FeedbackResponse.builder()
                .feedbackId(feedback.getFeedbackId())
                .reservationId(feedback.getReservationId())
                .guestId(feedback.getGuestId())
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .feedbackDate(feedback.getFeedbackDate())
                .build();
    }
}