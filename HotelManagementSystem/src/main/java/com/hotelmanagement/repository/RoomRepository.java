package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}