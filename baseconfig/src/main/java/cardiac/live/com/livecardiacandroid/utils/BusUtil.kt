package cardiac.live.com.livecardiacandroid.utils

import org.greenrobot.eventbus.EventBus

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 时间注册与通知工具类
 */

class BusUtil {
    companion object {

        /**
        @author 汤洪斌
        @time 2019/2/27 0027 16:39
        @version 1.0
        @describe 事件注册
         */
        fun registe(arg: Any) {
            EventBus.getDefault().register(arg)
        }


        /**
        @author 汤洪斌
        @time 2019/2/27 0027 16:40
        @version 1.0
        @describe 取消事件注册对象,registe以后必须要调用这个方法
         */
        fun unRegiste(arg: Any) {
            EventBus.getDefault().unregister(arg)
        }


        /**
        @author 汤洪斌
        @time 2019/2/27 0027 16:42
        @version 1.0
        @describe 发送事件
        */
        fun postEvent(event: Any) {
            EventBus.getDefault().postSticky(event)
        }


    }
}