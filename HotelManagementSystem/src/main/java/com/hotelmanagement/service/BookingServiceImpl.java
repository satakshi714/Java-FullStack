package com.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.entity.Booking;
import com.hotelmanagement.exception.BookingNotFoundException;
import com.hotelmanagement.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + id + " not found"));
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + id + " not found"));

        existingBooking.setCustomerName(booking.getCustomerName());
        existingBooking.setCustomerPhone(booking.getCustomerPhone());
        existingBooking.setCheckInDate(booking.getCheckInDate());
        existingBooking.setCheckOutDate(booking.getCheckOutDate());
        existingBooking.setRoom(booking.getRoom());

        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + id + " not found"));

        bookingRepository.delete(existingBooking);
    }
}