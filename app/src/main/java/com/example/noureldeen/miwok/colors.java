package com.example.noureldeen.miwok;

/**
 * Created by noureldeen on 7/17/2017.
 */

public class colors {

    String englishWord, miwokWord = "";
    Integer imageResource , soundResource = 0;
    colors(String englishWord, String miwokWord) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
    }
    colors(String englishWord, String miwokWord, Integer imageResource ,Integer soundResource) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imageResource = imageResource;
        this.soundResource = soundResource;
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

    public Integer getSoundResource() {
        return soundResource;
    }
}
