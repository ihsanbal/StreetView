package io.bal.ihsan.streetapi.api.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.squareup.okhttp.ResponseBody;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.bal.ihsan.streetapi.api.StreetApi;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Admin on 31/12/15.
 */
public class StreetView {

    private String pitch = "-0.76";
    private String heading = "151.78";
    private String size = "600x300";
    private String apiKey;

    public StreetView(Builder builder) {
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            pitch = builder.pitch;
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            heading = builder.heading;
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            size = builder.size;
        if (apiKey == null || apiKey.equalsIgnoreCase("") || apiKey.length() < 10)
            new RuntimeException("api key will not be null or wrong please check your api key and length");
        else
            apiKey = builder.apiKey;
    }

    public static class Builder {
        private String pitch = "-0.76";
        private String heading = "151.78";
        private String size = "600x300";

        //Required
        private final String apiKey;

        public Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        public Builder pitch(String value) {
            pitch = value;
            return this;
        }

        public Builder heading(String value) {
            heading = value;
            return this;
        }

        public Builder size(String value) {
            size = value;
            return this;
        }

        public StreetView build() {
            return new StreetView(this);
        }

    }

    public void getStreetView(double lat, double lng, final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, lat + "," + lng, heading, pitch, apiKey).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                InputStream inputStream = null;
                try {
                    inputStream = response.body().byteStream();
                } catch (IOException e) {
                    e.printStackTrace();
                    callBack.onFailure(e);
                } finally {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    final Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);
                    callBack.onResponse(response, retrofit, bmp);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onFailure(t);
            }
        });
    }

    public void getStreetView(String size, String heading, String pitch, double lat, double lng, final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, lat + "," + lng, heading, pitch, apiKey).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                InputStream inputStream = null;
                try {
                    inputStream = response.body().byteStream();
                } catch (IOException e) {
                    e.printStackTrace();
                    callBack.onFailure(e);
                } finally {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    final Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);
                    callBack.onResponse(response, retrofit, bmp);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onFailure(t);
            }
        });
    }

    public void getStreetView(String size, double lat, double lng, final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, lat + "," + lng, heading, pitch, apiKey).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                InputStream inputStream = null;
                try {
                    inputStream = response.body().byteStream();
                } catch (IOException e) {
                    e.printStackTrace();
                    callBack.onFailure(e);
                } finally {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    final Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);
                    callBack.onResponse(response, retrofit, bmp);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onFailure(t);
            }
        });
    }

}
