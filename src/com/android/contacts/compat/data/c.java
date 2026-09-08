package com.android.contacts.compat.data;

import kotlin.jvm.internal.i;

/* compiled from: ISettingsKeyMapping.kt */
/* loaded from: classes.dex */
public interface c extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14105a = a.f14106a;

    /* compiled from: ISettingsKeyMapping.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f14106a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static c f14107b;

        public final c a() {
            c cVar = f14107b;
            if (cVar != null) {
                return cVar;
            }
            i.q("inst");
            return null;
        }

        public final void b(c cVar) {
            i.f(cVar, "<set-?>");
            f14107b = cVar;
        }
    }
}
