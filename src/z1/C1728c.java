package z1;

import android.text.TextUtils;

/* compiled from: ProtocolHelper.java */
/* renamed from: z1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1728c {
    public static A1.c a(AbstractC1729d abstractC1729d, com.android.contacts.voicemail.impl.b bVar) {
        int b10 = bVar.b();
        String h10 = bVar.h();
        if (TextUtils.isEmpty(h10)) {
            H7.b.i("ProtocolHelper", "No destination number for this carrier.");
            return null;
        }
        return abstractC1729d.a(bVar.g(), bVar.k(), (short) b10, h10);
    }
}
