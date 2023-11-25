package demo;

import constant.Constants;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class AddData {
    public static void main(String[] args) {
        List<Song> spotifySongs = new ArrayList<>();
        Song songCruelSummer = new Song("Cruel Summer", "Taylor Swift", "Pop", "audio/CruelSummer_TaylorSwift.wav");
        Song songLoveStory = new Song("Love Story", "Taylor Swift", "Pop, Country", "audio/LoveStory_TaylorSwift.wav");
        Song songMemories = new Song("Memories", "Maroon 5", "Rock, Soft Rock", "audio/Memories_Maroon5.wav");
        Song songIKnewYouWereTrouble = new Song("I Knew You Were Trouble", "Taylor Swift", "Pop, EDM, Rock", "audio/IKnewYouWereTrouble_TaylorSwift.wav");
        Song songOneThing = new Song("One Thing", "One Direction", "Pop, Rock", "audio/OneThing_OneDirection.wav");
        Song songRed = new Song("Red", "Taylor Swift", "Pop, Country, Rock", "audio/Red_TaylorSwift.wav");
        Song songEnchanted = new Song("Enchanted", "Taylor Swift", "Ballad, Pop, Rock, Country", "audio/Enchanted_TaylorSwift.wav");
        Song songPayphone = new Song("Payphone", "Maroon 5", "Pop, R&B", "audio/Payphone_Maroon5.wav");
        Song songOneMoreNight = new Song("One More Night", "Maroon 5", "Pop, Rock", "audio/OneMoreNight_Maroon5.wav");
        Song songWhatMakesYouBeautiful = new Song("What Makes You Beautiful", "One Direction", "Pop", "audio/WhatMakesYouBeautiful_OneDirection.wav");
        Song song7Rings = new Song("7 Rings", "Ariana Grande", "Pop", "audio/7Rings_ArianaGrande.wav");
        Song songOneLastTime = new Song("One Last Time", "Ariana Grande", "Pop, Country", "audio/OneLastTime_ArianaGrande.wav");
        Song songEverytime = new Song("Everytime", "Ariana Grande", "Pop, R&B", "audio/Everytime_ArianaGrande.wav");
        Song songSantaTellMe = new Song("Santa Tell Me", "Ariana Grande", "Pop, Country, Rock", "audio/SantaTellMe_ArianaGrande.wav");
        Song songMean = new Song("Mean", "Taylor Swift", "Rock, Soft Rock", "audio/Mean_TaylorSwift.wav");
        Song songFifteen = new Song("Fifteen", "Taylor Swift", "Pop, R&B", "audio/Fifteen_TaylorSwift.wav");
        Song songLookWhatYouMadeMeDo = new Song("Look What You Made Me Do", "Taylor Swift", "Pop, Rock", "audio/LookWhatYouMadeMeDo_TaylorSwift.wav");
        Song songAsLongAsYouLoveMe = new Song("As Long As You Love Me", "Backstreet Boys", "Pop, Rock", "audio/AsLongAsYouLoveMe_BackstreetBoys.wav");
        Song songIWantItThatWay = new Song("I Want It That Way", "Backstreet Boys", "Pop", "audio/IWantItThatWay_BackstreetBoys.wav");
        Song songFearLess = new Song("Fearless", "Taylor Swift", "Pop, Country", "audio/Fearless_TaylorSwift.wav");
        spotifySongs.add(songCruelSummer);
        spotifySongs.add(songLoveStory);
        spotifySongs.add(songMemories);
        spotifySongs.add(songIKnewYouWereTrouble);
        spotifySongs.add(songOneThing);
        spotifySongs.add(songRed);
        spotifySongs.add(songEnchanted);
        spotifySongs.add(songPayphone);
        spotifySongs.add(songOneMoreNight);
        spotifySongs.add(songWhatMakesYouBeautiful);
        spotifySongs.add(song7Rings);
        spotifySongs.add(songOneLastTime);
        spotifySongs.add(songEverytime);
        spotifySongs.add(songSantaTellMe);
        spotifySongs.add(songMean);
        spotifySongs.add(songFifteen);
        spotifySongs.add(songLookWhatYouMadeMeDo);
        spotifySongs.add(songAsLongAsYouLoveMe);
        spotifySongs.add(songIWantItThatWay);
        spotifySongs.add(songFearLess);
        Constants.fileHandler.saveToFile(Constants.SPOTIFY_SONG_FILE_PATH, spotifySongs);
//        List<Song> allSongs = new ArrayList<>();
//        allSongs.add(songEverytime);
//        allSongs.add(songOneLastTime);
//        allSongs.add(songRed);
//        allSongs.add(songFearLess);
//        allSongs.add(songIWantItThatWay);
//        allSongs.add(songPayphone);
//        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
//
//        CreateInstance createInstance = new CreateInstance();
//        createInstance.execute();
    }
}
