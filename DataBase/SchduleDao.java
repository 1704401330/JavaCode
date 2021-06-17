package Bowling.DataBase;

import Bowling.entity.Member.Player;

import java.util.List;

public interface SchduleDao {
    /**
     *根据比赛id查询参赛选手id
     * @param game_id
     * @return
     */
    List<Player> SearchByPlyerID(String game_id);

}
