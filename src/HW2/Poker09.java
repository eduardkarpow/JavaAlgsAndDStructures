package HW2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Poker09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int handNums = sc.nextInt();
        if(handNums > 9){
            handNums = 9;
        }
        Deque.initializeDeque();
        Hand[] hands = new Hand[handNums];
        for(int i = 0; i < handNums; i++){
            hands[i] = new Hand();
        }
        for(int i =0; i < handNums; i++){
            System.out.println("HW2.Hand "+(i+1)+": "+hands[i]);
        }
    }
}

class Hand{
    private Card[] hand = new Card[5];

    public Hand(){
        for(int i = 0; i < 5; i++){
            hand[i] = Deque.getRandomCard();
        }
    }
    public String toString(){
        String allert = this.hand[0].getTile() + " : " + this.hand[0].getName();
        for(int i = 1; i < 5; i++){
            allert += ", " + this.hand[i].getTile() + " : " + this.hand[i].getName();
        }
        return allert;
    }
}
abstract class Deque{
    private static ArrayList<Card> deque = new ArrayList<Card>();
    public static void initializeDeque(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 4; j++){
                Deque.deque.add(new Card(j,i));
            }
        }
    }
    public static Card getRandomCard(){
        Random rnd = new Random();
        int id = rnd.nextInt(Deque.deque.size());
        Card currCard = Deque.deque.get(id);
        Deque.removeElement(id);
        return currCard;
    }
    private static void removeElement(int id){
        Deque.deque.remove(id);
    }
}

class Card {
    private String tile, name;

    public Card(int tile, int name) {
        // setting name of the card
        if(name > 1 && name < 10){
            this.name = Integer.toString(name);
        }
        else{
            switch (name){
                case 0:
                    this.name = "A";
                    break;
                case 1:
                    this.name = "J";
                    break;
                case 10:
                    this.name = "Q";
                    break;
                case 11:
                    this.name = "K";
                    break;
            }
        }
        // setting tile of the card
        switch (tile){
            case 0:
                this.tile = "spades";
                break;
            case 1:
                this.tile = "hearts";
                break;
            case 2:
                this.tile = "diamonds";
                break;
            case 3:
                this.tile = "clubs";
                break;
        }
    }

    public String getTile() {
        return tile;
    }


    public String getName() {
        return name;
    }

}