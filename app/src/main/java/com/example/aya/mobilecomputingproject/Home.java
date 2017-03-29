package com.example.aya.mobilecomputingproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private RecyclerView articlesView;
    private ArticleAdapter articleAdapter;
    private ArrayList<Article> articles = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        editor.putBoolean("LoggedIn", true);

        articles.add(new Article("Title1", "Abstract1"));
        articles.add(new Article("Title2", "Abstract2"));
        articles.add(new Article("Title3", "Abstract3"));
        articles.add(new Article("Title4", "Abstract4"));

        articlesView = (RecyclerView) findViewById(R.id.articles_view);
        articleAdapter = new ArticleAdapter(this, articles);

        articlesView.setLayoutManager(new GridLayoutManager(this, 1));
        articlesView.setAdapter(articleAdapter);
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
        if (id == R.id.action_profile) {
            startActivity(new Intent(this, Profile.class));
            return true;
        }
        else if(id == R.id.action_logout){
            sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putBoolean("LoggedIn", false);
            editor.commit();
            startActivity(new Intent(this, Landing.class));
            return true;
        }
        else if(id == R.id.action_home){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class DataTask extends AsyncTask<String, String, String> {
        String urlPath = "https://api.nytimes.com/svc/topstories/v2/health.json?api_key=";

        protected String doInBackground(String... param) {
            URL url = null;
            try {
                url = new URL(urlPath);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                urlConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            try {
                urlConnection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream in = null;
            try {
                in = urlConnection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }

}
