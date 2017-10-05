package com.example.noureldeen.miwok;

/**
 * Created by noureldeen on 7/16/2017.
 */

public class word {
    String englishWord, miwokWord = "";
    Integer imageResource, soundResourceID = 0;

    word(String englishWord, String miwokWord, Integer imageResource, Integer soundResourceID) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imageResource = imageResource;
        this.soundResourceID = soundResourceID;
    }

    word(String englishWord, String miwokWord) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public int getImageResourceID() {
        return imageResource;
    }

    public Integer getSoundResourceID() {
        return soundResourceID;
    }
}
