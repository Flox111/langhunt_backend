package ru.maltsev.myproject.model;

import javax.persistence.*;

@Entity(name = "card")
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cards_seq")
    @SequenceGenerator(name = "cards_seq", sequenceName = "cards_seq", allocationSize = 1)
    private Long cardId;

    @Column(name = "native_translated")
    private String nativeTranslated;

    @Column(name = "translated")
    private String translated;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "set_id", referencedColumnName = "set_id")
    private SetOfWords set;

    Card() {
    }

    public Card(String nativeTranslated, String translated, SetOfWords set, String imageUrl) {
        this.nativeTranslated = nativeTranslated;
        this.translated = translated;
        this.set = set;
        this.imageUrl = imageUrl;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getNativeTranslated() {
        return nativeTranslated;
    }

    public void setNativeTranslated(String nativeTranslated) {
        this.nativeTranslated = nativeTranslated;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public SetOfWords getSet() {
        return set;
    }

    public void setSet(SetOfWords set) {
        this.set = set;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
