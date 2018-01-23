package module5_2.module5_2_1.entites;

public class PlayerOne extends AbstractMP3Player {

    private final int price;
    private String[] playList;

    public PlayerOne(int price) {
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

        if(playList[0] == null){
            System.out.println("playlist is empty");
        }else {
            song = playList[0];
        }

        System.out.println("Playing: " + song);
    }
}
