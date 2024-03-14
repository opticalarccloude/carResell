package com.spring.jwt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class BidCarsDTO {

    private Integer bidCarId;

    private Integer beadingCarId;

    private LocalDateTime Time;

    private LocalDateTime closingTime;

    private LocalDateTime createdAt;
}
