package Bowling.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Member {

    public String name ;
    public String account ;
    public String password ;
    public String phoneNum ;
    public String site ;
    
    private List<Integer> scores = new ArrayList<Integer>();
    private int allScore;
    private List<Integer> grades=new ArrayList<>();

    public Player(String name, String account, String password, String phoneNum, String site) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.phoneNum = phoneNum;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public int getAllScore() {
        return allScore;
    }

    /**
     * 计算总分数
     */
    public void calAllScores(){
        for(int i:scores) allScore += i;
    }

    /**
     * 计算每一格的分数
     */
    public void calScores() {
        Integer[] num = grades.toArray(new Integer[100]);
        int a = 0;
        for (int i = 0; i < 10; i++) {
          if(num[a]==10) scores.add(num[a]+num[a+1]+num[a+2]);
          else if(num[a]+num[a+1]>=10) scores.add(num[a]+num[++a]+num[a+1]);
          else scores.add(num[a]+num[++a]);
          a++;
        }
    }

    /**
     * 模拟比赛
     */
    public void play(){
        int grade1,grade2 = 0;
        for(int i=0;i<10;i++){
            grade1 = ComeBowling(10);
            grades.add(grade1);
            if(grade1<10) {
                grade2=ComeBowling(10-grade1);
                grades.add(grade2);
            }
            if(i==9&&grade1+grade2>10) grades.add(ComeBowling(10));
        }
        calScores();
        calAllScores();
    }

    /**
     * 获取击球数
     * @param bottleNum
     * @return
     */
    public int ComeBowling(int bottleNum){
        Random random = new Random();
        return random.nextInt(bottleNum+1);
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", site='" + site + '\'' +
                ", scores=" + scores.toString()+
                ", allScore=" + allScore +
                '}';
    }
}
