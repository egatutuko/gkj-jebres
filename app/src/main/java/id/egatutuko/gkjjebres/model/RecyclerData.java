package id.egatutuko.gkjjebres.model;

public class RecyclerData {

    private String head_title;
    private int img_id;

    public String getHead_title() {
        return head_title;
    }

    public void setHead_title(String head_title) {
        this.head_title = head_title;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public RecyclerData(String head_title, int img_id) {
        this.head_title = head_title;
        this.img_id = img_id;
    }
}
