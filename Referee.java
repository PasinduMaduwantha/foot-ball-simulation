package main.java;

public class Referee extends Person{
    public final float halftime = 45;
    public final float breakTime = 15;
    public final float extraTime = 15;
    public final int noOfPenalties = 5;

    private int half;
    //final values not updatable therefore they set as public

    //randomly generate toss random boolean
    public boolean toss() {
        return (Math.random() < 0.5);
    }

    public int winingTeam(ScoreBoard scoreBoard) {
        if(scoreBoard.getTeam01Score()>scoreBoard.getTeam02Score())
            return 1;   //wining team is who won the toss
        else if (scoreBoard.getTeam01Score()==scoreBoard.getTeam02Score())
            return 0;   //score is equal
        else
            return 2;   //wining team is who loss the toss
    }
}
