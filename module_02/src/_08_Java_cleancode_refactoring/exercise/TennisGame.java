package _08_Java_cleancode_refactoring.exercise;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore;
        if (player1Score == player2Score) {
            switch (player1Score) {
                case LOVE:
                    score = "Love-All";
                    break;
                case FIFTEEN:
                    score = "Fifteen-All";
                    break;
                case THIRTY:
                    score = "Thirty-All";
                    break;
                case FORTY:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            boolean isAdvantageForPlayer1 = minusResult == 1;
            if (isAdvantageForPlayer1) {
                score = "Advantage for " + player1Name;
            }
            else {
                boolean isAdvantageForPlayer2 = minusResult == -1;
                if (isAdvantageForPlayer2) {
                    score = "Advantage player2";
                } else {
                    boolean isWinForPlayer1 = minusResult >= 2;
                    if (isWinForPlayer1) {
                        score = "Win for " + player1Name;
                    } else {
                        score = "Win for " + player2Name;
                    }
                }
            }
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = player1Score;
                    else {
                        score += "-";
                        tempScore = player2Score;
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
            return score;
        }
    }
