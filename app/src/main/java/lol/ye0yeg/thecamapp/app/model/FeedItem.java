package lol.ye0yeg.thecamapp.app.model;

import java.util.List;

/**
 * Created by Administrator on 7/14/2017.
 */
public class FeedItem {

    private String imgPath;

    private List<TagItem> tagList;

    public FeedItem() {

    }

    public FeedItem(List<TagItem> tagList, String imgPath) {
        this.imgPath = imgPath;
        this.tagList = tagList;
    }

    public List<TagItem> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagItem> tagList) {
        this.tagList = tagList;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
