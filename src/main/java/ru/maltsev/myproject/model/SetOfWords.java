package ru.maltsev.myproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sets")
public class SetOfWords {

    @Id
    @Column(name = "set_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sets_seq")
    @SequenceGenerator(name = "sets_seq", sequenceName = "sets_seq", allocationSize = 1)
    private Long setId;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "set", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public SetOfWords(String title, List<Card> cards, User user) {
        this.title = title;
        this.cards = cards;
        this.user = user;
    }

    public SetOfWords() { }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Card> getWords() {
        return cards;
    }

    public void setWords(List<Card> cards) {
        this.cards = cards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
