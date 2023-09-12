package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<String> questions = generateQuestions();
        Collections.shuffle(questions);

        int totalQuestions = random.nextInt(questions.size()) + 1;
        int correctAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            String question = questions.get(i);

            int num1 = Integer.parseInt(question.split(" x ")[0]);
            int num2 = Integer.parseInt(question.split(" x ")[1]);

            System.out.print("Питання " + (i + 1) + ": " + num1 + " x " + num2 + " = ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == (num1 * num2)) {
                System.out.println("Правильно!");
                correctAnswers++;
            } else {
                System.out.println("Неправильно. Правильна відповідь: " + (num1 * num2));
            }
        }

        double percentageCorrect = (double) correctAnswers / totalQuestions * 100;
        int grade = calculateGrade(percentageCorrect);

        System.out.println("Ви відповіли правильно на " + correctAnswers + " з " + totalQuestions + " питань.");
        System.out.println("Ваша оцінка: " + grade + " балів з 12.");
    }

    private static List<String> generateQuestions() {
        List<String> questions = new ArrayList<>();
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                questions.add(i + " x " + j);
            }
        }
        return questions;
    }

    private static int calculateGrade(double percentageCorrect) {
        if (percentageCorrect >= 90) {
            return 12;
        } else if (percentageCorrect >= 80) {
            return 11;
        } else if (percentageCorrect >= 70) {
            return 10;
        } else if (percentageCorrect >= 60) {
            return 9;
        } else if (percentageCorrect >= 50) {
            return 8;
        } else if (percentageCorrect >= 40) {
            return 7;
        } else if (percentageCorrect >= 30) {
            return 6;
        } else if (percentageCorrect >= 20) {
            return 5;
        } else if (percentageCorrect >= 10) {
            return 4;
        } else {
            return 3;
        }
    }
}