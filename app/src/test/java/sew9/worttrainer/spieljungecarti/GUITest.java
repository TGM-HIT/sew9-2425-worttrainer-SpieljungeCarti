package sew9.worttrainer.spieljungecarti;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class GUITest {
    @Test
    public void testLoadTrainer() {
        Trainer trainer = GUI.loadTrainer();
        assertNotNull(trainer);
    }

    @Test
    public void testSaveTrainer() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        GUI.saveTrainer(trainer);
        // No exception means success
    }
}
