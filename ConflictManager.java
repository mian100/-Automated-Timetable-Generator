import java.util.HashMap;

import java.util.Stack;

public class ConflictManager {

    // Hash Table for checking occupied slots
    private HashMap<String, String> occupiedSlots;

    // Stack for storing previous assignments
    private Stack<String> history;

    public ConflictManager() {
        occupiedSlots = new HashMap<>();
        history = new Stack<>();
    }

    // Check whether slot is already occupied
    public boolean hasConflict(String key) {
        return occupiedSlots.containsKey(key);
    }


    public void assignSlot(String key, String value) {
        occupiedSlots.put(key, value);
        history.push(value);
    }
    public String undoLastAssignment() {

        if (!history.isEmpty()) {
            return history.pop();
        }

        return null;
    }

    // Display all occupied slots
    public void displayConflicts() {

        System.out.println("\nOccupied Slots:");

        for (String key : occupiedSlots.keySet()) {
            System.out.println(key + " -> " + occupiedSlots.get(key));
        }
    }
}