package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shruti.vig on 3/8/16.
 */
public class Category {

    @SerializedName("title")
    private String categoryTitle;

    @SerializedName("details")
    private String categoryDetail;

    public Category(String title, String details) {
        this.categoryTitle = title;
        this.categoryDetail = details;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String title) {
        this.categoryTitle = title;
    }

    public String getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(String details) {
        this.categoryDetail = details;
    }
}
