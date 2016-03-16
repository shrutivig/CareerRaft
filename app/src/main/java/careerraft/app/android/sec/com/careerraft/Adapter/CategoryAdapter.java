package careerraft.app.android.sec.com.careerraft.Adapter;

/**
 * Created by shruti.vig on 3/8/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import careerraft.app.android.sec.com.careerraft.Model.Category;
import careerraft.app.android.sec.com.careerraft.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    public interface OnItemClickListenerCustom {
        void onItemClickCustom(Category item, View view);
    }

    private ArrayList<Category> mCategoryList;
    private final OnItemClickListenerCustom listener;

    public CategoryAdapter(ArrayList<Category> categoryList, OnItemClickListenerCustom listener) {
        this.mCategoryList = categoryList;
        this.listener = listener;
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

        holder.bindClickListener(mCategoryList.get(position), listener);

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

        public void bindClickListener(final Category item, final OnItemClickListenerCustom listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickCustom(item, itemView);
                }
            });
        }
    }
}