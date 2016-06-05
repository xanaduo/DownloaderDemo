package com.showbabyapp.myapplication.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.common.base.Preconditions;
import com.showbabyapp.myapplication.R;
import com.showbabyapp.myapplication.bean.AppliInfo;
import com.showbabyapp.myapplication.bean.DownloadInfo;
import com.showbabyapp.myapplication.downloader.DownloadManager;
import com.showbabyapp.myapplication.downloader.notify.DataWatcher;
import com.showbabyapp.myapplication.presenter.MainPresenter;
import com.showbabyapp.myapplication.ui.adapter.Adapter;
import com.showbabyapp.myapplication.ui.adapter.MainAdapter;
import com.showbabyapp.myapplication.view.IBaseView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends MVPBaseFragment<IBaseView, MainPresenter> implements IBaseView<AppliInfo> {

    private ProgressDialog dialog;
    private RecyclerView rv_content;
    private RadioButton rb_list;
    private RadioButton rb_grid;
    private static final int SPAN_COUNT = 2;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;
    private MainAdapter adapter;
    private Adapter adapter1;
    private ListView lv_content;
    private DownloadManager manager;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rv_content = (RecyclerView) view.findViewById(R.id.rv_content);
        lv_content = (ListView) view.findViewById(R.id.lv_content);
        rb_list = (RadioButton) view.findViewById(R.id.rb_list);
        rb_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
            }
        });

        rb_grid = (RadioButton) view.findViewById(R.id.rb_grid);
        rb_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
            }
        });
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.load();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.manager = DownloadManager.getInstance(this.getContext());
        adapter = new MainAdapter(manager);
        rv_content.setAdapter(adapter);
        /*adapter1 = new Adapter();
        lv_content.setAdapter(adapter1);*/
        presenter.load();
    }

    @Override
    public void loadView() {
        dialog = new ProgressDialog(this.getActivity());
        dialog.show();
        SystemClock.sleep(1000);
    }

    @Override
    public void successView(AppliInfo data) {
        adapter.setData(data);
        setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
    }

    @Override
    public void emptyView() {
        Toast.makeText(this.getContext(), "没有任何数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureView(Throwable throwable) {
        Toast.makeText(this.getActivity(), Preconditions.checkNotNull(throwable).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishView() {
        dialog.dismiss();
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (rv_content.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) rv_content.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        rv_content.setLayoutManager(mLayoutManager);
        rv_content.scrollToPosition(scrollPosition);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.manager.addObserver(watcher);
    }

    @Override
    public void onStop() {
        super.onStop();
        this.manager.deleteObserver(watcher);
    }

    private DataWatcher watcher = new DataWatcher() {
        @Override
        protected void notifyUpdate(DownloadInfo downloadInfo) {
            adapter.notifyDataSetChanged();
        }
    };
}
