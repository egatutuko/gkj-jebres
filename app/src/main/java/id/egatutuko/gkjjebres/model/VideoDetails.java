package id.egatutuko.gkjjebres.model;

public class VideoDetails {
    public String videoId, title, desc, url;

    public VideoDetails(String videoId, String title, String desc, String url) {
        this.videoId = videoId;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    public VideoDetails(){}

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
