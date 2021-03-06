package com.taobao.weex.devtools.trace;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.WXA;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXDiv;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXHeader;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXInput;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.WXSlider;
import com.taobao.weex.ui.component.WXSwitch;
import com.taobao.weex.ui.component.WXText;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.WXVideo;
import com.taobao.weex.ui.component.list.HorizontalListComponent;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.WXEditText;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewUtils {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static final Map<Class, String> sVDomMap = new HashMap();

    private ViewUtils() {
    }

    static {
        sVDomMap.put(WXComponent.class, WXBridgeManager.COMPONENT);
        sVDomMap.put(WXText.class, "text");
        sVDomMap.put(WXVContainer.class, "container");
        sVDomMap.put(WXDiv.class, WXBasicComponentType.DIV);
        sVDomMap.put(WXEditText.class, WXBasicComponentType.TEXTAREA);
        sVDomMap.put(WXA.class, "a");
        sVDomMap.put(WXInput.class, "input");
        sVDomMap.put(WXLoading.class, "loading");
        sVDomMap.put(WXScroller.class, WXBasicComponentType.SCROLLER);
        sVDomMap.put(WXSwitch.class, "switch");
        sVDomMap.put(WXSlider.class, WXBasicComponentType.SLIDER);
        sVDomMap.put(WXVideo.class, "video");
        sVDomMap.put(WXImage.class, "image");
        sVDomMap.put(WXHeader.class, "header");
        sVDomMap.put(WXEmbed.class, WXBasicComponentType.EMBED);
        sVDomMap.put(WXListComponent.class, WXBasicComponentType.LIST);
        sVDomMap.put(HorizontalListComponent.class, WXBasicComponentType.HLIST);
        sVDomMap.put(WXCell.class, WXBasicComponentType.CELL);
    }

    @NonNull
    public static String getComponentName(@NonNull WXComponent wXComponent) {
        String str = sVDomMap.get(wXComponent.getClass());
        return TextUtils.isEmpty(str) ? WXBridgeManager.COMPONENT : str;
    }

    public static float dp2px(@NonNull Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static float sp2px(@NonNull Context context, int i) {
        return TypedValue.applyDimension(2, (float) i, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(@NonNull Context context, float f) {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static int getScreenHeight(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static boolean isVerticalScroller(@NonNull WXScroller wXScroller) {
        return (wXScroller == null || wXScroller.getAttrs() == null || !"vertical".equals(wXScroller.getAttrs().getScrollDirection())) ? false : true;
    }

    @Nullable
    public static WXComponent getNestedRootComponent(@NonNull WXEmbed wXEmbed) {
        try {
            Field declaredField = wXEmbed.getClass().getDeclaredField("mNestedInstance");
            declaredField.setAccessible(true);
            WXSDKInstance wXSDKInstance = (WXSDKInstance) declaredField.get(wXEmbed);
            if (wXSDKInstance == null) {
                return null;
            }
            return wXSDKInstance.getRootComponent();
        } catch (Exception e) {
            WXLogUtils.e(e.getMessage());
            return null;
        }
    }

    public static double findSuitableVal(double d, int i) {
        if (d <= 0.0d || i <= 0) {
            return 0.0d;
        }
        int i2 = (int) d;
        while (i2 % i != 0) {
            i2++;
        }
        return (double) i2;
    }

    public static int generateViewId() {
        int i;
        int i2;
        do {
            i = sNextGeneratedId.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(i, i2));
        return i;
    }
}
