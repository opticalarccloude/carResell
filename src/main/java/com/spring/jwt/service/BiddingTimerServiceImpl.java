package com.spring.jwt.service;

import com.spring.jwt.Interfaces.BiddingTimerService;
import com.spring.jwt.dto.BiddingTimerRequestDTO;
import com.spring.jwt.entity.BiddingTimerRequest;
import com.spring.jwt.repository.BiddingTImerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BiddingTimerServiceImpl implements BiddingTimerService {

    private final BiddingTImerRepo biddingTImerRepo;

    private final ModelMapper modelMapper;

    private final JavaMailSender javaMailSender;




    @Override
    public BiddingTimerRequestDTO startTimer(BiddingTimerRequestDTO biddingTimerRequest) {

        BiddingTimerRequest biddingTimerRequest1 = convertToEntity(biddingTimerRequest);
        BiddingTimerRequest save = biddingTImerRepo.save(biddingTimerRequest1);
        BiddingTimerRequestDTO biddingTimerRequestDTO = convertToDto(save);


        return biddingTimerRequestDTO;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject("Bidding Timer Notification");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }


    public BiddingTimerRequest convertToEntity(BiddingTimerRequestDTO biddingTimerRequestDTO){
        BiddingTimerRequest biddingtime = modelMapper.map(biddingTimerRequestDTO, BiddingTimerRequest.class);

    return biddingtime;
    }

    public BiddingTimerRequestDTO convertToDto (BiddingTimerRequest biddingTimerRequest) {
        BiddingTimerRequestDTO biddingtimeDto = modelMapper.map(biddingTimerRequest, BiddingTimerRequestDTO.class);
        return biddingtimeDto;
    }
}
