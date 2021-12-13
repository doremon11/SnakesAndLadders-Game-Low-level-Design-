public class Dice {
    private int noofdices;
    Dice(int noofdices){
        this.noofdices=noofdices;
    }
    public int getnoofdices(){
        return noofdices;
    }
    int RollDice(){
        return ((int) (Math.random()*(6*noofdices - 1*noofdices))) + 1;
    }
}
