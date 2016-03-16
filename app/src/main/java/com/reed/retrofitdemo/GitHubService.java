package com.reed.retrofitdemo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 伟 on 2016/3/15.
 */
public interface GitHubService {

    @GET("users")
    Call<String> listRepos();

    /**
     * 参数比较少的情况下，可以直接传出参数名和参数值
     * @param page 参数值
     * @return 返回请求
     */
    @GET("repositories/892275/contributors")
    Call<String> repos(@Query("page")int page);

    /**
     * 参数比较多时，可以以map的形式传入参数名和值
     * @param options 参数Map
     * @return 返回请求
     */
    @GET("user/repos")
    Call<String> getRequestWithMap(@QueryMap Map<String, String> options);

    @FormUrlEncoded
    @POST("/some/endpoint")
    Call<String> getPostWithMap(@FieldMap Map<String, String> names);

    /**
     * 其他的一些使用方式可以参考官方使用说明
     * http://square.github.io/retrofit/
     */



}
