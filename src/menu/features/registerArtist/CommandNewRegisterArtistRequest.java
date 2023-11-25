package menu.features.registerArtist;

import entity.Email;
import entity.Request;
import entity.RequestArtistRegistered;
import entity.RequestList;
import menu.template.Command;
import menu.template.NavigateArtistRegisterDone;
import menu.template.NavigateConfirmStageName;
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
        Request requestArtistRegister = new RequestArtistRegistered(stageName);
        RequestList.getInstance().add(requestArtistRegister);
        Email.getInstance().addEmailRequest(requestArtistRegister);
        Navigator navigator = new NavigateArtistRegisterDone();
        navigator.navigate();
    }
}
