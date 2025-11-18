package WORK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoupleDeletor {
    
    public static Object[][] f_deletor(Object[][] individus) {

        List<Object[]> new_tab = new ArrayList<>();

        for (int i = 0; i < individus.length; i++) {
            boolean found = false;
            for (int j = 0; j < new_tab.size(); j++) {
                if (Arrays.equals(individus[i], new_tab.get(j))) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                new_tab.add(individus[i]);
            }
        }

        return new_tab.toArray(new Object[0][]);
    }
}
