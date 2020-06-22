package Stream.Speed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DummyData {
    public static List<String> createDummyDataString(int size){
        List<String> values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }
}
