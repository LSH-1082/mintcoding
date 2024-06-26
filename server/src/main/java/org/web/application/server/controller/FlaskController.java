package org.web.application.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.web.application.server.service.FlaskService;

@RestController
@RequestMapping("/flask")
@RequiredArgsConstructor
public class FlaskController {
    private final FlaskService flaskService;

    @Getter
    @RequiredArgsConstructor
    public static class PurposeDTO
    {
        private String purpose;
    }

    @PostMapping("/matching")
    public String sendToFlask(@RequestHeader(name = "Authorization") String token, @RequestBody PurposeDTO purposeDTO) throws JsonProcessingException
    {
        return flaskService.sendToFlask(token, purposeDTO.getPurpose());
    }
}
