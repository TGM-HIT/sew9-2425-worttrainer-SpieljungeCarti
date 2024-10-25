package sew9.worttrainer.spieljungecarti;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


public class SaLoTest {

    @Test
    public void testSaveAndLoad() throws IOException {
        SaLo saLo = new SaLo();
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        saLo.save("test_trainer_data.txt", trainer);

        Trainer loadedTrainer = saLo.load("test_trainer_data.txt");
        assertNotNull(loadedTrainer);
        assertEquals(1, loadedTrainer.getList().size());

        // Clean up
        new File("test_trainer_data.txt").delete();
    }
}
