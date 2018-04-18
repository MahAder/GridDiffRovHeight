package com.tarashor.androidapps.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Taras on 12.02.2018.
 */

public class PaginationRecyclerView extends RecyclerView {
    private AdapterDataObserver dataObserver;

    public PaginationRecyclerView(Context context) {
        super(context);
        initView();
    }

    public PaginationRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PaginationRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        adapter.registerAdapterDataObserver(dataObserver);
    }

    public void updateVisibility() {
        Adapter adapter = getAdapter();
        if (adapter instanceof PaginationAdapter){
            PaginationAdapter paginationAdapter = (PaginationAdapter)adapter;
            setVisibility(View.VISIBLE);
            if (paginationAdapter.getItemCount() == 0) {
                if (paginationAdapter.isDataLoaded()) {
                    setVisibility(View.GONE);
                } else {
                    paginationAdapter.loadMoreData();
                }
            }
        }
    }

    private void initView(){
        dataObserver = new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                updateVisibility();
            }
        };

        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                checkLastItemVisible();
            }
        });
    }

    private void checkLastItemVisible() {
        LayoutManager layoutManager = getLayoutManager();
        Adapter adapter = getAdapter();
        if (layoutManager instanceof LinearLayoutManager && adapter instanceof PaginationAdapter) {
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();

            int firstVisibleItemPosition = ((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();

            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                ((PaginationAdapter)adapter).loadMoreData();
            }
        } else {
            if(layoutManager instanceof StaggeredGridLayoutManager && adapter instanceof PaginationAdapter){
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();

                int firstVisibleItemPosition[] = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);

                int firstVisible = 0;
                for(int i = 0; i < firstVisibleItemPosition.length; i++){
                    if(firstVisibleItemPosition[i] > firstVisible){
                        firstVisible = firstVisibleItemPosition[i];
                    }
                }

                if ((visibleItemCount + firstVisible) >= totalItemCount) {
                    ((PaginationAdapter)adapter).loadMoreData();
                }
            }
        }
    }
}
