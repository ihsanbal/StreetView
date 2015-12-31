package io.bal.ihsan.streetapi.api.base;

import com.google.android.gms.maps.model.LatLng;
import com.squareup.okhttp.ResponseBody;

import io.bal.ihsan.streetapi.api.StreetApi;
import retrofit.Callback;
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

    public void getStreetView(LatLng location, final Callback<ResponseBody> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, location.latitude + "," + location.longitude, heading, pitch, apiKey).enqueue(callBack);
    }

    public void getStreetView(String size, String heading, String pitch, LatLng location, final Callback<ResponseBody> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, location.latitude + "," + location.longitude, heading, pitch, apiKey).enqueue(callBack);
    }

    public void getStreetView(String size, LatLng location, final Callback<ResponseBody> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .build();
        StreetApi api = retrofit.create(StreetApi.class);
        api.getStreetView(size, location.latitude + "," + location.longitude, heading, pitch, apiKey).enqueue(callBack);
    }

}
