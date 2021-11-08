package ru.maltsev.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsev.myproject.config.jwt.JwtUtils;
import ru.maltsev.myproject.model.SetOfWords;
import ru.maltsev.myproject.model.User;
import ru.maltsev.myproject.model.Card;
import ru.maltsev.myproject.repository.RefreshTokenRepository;
import ru.maltsev.myproject.repository.SetOfWordsRepository;
import ru.maltsev.myproject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TestController {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SetOfWordsRepository setOfWordsRepository;

    @GetMapping("/api/test")
    private ResponseEntity<List<String>> showUsers(){
        List<String> list = new ArrayList<>();
        for (int i = 0;i<40;i++) {
            list.add("test " + i);
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("test/govna/1")
    private void test1(){
        User user =  userRepository.findByUsername("flox").get();
        SetOfWords setOfWords = new SetOfWords();
        setOfWords.setUser(user);
        setOfWords.setTitle("Set1");
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("home","дом",setOfWords));
        cards.add(new Card("cat","кот",setOfWords));
        cards.add(new Card("dog","собака",setOfWords));
        setOfWords.setWords(cards);
        user.getSets().add(setOfWords);
        userRepository.save(user);
        return;
    }

    @GetMapping("test/govna/2")
    private void test2(){
        User user =  userRepository.findByUsername("flox").get();
        SetOfWords setOfWords = new SetOfWords();
        setOfWords.setUser(user);
        setOfWords.setTitle("Set2");
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("home","дом",setOfWords));
        cards.add(new Card("cat","кот",setOfWords));
        cards.add(new Card("dog","собака",setOfWords));
        setOfWords.setWords(cards);
        user.getSets().add(setOfWords);
        userRepository.save(user);
        return;
    }

    @GetMapping("test/govna/3")
    private void test3(){
        User user =  userRepository.findByUsername("flox").get();
        SetOfWords setOfWords = user.getSets().get(1);
        List<Card> cards = setOfWords.getWords();
        cards.add(new Card("snake","змея",setOfWords));
        userRepository.save(user);
        return;
    }
}
