package usst.lei.copyzhihudaily.base.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import usst.lei.copyzhihudaily.base.dagger.module.AppModule;
import usst.lei.copyzhihudaily.base.dagger.module.PresenterModule;
import usst.lei.copyzhihudaily.base.ui.BaseActivity;
import usst.lei.copyzhihudaily.index.mvp.IndexPresenter;

/**
 * Created by hchen on 2016/3/14.
 */
@Singleton
@Component(modules = {AppModule.class, PresenterModule.class})
public interface AppComponent  {
    void inject(IndexPresenter indexPresenter);
}
