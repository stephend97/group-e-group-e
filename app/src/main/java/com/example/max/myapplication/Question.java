package com.example.max.myapplication;

import java.util.ArrayList;

/**
 * Created by max
 */

public class Question {

    String quest = "";
    ArrayList<String> choiceList = new ArrayList<>();
    String answer = "";
    int questionID;
    int pointValue;

    public Question() {
        this.quest = "";
        this.answer = this.choiceList.get(0);
        this.questionID = 0;
        this.pointValue = 0;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getQuest(String quest) {
        return quest;
    }

    public void setChoiceList(String choice) {
        this.choiceList.add(choice);
    }

    public ArrayList<String> getChoiceList() {
        return this.choiceList;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(String answer) {
        return answer;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuestionID(int questionID) {
        return questionID;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getPointValue(int pointValue) {
        return pointValue;
    }

}
