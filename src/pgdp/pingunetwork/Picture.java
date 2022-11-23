package pgdp.pingunetwork;

public class Picture {

    private String location;

    private int width;

    private int height;

    private int[][] data;
    //github tests noch nicht ausgeführt - github tests erfolgreich
    private Picture[] thumbnails;

    public Picture(String location, int[][] data) {
        this.location = location;
        this.data = data;

        if (data != null) {
            if (data.length == 0 || data[0].length == 0) {
                width = 0;
                height = 0;
            } else {
                width = data[0].length;
                height = data.length;
            }
        }


        thumbnails = new Picture[0];
    }

    public String getLocation() {
        return location;
    }

    public Picture[] getThumbnails() {
        return thumbnails;
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

    public void setThumbnails(Picture[] thumbnails) {
        this.thumbnails = thumbnails;
    }
}
