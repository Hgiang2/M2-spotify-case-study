package menu.features.registerArtist;

import entity.Request;
import entity.RequestArtistRegistered;
import entity.RequestList;
import menu.features.Command;
import menu.template.NavigateArtistRegisterDone;
import menu.template.Navigator;
import services.observer.Observer;
import services.observer.Subject;

public class CommandNewRegisterArtistRequest extends Subject implements Command {
    private String stageName;

    public CommandNewRegisterArtistRequest(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public void execute() {
        Observer observeRequest = RequestList.getInstance();
        addObserver(observeRequest);
        Request requestArtistRegister = new RequestArtistRegistered(stageName);
        RequestList.getInstance().add(requestArtistRegister);
        notifyObserver();
        removeAll();
        Navigator navigator = new NavigateArtistRegisterDone(requestArtistRegister);
        navigator.navigate();
    }
}
