package com.vivo.push.c;

import java.util.List;

/* compiled from: OnSetTagsReceiveTask */
final class ad implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    ad(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    public final void run() {
        this.e.b.onSetTags(this.e.a, this.a, this.b, this.c, this.d);
    }
}
