package ru.maltsev.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maltsev.myproject.model.SetOfWords;
import ru.maltsev.myproject.model.User;
import ru.maltsev.myproject.model.Card;
import ru.maltsev.myproject.pojo.SetResponse;
import ru.maltsev.myproject.pojo.CardResponse;
import ru.maltsev.myproject.repository.RefreshTokenRepository;
import ru.maltsev.myproject.repository.SetOfWordsRepository;
import ru.maltsev.myproject.repository.UserRepository;
import ru.maltsev.myproject.repository.CardRepository;

import java.util.*;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    SetOfWordsRepository setOfWordsRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;


    public List<SetResponse> getSets(String refreshToken){
        Optional<User> user = userRepository.findById(refreshTokenRepository.findByToken(refreshToken).get().getUser().getId());
        List<SetOfWords> sets = user.get().getSets();
        List<SetResponse> response = new ArrayList<>();
        for (SetOfWords set: sets){
            response.add(new SetResponse(set.getSetId(),set.getTitle(),set.getUser().getId()));
        }
        return response;
    }

    public List<CardResponse> getWords(String refreshToken, Long set_id){
        Optional<User> user = userRepository.findById(refreshTokenRepository.findByToken(refreshToken).get().getUser().getId());
        List<SetOfWords> sets = user.get().getSets();
        List<CardResponse> response = new ArrayList<>();
        for (SetOfWords set: sets){
            if (set.getSetId() == set_id){
                for (Card card : set.getWords()){
                    response.add(new CardResponse(card.getCardId(),
                            card.getNativeTranslated(), card.getTranslated(), card.getImageUrl()));
                }
                break;
            }
        }
        return response;
    }

    public CardResponse addWord(String refreshToken, CardResponse cardResponse){
        Optional<User> user = userRepository.findById(refreshTokenRepository.findByToken(refreshToken).get().getUser().getId());
        List<SetOfWords> sets = user.get().getSets();
        SetOfWords set = new SetOfWords();
        for (SetOfWords iset: sets){
            if (iset.getSetId() == cardResponse.getSetId()){
                iset.getWords().add(new Card(cardResponse.getNativeTranslated(),
                        cardResponse.getTranslated(), iset, cardResponse.getImageUrl()));
                set = iset;
                break;
            }
        }
        userRepository.save(user.get());
        cardResponse.setCardId(set.getWords().get(set.getWords().size() - 1).getCardId());
        return cardResponse;
    }

    public SetResponse addSet(String refreshToken, SetResponse setResponse){
        Optional<User> user = userRepository.findById(refreshTokenRepository.findByToken(refreshToken).get().getUser().getId());
        List<SetOfWords> sets = user.get().getSets();
        sets.add(new SetOfWords(setResponse.getTitle(), new ArrayList<>(), user.get()));
        userRepository.save(user.get());
        setResponse.setSetId(sets.get(sets.size() - 1).getSetId());
        setResponse.setUserId(user.get().getId());
        return setResponse;
    }

    public void deleteCard(String refreshToken, CardResponse cardResponse){
        cardRepository.deleteById(cardResponse.getCardId());
    }

    public void deleteSet(String refreshToken, SetResponse setResponse){
        setOfWordsRepository.deleteById(setResponse.getSetId());
    }
}
