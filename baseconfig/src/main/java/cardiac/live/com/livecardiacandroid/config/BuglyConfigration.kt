package cardiac.live.com.livecardiacandroid.config

import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import android.app.Application.getProcessName
import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


/**
 * @author 汤洪斌
 * @time 2019/2/28 0028
 * @version 1.0
 *@describe bugly 上报的配置信息，进程控制等
 */


class BuglyConfigration(val mContext: Context) {

    /**
    @author 汤洪斌
    @time 2019/2/28 0028 9:22
    @version 1.0
    @describe 获取上报策略
     */
    fun getStrategy():UserStrategy  {

// 获取当前包名
        val packageName = mContext.getPackageName()
// 获取当前进程名
        val processName = getProcessName(android.os.Process.myPid())
// 设置是否为上报进程
        val strategy = UserStrategy(mContext)
        strategy.isUploadProcess = processName == null || processName == packageName
        return strategy
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader!!.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim({ it <= ' ' })
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                if (reader != null) {
                    reader!!.close()
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            }

        }
        return null
    }
}