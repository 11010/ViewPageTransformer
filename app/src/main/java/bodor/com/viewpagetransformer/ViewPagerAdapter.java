package bodor.com.viewpagetransformer;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import bodor.com.viewpagetransformer.PlatFormData;
import bodor.com.viewpagetransformer.R;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class ViewPagerAdapter extends PagerAdapter{

    Activity activity;
    List<PlatFormData> data;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Activity activity, List<PlatFormData> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = activity.getLayoutInflater();
        View itemView = layoutInflater.inflate(R.layout.viewpager_item,container,false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);

//        set imageView and text
        imageView.setImageResource(data.get(position).getImageId());
        textView.setText(data.get(position).getName());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
/*
* 规律1:
不管是向左滑动还是向右滑动，动画可以作用在进入屏幕和退出屏幕的两个view上。
当我们向左滑动的时候，慢慢滑出到屏幕左边的view，然后直到看不见的，她的position的变化是从0.0到-1.0，而从右边进入屏幕的view的position的变化是从1.0到0.0，成为可见(当前)的page。
当我们向右滑动的时候，慢慢滑出到屏幕右边的view，然后直到看不见的，她的position的变化是从0.0到1.0，而从左边进入屏幕的view的position的变化是从-1.0到0.0，成为可见(当前)的page。
规律2：
   对于一个page即一个view，如果它的position小于0.0或者大于1.0的部分都是看不到的，在保持一个滑动方向不变的情况，越是继续滑动，可见范围会越来越小，不可见范围越来大，即将进入屏幕成为显示的page(view)的position位置越来越接近0.0，可见范围越来越大，只有当page（View）的position的位置为0.0的时候，它真的成为当前展示的page（View），然后其他的不可见的pageposition都是大于等于正负1.0。
规律3:
    我们都知道View的坐标系都是从左上角开始计算的。
所以我们在给ViewPager写动画的时候，就可以抓住这两个规律，开发切换动画。
那这样的话，我们上面的demo的动画逻辑代码，几个if判断和每个语句块中的代码逻辑就很好分析理解了。
*
*
* */