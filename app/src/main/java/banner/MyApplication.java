package banner;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dubo.myapplication.R;

/**
 * Created by dubo on 2018/4/18.
 */

public class MyApplication extends Application {
    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    //屏幕的高
    public static int H;

    @Override
    public void onCreate() {
        super.onCreate();
        String[] urls = getResources().getStringArray(R.array.url4);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        String[] tips = getResources().getStringArray(R.array.title);
        titles= Arrays.asList(tips);

        initBanner();//初始化Banner
    }

    private void initBanner() {
        H=getScreenH(this);
        Fresco.initialize(this);

//        //让软件状态还原的框架
//        Recovery.getInstance()
//                .debug(true)
//                .recoverInBackground(false)
//                .recoverStack(true)
//                .mainPage(MyMainActivity.class)
//                .init(this);


    }

    /**
     * 得到屏幕的高
     * @param aty
     * @return
     */
    public int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
