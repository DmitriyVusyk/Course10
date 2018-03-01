package module5_2.module5_2_1.entites;

public class PlayerFour extends AbstractMP3Player {

    private final int price;
    private String[] playList;

    public PlayerFour(int price) {
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

        for (int i = playList.length-1; i >= 0; i--) {
            if (playList[i] != null){
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

}
