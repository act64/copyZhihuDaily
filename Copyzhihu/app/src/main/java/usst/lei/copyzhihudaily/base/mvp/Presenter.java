package usst.lei.copyzhihudaily.base.mvp;

import android.app.Activity;
import android.content.Context;

import javax.inject.Inject;

import retrofit2.Retrofit;
import usst.lei.copyzhihudaily.base.MainApplicatiom;
import usst.lei.copyzhihudaily.base.dagger.component.DaggerAppComponent;

/**
 * Created by hchen on 2016/3/14.
 */
public abstract class Presenter  {



    @Inject
    protected Context appContext;

    @Inject
    protected Retrofit retrofit;
    protected DaggerAppComponent appComponent;

    public void onCreat(){};

    public void onResume(){};

    public void onDestory(){};

    public void onAttach(IView view){
        if (view instanceof Activity){
          appComponent=  (((MainApplicatiom)(((Activity) view).getApplication())).getAppComponent());
            inject();
        }
    }
    //present 类型
    public abstract void inject();


}
