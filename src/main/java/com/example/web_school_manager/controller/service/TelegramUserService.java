package com.example.web_school_manager.controller.service;

import com.example.web_school_manager.client.ProcessorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserService {
    @Autowired
    ProcessorClient processorClient;

    public String processUserName(String username){
        String nextPage = "tgconfirm";
        try {
            processorClient.generateUserCode(username);
        } catch (Exception e) {
            nextPage = "500";
        }
        return nextPage;
    }


    public void validateUserCode(final String code, final String userName) throws Exception {
        processorClient.validateUserCode(code, userName);

    }
}
