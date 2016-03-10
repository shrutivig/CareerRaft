package Adapter;

/**
 * Created by shruti.vig on 3/8/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Category;
import careerraft.app.android.sec.com.careerraft.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Category> mCategoryList;

    public CategoryAdapter(ArrayList<Category> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mHeaderText.setText(mCategoryList.get(position).getCategoryTitle());
        holder.mDetailText.setText(mCategoryList.get(position).getCategoryDetail());

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mHeaderText;
        public TextView mDetailText;
        public ImageView mImageCategory;

        public ViewHolder(View v) {
            super(v);
            mHeaderText = (TextView) v.findViewById(R.id.text_title);
            mDetailText = (TextView) v.findViewById(R.id.text_detail);
            mImageCategory = (ImageView) v.findViewById(R.id.image_title);
        }
    }
}
