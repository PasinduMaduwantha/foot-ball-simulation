package main.java;

public class Player extends Person{
    private int numberOfGoals=0;
    private boolean withTheBall;
    private boolean gotPenalty;
    private float successRate;
    private int playerIndex;
    private String teamName;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean getIsPlayerInGoalArea() {
        //return randomly generate d boolean value
        return (Math.random() < 0.5);
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public boolean isWithTheBall() {
        return withTheBall;
    }

    public void setWithTheBall(boolean withTheBall) {
        this.withTheBall = withTheBall;
    }

    public boolean isGotPenalty() {
        return gotPenalty;
    }

    public void setGotPenalty(boolean gotPenalty) {
        this.gotPenalty = gotPenalty;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(float successRate) {
        this.successRate = successRate;
    }
}
