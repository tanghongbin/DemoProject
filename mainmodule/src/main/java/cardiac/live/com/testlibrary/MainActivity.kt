package cardiac.live.com.testlibrary

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import cardiac.live.com.livecardiacandroid.activity.BaseActivity
import cardiac.live.com.livecardiacandroid.constants.RouteConstants
import cardiac.live.com.livecardiacandroid.utils.GsonUtil
import cardiac.live.com.livecardiacandroid.utils.ImageUtil
import cardiac.live.com.testlibrary.adapter.TestAdapter
import cardiac.live.com.testlibrary.playvideo.mvp.model.MainModel
import cardiac.live.com.testlibrary.playvideo.mvp.presenter.MainPresenter
import cardiac.live.com.testlibrary.playvideo.mvp.view.MainView
import com.alibaba.android.arouter.facade.annotation.Route
import com.yiqihudong.imageutil.ImageSelectedHelper
import com.yiqihudong.imageutil.view.ImageCropCallback
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

@Route(path = RouteConstants.MAIN_ROUTE)
class MainActivity : BaseActivity<MainPresenter>(), MainView {
    override fun <E> refreshListView(list: List<E>) {
        Log.i("TAG","打印数据列表${GsonUtil.toJsonStr(list)}")
    }


    override fun getResourceId(): Int {
        return R.layout.activity_main
    }


    override fun init() {
        var mAdapter = TestAdapter(
            R.layout.main_test_item, Arrays.asList(
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3694566976,3597221850&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3509973531,4044189914&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3694566976,3597221850&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3509973531,4044189914&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg",
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3694566976,3597221850&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3509973531,4044189914&fm=27&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1548525155,1032715394&fm=27&gp=0.jpg"
            )
        )
        mRecycleView.layoutManager = GridLayoutManager(this, 4)
        mRecycleView.adapter = mAdapter

        mButton.setOnClickListener {
            ImageSelectedHelper.selectSinglePic(this, object : ImageCropCallback {
                override fun call(url: String?) {
                    ImageUtil.loadImage(url!!, mShowImage)
                }
            })
        }

        mPresenter = MainPresenter(this, MainModel(this))
        mPresenter!!.getList()

//        DaggerTestComponent.builder().testModule(TestModule()).build().inject(this)

    }
}
