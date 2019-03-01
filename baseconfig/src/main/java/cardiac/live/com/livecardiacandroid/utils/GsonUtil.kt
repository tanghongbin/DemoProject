package cardiac.live.com.livecardiacandroid.utils

import com.google.gson.Gson

/**
 * @author 汤洪斌
 * @time 2019/3/1 0001
 * @version 1.0
 *@describe
 */
class GsonUtil{
    companion object {
        val gson = Gson()
        fun toJsonStr(any: Any):String{
           return gson.toJson(any)
        }
    }
}