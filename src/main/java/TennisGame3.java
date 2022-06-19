
public class TennisGame3 implements TennisGame {

    private int playerTwoPoints;
    private int playerOnePoints;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.playerOneName = namePlayer1;
        this.playerTwoName = namePlayer2;
    }

    public String getScore() {
        if (movePointsPlayers()) {
            return scorePlayers();
        } else {
            if (equalsPointsPlayers(playerOnePoints, playerTwoPoints))
                return "Deuce";
            return advantageOrWinnerPlayer();
        }
    }

    private boolean equalsPointsPlayers(int pointPlayer1, int pointPlayer2) {
        return pointPlayer1 == pointPlayer2;
    }

    private String advantageOrWinnerPlayer() {
        return (equalsPointsPlayers((playerOnePoints - playerTwoPoints)*(playerOnePoints - playerTwoPoints), 1)) ? advantagePlayer() : winnerPlayer();
    }

    private String winnerPlayer() {
        return "Win for " + namepPlayerWinnerOAdvantage();
    }

    private String advantagePlayer() {
        return "Advantage " + namepPlayerWinnerOAdvantage();
    }

    private String namepPlayerWinnerOAdvantage() {
        return playerOnePoints > playerTwoPoints ? playerOneName : playerTwoName;
    }

    private String scorePlayers() {
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (playerOnePoints == playerTwoPoints) ?  p[playerOnePoints] + "-All" :  p[playerOnePoints] + "-" + p[playerTwoPoints];
    }

    private boolean movePointsPlayers() {
        return limitMovePoints() && !(playerOnePoints + playerTwoPoints == 6);
    }

    private boolean limitMovePoints() {
        return playerOnePoints < 4 && playerTwoPoints < 4;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.playerOneName))
            this.playerOnePoints += 1;
        else
            this.playerTwoPoints += 1;

    }

}
