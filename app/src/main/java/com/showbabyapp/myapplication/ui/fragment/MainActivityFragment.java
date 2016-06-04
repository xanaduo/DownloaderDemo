package com.showbabyapp.myapplication.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.common.base.Preconditions;
import com.showbabyapp.myapplication.R;
import com.showbabyapp.myapplication.ui.adapter.MainAdapter;
import com.showbabyapp.myapplication.view.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements IBaseView<String> {

    private ProgressDialog dialog;
    private RecyclerView rv_content;
    private RadioButton rb_list;
    private RadioButton rb_grid;
    private static final int SPAN_COUNT = 2;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rv_content = (RecyclerView) view.findViewById(R.id.rv_content);
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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialog = new ProgressDialog(this.getActivity());
        dialog.show();
    }

    @Override
    public void refreshView(String data) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            list.add(i + data);
        MainAdapter adapter = new MainAdapter(list);
        rv_content.setAdapter(adapter);
        dialog.dismiss();
    }

    @Override
    public void errorView(Throwable throwable) {
        Toast.makeText(this.getActivity(), Preconditions.checkNotNull(throwable).toString(), Toast.LENGTH_SHORT).show();
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
}