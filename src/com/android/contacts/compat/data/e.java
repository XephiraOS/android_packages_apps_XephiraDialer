package com.android.contacts.compat.data;

import kotlin.jvm.internal.i;

/* compiled from: IUriKeyMapping.kt */
/* loaded from: classes.dex */
public interface e extends b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f14111c = a.f14112a;

    /* compiled from: IUriKeyMapping.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f14112a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static e f14113b;

        public final e a() {
            e eVar = f14113b;
            if (eVar != null) {
                return eVar;
            }
            i.q("inst");
            return null;
        }

        public final void b(e eVar) {
            i.f(eVar, "<set-?>");
            f14113b = eVar;
        }
    }
}
