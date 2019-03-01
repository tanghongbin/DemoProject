package cardiac.live.com.livecardiacandroid.net

import android.util.Log
import cardiac.live.com.baseconfig.BuildConfig
import cardiac.live.com.livecardiacandroid.constants.NetConstant
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe Retrofit网络请求管理类
 */
object RetrofitManager {

    /**
    @author 汤洪斌
    @time 2019/3/1 0001 11:15
    @version 1.0
    @describe 获取retrofit实例
     */
    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(NetConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(buildClient())
            .build()
        return retrofit
    }

    /**
    @author 汤洪斌
    @time 2019/3/1 0001 12:33
    @version 1.0
    @describe 构建OkHttpClient的实例
     */
    private fun buildClient(): OkHttpClient {
        var logger = HttpLoggingInterceptor.Logger {
            if (BuildConfig.DEBUG) {
                Log.i("HttpRequestInfo:", it)
            }
        }
        var logInterceptor = HttpLoggingInterceptor(logger)//创建拦截对象
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        var client = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(8, 10, TimeUnit.MINUTES))
            .readTimeout(60 * 2, TimeUnit.SECONDS)
            .addNetworkInterceptor(logInterceptor)  //设置打印拦截日志
            .build()
        return client
    }
}