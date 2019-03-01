package cardiac.live.com.livecardiacandroid.utils;

import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

/**
 * @author 汤洪斌
 * @version 1.0
 * @time 2019/3/1 0001 10:41
 * @describe 生命周期工具类
 */
public class RxLifecycleUtils {

    private RxLifecycleUtils() {
        throw new IllegalStateException("Can't instance the RxLifecycleUtils");
    }

    /**
     * @author 汤洪斌
     * @time 2019/3/1 0001 10:41
     * @version 1.0
     * @describe 绑定到具体的生命周期对象里
     */
    public static <T> AutoDisposeConverter<T> bindLifecycle(LifecycleOwner lifecycleOwner) {
        return AutoDispose.autoDisposable(
                AndroidLifecycleScopeProvider.from(lifecycleOwner)
        );
    }
}
