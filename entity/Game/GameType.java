package Bowling.entity.Game;

public enum GameType {
    SINGLE("单人赛",1),
    DOUBLE("双人赛",2),
    TRIPLE("三人赛",3),
    QUINTUPLE("五人赛",5),
    ELITE("精英赛",1),
    VERSATILE("全能赛",1);

    private String name;
    private int num;

    GameType (String name,int num){
        this.name = name;
        this.num = num;
    }

    public String getName(){
        return name;
    }

    public int getNum(){
        return num;
    }
}
