package cardiac.live.com.testlibrary.playvideo.mvp.model

import androidx.appcompat.app.AppCompatActivity
import cardiac.live.com.livecardiacandroid.model.IModel
import cardiac.live.com.livecardiacandroid.net.RetrofitManager
import cardiac.live.com.livecardiacandroid.utils.RxLifecycleUtils
import cardiac.live.com.testlibrary.playvideo.api.MainApi
import cardiac.live.com.testlibrary.playvideo.bean.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author 汤洪斌
 * @time 2019/3/1 0001
 * @version 1.0
 *@describe
 */

class MainModel(val mActivity: AppCompatActivity) : IModel {

    fun getListInfo(func: (List<Repo>) -> Unit, error: (String?) -> Unit) {
        var mainApi = RetrofitManager.getRetrofit().create(MainApi::class.java)
        var observer = mainApi.listRepos("octocat")
        observer.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .`as`(RxLifecycleUtils.bindLifecycle(mActivity))
            .subscribe(
                {
                    func(it)
                }, {
                    error(it.message)
                }
            )
    }
}