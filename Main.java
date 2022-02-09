/*
 * DATE       : 09-11-2021
 * COURSE     : PROGRAMMING QUEST (CO2210)
 * TITLE      : QUEST 07- FOOTBALL GAME SIMULATOR
 * AUTHOR     : MADHUWANTHA A.P.
 * INDEX NO   : 19/ENG/121
 */
package main.java;
import java.util.Vector;

public class Main {

    public static void main(String[] args)  {
        //randomly generate the no of players in each team
        int noOfPlayers=  (int) (Math.random() * (18 - 12)) + 12;
        Team team1=new Team();
        team1.setTeamName("Team01");
        //SETTING TEAM 1
        try {
            //randomly generate the no of team members
            team1.setTeam(noOfPlayers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //SETTING TEAM 2
        Team team2=new Team();
        team2.setTeamName("Team02");
        try {
            team2.setTeam(noOfPlayers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //getting the team vectors
        Vector<Person> team01Vector=team1.getTeam();
        Vector<Person> team02Vector=team2.getTeam();


        System.out.println("name\t\t\t\t\t\tposition\t\t\tTeam Name");
        for (int i=0;i<team01Vector.size();i++) {

            System.out.print(team01Vector.get(i).getName());
            System.out.print("\t\t\t");
            System.out.print(team01Vector.get(i).getPosition());
            System.out.print("\t\t\t\t");
            System.out.println(team1.getTeamName());

        }
        System.out.println("\nname\t\t\t\t\t\tposition\t\t\tTeam Name");
        for (int i=0;i<team02Vector.size();i++) {
            System.out.print(team02Vector.get(i).getName());
            System.out.print("\t\t\t");
            System.out.print(team02Vector.get(i).getPosition());
            System.out.print("\t\t\t\t");
            System.out.println(team2.getTeamName());
        }
        //sleep for 2 seconds
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //assume that the team leader starts the game
        //randomly generate a number between 0 and 100
        //randomly set the attempt

        /*if attempt
         * 0-1 goal attempt
         * 2-5 go pass the ball attempt
         * 6-8 go forward attempt
         * 9-10 out of field attempt
         *
         * if player inside the goal area when the success rate is greater than 1 times goalie's success rate
         * if player outside the goal area when the success rate is greater than 2 times goalie's success rate
         * if average success rate of both who pass and receive the ball is greater than 60% then the ball passing is successful
         * otherwise the ball passing is unsuccessful, other team gets the ball
         * if the success rate is greater than 60% then player can success pass the ball forward with himself
         */
        Referee ref=new Referee();
        ScoreBoard scoreBoard = new ScoreBoard();
        if (ref.toss()) {
            //team1 wins the toss
            System.out.println(team1.getTeamName()+" won the toss and will start the game\n");
            scoreBoard.setTeam01Name(team1.getTeamName());
            scoreBoard.setTeam02Name(team2.getTeamName());
            scoreBoard=playTheGame(team1, team2, scoreBoard, 90);
        } else {
            //team2 wins the toss
            System.out.println(team2.getTeamName()+" won the toss and will start the game\n");
            scoreBoard.setTeam01Name(team2.getTeamName());
            scoreBoard.setTeam02Name(team1.getTeamName());
            scoreBoard=playTheGame(team2, team1, scoreBoard, 90);
        }
        int score=ref.winingTeam(scoreBoard);
        if (score==1) {
            System.out.println(scoreBoard.getTeam01Name()+" won the game");
        }
        else if (score==2) {
            System.out.println(scoreBoard.getTeam02Name()+" won the game");
        }
        else if (score==0) {
            System.out.println("Scores are equal"); //then play another 15 minutes
            scoreBoard=playTheGame(team2, team1,scoreBoard, 15);
            if (score==1) {
                System.out.println(scoreBoard.getTeam01Name()+" won the game");
            }
            else if (score==2) {
                System.out.println(scoreBoard.getTeam02Name()+" won the game");
            }else if (score==0) {
                System.out.println("give 5 penalties for each team"); //then give 5 penalties for each team
                scoreBoard=playPenalties(team1, team2, scoreBoard, 0);
                score=ref.winingTeam(scoreBoard);
                if (score==1) {
                    System.out.println(scoreBoard.getTeam01Name()+" won the game");
                }else if (score==2) {
                    System.out.println(scoreBoard.getTeam02Name()+" won the game");
                }
            }

        }
    }

    public static ScoreBoard playPenalties(Team team01, Team team02, ScoreBoard scoreBoard, int time) {
        Vector<Person> team01Vector = team01.getTeam();    //team who won the toss set as team1
        Vector<Person> team02Vector = team02.getTeam();   //team who lost the toss set as team2

        Player penaltyTaker=null; //player who will play the penalty
        Player team01Goalie=(Player) team01Vector.get(1); //team1's goalie
        Player team02Goalie=(Player) team02Vector.get(1); //team2's goalie

        for (int i=0; i<5;i++){
            int playerIdx=(int) (Math.random() * (11 - 1)) + 1;
            penaltyTaker=(Player) team01Vector.get(playerIdx);
            if (penaltyTaker.getSuccessRate() >= team02Goalie.getSuccessRate()) {
                System.out.println("Goal is successful");
                penaltyTaker.setNumberOfGoals(penaltyTaker.getNumberOfGoals() + 1);
                team01.setScore(team01.getScore() + 1);
                scoreBoard.setTeam01Score(team01.getScore());
                scoreBoard.setLastGoalBy(penaltyTaker.getName());
            } else {
                System.out.println("Goal is unsuccessful, Goal is prevented by the goalie");
                scoreBoard.setStoppedByGoalie(true);
            }
        }
        for (int i=0; i<5;i++){
            int playerIdx=(int) (Math.random() * (11 - 1)) + 1;
            penaltyTaker=(Player) team02Vector.get(playerIdx);
            if (penaltyTaker.getSuccessRate() >= team02Goalie.getSuccessRate()) {
                System.out.println("Goal is successful");
                penaltyTaker.setNumberOfGoals(penaltyTaker.getNumberOfGoals() + 1);
                team01.setScore(team01.getScore() + 1);
                scoreBoard.setTeam01Score(team01.getScore());
                scoreBoard.setLastGoalBy(penaltyTaker.getName());
            } else {
                System.out.println("Goal is unsuccessful, Goal is prevented by the goalie");
                scoreBoard.setStoppedByGoalie(true);
            }
        }
        return scoreBoard;
    }

    public static ScoreBoard playTheGame(Team teamWhoWonTheToss, Team teamWhoLossTheToss, ScoreBoard scoreBoard, int time) {
        //i= iteration number
        int playerIdx = 0;
        boolean wonTheBall = true;   //set a flag to check if the ball is won or not
        //true = the ball is within team who won the toss
        //false = the ball is outside team who loss the toss
        //getting the team vectors
        Vector<Person> team01Vector = teamWhoWonTheToss.getTeam();    //team who won the toss set as team1
        Vector<Person> team02Vector = teamWhoLossTheToss.getTeam();   //team who lost the toss set as team2

        for (int i=0; i < time; i++) {
            scoreBoard.setOutSide(false);
            scoreBoard.setStoppedByGoalie(false);
            scoreBoard.setStoppedByDefense(false);

            Player player=null;
            Player goalie=null;
            Player oppositePlayerObject=null;
            int oppositePlayer=0;
            if(wonTheBall){
                //if the ball is won by team1
                player = (Player) team01Vector.get(playerIdx);
                scoreBoard.setTeamHasBall(teamWhoWonTheToss.getTeamName());
                goalie = (Player) team02Vector.get(1);
                oppositePlayer = (int) (Math.random() * (11 - 1)) + 1;
                oppositePlayerObject = (Player) team02Vector.get(oppositePlayer);
                scoreBoard.setTeamReceiveBall(teamWhoWonTheToss.getTeamName());
            }
            else {
                //a player of opposite team gets the ball
                player = (Player) team02Vector.get(playerIdx);
                scoreBoard.setTeamHasBall(teamWhoLossTheToss.getTeamName());
                goalie = (Player) team01Vector.get(1);
                oppositePlayer = (int) (Math.random() * (11 - 1)) + 1;
                oppositePlayerObject = (Player) team01Vector.get(oppositePlayer);
                scoreBoard.setTeamReceiveBall(teamWhoLossTheToss.getTeamName());
            }
            player.setWithTheBall(true);
            scoreBoard.setWhoHasBall(player.getName());


            //randomly generate the attempts
            int setAttempt = (int) (Math.random() * 10);
            //pass the ball to nearest player, in this case the nearest player is the player generate randomly
            int nearestPlayer = (int) (Math.random() * (11 - 1)) + 1;
            Player nearestPlayerObject = (Player) team01Vector.get(nearestPlayer);


            if (setAttempt >= 0 && setAttempt <= 1) {
//                System.out.println(player.getName() + "(" + player.getPosition() + ")" + " is trying a goal");
                if (player.getIsPlayerInGoalArea())
                    if (player.getSuccessRate() >= goalie.getSuccessRate()) {
//                        System.out.println("Goal is successful");
                        player.setNumberOfGoals(player.getNumberOfGoals() + 1);

                        if(wonTheBall) {
                            teamWhoWonTheToss.setScore(teamWhoWonTheToss.getScore() + 1);
                            scoreBoard.setTeam01Score(teamWhoWonTheToss.getScore());
                        }
                        else {
                            teamWhoLossTheToss.setScore(teamWhoLossTheToss.getScore() + 1);
                            scoreBoard.setTeam02Score(teamWhoLossTheToss.getScore());
                        }
                        scoreBoard.setLastGoalBy(player.getName());
                        wonTheBall = true;
                    } else {
//                        System.out.println("Goal is unsuccessful, Goal is prevented by the goalie");
                        playerIdx = oppositePlayer;
                        scoreBoard.setStoppedByGoalie(true);
                        wonTheBall = false;
                    }
                else {
                    if (player.getSuccessRate() >= goalie.getSuccessRate() * 2) {
//                        System.out.println("Goal is successful");
                        wonTheBall=true;
                    } else {
//                        System.out.println("Goal is unsuccessful, Goal is prevented by the goalie");
                        scoreBoard.setStoppedByGoalie(true);
                        playerIdx = oppositePlayer;
                        wonTheBall = false;
                    }
                }
            } else if (setAttempt >= 2 && setAttempt <= 5) {
//                System.out.println(player.getName() + " is trying a forward the ball with himself");
                if ((player.getSuccessRate() + nearestPlayerObject.getSuccessRate()) / 2 >= 60) {
                    nearestPlayerObject.setWithTheBall(true);
//                    System.out.println("The ball is passed to " + nearestPlayerObject.getName());
                    playerIdx = nearestPlayer;    //pass the ball to the nearest player
                    scoreBoard.setWhoHasBall(player.getName());
                    scoreBoard.setWhoReceiveBall(nearestPlayerObject.getName());
                    wonTheBall=true;
                } else {
                    oppositePlayerObject.setWithTheBall(true);
//                    System.out.println("The ball is taken by " + oppositePlayerObject.getName());
                    playerIdx = oppositePlayer;    //take the ball from the opposite player
                    scoreBoard.setWhoHasBall(player.getName());
                    scoreBoard.setWhoReceiveBall(oppositePlayerObject.getName());
                    scoreBoard.setStoppedByDefense(true);
                    wonTheBall = false;
                }
            } else if (setAttempt >= 6 && setAttempt <= 8) {
//                System.out.println(player.getName() + " is trying a pass the ball");
                if (player.getSuccessRate() >= 60) {
                    player.setWithTheBall(true);
//                    System.out.println("The ball is passed with himself " + player.getName());
                    playerIdx = playerIdx;    //pass the ball to the same player
                    scoreBoard.setWhoHasBall(player.getName());
                    scoreBoard.setWhoReceiveBall(nearestPlayerObject.getName());
                    wonTheBall=true;
                } else {
                    oppositePlayerObject.setWithTheBall(true);
//                    System.out.println("The ball is taken by " + oppositePlayerObject.getName());
                    playerIdx = oppositePlayer;    //take the ball from the opposite player
                    scoreBoard.setWhoHasBall(player.getName());
                    scoreBoard.setWhoReceiveBall(oppositePlayerObject.getName());
                    scoreBoard.setStoppedByDefense(true);
                    wonTheBall = false;
                }
            } else if (setAttempt >= 9 && setAttempt <= 10) {
//                System.out.println(player.getName() + " is pass the ball out of field");
                playerIdx = oppositePlayer;    //chance goes to the opposite player
                scoreBoard.setOutSide(true);
                wonTheBall = false;
            }
            if (i<45)
                scoreBoard.setPeriod("1st Half");
            else if (i==45) {
                scoreBoard.setPeriod("Interval");
                //sleep(5000);
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
                scoreBoard.setPeriod("2nd Half");

            scoreBoard.setTimeToEnd(90 - i);
            scoreBoard.printTheScoreBoard();
            //sleep(1000);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            //clear the screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

        }
        return scoreBoard;
    }
}
