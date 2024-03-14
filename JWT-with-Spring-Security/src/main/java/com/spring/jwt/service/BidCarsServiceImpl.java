package com.spring.jwt.service;

import com.spring.jwt.Interfaces.BidCarsService;
import com.spring.jwt.dto.BeadingCAR.BeadingCARDto;
import com.spring.jwt.dto.BidCarsDTO;
import com.spring.jwt.dto.BidDetailsDTO;
import com.spring.jwt.dto.ResDtos;
import com.spring.jwt.entity.BeadingCAR;
import com.spring.jwt.entity.BidCars;
import com.spring.jwt.repository.BeadingCarRepo;
import com.spring.jwt.repository.BidCarsRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BidCarsServiceImpl implements BidCarsService {

    private final ModelMapper modelMapper;

    private final BeadingCarRepo beadingCarRepo;

    private final BidCarsRepo bidCarsRepo;

    @Override
    public BidCarsDTO createBidding(BidCarsDTO bidCarsDTO) {
        Optional<BeadingCAR> byId = beadingCarRepo.findById(bidCarsDTO.getBeadingCarId());
        if (!byId.isPresent()) {
            throw new RuntimeException("Car Not Found");
        }
        BidCars bidCars = convertToEntity(bidCarsDTO);
        BidCars save = bidCarsRepo.save(bidCars);
        return convertToDto(save);
    }

    @Override
    public BidDetailsDTO getbyBidId(Integer bidCarId, Integer beadingCarId) {
        Optional<BidCars> bidCarOptional  = bidCarsRepo.findById(bidCarId);
        Optional<BeadingCAR> beadingCarOptional  = beadingCarRepo.findById(beadingCarId);

        if (bidCarOptional.isPresent() && beadingCarOptional.isPresent()) {
            BidCars bidCar = bidCarOptional.get();
            BeadingCAR beadingCar = beadingCarOptional.get();

            BidDetailsDTO bidDetailsDTO = new BidDetailsDTO();

            bidDetailsDTO.setBidCarId(bidCar.getBidCarId());
            bidDetailsDTO.setBeadingCarId(beadingCar.getBeadingCarId());
            bidDetailsDTO.setTime(bidCar.getTime());
            bidDetailsDTO.setClosingTime(bidCar.getClosingTime());
            bidDetailsDTO.setCreatedAt(bidCar.getCreatedAt());
            bidDetailsDTO.setMusicFeature(beadingCar.getMusicFeature());
            bidDetailsDTO.setArea(beadingCar.getArea());
            bidDetailsDTO.setBodyType(beadingCar.getBodyType());
            bidDetailsDTO.setBrand(beadingCar.getBrand());
            bidDetailsDTO.setCarInsurance(beadingCar.getCarInsurance());
            bidDetailsDTO.setCarStatus(beadingCar.getCarStatus());
            bidDetailsDTO.setCity(beadingCar.getCity());
            bidDetailsDTO.setColor(beadingCar.getColor());
            bidDetailsDTO.setDescription(beadingCar.getDescription());
            bidDetailsDTO.setFuelType(beadingCar.getFuelType());
            bidDetailsDTO.setKmDriven(beadingCar.getKmDriven());
            bidDetailsDTO.setModel(beadingCar.getModel());
            bidDetailsDTO.setNoOfWheels(beadingCar.getNoOfWheels());
            bidDetailsDTO.setOwnerSerial(beadingCar.getOwnerSerial());
            bidDetailsDTO.setPowerWindowFeature(beadingCar.getPowerWindowFeature());
            bidDetailsDTO.setPrice(beadingCar.getPrice());
            bidDetailsDTO.setRearParkingCameraFeature(beadingCar.getRearParkingCameraFeature());
            bidDetailsDTO.setRegistration(beadingCar.getRegistration());
            bidDetailsDTO.setSafetyDescription(beadingCar.getSafetyDescription());
            bidDetailsDTO.setTransmission(beadingCar.getTransmission());
            bidDetailsDTO.setTyre(beadingCar.getTyre());
            bidDetailsDTO.setYear(beadingCar.getYear());
            bidDetailsDTO.setDate(beadingCar.getDate());
            bidDetailsDTO.setUserId(beadingCar.getUserId());

            return bidDetailsDTO;
        }else {
            // Handle the case when either bid car or beading car is not found
            throw new RuntimeException("Bid car or Beading car not found");
        }
    }



    public BidCars convertToEntity(BidCarsDTO bidCarsDTO){
        BidCars bdCarEntity = modelMapper.map(bidCarsDTO, BidCars.class);
        return bdCarEntity;
    }

    public BidCarsDTO convertToDto (BidCars bidCars){
        BidCarsDTO bdCarDto = modelMapper.map(bidCars, BidCarsDTO.class);
        return bdCarDto;
    }
}
