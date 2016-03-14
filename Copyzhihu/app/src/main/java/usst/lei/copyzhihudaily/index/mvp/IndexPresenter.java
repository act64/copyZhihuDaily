package usst.lei.copyzhihudaily.index.mvp;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import usst.lei.copyzhihudaily.base.mvp.IView;
import usst.lei.copyzhihudaily.base.mvp.Presenter;
import usst.lei.copyzhihudaily.index.IndexActivity;
import usst.lei.copyzhihudaily.index.network.ServiceApi;

/**
 * Created by hchen on 2016/3/14.
 */
public class IndexPresenter extends Presenter {
    @Inject
    Retrofit retrofit;
    @Inject
    Context appContext;

    private IndexActivity mActivity;

    @Override
    public void onCreat() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onAttach(IView view) {
        super.onAttach(view);
        if (view instanceof IndexActivity)
        mActivity= (IndexActivity) view;
       ServiceApi serviceApi= retrofit.create(ServiceApi.class);
    serviceApi.getIndexData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<IndexModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(IndexModel indexModel) {
            mActivity.paraseIndex(indexModel);
        }
    });

    }

    @Override
    public void inject() {
        appComponent.inject(this);
    }

}
