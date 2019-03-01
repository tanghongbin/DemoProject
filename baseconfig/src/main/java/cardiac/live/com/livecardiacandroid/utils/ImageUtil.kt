package cardiac.live.com.livecardiacandroid.utils

import android.widget.ImageView
import cardiac.live.com.baseconfig.R
import cardiac.live.com.livecardiacandroid.BaseApplication
import cardiac.live.com.livecardiacandroid.net.Urls
import com.bumptech.glide.Glide

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 图片工具
 */

class ImageUtil {
    companion object {
        fun loadImage(url: String, image: ImageView) {
            Glide
                .with(BaseApplication.INSTANCE)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(image)
        }
    }
}