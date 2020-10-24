package me.nguyenthotuan.model;

public class Vocabulary {
    private int module;
    private int page;
    private String english;
    private String spelling;
    private String meaning;
    private String example;

    public Vocabulary() {
    }

    public Vocabulary(int module, int page, String english, String spelling, String meaning, String example) {
        this.module = module;
        this.page = page;
        this.english = english;
        this.spelling = spelling;
        this.meaning = meaning;
        this.example = example;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", english, meaning, example);
    }
}
