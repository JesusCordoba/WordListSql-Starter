package com.android.example.wordlistsql;

public class WordItem {

    private int mId;
    private String mWord;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    public WordItem(){

    }


    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String mWord) {
        this.mWord = mWord;
    }
}
