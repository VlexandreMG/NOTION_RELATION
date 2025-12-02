package UTILS;

import java.util.ArrayList;
import java.util.List;

public class StringView {

    public static List<String> parseConditions (String cdt) {
        
        List<String> conditions = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int parenCount = 0;

        for (int i = 0; i < cdt.length(); i++) {
            char c = cdt.charAt(i);

            if (c == '(') {
                if (parenCount == 0 && current.length() > 0) {
                    // Ajouter la condition avant la parenthèse
                    conditions.add(current.toString().trim());
                    current.setLength(0);
                }
                parenCount++;
                current.append(c);
            } else if (c == ')') {
                parenCount--;
                current.append(c);
                if (parenCount == 0) {
                    // Condition entre parenthèses complète
                    conditions.add(current.toString().trim());
                    current.setLength(0);
                }
            } else if (c == '&' && cdt.length() > i + 1 && cdt.charAt(i + 1) == '&' && parenCount == 0) {
                // Opérateur AND
                if (current.length() > 0) {
                    conditions.add(current.toString().trim());
                    current.setLength(0);
                }
                conditions.add("&&");
                i++; // Saute le deuxième '&'
            } else if (c == '|' && cdt.length() > i + 1 && cdt.charAt(i + 1) == '|' && parenCount == 0) {
                // Opérateur OR
                if (current.length() > 0) {
                    conditions.add(current.toString().trim());
                    current.setLength(0);
                }
                conditions.add("||");
                i++; // Saute le deuxième '|'
            } else {
                current.append(c);
            }
        }

        // Ajouter la dernière condition
        if (current.length() > 0) {
            conditions.add(current.toString().trim());
        }

        return conditions;
    }
}
