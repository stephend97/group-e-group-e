package com.example.max.myapplication;

import java.util.ArrayList;

/**
 * Created by max
 */

public class Quiz {

    User creator;
    String quizID = "";
    ArrayList<Question> questionList = new ArrayList<>();
    double possiblePoints;
    double receivedPoints;

    public Quiz() {
        this.creator = null;
        this.quizID = "";
        this.questionList.clear();
        this.possiblePoints = 0.0;
        this.receivedPoints = 0.0;
    }

    /*public Quiz(User pcreator, String pquizID, Question pquest, double ppossiblePoints, double preceivedPoints) {
        this.creator = pcreator;
        this.quizID = pquizID;
        this.quest = pquest;
        this.possiblePoints = ppossiblePoints;
        this.receivedPoints = preceivedPoints;
    }*/

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    public String getQuizID() {
        return quizID;
    }

    public void setQuestionList(Question quest) {
        questionList.add(quest);
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }


    public void setPossiblePoints(double possiblePoints) {
        this.possiblePoints = possiblePoints;
    }

    public double getPossiblePoints() {
        return possiblePoints;
    }

    public void setRecievedPoints(double recievedPoints) {
        this.receivedPoints = recievedPoints;
    }

    public double getRecievedPoints() {
        return receivedPoints;
    }

}
