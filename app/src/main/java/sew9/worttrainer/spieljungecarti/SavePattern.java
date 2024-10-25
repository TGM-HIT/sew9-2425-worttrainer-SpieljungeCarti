package sew9.worttrainer.spieljungecarti;

import java.io.IOException;

public interface SavePattern {
    void save(String fileName, Trainer trainer) throws IOException;
    Trainer load(String fileName) throws IOException;
}
