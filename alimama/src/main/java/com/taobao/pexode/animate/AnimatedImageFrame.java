package com.taobao.pexode.animate;

import android.graphics.Bitmap;

public interface AnimatedImageFrame {
    void dispose();

    int getDurationMs();

    AnimatedDrawableFrameInfo getFrameInfo();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int i, int i2, Bitmap bitmap);
}
