package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int i) {
        this.capacityHint = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.size
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001a
            int r0 = r4.capacityHint
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.head = r0
            java.lang.Object[] r0 = r4.head
            r4.tail = r0
            java.lang.Object[] r0 = r4.head
            r0[r1] = r5
            r4.indexInTail = r2
            r4.size = r2
            goto L_0x0047
        L_0x001a:
            int r0 = r4.indexInTail
            int r3 = r4.capacityHint
            if (r0 != r3) goto L_0x0037
            int r0 = r4.capacityHint
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.tail
            int r1 = r4.capacityHint
            r5[r1] = r0
            r4.tail = r0
            r4.indexInTail = r2
            int r5 = r4.size
            int r5 = r5 + r2
            r4.size = r5
            goto L_0x0047
        L_0x0037:
            java.lang.Object[] r0 = r4.tail
            int r1 = r4.indexInTail
            r0[r1] = r5
            int r5 = r4.indexInTail
            int r5 = r5 + r2
            r4.indexInTail = r5
            int r5 = r4.size
            int r5 = r5 + r2
            r4.size = r5
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.LinkedArrayList.add(java.lang.Object):void");
    }

    public Object[] head() {
        return this.head;
    }

    public Object[] tail() {
        return this.tail;
    }

    public int size() {
        return this.size;
    }

    public int indexInTail() {
        return this.indexInTail;
    }

    public int capacityHint() {
        return this.capacityHint;
    }

    /* access modifiers changed from: package-private */
    public List<Object> toList() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] head2 = head();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(head2[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    head2 = head2[i];
                }
            }
            return arrayList;
        }
    }

    public String toString() {
        return toList().toString();
    }
}
