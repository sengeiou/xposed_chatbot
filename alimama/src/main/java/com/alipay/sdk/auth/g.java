package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.alipay.sdk.data.c;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.widget.a;

public class g {
    private static final String a = "com.eg.android.AlipayGphone";
    private static final int b = 65;
    /* access modifiers changed from: private */
    public static a c;
    /* access modifiers changed from: private */
    public static String d;

    private static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            if (packageInfo != null && packageInfo.versionCode >= 65) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Activity activity, APAuthInfo aPAuthInfo) {
        b.a().a(activity, c.b());
        if (a((Context) activity)) {
            b(activity, aPAuthInfo);
        } else {
            c(activity, aPAuthInfo);
        }
    }

    private static void b(Activity activity, APAuthInfo aPAuthInfo) {
        a(activity, "alipayauth://platformapi/startapp" + "?appId=20000122" + "&approveType=005" + "&scope=kuaijie" + "&productId=" + aPAuthInfo.getProductId() + "&thirdpartyId=" + aPAuthInfo.getAppId() + "&redirectUri=" + aPAuthInfo.getRedirectUri());
    }

    private static void c(Activity activity, APAuthInfo aPAuthInfo) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    c = new a(activity, a.a);
                    c.b();
                }
            } catch (Exception unused) {
                c = null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=");
        sb.append(aPAuthInfo.getAppId());
        sb.append("&partner=");
        sb.append(aPAuthInfo.getPid());
        sb.append("&scope=kuaijie");
        sb.append("&login_goal=auth");
        sb.append("&redirect_url=");
        sb.append(aPAuthInfo.getRedirectUri());
        sb.append("&view=wap");
        sb.append("&prod_code=");
        sb.append(aPAuthInfo.getProductId());
        new Thread(new h(activity, sb, aPAuthInfo)).start();
    }

    public static void a(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
