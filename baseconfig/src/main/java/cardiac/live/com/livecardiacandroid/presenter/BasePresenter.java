package cardiac.live.com.livecardiacandroid.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import cardiac.live.com.livecardiacandroid.model.IModel;
import cardiac.live.com.livecardiacandroid.utils.RxLifecycleUtils;
import cardiac.live.com.livecardiacandroid.view.IView;
import com.uber.autodispose.AutoDisposeConverter;
import org.jetbrains.annotations.NotNull;

/**
 * @author 汤洪斌
 * @version 1.0
 * @time 2019/3/1 0001
 * @describe
 */
public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    /**
     * @author 汤洪斌
     * @time 2019/3/1 0001 10:45
     * @version 1.0
     * @describe view模型基类
     */
    protected V iView;


    /**
     * @author 汤洪斌
     * @time 2019/3/1 0001 10:46
     * @version 1.0
     * @describe 数据处理模型基类
     */
    protected M mModel;


    public BasePresenter(V rootView, M model) {
        this.iView = rootView;
        this.mModel = model;
    }

}

