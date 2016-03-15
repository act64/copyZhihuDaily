package usst.lei.copyzhihudaily.readcontent.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import usst.lei.copyzhihudaily.R;
import usst.lei.copyzhihudaily.base.ui.BaseActivity;
import usst.lei.copyzhihudaily.readcontent.mvp.LatestModel;

/**
 * Created by hchen on 2016/3/15.
 */
public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    LatestModel latestModel;
    ViewPager vpTopStories;
    ArrayList<View> topStoryViews;
    int tsLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latestModel= (LatestModel) getIntent().getSerializableExtra("latestModel");
        iniView();
    }

    private void iniView(){
        vpTopStories= (ViewPager) findViewById(R.id.vp_topstorys);
        topStoryViews=new ArrayList<>();
        iniTopStoryViewpager();


    }

    private void iniTopStoryViewpager() {
        tsLength=latestModel.getTop_stories().size();
        for (int i=0;i<tsLength;i++) {
            View tempView= LayoutInflater.from(this).inflate(R.layout.item_topstorys, null);
            tempView.setTag(latestModel.getTop_stories().get(i));
            ((TextView)(tempView.findViewById(R.id.tv_item_topstory))).setText(latestModel.getTop_stories().get(i).getTitle());
            ImageView iv= (ImageView) tempView.findViewById(R.id.iv_item_topstory);
            Glide.with(this).load(latestModel.getTop_stories().get(i).getImage()).into(iv);
            topStoryViews.add(tempView);
        }
        if (tsLength>1){
            View tempViewpre=LayoutInflater.from(this).inflate(R.layout.item_topstorys, null);
            ((TextView)(tempViewpre.findViewById(R.id.tv_item_topstory))).setText(latestModel.getTop_stories().get(tsLength - 1).getTitle());
            ImageView iv0= (ImageView) tempViewpre.findViewById(R.id.iv_item_topstory);
            Glide.with(this).load(latestModel.getTop_stories().get(tsLength-1).getImage()).into(iv0);
            topStoryViews.add(0,tempViewpre);
            tempViewpre.setTag(latestModel.getTop_stories().get(tsLength - 1));
            View tempView=LayoutInflater.from(this).inflate(R.layout.item_topstorys, null);
            ((TextView)(tempView.findViewById(R.id.tv_item_topstory))).setText(latestModel.getTop_stories().get(0).getTitle());
            ImageView iv= (ImageView) tempView.findViewById(R.id.iv_item_topstory);
            Glide.with(this).load(latestModel.getTop_stories().get(0).getImage()).into(iv);
            topStoryViews.add(tempView);
            tempView.setTag(latestModel.getTop_stories().get(0));

        }
        TopStoryAdapter topStoryAdapter=new TopStoryAdapter();
        vpTopStories.setAdapter(topStoryAdapter);
        vpTopStories.addOnPageChangeListener(this);
        topStoryAdapter.notifyDataSetChanged();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (tsLength > 1) {// 多于一个view才会循环跳转
            if (position == 0 && positionOffsetPixels== 0) {
                // 切换循环更加流畅，不会出现生硬的切换感觉
                vpTopStories.setCurrentItem(tsLength, false);
            } else if (position > tsLength) {
                vpTopStories.setCurrentItem(1, false);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class TopStoryAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return topStoryViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(topStoryViews.get(position));
            return topStoryViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v=topStoryViews.get(position);
            ((ViewPager)(container)).removeView(v);
        }
    }
}
