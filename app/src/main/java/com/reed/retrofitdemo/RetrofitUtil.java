package com.reed.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 伟 on 2016/3/16.
 */
public class RetrofitUtil {

    private volatile static Retrofit retrofit;
    private volatile static GitHubService service;

    private static Retrofit getInstance() {
        if (retrofit == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl("https://api.github.com/")
                            //解析结果为需要的类型
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static GitHubService getService() {
        if (service == null) {
            synchronized (RetrofitUtil.class) {
                if (service == null) {
                    service = getInstance().create(GitHubService.class);
                }
            }
        }
        return service;
    }
}
