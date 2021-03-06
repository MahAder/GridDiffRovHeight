package com.tarashor.androidapps.horizontalitemspaginationview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tarashor.androidapps.widgets.PaginationAdapter;
import com.tarashor.androidapps.widgets.PaginationRecyclerView;

import java.util.Random;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ader on 4/18/2018.
 */

public class StagedGridItemsActivity extends AppCompatActivity {
    public static final int PAGES_COUNT = 5;
    public static final int ITEMS_COUNT = PAGES_COUNT * 12;
    public static final int DELAY_MILLIS = 1500;

    private Handler handler = new Handler();

    private ItemsAdapter adapter;

    private Model model;

    private SwitchCompat clearSwitchCompat;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griditems);

        layoutManager = new GridLayoutManager(this, 3);

        PaginationRecyclerView itemsView = findViewById(R.id.items_view);
        itemsView.setLayoutManager(layoutManager);

        adapter = new ItemsAdapter();
        adapter.setDataLoader(new PaginationAdapter.DataLoader() {
            @Override
            public void loadMoreData(int itemsCountLoaded, final PaginationAdapter adapter) {
                loadNextPage();
            }
        });
        itemsView.setAdapter(adapter);
        itemsView.setHasFixedSize(true);

        clearSwitchCompat = findViewById(R.id.clear_switch);

        clearSwitchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                model.resetIsAllDataLoaded();
            }
        });

        Button startButton = findViewById(R.id.button_start_loading);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoadingData();
            }
        });

        model = new Model(ITEMS_COUNT, PAGES_COUNT);

    }

    private void startLoadingData() {
        adapter.setIsDataLoaded(false);
        adapter.loadMoreData();
    }

    private void loadNextPage() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (clearSwitchCompat.isChecked()){
                    model.clearItems();
                } else {
                    model.generateNextPage();
                }

                adapter.setItems(model.getItems());
                adapter.setIsDataLoaded(model.isAllDataLoaded());

            }
        }, DELAY_MILLIS);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder
    {
        private FrameLayout container = null;
        private TextView text = null;

        public ItemViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.item_color_view);
            text = itemView.findViewById(R.id.item_name_view);
        }

        public void bind(Item item) {
            container.setBackgroundColor(item.getColor());
            text.setText(item.getName());
        }
    }

    public static class ItemsAdapter extends PaginationAdapter<Item>{

        @Override
        protected RecyclerView.ViewHolder createItemViewHolder(ViewGroup parent) {
            View view = PaginationAdapter.createViewFromLayout(parent, R.layout.item_layout);

            return new GridItemsActivity.ItemViewHolder(view);
        }

        @Override
        protected void bindItemViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            GridItemsActivity.ItemViewHolder itemViewHolder = (GridItemsActivity.ItemViewHolder) viewHolder;
            int height = 200;
            viewHolder.itemView.findViewById(R.id.item_color_view).getLayoutParams().height = (int) (height * items.get(position).getHeightCof());

            itemViewHolder.bind(items.get(position));
        }

        @Override
        protected LoadingViewHolder createLoadingViewHolder(ViewGroup parent) {
            View view = PaginationAdapter.createViewFromLayout(parent, R.layout.loading_item_layout);
            return new LoadingViewHolder(view);
        }
    }
}
