package cardiac.live.com.livecardiacandroid.utils

import android.app.Activity
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 常用的一些工具
 */

class Utils {
    companion object {
        fun routeNavigation(route:String){
            ARouter.getInstance().build(route).navigation()
        }
    }
}