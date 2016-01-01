package io.bal.ihsan.streetapi.api.base;

/**
 * Google Street View Image API
 * <p/>
 * Introduction
 * <p/>
 * The Google Street View Image API lets you embed a static (non-interactive) Street View panorama or
 * thumbnail into your web page, without the use of JavaScript. The viewport is defined with URL parameters
 * sent through a standard HTTP request, and is returned as a static image.
 * <p/>
 * <p/>
 * <p/>
 * https://maps.googleapis.com/maps/api/streetview?size=400x400&location=40.720032,-73.988354
 * &fov=90&heading=235&pitch=10
 * &key=YOUR_API_KEY
 * URL Parameters
 * <p/>
 * A Street View Image request is an HTTP URL of the following form:
 * <p/>
 * https://maps.googleapis.com/maps/api/streetview?parameters
 * The image is specified using request parameters. As is standard in URLs, all parameters are
 * separated using the ampersand (&) character. Allowed parameters and their possible values are listed below.
 * <p/>
 * Required parameters
 * <p/>
 * Either:
 * <p/>
 * location can be either a text string (such as Chagrin Falls, OH) or a lat/lng value (40.457375,-80.009353).
 * The Google Street View Image API will snap to the panorama photographed closest to this location. Because Street View
 * imagery is periodically refreshed, and photographs may be taken from slightly different
 * positions each time, it's possible that your location may snap to a different panorama when imagery is updated.
 * Or:
 * <p/>
 * pano is a specific panorama ID. These are generally stable.
 */

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
    private String heading = "180.0";
    private String size = "600x300";
    private String fov = "90";
    private String apiKey;

    public StreetView(Builder builder) {
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            pitch = builder.pitch;
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            heading = builder.heading;
        if (builder.pitch != null && !builder.pitch.equalsIgnoreCase(""))
            size = builder.size;
        if (builder.fov != null && !builder.fov.equalsIgnoreCase(""))
            fov = builder.fov;
        if (apiKey == null || apiKey.equalsIgnoreCase("") || apiKey.length() < 10)
            new RuntimeException("api key will not be null or wrong please check your api key and length");
        else
            apiKey = builder.apiKey;
    }

    public static class Builder {
        private String pitch = "0";
        private String heading = "151.78";
        private String size = "600x400";
        private String fov;

        //Required
        private final String apiKey;

        /**
         * @param apiKey key allows you to monitor your application's API usage in the [!Google Developers Console](https://developers.google.com/console/help/new/);
         *               enables per-key instead of per-IP-address quota limits; and ensures that Google can
         *               contact you about your application if necessary. For more information, see
         *               Get a Key and Signature.
         */
        public Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        /**
         * @param value pitch (default is 0) specifies the up or down angle of the camera relative to the Street
         *              View vehicle. This is often, but not always, flat horizontal. Positive values angle the
         *              camera up (with 90 degrees indicating straight up); negative values angle the camera down
         *              (with -90 indicating straight down).
         */
        public Builder pitch(String value) {
            pitch = value;
            return this;
        }

        /**
         * @param value heading (default is 180.0) indicates the compass heading of the camera. Accepted values are from 0 to 360
         *              (both values indicating North, with 90 indicating East, and 180 South). If no heading
         *              is specified, a value will be calculated that directs the camera towards the specified
         *              location, from the point at which the closest photograph was taken.
         */
        public Builder heading(String value) {
            heading = value;
            return this;
        }

        /**
         * @param value size (default is 600x400) specifies the output size of the image in pixels. Size is specified as
         *              {width}x{height} - for example, size=600x400 returns an image 600 pixels wide, and 400 high.
         */
        public Builder size(String value) {
            size = value;
            return this;
        }

        /**
         * @param value fov (default is 90) determines the horizontal field of view of the image. The field of
         *              view is expressed in degrees, with a maximum allowed value of 120. When dealing with a
         *              fixed-size viewport, as with a Street View image of a set size, field of view in essence
         *              represents zoom, with smaller numbers indicating a higher level of zoom.
         */
        public Builder fov(String value) {
            fov = value;
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
        api.getStreetView(size, lat + "," + lng, heading, pitch, fov, apiKey).enqueue(new Callback<ResponseBody>() {
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
