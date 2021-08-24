package com.example.web_school_manager.controller.service;

import com.example.web_school_manager.client.ProcessorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserService {
    @Autowired
    ProcessorClient processorClient;

    public void processUserName(String username) {
        processorClient.generateUserCode(username);

    }


    public void validateUserCode(short code) throws Exception {
        processorClient.generateUserCode(code + "");

    }
}
