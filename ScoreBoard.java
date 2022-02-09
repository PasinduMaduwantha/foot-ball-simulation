package main.java;

public class ScoreBoard {
    private String team01Name;
    private String team02Name;
    private int team01Score;
    private int team02Score;
    private String lastGoalBy;
    private String period;
    private float timeToEnd;
    //current status
    private String whoHasBall;
    private String teamHasBall;
    private String whoReceiveBall;
    private String teamReceiveBall;
    private boolean isOutSide=false;
    private boolean isStoppedByGoalie=false;
    private boolean isStoppedByDefense=false;

    public void printTheScoreBoard(){
        System.out.printf("%-30.30s  %-30.30s%n", team01Name, team02Name);
        System.out.printf("%-30.30s  %-30.30s%n", team01Score, team02Score);
        System.out.println("Last Goal By: " + lastGoalBy);
        System.out.println("Period: " + period);
        System.out.println("Time to End: " + timeToEnd);
        System.out.println(whoHasBall+" Has The Ball");
        System.out.println(teamHasBall+" has Ball");
        System.out.println(whoReceiveBall+" received Ball" );
        System.out.println(teamReceiveBall+" Team received Ball");
        if (isOutSide)
            System.out.println("Ball is out side from the field ");
        if (isStoppedByGoalie)
            System.out.println("Ball is stopped by goalie");
        if (isStoppedByDefense)
            System.out.println("Ball is stopped by defense\n\n");
    }

    public String getTeam01Name() {
        return team01Name;
    }

    public void setTeam01Name(String team01Name) {
        this.team01Name = team01Name;
    }

    public String getTeam02Name() {
        return team02Name;
    }

    public void setTeam02Name(String team02Name) {
        this.team02Name = team02Name;
    }

    public int getTeam01Score() {
        return team01Score;
    }

    public void setTeam01Score(int team01Score) {
        this.team01Score = team01Score;
    }

    public int getTeam02Score() {
        return team02Score;
    }

    public void setTeam02Score(int team02Score) {
        this.team02Score = team02Score;
    }

    public String getLastGoalBy() {
        return lastGoalBy;
    }

    public void setLastGoalBy(String lastGoalBy) {
        this.lastGoalBy = lastGoalBy;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public float getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(float timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    public String getWhoHasBall() {
        return whoHasBall;
    }

    public void setWhoHasBall(String whoHasBall) {
        this.whoHasBall = whoHasBall;
    }

    public String getTeamHasBall() {
        return teamHasBall;
    }

    public void setTeamHasBall(String teamHasBall) {
        this.teamHasBall = teamHasBall;
    }

    public String getWhoReceiveBall() {
        return whoReceiveBall;
    }

    public void setWhoReceiveBall(String whoReceiveBall) {
        this.whoReceiveBall = whoReceiveBall;
    }

    public String getTeamReceiveBall() {
        return teamReceiveBall;
    }

    public void setTeamReceiveBall(String teamReceiveBall) {
        this.teamReceiveBall = teamReceiveBall;
    }

    public boolean isOutSide() {
        return isOutSide;
    }

    public void setOutSide(boolean outSide) {
        isOutSide = outSide;
    }

    public boolean isStoppedByGoalie() {
        return isStoppedByGoalie;
    }

    public void setStoppedByGoalie(boolean stoppedByGoalie) {
        isStoppedByGoalie = stoppedByGoalie;
    }

    public boolean isStoppedByDefense() {
        return isStoppedByDefense;
    }

    public void setStoppedByDefense(boolean stoppedByDefense) {
        isStoppedByDefense = stoppedByDefense;
    }
}
