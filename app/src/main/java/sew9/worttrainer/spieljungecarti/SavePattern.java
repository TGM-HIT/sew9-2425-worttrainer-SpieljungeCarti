package sew9.worttrainer.spieljungecarti;

import java.io.IOException;

/**
 * Dies ist ein Interface, das Methoden zum Speichern und Laden eines Trainer-Objekts definiert. 
*/


public interface SavePattern {
    void save(String fileName, Trainer trainer) throws IOException;
    Trainer load(String fileName) throws IOException;
}
