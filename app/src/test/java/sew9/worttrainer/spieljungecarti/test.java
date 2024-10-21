package sew9.worttrainer.spieljungecarti;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class test {

    // Testet ob die Methode viable() in Pic richtig funktioniert
    @Test
    public void trainerViable() {
        assertThrows(IllegalArgumentException.class, () -> new Pic(null,null));
        assertThrows(IllegalArgumentException.class, () -> new Pic("https://www.google.com", "google"));
    }

    // Der Test schlägt fehl, da die der Liste keinen Inhalt hat
    @Test
    public void trainerSelectErr() {
        List<Pic> l = new ArrayList<Pic>();
        Trainer t = new Trainer(l);
        assertThrows(IllegalArgumentException.class, () -> t.select());
    }

    // Der Test schlägt fehl, da der Index größer als die Liste ist
    @Test 
    public void trainerSelectIndexErr() throws IllegalArgumentException {
        List l = new ArrayList<Pic>();
        l.add(new Pic("https://www.google.com.png", "google"));
        Trainer t = new Trainer(l);
        assertThrows(IllegalArgumentException.class, () -> t.select(2));
    }

    // Testet die check Methode in Trainer 
    @Test
    public void trainerCheck() {
        List l = new ArrayList<Pic>();
        l.add(new Pic("https://www.google.com.png", "google"));
        Trainer t = new Trainer(l);
        t.select(0);
        assert(t.check("google") == true);
        assert(t.check("goo") == false);
    }

    // Testet ob die Statistik richtig angezeigt wird
    @Test
    public void trainerStats() {
        List l = new ArrayList<Pic>();
        l.add(new Pic("https://www.google.com.png", "google"));
        Trainer t = new Trainer(l);
        t.select(0);
        t.check("google");
        t.check("goo");
        assert(t.stats().equals("1/2"));
    }

}
