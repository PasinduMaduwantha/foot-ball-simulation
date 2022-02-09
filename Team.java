package main.java;

import java.util.Vector;

public class Team {
    Exception e=new Exception();

    private String teamName;
    private int score=0;
    //get the team's score
    public int getScore() {
        return score;
    }
    //set the team's score
    public void setScore(int score) {
        this.score = score;
    }

    private Vector<Person> team = new Vector<>();

    public Vector<Person> getTeam() {
        return team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setTeam(int nuOfPlayers) throws Exception {
        if (nuOfPlayers>=11 && nuOfPlayers<=18) {
            //assume player01 is the captain and player02 is the goalkeeper
            for (int i = 0; i < nuOfPlayers; i++) {
                //auto generate the player's name
                String name = "Player " + (i + 1)+" Of "+teamName;
                //generate the object of the player
                Player player = new Player();
                //set the player's name
                player.setName(name);
                //set the player's number
                player.setPlayerIndex(i + 1);
                //set the player's success rate
                player.setSuccessRate((float) (Math.random() * 100));
                //set the player's team
                player.setTeamName(teamName);
                //set the player's position
                if (i==0)
                    player.setPosition("Captain");
                else if (i==1)
                    player.setPosition("Goalie");
                else
                    player.setPosition("Player");
                //add the player to the team
                team.add(player);
            }
            //auto generate the coach's name
            String name = "Coach Of the "+teamName;
            //generate the object of the coach
            Coach coach = new Coach();
            //set the coach's name
            coach.setName(name);
            //set the coach's position
            coach.setPosition("Coach");
            //add the coach to the team
            team.add(coach);

            //auto generate the doctor's name
            String name1 = "Doctor Of "+teamName;
            //generate the object of the doctor
            Doctor doctor = new Doctor();
            //set the doctor's name
            doctor.setName(name1);
            //set the doctor's position
            doctor.setPosition("Doctor");
            //add the doctor to the team
            team.add(doctor);
        }
        //when players are not in range throw an exception
        else
            throw e;
    }
}
