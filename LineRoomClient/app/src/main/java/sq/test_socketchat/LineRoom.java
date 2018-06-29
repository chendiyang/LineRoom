package sq.test_socketchat;

/**
 * Created by chendsir on 18-6-29.
 */

public class LineRoom {
    private String name;
    private int imageId;


    public LineRoom(String name, int imageId) {
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;

    }

    public int getImageId() {
        return imageId;
    }
}
