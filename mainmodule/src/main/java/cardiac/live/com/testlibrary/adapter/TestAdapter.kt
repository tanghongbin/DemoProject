package cardiac.live.com.testlibrary.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cardiac.live.com.livecardiacandroid.utils.BusUtil
import cardiac.live.com.livecardiacandroid.utils.ImageUtil
import cardiac.live.com.testlibrary.R
import cardiac.live.com.testlibrary.R.id.mImage
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.main_test_item.view.*

/**
 * @author 汤洪斌
 * @time 2019/2/27 0027
 * @version 1.0
 *@describe 测试适配器
 */
class TestAdapter(layoutId:Int,data:MutableList<String>) : BaseQuickAdapter<String, BaseViewHolder>(layoutId,data) {
    override fun convert(helper: BaseViewHolder, item: String?) {
        ImageUtil.loadImage(item!!,helper!!.getView(R.id.mImage) as ImageView)
    }

}