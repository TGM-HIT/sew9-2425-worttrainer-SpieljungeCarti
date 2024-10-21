package sew9.worttrainer.spieljungecarti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save {
    
    public static void save(Trainer trainer, String fileName) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Speichern der Wort-Einträge
            for (Pic pic : trainer.getList()) {
                writer.write(pic.getName() + "," + pic.getUrl());
                writer.newLine();
            }
            // Speichern der Statistik
            writer.write("Versuche im Format richtig/versucheGesamt:" + trainer.stats());
        }
    }

    public static Trainer load(String fileName) throws IOException{
        int right = 0;
        int amount = 0;
        List<Pic> list = new ArrayList<Pic>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Versuche")) {
                    String line2 = line.substring("Versuche im Format richtig/versucheGesamt:".length());
                    String[] parts = line2.split("/");
                    right = Integer.parseInt(parts[0]);
                    amount = Integer.parseInt(parts[1]);
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String wort = parts[0];
                        String url = parts[1];
                        Pic pic = new Pic(url, wort);
                        list.add(pic);
                    }
                }
            }
        }

        Trainer trainer = new Trainer(list);
        trainer.setRight(right);
        trainer.setAmount(amount);
        return trainer;
    }
}
