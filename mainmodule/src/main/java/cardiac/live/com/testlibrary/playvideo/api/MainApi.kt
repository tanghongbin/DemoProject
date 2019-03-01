package cardiac.live.com.testlibrary.playvideo.api

import cardiac.live.com.testlibrary.playvideo.bean.Repo
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author 汤洪斌
 * @time 2019/3/1 0001
 * @version 1.0
 *@describe
 */

interface MainApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>>

}