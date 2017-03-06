package com.dev.bins.bandwagongclient.net;

import com.dev.bins.bandwagongclient.bean.AvailableOS;
import com.dev.bins.bandwagongclient.bean.ResultCode;
import com.dev.bins.bandwagongclient.bean.ServerInfo;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bin on 10/02/2017.
 */

public interface Api {
    String BASE_URL = "https://api.64clouds.com/v1/";



    @POST("start")
    @FormUrlEncoded
    Observable<ResultCode> start(@Field("veid") String veid, @Field("api_key") String api_key);

    @POST("stop")
    @FormUrlEncoded
    Observable<ResultCode> stop(@Field("veid") String veid, @Field("api_key") String api_key);


    @POST("restart")
    @FormUrlEncoded
    Observable<ResultCode> restart(@Field("veid") String veid, @Field("api_key") String api_key);

    @POST("kill")
    @FormUrlEncoded
    Observable<ResultCode> kill(@Field("veid") String veid, @Field("api_key") String api_key);


    @POST("getServiceInfo")
    @FormUrlEncoded
    Observable<ServerInfo> getServerInfo(@Field("veid") String veid, @Field("api_key") String api_key);

//    @GET("getServiceInfo")
//    Observable<ServerInfo> getServerInfo(@Query("veid") String veid, @Query("api_key") String api_key);


//    @POST("getLiveServiceInfo")
//    @FormUrlEncoded
//    Observable<ServerInfo> getLiveServiceInfo(@Field("veid") String veid, @Field("api_key") String api_key);


    @POST("getAvailableOS")
    @FormUrlEncoded
    Observable<AvailableOS> getAvailableOS(@Field("veid") String veid, @Field("api_key") String api_key);


    @POST("reinstallOS")
    @FormUrlEncoded
    Observable<ResultCode> reinstallOS(@Field("veid") String veid, @Field("api_key") String api_key,@Field("os")String os);


    @POST("setHostname")
    @FormUrlEncoded
    Observable<ResultCode> setHostname(@Field("veid") String veid, @Field("api_key") String api_key,@Field("newHostname")String newHostname);





}
