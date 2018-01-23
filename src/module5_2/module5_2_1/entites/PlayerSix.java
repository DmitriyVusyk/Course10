package module5_2.module5_2_1.entites;

import java.util.*;

public class PlayerSix extends AbstractMP3Player {

    private final int price;
    private String[] playList;

    public PlayerSix(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String[] getPlayList() {
        return playList;
    }

    public void setPlayList(String[] playList) {
        this.playList = playList;
    }

    @Override
    public void playSong(String[] playList) {

        for (int i = 0; i < playList.length; i++) {
            if (playList[i] != null) {
                System.out.println("Playing: " + playList[i]);
                break;
            }
        }
    }

    public void playAllSongs(String[] playList) {

        if (playList == null) {
            System.out.println("Playlist is empty");
        }


        assert playList != null;
        for (String song :
                playList) {
            System.out.println("Playing: " + song);
        }
    }

    public void shuffle(String[] playList) {
        ArrayList<String> playListSet = new ArrayList<>(Arrays.asList(playList));
        Collections.shuffle(playListSet);
        this.playList = playListSet.toArray(new String[playListSet.size()]);
    }
}
