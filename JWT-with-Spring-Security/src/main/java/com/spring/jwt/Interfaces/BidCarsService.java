package com.spring.jwt.Interfaces;

import com.spring.jwt.dto.BidCarsDTO;
import com.spring.jwt.dto.BidDetailsDTO;

public interface BidCarsService {

    public BidCarsDTO createBidding(BidCarsDTO bidCarsDTO);

    public BidDetailsDTO getbyBidId (Integer bidCarId,  Integer beadingCarId);
}
