package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.bindingx.DXBindingXConstant;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;

public class NavigationChannel {
    private static final String TAG = "NavigationChannel";
    @NonNull
    public final MethodChannel channel;

    public NavigationChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
    }

    public void setInitialRoute(@NonNull String str) {
        Log.v(TAG, "Sending message to set initial route to '" + str + DXBindingXConstant.SINGLE_QUOTE);
        this.channel.invokeMethod("setInitialRoute", str);
    }

    public void pushRoute(@NonNull String str) {
        Log.v(TAG, "Sending message to push route '" + str + DXBindingXConstant.SINGLE_QUOTE);
        this.channel.invokeMethod("pushRoute", str);
    }

    public void popRoute() {
        Log.v(TAG, "Sending message to pop route.");
        this.channel.invokeMethod("popRoute", (Object) null);
    }

    public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler methodCallHandler) {
        this.channel.setMethodCallHandler(methodCallHandler);
    }
}
