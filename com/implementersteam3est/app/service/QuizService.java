package com.implementersteam3est.app.service;

import java.util.Scanner;

import com.implementersteam3est.app.dao.Question;

public class QuizService {

	//Question questions[] = new Question[5];
	Question questions[];
	int finalScore=0;

	public void playQuiz(){
		System.out.println("Welcome To Quiz App!");
		Scanner scan = new Scanner(System.in);
		System.out.println("How many questions do you want to setup in Quiz?");
		int totalQues = scan.nextInt();
		if(totalQues <= 0) {
			System.out.println("Count should be more than 0 to proceed.");
			System.out.println("Do you wish to continue? \n1)Yes \n2)No");
			String conf = scan.next();
			if(conf.equalsIgnoreCase("yes")) {
				playQuiz();
			}else {
				System.out.println("See You Again!");
				return;
			}
		}
		questions = new Question[totalQues];
		//Admin setup the questions and options
		getQuestion(totalQues);
		//System.out.println("length>>>"+questions.length);
		//Student taking the test
		takeTest();
	}
	
	public void getQuestion(int totalQues) {
		
		for(int i=0;i<totalQues;i++) {
			String options[] = new String[4];
			Scanner scanTitle = new Scanner(System.in);
			int queNo = i+1;
			System.out.println("Enter question number: "+queNo);
			String title = scanTitle.nextLine();
			//System.out.println(title);
			for(int j=0;j<4;j++) {
				int count = j+1;
				System.out.print(count+")");
				options[j]=scanTitle.nextLine();
				//System.out.println(">>>>>>"+options[j]);
			}
			System.out.print("Enter the correct Answer: ");
			String answer = scanTitle.nextLine();
			//System.out.println("Answer>>"+answer);
			questions[i]=new Question(queNo,title,options[0],options[1],options[2],options[3],answer);
			//System.out.println("questions[i]>>"+questions[i]);
		}
		/*
		 * for(Question q : questions) { System.out.println("questions[i]>>"+q); }
		 */
	}
	
	public void takeTest() {
		System.out.println("Get Ready to Play!");
		int titleNo=1;
		//System.out.println("length>>>>"+questions.length);
		for(Question q : questions) {
			Scanner scanAnswer = new Scanner(System.in);
			System.out.println("Question No "+titleNo+"\n"+q.getTitle());
			System.out.println("1)"+q.getOption1());
			System.out.println("2)"+q.getOption2());
			System.out.println("3)"+q.getOption3());
			System.out.println("4)"+q.getOption4());
			String ansEntered = scanAnswer.nextLine();
			if(ansEntered.equalsIgnoreCase(q.getAnswer())) {
				//System.out.println("Good Job!!!");
				finalScore = finalScore + 2;
			}else if(!ansEntered.isBlank()){
				finalScore = finalScore - 1;
			}
			titleNo=titleNo+1;
		}
		System.out.println("FinalScore>>"+finalScore);
	}
}
