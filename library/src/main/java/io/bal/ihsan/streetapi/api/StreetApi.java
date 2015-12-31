package io.bal.ihsan.streetapi.api;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Streaming;

/**
 * Created by Admin on 31/12/15.
 */
public interface StreetApi {
    @GET("/maps/api/streetview?")
    @Streaming
    Call<ResponseBody> getStreetView(@Query("size") String size, @Query("location") String location, @Query("heading") String heading, @Query("pitch") String pitch, @Query("key") String key);
}

