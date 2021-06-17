package Bowling.DataBase;

import Bowling.entity.Member.Player;

import java.util.List;

public interface PlayerDao {



    /**
     * 登记参赛选手信息
     * @param player 选手信息类
     */
    int insertPlayer(Player player);

    /**
     *查询所有参赛选手
     * @return 查询到的所有选手
     */
    List<Player> findAllPlayer();

    /**
     * 删除指定选手的信息
     * @param player 选手的信息
     * @return
     */
    int  deletePlayer(Player player);

}
