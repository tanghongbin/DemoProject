package cardiac.live.com.livecardiacandroid;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.multidex.MultiDex;
import cardiac.live.com.baseconfig.BuildConfig;
import cardiac.live.com.livecardiacandroid.config.BuglyConfigration;
import cardiac.live.com.livecardiacandroid.constants.Constants;
import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.yiqihudong.imageutil.ContextManager;
import com.yiqihudong.imageutil.ImageSelectedHelper;

/**
 * @author 汤洪斌
 * @version 1.0
 * @time 2019/2/27 0027
 * @describe
 */
public class BaseApplication extends Application {

    public static BaseApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        // bugly 注册,并且只在主进程上报
        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLY_APPID,
                BuildConfig.DEBUG, new BuglyConfigration(this).getStrategy());

        // 路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);


        //图片选择注册
        ContextManager.init(this);
        ImageSelectedHelper.initProviderAuth(this, Constants.FILE_IMAGE_PROVIDER_PATH);

        // 内存泄漏安装
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //分包
        MultiDex.install(this);
    }
}
