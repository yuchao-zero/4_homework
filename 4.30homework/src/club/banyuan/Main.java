package club.banyuan;

import java.util.Scanner;

public class Main {
  // TODO
  // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
  // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
  // 3. 用户猜拳界面，输入0，返回到上一级，重新开始选择参与人数
  // 4. 用户进入到猜拳界面，提示当前的人数的信息，例如"当前游戏3人猜拳"，每次猜拳下一轮开始时，显示本轮剩余玩家数量，
  public static void main(String[] args) {
    // 1. 如果用户随意输入内容，不满足条件的，提示用户重新输入
    // 2. 用户输入多少人参与猜拳（2~5人）提示，输入0退出程序
    while (true) {
      int playerCount = 0;
      while (true) {
        Rules.returnFirstMenu = false;
        try {
          System.out.println("用户输入多少人参与猜拳（2~5人），输入0退出程序");
          Scanner scanner = new Scanner(System.in);
          playerCount = scanner.nextInt();
          if (playerCount == 0) {
            return;
          } else if (playerCount < 2 || playerCount > 5) {
            System.out.println("输入不合法，请重新输入");
          } else {
            break;
          }
        } catch (Exception e) {
          //e.printStackTrace();
          System.out.println("输入不合法，请重新输入");
        }
      }

      Player[] players = Player.initPlayers(playerCount);
      Rules.setSurplusOfPlayer(players.length);
      //出拳程序
      while (true) {
        Rules.showFingers(players);

        if(Rules.returnFirstMenu){
          break; //跳出出拳界面
        }
        String rlt = Rules.competeResult(players);

        if (Rules.isDraw(rlt)) {
          continue;
        } else {
          Rules.outPlayer(players, rlt);
        }
        if (Rules.isFinalWinner(players)) {
          break;
        }
      }
      if(Rules.returnFirstMenu){ //退出内层循环，继续最外层循环
        continue;
      }
      Rules.printWinner(players);
      break;
    }
  }
}
