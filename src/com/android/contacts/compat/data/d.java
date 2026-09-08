package com.android.contacts.compat.data;

import kotlin.jvm.internal.i;

/* compiled from: IStringKeyMapping.kt */
/* loaded from: classes.dex */
public interface d extends b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f14108b = a.f14109a;

    /* compiled from: IStringKeyMapping.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f14109a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static d f14110b;

        public final d a() {
            d dVar = f14110b;
            if (dVar != null) {
                return dVar;
            }
            i.q("inst");
            return null;
        }

        public final void b(d dVar) {
            i.f(dVar, "<set-?>");
            f14110b = dVar;
        }
    }
}
