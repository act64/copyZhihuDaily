package usst.lei.copyzhihudaily.base.dagger.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import usst.lei.copyzhihudaily.base.tools.InternetUtil;

/**
 * Created by hchen on 2016/3/14.
 */
@Module
public class AppModule {
    private final Context appContext;
    private  OkHttpClient client;
    private InternetUtil internetUtil;
    public AppModule(Application application){
        appContext=application;
        internetUtil=new InternetUtil();
    }

    @Provides
    @Singleton
     Context getAppContext(){
        return this.appContext;
    }

    @Provides
    @Singleton
    InternetUtil getInternetUtil(){
        return internetUtil;
    }

    @Provides
    @Singleton
    Retrofit getRetrofit(){
        if (client==null){
            final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
                @Override public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!internetUtil.hasInternet(appContext)) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();

                    }
                    Response response = chain.proceed(request);

                    if (internetUtil.hasInternet(appContext)) {
                        int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
                        response.newBuilder()
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                                .build();
                    } else {

                        int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周

                        response.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .removeHeader("Pragma")
                                .build();
                    }
                    return response;
                }};
            File httpCacheDirectory = new File(appContext.getCacheDir(), "responses");
            //设置缓存 10M
            Cache cache = new Cache(httpCacheDirectory, 100 * 1024 * 1024);
            client=new OkHttpClient.Builder().addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR).cache(cache).build();
        }

        return new Retrofit.Builder().baseUrl("http://news-at.zhihu.com/api/4/").client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
