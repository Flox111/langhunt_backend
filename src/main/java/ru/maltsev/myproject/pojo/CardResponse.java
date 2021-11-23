package ru.maltsev.myproject.pojo;

public class CardResponse {

    private Long cardId;

    private String nativeTranslated;

    private String translated;

    private Long setId;

    private String imageUrl;

    public CardResponse(Long cardId, String nativeTranslated, String translated, String imageUrl) {
        this.cardId = cardId;
        this.nativeTranslated = nativeTranslated;
        this.translated = translated;
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

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
