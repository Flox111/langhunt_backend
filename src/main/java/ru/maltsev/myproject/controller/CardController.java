package ru.maltsev.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maltsev.myproject.pojo.SetResponse;
import ru.maltsev.myproject.pojo.CardResponse;
import ru.maltsev.myproject.service.CardService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/api/getSets")
    public List<SetResponse> getSets(@RequestParam("refresh_token") String refreshToken){
        List<SetResponse> sets = cardService.getSets(refreshToken);
        return sets;
    }

    @GetMapping("/api/getWords")
    public List<CardResponse> getWords(@RequestParam("refresh_token") String refreshToken, @RequestParam Long set_id){
        List<CardResponse> sets = cardService.getWords(refreshToken, set_id);
        return sets;
    }

    @PostMapping("/api/addWord")
    public CardResponse addWord(@RequestParam("refresh_token") String refreshToken, @RequestBody CardResponse cardResponse){
        CardResponse newWord = cardService.addWord(refreshToken, cardResponse);
        return newWord;
    }

    @PostMapping("/api/addSet")
    public SetResponse addWord(@RequestParam("refresh_token") String refreshToken, @RequestBody SetResponse setResponse){
        SetResponse newSet = cardService.addSet(refreshToken, setResponse);
        return newSet;
    }

    @PostMapping("/api/deleteCard")
    public CardResponse deleteCard(@RequestParam("refresh_token") String refreshToken, @RequestBody CardResponse cardResponse){
        cardService.deleteCard(refreshToken, cardResponse);
        return cardResponse;
    }

    @PostMapping("/api/deleteSet")
    public SetResponse deleteSet(@RequestParam("refresh_token") String refreshToken, @RequestBody SetResponse setResponse){
        cardService.deleteSet(refreshToken, setResponse);
        return setResponse;
    }
}
