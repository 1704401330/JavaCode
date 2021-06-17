package Bowling.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    public String name ;
    public String account ;
    public String password ;
    public String phoneNum ;
    public String site ;
    private int allScore;
    private boolean flag = false;

    private List<Integer> scores = new ArrayList<Integer>();
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


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }


    public List<Integer> getScores() {
        return scores;
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
        Integer[] num = grades.toArray(new Integer[25]);
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
        if (!flag) {
            int grade1, grade2 = 0;
            for (int i = 0; i < 10; i++) {
                grade2 = 0;
                grade1 = ComeBowling(10);
                grades.add(grade1);
                if (grade1 < 10) {
                    grade2 = ComeBowling(10 - grade1);
                    grades.add(grade2);
                }
                if (i == 9 && grade1 + grade2 <= 10) grades.add(ComeBowling(10));
                if (i == 9 && grade1 == 10) grades.add(ComeBowling(10));
            }
            calScores();
            calAllScores();
            flag = true;
        }
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
        return "姓名：" + name + '\n' +
                "账号：" + account + '\n' +
                "密码：" + password + '\n' +
                "电话：" + phoneNum + '\n' +
                "地址：" + site + '\n';
    }

    public boolean getFlag() {
        return flag;
    }

}
