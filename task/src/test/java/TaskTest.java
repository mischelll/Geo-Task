import com.geowealth.task.Task;
import com.geowealth.task.WordsLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskTest {
    private WordsLoader wordsLoader;
    private Task task;

    @BeforeEach
    void setUp() {
        this.wordsLoader = mock(WordsLoader.class);
        this.task = new Task(wordsLoader);
    }

    @Test
    @DisplayName("Should verify that STARTLING is a valid 9-letter word")
    void testIf9LetterWordIsValid() throws URISyntaxException {
        var mockWords = new HashSet<>(Set.of(
                "STARTLING", "STARTING", "STARING", "STRING", "STING", "SING", "SIN", "IN", "I", "A"
        ));

        when(wordsLoader.loadAllWords()).thenReturn(mockWords);

        var validWords = task.findAllValid9LetterWords();
        assertTrue(validWords.contains("STARTLING"), "STARTLING should be a valid word");
    }
}
