package module5_2.module5_2_1.entites;

public class PlayerFive extends AbstractMP3Player {
    private final int price;
    private String[] playList;

    public PlayerFive(int price) {
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

        for (int i = playList.length -1 ; i>= 0; i--) {
            System.out.println("Playing: " + playList[i]);
        }
    }
}
