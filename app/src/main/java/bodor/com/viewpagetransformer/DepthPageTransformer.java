package bodor.com.viewpagetransformer;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer{
    private static final float MIN_SCALE = 0.75F;

    @Override
    public void transformPage(View page, float position) {
    int pagetWidth = page.getWidth();
        Log.e("hello",position+"");
        if (position < -1) {
            page.setAlpha(0);
        }else if (position<=0){
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setTranslationY(1);//?问题在哪？
        }else if (position<=1){
            page.setAlpha(1-position);
            page.setTranslationX(pagetWidth *= position);//问题同上
            float scaleFactor = MIN_SCALE + (1-MIN_SCALE)*(1-Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }else {
            page.setAlpha(0);
        }

    }
}
