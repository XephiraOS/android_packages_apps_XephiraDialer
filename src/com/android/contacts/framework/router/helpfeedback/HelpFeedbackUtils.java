package com.android.contacts.framework.router.helpfeedback;

import k1.InterfaceC1207a;
import kotlin.a;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: HelpFeedbackUtils.kt */
/* loaded from: classes.dex */
public final class HelpFeedbackUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final HelpFeedbackUtils f16335a = new HelpFeedbackUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final String f16336b = "origin_from_page";

    /* renamed from: c, reason: collision with root package name */
    public static final d f16337c;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<InterfaceC1207a>() { // from class: com.android.contacts.framework.router.helpfeedback.HelpFeedbackUtils$helpFeedback$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InterfaceC1207a invoke() {
                return (InterfaceC1207a) A8.a.f202a.a(InterfaceC1207a.class);
            }
        });
        f16337c = b10;
    }

    public static final void a(int i10) {
        InterfaceC1207a b10 = f16335a.b();
        if (b10 != null) {
            b10.a(i10);
        }
    }

    public final InterfaceC1207a b() {
        return (InterfaceC1207a) f16337c.getValue();
    }
}
