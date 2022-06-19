import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private final String playerOneName;
    private final String playerTwoName;

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore(){

        StringBuilder stringBuilder = new StringBuilder();

        if (isTie()){
            stringBuilder.append(equalScores());
        }else if(playerFourPointsMore()){
            int scoreDifference = playerOnePoints - playerTwoPoints;
            stringBuilder.append(getAdeventage(scoreDifference));
        }else {
            stringBuilder.append(getScore(playerOnePoints)).append("-").append(getScore(playerTwoPoints));
        }

        return stringBuilder.toString();
    }

    public void wonPoint(String player) {
        if(player.equals(this.playerOneName)){
            playerOnePoints++;
        }
        if(player.equals(this.playerTwoName)){
            playerTwoPoints++;
        }
    }

    public String equalScores() {
        List<String> scores = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return scores.get(playerOnePoints);
    }

    public String getScore(int scorePlayer){
        List<String> scores = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return scores.get(scorePlayer);
    }

    public String getAdeventage(int scoreDifference){
        switch (scoreDifference){
            case 1:
                return "Advantage ".concat(playerOneName);
            case -1:
                return "Advantage ".concat(playerTwoName);
            default:
                return (scoreDifference >= 2)? "Win for ".concat(playerOneName) : "Win for ".concat(playerTwoName);
        }
    }

    public boolean playerFourPointsMore(){
        return playerOnePoints >= 4 || playerTwoPoints >= 4;
    }

    public boolean isTie(){
        return playerOnePoints == playerTwoPoints;
    }
}