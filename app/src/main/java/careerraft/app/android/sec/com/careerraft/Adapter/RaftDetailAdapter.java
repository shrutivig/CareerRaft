package careerraft.app.android.sec.com.careerraft.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import careerraft.app.android.sec.com.careerraft.Model.RaftDetail;
import careerraft.app.android.sec.com.careerraft.R;

/**
 * Created by shruti.vig on 3/10/16.
 */
public class RaftDetailAdapter extends RecyclerView.Adapter<RaftDetailAdapter.ViewHolder> {

    private ArrayList<RaftDetail> mPreSchoolList;
    private Context mContext;

    public RaftDetailAdapter(ArrayList<RaftDetail> categoryList, Context context) {
        this.mPreSchoolList = categoryList;
        this.mContext = context;
    }

    @Override
    public RaftDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RaftDetailAdapter.ViewHolder holder, int position) {
        holder.mHeaderText.setText(mPreSchoolList.get(position).getPreSchoolTitle());
        holder.mDetailText.setText(mPreSchoolList.get(position).getPreSchoolDetail());
    }

    @Override
    public int getItemCount() {
        return mPreSchoolList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mHeaderText;
        public TextView mDetailText;
        public ImageView mImageCategory;
        public CardView mContainer;

        public ViewHolder(View v) {
            super(v);
            mContainer = (CardView) v.findViewById(R.id.card_view);
            mHeaderText = (TextView) v.findViewById(R.id.text_title);
            mDetailText = (TextView) v.findViewById(R.id.text_detail);
            mImageCategory = (ImageView) v.findViewById(R.id.image_title);
        }
    }
}
