package org.example.dbreader;

import java.util.HashMap;
import java.util.Map;

public class BattleResultComparator {

    public static Map<String, Object> compareAndReturnWinner(Map<String, Object> first, Map<String, Object> second) {
        int firstPower = (int) first.getOrDefault("power", 0);
        int secondPower = (int) second.getOrDefault("power", 0);

        if (firstPower > secondPower) {
            return first;
        } else if (secondPower > firstPower) {
            return second;
        } else {
            // В случае равенства мощностей вернём оба результата
            Map<String, Object> tieResult = new HashMap<>();
            tieResult.putAll(first);
            tieResult.putAll(second);
            return tieResult;
        }
    }
}

