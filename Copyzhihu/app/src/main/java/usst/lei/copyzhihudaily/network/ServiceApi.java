package usst.lei.copyzhihudaily.network;

import retrofit2.http.GET;
import rx.Observable;
import usst.lei.copyzhihudaily.index.mvp.IndexModel;
import usst.lei.copyzhihudaily.readcontent.mvp.LatestModel;

/**
 * Created by hchen on 2016/3/14.
 */
public interface ServiceApi  {
    @GET("start-image/1080*1776")
    Observable<IndexModel> getIndexData();

    @GET("news/latest")
    Observable<LatestModel> getLatest();
}
