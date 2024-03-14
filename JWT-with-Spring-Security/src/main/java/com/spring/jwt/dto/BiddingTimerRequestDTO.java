package com.spring.jwt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BiddingTimerRequestDTO {
    private Integer BiddingTimerId;

    private Integer carId;

    private Integer userId;

    private Integer basePrice;

    private int durationMinutes;
}
