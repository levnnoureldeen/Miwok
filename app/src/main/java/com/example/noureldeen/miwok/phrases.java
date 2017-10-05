package com.example.noureldeen.miwok;

/**
 * Created by noureldeen on 7/17/2017.
 */

public class phrases {
    String englishWord, miwokWord = "";
    private final Integer NO_IMAGE_RESOURCE = -1;
    Integer imageResource = NO_IMAGE_RESOURCE;
    Integer soundResourceID = 0;

    phrases(String englishWord, String miwokWord) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
    }
    phrases(String englishWord, String miwokWord ,Integer soundResourceID) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.soundResourceID = soundResourceID;
    }
    phrases(String englishWord, String miwokWord, Integer imageResource, Integer soundResourceID) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imageResource = imageResource;
        this.soundResourceID = soundResourceID;
    }


    public String getEnglishWord() {
        return englishWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public Integer getImageResourceID() {
        return imageResource;
    }

    public boolean hasImage() {
        return imageResource != NO_IMAGE_RESOURCE;
    }

    public Integer getSoundResourceID() {
        return soundResourceID;
    }
}
