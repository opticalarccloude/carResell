package com.spring.jwt.Interfaces;

import com.spring.jwt.dto.BiddingTimerRequestDTO;


public interface BiddingTimerService {

    public BiddingTimerRequestDTO startTimer (BiddingTimerRequestDTO biddingTimerRequest);

    void sendNotification (String recipient, String message);
}
