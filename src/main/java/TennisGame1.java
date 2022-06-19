
public class TennisGame1 implements TennisGame {

    private int mScoreOne = 0;
    private int mScoreTwo = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String player1Name, String player2Name) {
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            mScoreOne += 1;
        else
            mScoreTwo += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (mScoreOne == mScoreTwo)
        {
            switch (mScoreOne)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (mScoreOne >=4 || mScoreTwo >=4)
        {
            int minusResult = mScoreOne - mScoreTwo;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = mScoreOne;
                else { score+="-"; tempScore = mScoreTwo;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
