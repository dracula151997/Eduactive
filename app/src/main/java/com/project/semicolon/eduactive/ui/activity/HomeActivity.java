package com.project.semicolon.eduactive.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.utils.AppHelper;

public class HomeActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        NavController.OnDestinationChangedListener {
    private AppBarConfiguration appBarConfiguration;
    private NavController controller;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        controller = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(controller.getGraph())
                .setDrawerLayout(drawerLayout)
                .build();
        controller.addOnDestinationChangedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, controller);
        NavigationUI.setupWithNavController(navigationView, controller);
        AppHelper.setSystemBarLight(this);
        AppHelper.setSystemBarColor(this, R.color.grey_10);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void hideBottomNav(boolean hide) {
        if (hide) bottomNavigationView.setVisibility(View.GONE);
        else bottomNavigationView.setVisibility(View.VISIBLE);
    }

    private void showToolbar() {
        findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
    }

    private void hideToolbar(boolean hide) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (hide) toolbar.setVisibility(View.GONE);
        else toolbar.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawers();
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.menu_study_time_table:
                controller.navigate(R.id.studyTimeTableFragment);
                return true;
            case R.id.menu_exam_bank:
                controller.navigate(R.id.examsBankFragment);
                return true;
            case R.id.menu_home:
                controller.navigate(R.id.homeFragment);
                return true;


        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull
            NavDestination destination, @Nullable Bundle arguments) {
        CharSequence title = destination.getLabel();
        toolbar.setTitle(title);
        switch (destination.getId()) {
            case R.id.loginFragment:
                hideToolbar(true);
                hideBottomNav(true);
                break;
            case R.id.homeFragment:
            case R.id.trainingFragment:
            case R.id.eventsFragment:
                hideBottomNav(false);
                hideToolbar(false);
                break;
            default:
                hideToolbar(false);
                hideBottomNav(true);
                break;
        }
    }
}
