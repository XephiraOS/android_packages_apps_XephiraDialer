package com.android.contacts.framework.baseui.util;

/* compiled from: SimpleCallback.kt */
/* loaded from: classes.dex */
public interface t {

    /* compiled from: SimpleCallback.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ void a(t tVar, int i10, Object obj, Object obj2, int i11, Object obj3) {
            if (obj3 == null) {
                if ((i11 & 4) != 0) {
                    obj2 = null;
                }
                tVar.a(i10, obj, obj2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCall");
        }
    }

    void a(int i10, Object obj, Object obj2);
}
