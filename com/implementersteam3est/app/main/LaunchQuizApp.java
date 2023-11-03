package com.implementersteam3est.app.main;

import com.implementersteam3est.app.service.QuizService;

public class LaunchQuizApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizService start = new QuizService();
		/*
		 * start.getQuestion(); start.takeTest();
		 */
		start.playQuiz();
	}

}
