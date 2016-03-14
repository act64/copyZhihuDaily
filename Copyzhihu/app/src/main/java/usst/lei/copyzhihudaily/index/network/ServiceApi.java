package usst.lei.copyzhihudaily.index.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;
import usst.lei.copyzhihudaily.index.mvp.IndexModel;

/**
 * Created by hchen on 2016/3/14.
 */
public interface ServiceApi  {
    @GET("start-image/1080*1776")
    Observable<IndexModel> getIndexData();
}
