package com.vivo.push.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: BaseSharePreference */
public class a {
    protected Context a;
    private String b;
    private volatile SharedPreferences c;
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<String, Long> e = new HashMap<>();
    private HashMap<String, Integer> f = new HashMap<>();
    private HashMap<String, Boolean> g = new HashMap<>();

    public final void a(Context context, String str) {
        if (!(context instanceof Application)) {
            throw new RuntimeException("you can't invoke this in other sContext but Application, in case memory leak");
        } else if (!TextUtils.isEmpty(str)) {
            this.b = str;
            this.c = context.getSharedPreferences(this.b, 0);
            this.a = context;
        } else {
            throw new RuntimeException("sharedFileName can't be null");
        }
    }

    public final void a(String str, String str2) {
        this.d.put(str, str2);
        b();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final void a(String str, int i) {
        this.f.put(str, Integer.valueOf(i));
        b();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putInt(str, i);
            a(edit);
        }
    }

    public final void a(String str, long j) {
        this.e.put(str, Long.valueOf(j));
        b();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putLong(str, j);
            a(edit);
        }
    }

    public final String a(String str) {
        String str2 = this.d.get(str);
        if (str2 != null) {
            return str2;
        }
        b();
        if (this.c != null) {
            str2 = this.c.getString(str, (String) null);
            if (!TextUtils.isEmpty(str2) && !str2.equals((Object) null)) {
                this.d.put(str, str2);
            }
        }
        return str2;
    }

    public final int b(String str) {
        Integer num = this.f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.c != null) {
            num = Integer.valueOf(this.c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final long b(String str, long j) {
        Long l = this.e.get(str);
        if (l != null) {
            return l.longValue();
        }
        b();
        if (this.c != null) {
            l = Long.valueOf(this.c.getLong(str, j));
            if (!l.equals(Long.valueOf(j))) {
                this.e.put(str, l);
            }
        }
        return l.longValue();
    }

    public final void c(String str) {
        this.e.remove(str);
        this.f.remove(str);
        this.g.remove(str);
        this.d.remove(str);
        b();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            if (this.c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }

    public final void a() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        b();
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.clear();
            a(edit);
        }
    }

    private void b() {
        if (this.c != null) {
            return;
        }
        if (this.a != null) {
            this.c = this.a.getSharedPreferences(this.b, 0);
            return;
        }
        throw new RuntimeException("SharedPreferences is not init", new Throwable());
    }
}
