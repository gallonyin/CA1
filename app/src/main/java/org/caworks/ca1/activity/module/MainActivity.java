package org.caworks.ca1.activity.module;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import org.caworks.ca1.R;
import org.caworks.ca1.test.activity.TestMainActivity;
import org.caworks.ca1.view.fragment.HomePageFragment;
import org.caworks.library.activity.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener, HomePageFragment.OnFragmentInteractionListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    public static void enterActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestMainActivity.enterActivity(mContext);
            }
        });
    }

    /**
     * 在回退后 仍不关闭 进程进入后台
     */
    @Override
    public void onBackPressed() {
        Intent launcherIntent = new Intent(Intent.ACTION_MAIN);
        launcherIntent.addCategory(Intent.CATEGORY_HOME);
        startActivity(launcherIntent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void updatePageTitle(String title) {
        toolbar.setTitle(title);
    }
}
