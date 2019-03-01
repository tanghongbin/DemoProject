package cardiac.live.com.livecardiacandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cardiac.live.com.livecardiacandroid.presenter.IPresenter
import com.alibaba.android.arouter.launcher.ARouter
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 公共基类
 */

abstract class BaseActivity<P : IPresenter> : AppCompatActivity() {
    protected lateinit var rxPermission: RxPermissions

    var mPresenter: P? = null

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResourceId())
        initConfig()
        init()
    }

    /**
    @author 汤洪斌
    @time 2019/3/1 0001 10:52
    @version 1.0
    @describe 配置些初始化参数
     */
    private fun initConfig() {
        // 路由
        ARouter.getInstance().inject(this)
        // 权限
        rxPermission = RxPermissions(this)


    }

    abstract fun getResourceId(): Int

    public abstract fun init()
}