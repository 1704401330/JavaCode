package Bowling.DataBase;

import Bowling.entity.Member.Player;

import java.sql.Connection;
import java.util.List;

public class PlayerDaoImpl extends DBCconnection implements PlayerDao{
    //插入一个选手SQL
    private final String INSERT_PLAYER_SQL = "insert into player(pid,name) values(?,?)";

    //查询所有选手的SQL
    private final String SELECT_PLAYERS_SQL = "select pid,name from player";

    //查询某个选手的信息
    private final String SELECT_PLAYER_SQL = "select count(*) from player where pid=? and name=?";

    //删除一个选手的信息
    private final String DELETE_PLAYER_SQL = "delete from player where pid = ? and name =?";

    @Override
    public int insertPlayer(Player player) {
        return 0;
    }

    @Override
    public List<Player> findAllPlayer() {
        return null;
    }

    @Override
    public int deletePlayer(Player player) {
        return 0;
    }
}
