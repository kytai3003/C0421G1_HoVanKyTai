package _08_Java_cleancode_refactoring.exercise;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static void similarPoint(int player1Score) {
        switch (player1Score) {
            case LOVE:
                System.out.println("Love-All");
                break;
            case FIFTEEN:
                System.out.println("Fifteen-All");
                break;
            case THIRTY:
                System.out.println("Thirty-All");
                break;
            case FORTY:
                System.out.println("Forty-All");
                break;
            default:
                System.out.println("Deuce");
                break;
        }
    }

    public static void getMatchResult(int scoreOne, int scoreTwo) {
        int minusResult = scoreOne - scoreTwo;
        if (minusResult > 1) {
            score = "Win for player 1";
        } else if (minusResult == 1) {
            score = "Advantage player 1";
        } else if (minusResult == -1) {
            score = "Advantage player 2";
        } else {
            score = "Win for player 2";
        }
    }

    public static void setMatchPoint(int scoreOne, int scoreTwo) {
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scoreOne;
            } else {
                score += "-";
                tempScore = scoreTwo;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }
    }


    public static String score = "";

    public static String getScore(String nameOne, String nameTwo, int scoreOne, int scoreTwo) {
        if (scoreOne == scoreTwo) {
            similarPoint(scoreOne);
        }
        if (scoreOne >= 4 || scoreTwo >= 4) {
            getMatchResult(scoreOne, scoreTwo);
        } else {
            setMatchPoint(scoreOne, scoreTwo);
        }
        return score;
    }
}