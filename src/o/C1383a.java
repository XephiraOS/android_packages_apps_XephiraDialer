package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* compiled from: CardViewApi21Impl.java */
/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1383a implements InterfaceC1385c {
    @Override // o.InterfaceC1385c
    public void a(InterfaceC1384b interfaceC1384b) {
        k(interfaceC1384b, j(interfaceC1384b));
    }

    @Override // o.InterfaceC1385c
    public float b(InterfaceC1384b interfaceC1384b) {
        return e(interfaceC1384b) * 2.0f;
    }

    @Override // o.InterfaceC1385c
    public void c(InterfaceC1384b interfaceC1384b, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        interfaceC1384b.setCardBackground(new C1386d(colorStateList, f10));
        View cardView = interfaceC1384b.getCardView();
        cardView.setClipToOutline(true);
        cardView.setElevation(f11);
        k(interfaceC1384b, f12);
    }

    @Override // o.InterfaceC1385c
    public void d(InterfaceC1384b interfaceC1384b) {
        k(interfaceC1384b, j(interfaceC1384b));
    }

    @Override // o.InterfaceC1385c
    public float e(InterfaceC1384b interfaceC1384b) {
        return o(interfaceC1384b).d();
    }

    @Override // o.InterfaceC1385c
    public void f(InterfaceC1384b interfaceC1384b) {
        if (!interfaceC1384b.getUseCompatPadding()) {
            interfaceC1384b.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float j10 = j(interfaceC1384b);
        float e10 = e(interfaceC1384b);
        int ceil = (int) Math.ceil(C1387e.a(j10, e10, interfaceC1384b.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(C1387e.b(j10, e10, interfaceC1384b.getPreventCornerOverlap()));
        interfaceC1384b.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    @Override // o.InterfaceC1385c
    public float g(InterfaceC1384b interfaceC1384b) {
        return interfaceC1384b.getCardView().getElevation();
    }

    @Override // o.InterfaceC1385c
    public void h(InterfaceC1384b interfaceC1384b, float f10) {
        interfaceC1384b.getCardView().setElevation(f10);
    }

    @Override // o.InterfaceC1385c
    public ColorStateList i(InterfaceC1384b interfaceC1384b) {
        return o(interfaceC1384b).b();
    }

    @Override // o.InterfaceC1385c
    public float j(InterfaceC1384b interfaceC1384b) {
        return o(interfaceC1384b).c();
    }

    @Override // o.InterfaceC1385c
    public void k(InterfaceC1384b interfaceC1384b, float f10) {
        o(interfaceC1384b).g(f10, interfaceC1384b.getUseCompatPadding(), interfaceC1384b.getPreventCornerOverlap());
        f(interfaceC1384b);
    }

    @Override // o.InterfaceC1385c
    public float l(InterfaceC1384b interfaceC1384b) {
        return e(interfaceC1384b) * 2.0f;
    }

    @Override // o.InterfaceC1385c
    public void m(InterfaceC1384b interfaceC1384b, ColorStateList colorStateList) {
        o(interfaceC1384b).f(colorStateList);
    }

    @Override // o.InterfaceC1385c
    public void n(InterfaceC1384b interfaceC1384b, float f10) {
        o(interfaceC1384b).h(f10);
    }

    public final C1386d o(InterfaceC1384b interfaceC1384b) {
        return (C1386d) interfaceC1384b.getCardBackground();
    }

    @Override // o.InterfaceC1385c
    public void initStatic() {
    }
}
