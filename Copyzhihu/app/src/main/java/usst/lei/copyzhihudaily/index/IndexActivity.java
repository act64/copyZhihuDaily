package usst.lei.copyzhihudaily.index;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import retrofit2.Retrofit;
import usst.lei.copyzhihudaily.R;
import usst.lei.copyzhihudaily.base.mvp.IView;
import usst.lei.copyzhihudaily.base.ui.BaseActivity;
import usst.lei.copyzhihudaily.index.mvp.IndexModel;
import usst.lei.copyzhihudaily.index.mvp.IndexPresenter;
import usst.lei.copyzhihudaily.readcontent.mvp.LatestModel;
import usst.lei.copyzhihudaily.readcontent.ui.MainActivity;

/**
 * Created by hchen on 2016/3/14.
 */
public class IndexActivity extends BaseActivity implements IView {

    IndexPresenter presenter;
    TextView tvName;
    ImageView ivIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        iniview();
        presenter=new IndexPresenter();
        presenter.onCreat();
        presenter.onAttach(this);
    }

    private void iniview(){
        tvName= (TextView) findViewById(R.id.tv_index);
        ivIndex= (ImageView) findViewById(R.id.iv_index);
    }

    public void paraseIndex(IndexModel indexModel){
        tvName.setText(indexModel.getText());
        Glide.with(this).load(indexModel.getImg()).into(ivIndex);
    }

    public void startMain(LatestModel latestModel){
        Intent i=new Intent(this, MainActivity.class);
        i.putExtra("latestModel",latestModel);
        startActivity(i);
        finish();
    }
}
