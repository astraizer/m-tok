package com.nostratech.m_tok.model;

import com.nostratech.m_tok.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "bookings")
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
