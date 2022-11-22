package pgdp.pingunetwork;

public class Picture {

    private String location;

    private int width;

    private int height;

    private int[][] data;
    //github tests noch nicht ausgeführt
    private Picture[] thumbnails;

    public Picture(String location, int[][] data) {
        this.location = location;
        this.data = data;

        this.width = data[data.length].length;
        this.height = data.length;

        thumbnails = new Picture[0];
    }

    public String getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getData() {
        return data;
    }

    public void setThumbnail(Picture[] thumbnails) {
        this.thumbnails = thumbnails;
    }
}
