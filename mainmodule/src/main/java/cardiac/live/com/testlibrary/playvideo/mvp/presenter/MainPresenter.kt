package cardiac.live.com.testlibrary.playvideo.mvp.presenter

import android.util.Log
import cardiac.live.com.livecardiacandroid.presenter.BasePresenter
import cardiac.live.com.testlibrary.playvideo.mvp.model.MainModel
import cardiac.live.com.testlibrary.playvideo.mvp.view.MainView

/**
 * @author 汤洪斌
 * @time 2019/3/1 0001
 * @version 1.0
 *@describe
 */

class MainPresenter(var mainView: MainView, var mainModel: MainModel) :
    BasePresenter<MainView, MainModel>(mainView, mainModel) {

    fun getList() {
        mainModel.getListInfo({
            mainView.refreshListView(it)
        }, {
            Log.i("TAG", "打印日志:$it")
        })
    }

}