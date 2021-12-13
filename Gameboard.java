import java.util.List;
import java.util.Map;
import java.util.Queue;
public class Gameboard {
    public int boardSize;
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<SnakeandLadder> Snakes;
    private List<SnakeandLadder> Ladder;
    private Map<String,Integer > playerpos ;
    public Gameboard(Dice dice, Queue<Player> nextTurn,  List<SnakeandLadder> Ladder, List<SnakeandLadder> Snakes,Map<String,Integer>playerpos,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.Snakes = Snakes;
        this.Ladder = Ladder;
        this.playerpos = playerpos;
        this.boardSize = boardSize;
    }
    void startGame(){
        while(nextTurn.size()>1) {
            Player player = nextTurn.poll();
            int currentPosition = playerpos.get(player.getName());
            int diceValue = dice.RollDice();
            int nextCell = currentPosition + diceValue;
            if (nextCell > boardSize) nextTurn.offer(player);
            else if (nextCell == boardSize) {
                System.out.println( player.getName() + " won the game");
            }else{
               int[] nextPosition= new int[1];
               boolean[] b =new boolean[1];
                nextPosition[0]= nextCell;
               Snakes.forEach(v-> {
                   if(v.getStart()==nextCell) {
                       nextPosition[0] = v.getEnd();
                   } } );
               if(nextPosition[0] != nextCell) System.out.println(player.getName() + " Bitten by Snake present at: "+ nextCell);
                Ladder.forEach(v-> {
                    if(v.getStart()==nextCell) {
                        nextPosition[0] = v.getEnd();
                        b[0]=true;
                    } } );
                if(nextPosition[0] != nextCell && b[0]) System.out.println(player.getName() + " Got ladder present at: "+ nextCell);
                if(nextPosition[0] == boardSize){
                    System.out.println(player.getName() + " won the game");
                }else{
                    playerpos.put(player.getName(),nextPosition[0]);
                    System.out.println(player.getName() + " is at position "+ nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }

    
}
