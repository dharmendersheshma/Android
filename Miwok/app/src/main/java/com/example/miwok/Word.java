package com.example.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceID = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private int mAudioResourceID;


    public Word(String DefaultTranslation, String MiwokTranslation, int audioResourceID){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceID = audioResourceID;
    }

    public Word(String DefaultTranslation, String MiwokTranslation, int ImageResourceID, int audioResourceID ){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceID = ImageResourceID;
        mAudioResourceID = audioResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceID(){
        return mImageResourceID;
    }

    public int geAudioResourceID(){
        return mAudioResourceID;
    }

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE;
    }
}
