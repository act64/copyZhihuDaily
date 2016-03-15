package usst.lei.copyzhihudaily.index.mvp;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import usst.lei.copyzhihudaily.base.mvp.IView;
import usst.lei.copyzhihudaily.base.mvp.Presenter;
import usst.lei.copyzhihudaily.index.IndexActivity;
import usst.lei.copyzhihudaily.network.ServiceApi;
import usst.lei.copyzhihudaily.readcontent.mvp.LatestModel;

/**
 * Created by hchen on 2016/3/14.
 */
public class IndexPresenter extends Presenter {
    @Inject
    Retrofit retrofit;
    @Inject
    Context appContext;

    private ServiceApi serviceApi;
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
        if (view instanceof IndexActivity) {
            mActivity = (IndexActivity) view;
            serviceApi = retrofit.create(ServiceApi.class);
            serviceApi.getIndexData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<IndexModel>() {
                @Override
                public void onCompleted() {
                    loadMainPageData();
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

    }

    @Override
    public void inject() {
        appComponent.inject(this);
    }

    public void loadMainPageData() {
        serviceApi.getLatest().observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(new Subscriber<LatestModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("error",e.getMessage());
            }

            @Override
            public void onNext(LatestModel latestModel) {
                mActivity.startMain(latestModel);
            }
        });
    }

}
