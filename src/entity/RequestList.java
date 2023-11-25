package entity;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import services.observer.Observer;
import services.observer.Subject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RequestList implements Observer {
    private List<Request> allRequests;

    private static RequestList instance;

    private RequestList() {
        Type requestType = new TypeToken<List<Request>>() {
        }.getType();
        try {
            allRequests = (ArrayList<Request>) Constants.fileHandler.readFromFile(Constants.ALL_REQUESTS_FILE_PATH, requestType);
        } catch (Exception e) {
            allRequests = new ArrayList<>();
        }
    }

    public static RequestList getInstance() {
        if (instance == null) {
            instance = new RequestList();
        }
        return instance;
    }

    public List<Request> getList() {
        return allRequests;
    }

    public void add(Request request) {
        try {
            allRequests.add(request);
        } catch (NullPointerException e) {
            allRequests = new ArrayList<>();
            allRequests.add(request);
        }
        update();
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.ALL_REQUESTS_FILE_PATH, allRequests);
    }
}
