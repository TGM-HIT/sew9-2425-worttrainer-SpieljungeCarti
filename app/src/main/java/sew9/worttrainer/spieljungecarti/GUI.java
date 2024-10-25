package sew9.worttrainer.spieljungecarti;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI {
    public static void main(String[] args) {
        Trainer trainer = loadTrainer();

        while (true) {
            trainer.select();
            Pic currentPic = trainer.getCurrent();
            ImageIcon icon = null;
            Image i = null;
            try {
                URL u = new URL(currentPic.getUrl());
                icon = new ImageIcon(u);
                i = icon.getImage();
                icon = new ImageIcon(i.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes", "Fehler", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            String message = "Statistik: " + trainer.stats();
            String answer = JOptionPane.showInputDialog(null, message, "Worttrainer", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();

            if (answer == null || answer.trim().isEmpty()) {
                break;
            }

            boolean correct = trainer.check(answer);
            String feedback = correct ? "Richtig!" : "Falsch!";
            JOptionPane.showMessageDialog(null, feedback, "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
        }

        saveTrainer(trainer);
    }

    public static Trainer loadTrainer() {
        try {
            SaLo s = new SaLo();
            return s.load("trainer_data.txt");
        } catch (IOException e) {
            List<Pic> defaultPics = new ArrayList<>();
            defaultPics.add(new Pic("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwyXeKDN29AmZgZPLS7n0Bepe8QmVappBwZCeA3XWEbWNdiDFB", "Hund"));
            defaultPics.add(new Pic("https://image.geo.de/34423086/t/u8/v1/w1440/r0/-/katze-as-97589769.jpg", "Katze"));
            return new Trainer(defaultPics);
        }
    }

    public static void saveTrainer(Trainer trainer) {
        try {
            SaLo s = new SaLo();
            s.save("trainer_data.txt", trainer);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Daten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
}