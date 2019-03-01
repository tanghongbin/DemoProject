package cardiac.live.com.testlibrary.playvideo.mvp.view

import cardiac.live.com.livecardiacandroid.view.IView

/**
 * @author 汤洪斌
 * @time 2019/3/1 0001
 * @version 1.0
 *@describe
 */
interface MainView:IView {
    fun <E>refreshListView(list:List<E>)
}