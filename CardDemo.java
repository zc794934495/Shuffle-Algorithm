import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[] SUITS = {"♠", "♥", "♣", "♦"};
    // 买一副牌
    private static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                int rank = j;
                Card card = new Card();
                card.rank = rank;
                card.suit = suit;
                deck.add(card);
            }
        }
        return deck;
    }
    private static void swap(List<Card> deck,int i,int j) {
        Card t = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }
    //i从队尾开始和产生的随机下标交换位置，这样可以避免随机数重复
    public static void shuffle(List<Card> deck) {
        Random random = new Random((int) (System.currentTimeMillis() / 1000));
        for (int i = deck.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(deck, i, r);
        }
    }

    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println("刚买回来的牌:");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌:");
        System.out.println(deck); // 三个人，每个人轮流抓 5 张牌
        List<List<Card>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌:");
        System.out.println(deck);
        System.out.println("A 手中的牌:");
        System.out.println(hands.get(0));
        System.out.println("B 手中的牌:");
        System.out.println(hands.get(1));
        System.out.println("C 手中的牌:");
        System.out.println(hands.get(2));
    }
}
