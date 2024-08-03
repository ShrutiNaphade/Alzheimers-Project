package com.example.game;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.BreakIterator;

public class LevelSelection extends Collection implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Checkout the profile section", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView;
        navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        TextView headermail=(TextView) header.findViewById(R.id.headeremail);
        headermail.setText(user_name);
        //Menu x=navigationView.getMenu();
        //MenuItem t=x.findItem(R.id.nav_level1);
       // t.setEnabled(false);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.level_selection, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logout Successfull!", Toast.LENGTH_LONG).show();
                Intent inToMain = new Intent(LevelSelection.this,MainActivity.class);
                startActivity(inToMain);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_level1) {
            startActivity(new Intent(getApplicationContext(), LevelOne.class));
        }
        if (id == R.id.nav_level2) {
            startActivity(new Intent(getApplicationContext(), LevelTwo.class));
        }
        if (id == R.id.nav_level3) {
            startActivity(new Intent(getApplicationContext(), LevelThree.class));
        }
        if(id == R.id.nav_level4)
        {
            startActivity(new Intent(getApplicationContext(), LevelFour.class));
        }
        if(id == R.id.nav_level5)
        {
            startActivity(new Intent(getApplicationContext(), LevelFive.class));
        }
        if(id == R.id.nav_level6)
        {
            startActivity(new Intent(getApplicationContext(), LevelSix.class));
        }
        if(id == R.id.nav_level7)
        {
            startActivity(new Intent(getApplicationContext(), LevelSeven.class));
        }
        if(id == R.id.nav_level8)
        {
            startActivity(new Intent(getApplicationContext(), LevelEight.class));
        }
        if(id == R.id.nav_customlevel)
        {
            startActivity(new Intent(getApplicationContext(), CustomLevel.class));
        }
        if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(getApplicationContext(), "Logout Successfull!", Toast.LENGTH_LONG).show();
            Intent inToMain = new Intent(LevelSelection.this,MainActivity.class);
            startActivity(inToMain);
        }
        if(id == R.id.nav_profile)
        {
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }
        if(id == R.id.nav_contactus)
        {
            startActivity(new Intent(getApplicationContext(), contact.class));
        }
        if(id == R.id.nav_about)
        {
            startActivity(new Intent(getApplicationContext(), About.class));
        }
        if(id == R.id.nav_feedback)
        {
            Uri uri = Uri.parse("http://docs.google.com/forms/d/e/1FAIpQLScURC3J0upvxOTfs6lCqQi16uvFYa8TEbycM1ba206WeMnIBQ/viewform?usp=sf_link");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
