package org.example.controllers;

import org.example.service.BattleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;



@Controller
@CrossOrigin(origins = "http://localhost:8081")
public class BattleController {

    private final BattleService battleService;
    private static final Logger log = LoggerFactory.getLogger(BattleController.class);

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }
}









