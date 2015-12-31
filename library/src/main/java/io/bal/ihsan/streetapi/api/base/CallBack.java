package io.bal.ihsan.streetapi.api.base;

import android.graphics.Bitmap;

import com.squareup.okhttp.ResponseBody;

import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Admin on 31/12/15.
 */
public interface CallBack {
    void onResponse(Response<ResponseBody> response, Retrofit retrofit, Bitmap bitmapStreetView);

    void onFailure(Throwable t);
}
