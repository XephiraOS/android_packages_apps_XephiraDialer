package j5;

import P4.g;

/* compiled from: QRCodeDecoderMetaData.java */
/* renamed from: j5.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1167e {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f33880a;

    public C1167e(boolean z10) {
        this.f33880a = z10;
    }

    public void a(g[] gVarArr) {
        if (this.f33880a && gVarArr != null && gVarArr.length >= 3) {
            g gVar = gVarArr[0];
            gVarArr[0] = gVarArr[2];
            gVarArr[2] = gVar;
        }
    }
}
