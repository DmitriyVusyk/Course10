package module5_2.module5_2_1.entites;

public class PlayerThree extends AbstractMP3Player {

    private final int price;
    private String[] playList;

    public PlayerThree(int price) {
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
        String song = null;

        for (int i = 0; i < playList.length; i++) {
            if (playList[i] != null){
                System.out.println("Playing: " + playList[i]);
                break;
            }
        }
    }

    public void playAllSongs(String[] playList){

        if (playList == null){
            System.out.println("Playlist is empty");
        }

        for (String song :
                playList) {
            System.out.println("Playing: " + song);
        }
    }
}

