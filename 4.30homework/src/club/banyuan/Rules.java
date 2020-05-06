package club.banyuan;

public class Rules {
  static boolean returnFirstMenu;
  private static int surplusOfPlayer; //剩余玩家数

  public static int getSurplusOfPlayer() {
    return surplusOfPlayer;
  }

  public static void setSurplusOfPlayer(int surplus) {
    surplusOfPlayer = surplus;
  }

  static void printWinner(Player[] players) {
    // 输出获胜方
    for (Player player : players) {
      if (!player.isOut()) {
        System.out.println("获胜方是" + player.getRole() + player.getId());
      }
    }
  }

  static boolean isFinalWinner(Player[] players) {
    int winnerCount = 0;
    for (Player player : players) {
      if (!player.isOut()) {
        winnerCount++;
      }
    }
    return winnerCount == 1;
  }

  static boolean isDraw(String rlt) {
    return rlt.length() == 3 || rlt.length() == 1;
  }

  static void outPlayer(Player[] players, String rlt) { //输的玩家出局
    int winnerFinger = getWinnerFinger(rlt);
    for (Player player : players) {
      if (!player.isOut() && player.getFinger() != winnerFinger) {
        player.setOut(true);
        int count = getSurplusOfPlayer();
        setSurplusOfPlayer(count - 1);
        System.out.println(
            player.toString() + "输掉了");
      } else if (!player.isOut()) {
        System.out.println(
            player.toString() + "胜利");
      }
    }
  }

  static void showFingers(Player[] players) {
    System.out.printf("当前游戏%d人数猜拳\n",getSurplusOfPlayer());
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      player.showFinger();
    }
  }

  static String competeResult(Player[] players) {
    StringBuilder rlt = new StringBuilder();
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      String oneFinger = player.getFinger() + "";
      if (!rlt.toString().contains(oneFinger)) {
        rlt.append(oneFinger);
      }
    }
    return rlt.toString();
  }

  //  12 21 = 1
  //         13 31 = 3
  //         23 32 = 2
  private static int getWinnerFinger(String rlt) {
    if ("12".equals(rlt) || "21".equals(rlt)) {
      return 1;
    } else if ("13".equals(rlt) || "31".equals(rlt)) {
      return 3;
    } else {
      return 2;
    }
  }
}
