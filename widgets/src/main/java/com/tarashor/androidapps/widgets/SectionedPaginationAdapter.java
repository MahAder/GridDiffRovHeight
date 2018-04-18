package com.tarashor.androidapps.widgets;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Taras on 24.11.2017.
 */

public abstract class SectionedPaginationAdapter<TItem> extends PaginationAdapter<TItem> {
//    protected static final int SECTION_ITEM = 2;
//
//    protected boolean isAllSectionsLoaded;
//
//    public SectionedPaginationAdapter() {
//        super();
//
//    }
//
//    protected void initState() {
//        super.initState();
//        isAllSectionsLoaded = true;
//    }
//
//
//    public void setItems(List<TItem> newItems) {
//        isDataLoading = false;
//
//        items.clear();
//        if (newItems != null){
//            items.addAll(newItems);
//        }
//        notifyDataSetChanged();
//    }
//
//    public void setIsAllSectionsLoaded(boolean isAllSectionsLoaded) {
//        if (this.isAllSectionsLoaded != isAllSectionsLoaded) {
//            this.isAllSectionsLoaded = isAllSectionsLoaded;
//            if (!this.isAllSectionsLoaded) {
//                notifyItemInserted(getItemCount() - 1);
//            } else{
//                notifyItemRemoved(getItemCount() - 1);
//            }
//        }
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return isAllSectionsLoaded ? getItemCount() : getItemCount() + 1;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return (position == getItemCount() - 1 && !isAllSectionsLoaded) ? LOADING_ITEM : ITEM;
//    }
//
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        RecyclerView.ViewHolder viewHolder = null;
//        switch (viewType) {
//            case ITEM:
//                viewHolder = createItemViewHolder(parent);
//                break;
//            case LOADING_ITEM:
//                viewHolder = createLoadingViewHolder(parent);
//                break;
//            default:
//                break;
//        }
//        return viewHolder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
//        switch (getItemViewType(position)) {
//            case ITEM:
//                bindItemViewHolder(viewHolder, position);
//                break;
//            case LOADING_ITEM:
//                bindLoadingViewHolder(viewHolder);
//            default:
//                break;
//        }
//    }
//
//    private void bindLoadingViewHolder(RecyclerView.ViewHolder viewHolder) {
//    }
//
//    protected abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent);
//    protected abstract void bindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position);
//    protected abstract LoadingViewHolder createLoadingViewHolder(ViewGroup parent);
//
//    public static View createViewFromLayout(ViewGroup parent, @LayoutRes int layoutId){
//        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
//    }
//
//    public boolean isDataLoaded() {
//        return isAllSectionsLoaded;
//    }
//
//
//    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
//        public LoadingViewHolder(View view) {
//            super(view);
//        }
//    }
//
//    public interface DataLoader {
//        void loadMoreData(int itemsCountLoaded, SectionedPaginationAdapter adapter);
//    }


}
