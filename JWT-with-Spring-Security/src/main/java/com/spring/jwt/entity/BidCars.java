package com.spring.jwt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@NoArgsConstructor
public class BidCars {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name= "bidCarId")
   private Integer bidCarId;

   @Column(name = "beadingCardId")
   private Integer beadingCarId;

   @Column(name="time")
   private LocalDateTime Time;

    @Column(nullable = false)
    private LocalDateTime createdAt;

   @Column(name = "closingTime")
   private LocalDateTime closingTime;

    @PrePersist
    public void prePersist() {
        final LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        if(closingTime == null) {
            closingTime = localDateTime.plusHours(1);
        }
        if(createdAt == null) {
            createdAt = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        }
    }
}
