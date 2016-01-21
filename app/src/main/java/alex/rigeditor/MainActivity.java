package alex.rigeditor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import alex.rigeditor.data.Rig;

public class MainActivity extends AppCompatActivity {

    // Attributs
    private String[] menuSections;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle toggle;

    public ListView rigList;
    public ArrayList<String> stringArrayList;
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liste de l'accueil
        rigList = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.mon_layout_adapter);
        rigList.setAdapter(adapter);

        // Recup rig
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Rig myRig = gson.fromJson(json, Rig.class);

        // Création du drawer
        menuSections = getResources().getStringArray(R.array.menu_items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.left_drawer, menuSections));

        toggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.string.app_name,  /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        ) {
            public void onDrawerClosed(View view) {
                Log.d("MainActivity", "onDrawerClosed");
            }

            public void onDrawerOpened(View drawerView) {
                Log.d("MainActivity", "onDrawerOpened");
            }
        };

        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(toggle);
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent,
                                View view, int position, long id) {
            Intent i;
            switch((String) parent.getAdapter().getItem(position))
            {
                case "Accueil":
                    // WHY
                    i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    break;
                case "Nouveau":
                    i = new Intent(MainActivity.this, NewRig.class);
                    startActivity(i);
                    break;
                case "Edition":
                    break;
                default:
                break;
            }
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

}
