package sew9.worttrainer.spieljungecarti;

import java.util.List;
import java.util.Random;
public class Trainer {

    private List<Pic> list;
    private Pic current;
    private Random random;
    private int right;
    private int amount;

    public Trainer(List<Pic> list) {
        this.list = list;
        this.random = new Random();
    }

    public void select() throws IllegalArgumentException{
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int index = random.nextInt(list.size());
        current = list.get(index);
    }

    public void select(int index) throws IllegalArgumentException {
        if ( index > list.size() || list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        current = list.get(index);
    }

    public boolean check(String answer) {
        amount++;
        if (current.getName().toLowerCase() == answer.toLowerCase()) {
            right++;
            return true;
        }
        return false;
    }

    public String stats() {
        return (right+ "/" +amount);
    }
}
