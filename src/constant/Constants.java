package constant;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateMenuMain;
import menu.menuCommand.NavigateMenuStart;
import menu.service.exitCommand.CommandBack;
import menu.service.exitCommand.CommandExit;
import services.JSON.FileHandler;
import services.comparator.SortPlaylistByDate;
import services.comparator.SortPlaylistByName;
import services.comparator.SortSongByDate;
import services.comparator.SortSongByName;
import services.comparator.SortStringByName;
import services.singleton.DisplayList;
import services.singleton.FormatDate;

import java.util.Scanner;

public interface Constants {
    FileHandler fileHandler = new FileHandler();
    Scanner SCANNER = new Scanner(System.in);
    DisplayList DISPLAY_LIST = DisplayList.getInstance();
    FormatDate FORMAT_DATE = FormatDate.getInstance();
    String ALL_SONG_FILE_PATH = "data/localSongs.json";
    String ALL_PLAYLIST_FILE_PATH = "data/playlist.json";
    String SPOTIFY_SONG_FILE_PATH = "data/spotifySongs.json";
    String VALID_USER_FILE_PATH = "data/validUsers.json";
    String DATE_FORMAT = "dd/MM/yyyy, HH:mm:ss";
    String EXIT = "Exit";
    String EXIT_DESCRIPTION = """
           Exiting...
           Completed!
           ------------------------
           Do you want to re-open Spotify?""";
    String BACK = "Back";
    String RETURN_TO_MAIN = "Return to Main";
    String BLANK = "";
    String USER_START_MENU_TITLE = "Start Menu";
    String USER_START_MENU_DESCRIPTION = "Welcome to Spotify! You are...";
    String SIGN_IN_MENU_TITLE = "Sign-in Menu";
    String SIGN_IN_MENU_DESCRIPTION = "Let's create for you a new account!";
    String LOG_IN_MENU_TITLE = "Log-in Menu";
    String LOG_IN_MENU_DESCRIPTION = "Let's log in to your account!";
    String MAIN_MENU_TITLE = "Main Menu";
    String STREAM_IN_ORDER = "Stream in order";
    String STREAM_RANDOMLY = "Stream randomly";
    String NEXT = "Next";
    String PREVIOUS = "Previous";
    String ADD_MULTIPLE_TO_FAVORITES = "Add Multiple to Favorites";
    String ADD_MULTIPLE_TO_PLAYLISTS = "Add Multiple to Playlists";
    String USERNAME_REGEX = "[a-zA-Z0-9]*";
    String PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-]).{8,}$";
    String MULTIPLE_CHOICE_REGEX = "^\\d{1,2}\\s*";
    SortStringByName SORT_STRING_BY_NAME = new SortStringByName();
    SortSongByName SORT_SONG_BY_NAME = new SortSongByName();
    SortSongByDate SORT_SONG_BY_DATE = new SortSongByDate();
    SortPlaylistByName SORT_PLAYLIST_BY_NAME = new SortPlaylistByName();
    SortPlaylistByDate SORT_PLAYLIST_BY_DATE = new SortPlaylistByDate();
//    List<Song> ALL_SONGS = SongManagement.getInstance().getSongList();
//    List<Playlist> PLAYLIST_LIST = PlaylistListManagement.getInstance().getPlaylistList();
////    int USER_CHOICE_EXIT = 0;

    Command BACK_TO_START = new CommandBack(new NavigateMenuStart());
    Command BACK_TO_MAIN = new CommandBack(new NavigateMenuMain());
    Command EXIT_APP = new CommandExit();
    int PASSWORD_MAX_WRONG_ATTEMPT = 3;
    int PASSWORD_MIN_LENGTH = 8;
    int USERNAME_MAX_LENGTH = 26;
}
