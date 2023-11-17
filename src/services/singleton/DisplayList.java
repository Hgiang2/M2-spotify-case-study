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
            System.out.println(i + ". " + list.get(i).toString());
        }
    }

//    public void displayTwoLists(List<?> list1, List<?> list2) {
//        for (int i = 0; i < list1.size() + list2.size(); i++) {
//            if (i > list1.size()) {
//                for (int j = 0; j < list2.size(); j++) {
//                    System.out.println(i + 1 + ". " + list2.get(j).toString());
//                }
//            }
//            System.out.println(i + 1 + ". " + list1.get(i).toString());
//        }
//    }
}
