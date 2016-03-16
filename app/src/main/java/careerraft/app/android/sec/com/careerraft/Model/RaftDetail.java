package careerraft.app.android.sec.com.careerraft.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shruti.vig on 3/10/16.
 */
public class RaftDetail {

    @SerializedName("title")
    private String preSchoolTitle;

    @SerializedName("details")
    private String preSchoolDetail;

    public RaftDetail(String title, String details) {
        this.preSchoolTitle = title;
        this.preSchoolDetail = details;
    }

    public String getPreSchoolTitle() {
        return preSchoolTitle;
    }

    public void setPreSchoolTitle(String title) {
        this.preSchoolTitle = title;
    }

    public String getPreSchoolDetail() {
        return preSchoolDetail;
    }

    public void setPreSchoolDetail(String details) {
        this.preSchoolDetail = details;
    }
}
