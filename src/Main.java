import menu.template.NavigateMenuStart;
import menu.template.Navigator;
import services.observer.Subject;

public class Main extends Subject {
    public static void main(String[] args) {
        Navigator navigatorStart = new NavigateMenuStart();
        navigatorStart.navigate();
    }
}
