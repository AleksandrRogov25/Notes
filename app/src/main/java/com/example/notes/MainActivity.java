package com.example.notes;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();

        if(!isLandscape())
            initToolbarAndDrawer();
        else
            initToolBar();
        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new NotesFragment())
                    .commit();

    }

    private void initToolbarAndDrawer() {
        Toolbar toolbar = initToolBar();
        initDrawer(toolbar);

    }
    private Toolbar initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;


    }

    private void initDrawer(Toolbar toolbar) {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.about_program) {
                    AboutProgramFragment();
                    return true;
                }
                return false;
            }
        });
    }

    private void AboutProgramFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.fragment_container, new AboutProgramFragment()).commit();
            }


            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu, menu);

                return super.onCreateOptionsMenu(menu);
            }


            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_delete:

                        Toast.makeText(getApplicationContext(), "Удалить заметку", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_change:

                        Toast.makeText(getApplicationContext(), "Изменить заметку", Toast.LENGTH_SHORT).show();
                        return true;



                    case R.id.action_exit:
                        new AlertDialog.Builder(this)
                                .setTitle("Диалоговое окно")
                                .setMessage("Вы уверены что хотите закрыть приложение?")
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("Нет", null)
                                .show();
                        return true;
                    }
                    return super.onOptionsItemSelected(item);
                }

   
    private boolean isLandscape() {
        return getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

        }
