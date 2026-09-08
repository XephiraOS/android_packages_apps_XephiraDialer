package a6;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import l6.g;

/* compiled from: LPaint.java */
/* renamed from: a6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0423a extends Paint {
    public C0423a() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i10) {
        super.setAlpha(g.c(i10, 0, 255));
    }

    public C0423a(int i10) {
        super(i10);
    }

    public C0423a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public C0423a(int i10, PorterDuff.Mode mode) {
        super(i10);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
