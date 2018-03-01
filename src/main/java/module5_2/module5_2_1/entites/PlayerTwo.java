package module5_2.module5_2_1.entites;

public class PlayerTwo extends AbstractMP3Player {

    private final int price;
    private String[] playList;

    public PlayerTwo(int price) {
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
        System.out.println("error");
    }
}
