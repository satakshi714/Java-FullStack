package com.hotelmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;

    @Column(name = "CHECKIN_DATE")
    private LocalDate checkInDate;

    @Column(name = "CHECKOUT_DATE")
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    public Booking() {
    }

    public Booking(Long bookingId, String customerName, String customerPhone,
                   LocalDate checkInDate, LocalDate checkOutDate, Room room) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}