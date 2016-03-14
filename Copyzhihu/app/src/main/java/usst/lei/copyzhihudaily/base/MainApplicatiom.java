package usst.lei.copyzhihudaily.base;

import android.app.Application;

import usst.lei.copyzhihudaily.base.dagger.component.DaggerAppComponent;
import usst.lei.copyzhihudaily.base.dagger.module.AppModule;

/**
 * Created by hchen on 2016/3/14.
 */
public class MainApplicatiom  extends Application{
    private  DaggerAppComponent daggerAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        daggerAppComponent= (DaggerAppComponent) DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public DaggerAppComponent getAppComponent(){
        return daggerAppComponent;
    }
}
