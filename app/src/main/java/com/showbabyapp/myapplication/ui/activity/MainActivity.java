package com.showbabyapp.myapplication.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.showbabyapp.myapplication.R;
import com.showbabyapp.myapplication.presenter.MainPresenter;
import com.showbabyapp.myapplication.ui.fragment.MainActivityFragment;

import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mainPresenter;
    String url = "http://www.showbabybox.com/ARShowServer1.0/product_findProduct.do?pdata={\"appkey\":\"1806978425\",\"signature\":\"a249e60cd9f77abcfbe14a039591fe3825b20546\",\"timestamp\":\"1465035200\",\"sts\":\"\",\"model\":\"android\",\"rmk\":\"\",\"apkVersion\":\"1.2.7\",\"registerID\":null,\"biz\":[{\"bname\":\"\",\"mname\":\"\",\"title\":\"\",\"type\":0,\"aid\":\"\",\"limit\":12,\"start\":0}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        x.Ext.init(getApplication());

        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        mainPresenter = new MainPresenter(fragment);
        loadData();
    }

    void loadData() {
        mainPresenter.load(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
