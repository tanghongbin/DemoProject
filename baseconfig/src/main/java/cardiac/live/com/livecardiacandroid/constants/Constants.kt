package cardiac.live.com.livecardiacandroid.constants

import com.yiqihudong.imageutil.ImageSelectedHelper
import com.yiqihudong.imageutil.view.ImageSingleChooseActivity

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 各种常量的集合
 */
class RouteConstants {
    companion object {

        const val MAIN_ROUTE = "/main/mainActivity"
    }
}

/**
 * 网络请求常量
 */
class NetConstant {
    companion object {
        /**
         * 基础url
         */
        const val BASE_URL = "https://api.github.com/"
    }
}

class Constants {
    companion object {

        // 图片选择授权路径
        const val FILE_IMAGE_PROVIDER_PATH = ImageSingleChooseActivity.SPECIAL_CUSTOM_URL_HEADER + "cardiac.live"
        // Bugly appid
        const val BUGLY_APPID = "b1333535af"
    }
}