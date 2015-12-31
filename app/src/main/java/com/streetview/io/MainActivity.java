package com.streetview.io;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;
import com.squareup.okhttp.ResponseBody;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.bal.ihsan.streetapi.api.base.StreetView;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {

    ImageView streetViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        streetViewContainer = (ImageView) findViewById(R.id.streetImageContainer);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StreetView streetView = new StreetView.Builder("AIzaSyDJwAJBnh_N5cJ0mNU9hspD9S55oJGmijo")
                        .pitch("-0.76")
                        .heading("80.0")
                        .size("600x400")
                        .build();

                streetView.getStreetView(new LatLng(41.0421119, 29.0379787), new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                        try {
                            InputStream inputStream = response.body().byteStream();
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                            final Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);
                            streetViewContainer.setImageBitmap(bmp);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
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
