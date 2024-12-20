package sew9.worttrainer.spieljungecarti;

/**
 * Diese Klasse verwaltet eine Liste von Pic-Objekten und hält den aktuellen Stand der Trainingseinheit. 
 * Sie bietet Methoden zum Auswählen eines zufälligen Bildes, Überprüfen der Benutzereingabe und Abrufen
 * der Statistik.
 */

import java.util.List;
import java.util.Random;
public class Trainer {

    private List<Pic> list;
    private Pic current;
    private int right;
    private int amount;

    public Trainer(List<Pic> list) {
        this.list = list;
        this.right = 0;
        this.amount = 0;
    }

    public void select() throws IllegalArgumentException{
        Random random = new Random();
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        current = list.get(random.nextInt(list.size()));
    }

    public void select(int index) throws IllegalArgumentException {
        if ( index > list.size() || list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        current = list.get(index);
    }

    public boolean check(String answer) {
        if (answer == null) {
            throw new NullPointerException();
        }
        else {
            amount++;
            if (current.getName().toLowerCase().equals(answer.toLowerCase())) {
                right++;
                return true;
            }   
            return false;
        }
    }

    public String stats() {
        return (right+ "/" +amount);
    }

    public List<Pic> getList() {
        return list;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Pic getCurrent() {
        return current;
    }
}
