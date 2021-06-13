package Bowling.entity.Game;

import Bowling.entity.Member.Player;
import Bowling.entity.Member.Team;

import java.util.TreeSet;

public class DoubleGame implements Game{

    private TreeSet<Team> teams = new TreeSet<Team>();

    @Override
    public void play() {
        for(Team team:teams){
            Player[] players = team.getPlayers().toArray(new Player[team.getPlayerNum()]);
            for(Player player:players) player.play();
        }
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    public TreeSet<Team> getTeams() {
        return teams;
    }

    public void setTeams(TreeSet<Team> teams) {
        this.teams = teams;
    }
}
