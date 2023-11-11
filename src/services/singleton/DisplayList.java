package services.singleton;

import java.util.List;

public class DisplayList {
    private static DisplayList instance;

    public static DisplayList getInstance() {
        if (instance == null) {
            instance = new DisplayList();
        }
        return instance;
    }

    private DisplayList() {
    }

    public void displayList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).toString());
        }
    }
}
