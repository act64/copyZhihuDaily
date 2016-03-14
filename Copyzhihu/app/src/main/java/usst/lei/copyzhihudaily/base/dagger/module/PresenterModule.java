
package usst.lei.copyzhihudaily.base.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import usst.lei.copyzhihudaily.index.mvp.IndexPresenter;

/**
 * Created by hchen on 2016/3/14.
 */
@Module
public class PresenterModule  {
    @Provides
    @Singleton
    IndexPresenter getPresenter(){
        return new IndexPresenter();
    }
}