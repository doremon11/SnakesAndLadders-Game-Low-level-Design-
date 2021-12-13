import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey! Welcome to snakeandLadders game ");
        System.out.println("Enter No of players :");
        int n = sc.nextInt();
        Queue<Player> allPlayers = new LinkedList<>();
        Map<String,Integer> playersCurrPos = new HashMap<>();
        for(int i=1;i<=n;i++){
              System.out.println("enter Player Name : "+i);
              Player p1 = new  Player(sc.next(),i);
              String names=p1.getName();
              allPlayers.offer(p1);
              playersCurrPos.put(names,0);
        }
        System.out.println("Enter no of dices :");
        Dice dice = new Dice(sc.nextInt());
        System.out.println("Enter the Board Size");
        int a= sc.nextInt();
        List<SnakeandLadder> snakes = new ArrayList<>();
        System.out.println("Enter No of Snakes :");
        int ns = sc.nextInt();
        for(int i=0;i<ns;i++){
            SnakeandLadder ladder1 = new SnakeandLadder(sc.nextInt(),sc.nextInt());
            snakes.add(ladder1);
      }
      List<SnakeandLadder> ladders = new ArrayList<>();
      System.out.println("Enter No of Ladders :");
      int nl = sc.nextInt();
      for(int i=0;i<nl;i++){
          SnakeandLadder snake1 = new SnakeandLadder(sc.nextInt(),sc.nextInt());
          snakes.add(snake1);
    }
        Gameboard gb=new Gameboard(dice,allPlayers,snakes,ladders,playersCurrPos,a);
        gb.startGame();
        
    }
}
