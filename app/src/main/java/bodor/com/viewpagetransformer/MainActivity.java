package bodor.com.viewpagetransformer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    ViewPager pager;
    private PlatFormData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(MainActivity.this,getData());
        pager.setAdapter(adapter);
        pager.setPageTransformer(true,new DepthPageTransformer());
    }

    private List<PlatFormData> getData() {

    List<PlatFormData> lstResult = new ArrayList<>();
        data = new PlatFormData();
        data.name = "haha";
        data.imageId = R.drawable.bg_1;
        lstResult.add(data);

        data = new PlatFormData();
        data.name = "heihei";
        data.imageId = R.drawable.bg_2;
        lstResult.add(data);

        data = new PlatFormData();
        data.name = "hehe";
        data.imageId = R.drawable.bg_3;
        lstResult.add(data);

        return lstResult;
    }
}
