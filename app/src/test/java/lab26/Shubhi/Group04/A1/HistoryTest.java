package lab26.Shubhi.Group04.A1;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HistoryTest {

    @Test
    void testToString() {
        History ts_history = new History();
        ts_history.setName("pizza");
        ts_history.setAmount(29);
        Date testDate = new Date();
        ts_history.setDate(testDate);
        assertEquals("Food{" +
                "name='" + ts_history.getName() + '\'' +
                ", amount=" + ts_history.getAmount() +
                ", date=" + ts_history.getDate() +
                '}', ts_history.toString());
    }

}

