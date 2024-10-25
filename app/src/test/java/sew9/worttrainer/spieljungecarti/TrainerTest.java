package sew9.worttrainer.spieljungecarti;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TrainerTest {

    @Test
    public void testConstructorValid() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        assertNotNull(trainer.getList());
    }

    @Test
    public void testSelectValid() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.select();
        assertNotNull(trainer.getCurrent());
    }

    @Test
    public void testSelectEmptyList() {
        Trainer trainer = new Trainer(Arrays.asList());
        assertThrows(IllegalArgumentException.class, () -> {
            trainer.select();
        });
    }

    @Test
    public void testCheckCorrect() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.select(0);
        assertTrue(trainer.check("Example"));
    }

    @Test
    public void testCheckIncorrect() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.select(0);
        assertFalse(trainer.check("Wrong"));
    }

    @Test
    public void testStats() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.select(0);
        trainer.check("Example");
        assertEquals("1/1", trainer.stats());
    }

    @Test
    public void testGetList() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        assertNotNull(trainer.getList());
    }

    @Test
    public void testSetRightAndAmount() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.setRight(5);
        trainer.setAmount(10);
        assertEquals("5/10", trainer.stats());
    }

    @Test
    public void testGetCurrent() {
        Trainer trainer = new Trainer(Arrays.asList(new Pic("https://example.com", "Example")));
        trainer.select(0);
        assertNotNull(trainer.getCurrent());
    }
}