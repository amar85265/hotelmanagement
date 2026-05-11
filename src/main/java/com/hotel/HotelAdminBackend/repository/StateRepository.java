package com.hotel.HotelAdminBackend.repository;

import com.hotel.HotelAdminBackend.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}