package menu.features.createPlaylist;

import menu.template.CommandInput;

import java.util.Scanner;

public class CommandInputPlaylistName implements CommandInput {
    private String description;
    private String playlistName;

    public CommandInputPlaylistName(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.println(description);
        Scanner SCANNER = new Scanner(System.in);
        playlistName = SCANNER.nextLine();
        System.out.println();
    }

    @Override
    public String getInput() {
        return playlistName;
    }
}
