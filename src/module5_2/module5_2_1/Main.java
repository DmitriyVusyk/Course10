package module5_2.module5_2_1;

import module5_2.module5_2_1.entites.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PlayerOne playerOne = new PlayerOne(100);
        PlayerTwo playerTwo = new PlayerTwo(200);
        PlayerThree playerThree = new PlayerThree(300);
        PlayerFour playerFour = new PlayerFour(400);
        PlayerFive playerFive = new PlayerFive(500);
        PlayerSix playerSix = new PlayerSix(600);

        String[] playlist = {"run run run away", "yeah baby", "get closer"};

        System.out.println("Player one operations:");
        playerOne.setPlayList(playlist);
        playerOne.playSong(playlist);

        System.out.println("Player two operations:");
        playerTwo.playSong(playlist);

        System.out.println("Player three operations:");
        playerThree.setPlayList(playlist);
        playerThree.playSong(playlist);
        playerThree.playAllSongs(playlist);

        System.out.println("Player four operations: ");
        playerFour.playSong(playlist);
        playerFour.playAllSongs(playlist);

        System.out.println("Player five operations:");
        playerFive.playSong(playlist);
        playerFive.playAllSongs(playlist);

        System.out.println("Player six operations:");
        playerSix.playSong(playlist);
        playerSix.playAllSongs(playlist);
        playerSix.shuffle(playlist);
        System.out.println(Arrays.toString(playerSix.getPlayList()));

    }
}
