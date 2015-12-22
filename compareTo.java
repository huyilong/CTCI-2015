import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player {
    private int position;
    private int rating;
    private final String name;

    Player(int position, int rating, String name) {
        this.position = position;
        this.rating = rating;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public int getPos() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s:%d:%d", name, position, rating);
    }
}

class PlayerComparatorByRating implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getRating() - o2.getRating();
    }
}

class PlayerComparatorByName implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class PlayerComparatorDemo {
    public static void main(String[] args){
        List<Player> list = new ArrayList<Player>();

        Player p1 = new Player(1, 92, "Zlatan");
        Player p2 = new Player(2, 92, "Hazard");
        Player p3 = new Player(1, 82, "Klose");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collections.sort(list, new PlayerComparatorByRating());
        System.out.println(list);
        Collections.sort(list, new PlayerComparatorByName());
        System.out.println(list);
    }
}