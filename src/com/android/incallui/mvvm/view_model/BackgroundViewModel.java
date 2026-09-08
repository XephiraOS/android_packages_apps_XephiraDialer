package com.android.incallui.mvvm.view_model;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.telecom.VideoProfile;
import android.util.Log;
import android.view.Display;
import com.android.incallui.Call;
import com.android.incallui.R;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.b;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import e2.C0968c;
import e2.C0969d;
import f2.c;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.g;
import v9.InterfaceC1637a;
import v9.p;
import v9.q;

/* compiled from: BackgroundViewModel.kt */
/* loaded from: classes.dex */
public final class BackgroundViewModel extends BaseViewModel {

    /* renamed from: j, reason: collision with root package name */
    public static final a f18670j = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final y<Integer> f18671d;

    /* renamed from: e, reason: collision with root package name */
    public final y<Drawable> f18672e;

    /* renamed from: f, reason: collision with root package name */
    public final y<Drawable> f18673f;

    /* renamed from: g, reason: collision with root package name */
    public final y<ColorDrawable> f18674g;

    /* renamed from: h, reason: collision with root package name */
    public final y<Matrix> f18675h;

    /* renamed from: i, reason: collision with root package name */
    public final y<Boolean> f18676i;

    /* compiled from: BackgroundViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public BackgroundViewModel() {
        List j10;
        c cVar = c.f31677a;
        h<Drawable> b10 = cVar.b();
        h<C0968c> e10 = cVar.e();
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        h<BitmapDrawable> D12 = responsiveConfigRepository.D1();
        y<Boolean> a02 = responsiveConfigRepository.a0();
        h<Boolean> g10 = cVar.g();
        h<Integer> d10 = cVar.d();
        h<Integer> f10 = cVar.f();
        VideoBackgroundUseCase videoBackgroundUseCase = VideoBackgroundUseCase.f18569a;
        j10 = o.j(b10, e10, D12, a02, g10, d10, f10, videoBackgroundUseCase.l(), videoBackgroundUseCase.j());
        y<Integer> x10 = IgnoreEqualsLiveDataKt.x(j10, true, new InterfaceC1637a<Integer>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mBackgroundState$1
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                Drawable value;
                int i10;
                c cVar2 = c.f31677a;
                if (C0969d.a(cVar2.e().getValue())) {
                    i10 = 1;
                } else {
                    if (Call.State.isInComming(cVar2.d().getValue().intValue())) {
                        VideoBackgroundUseCase videoBackgroundUseCase2 = VideoBackgroundUseCase.f18569a;
                        if (videoBackgroundUseCase2.l().getValue() != null && videoBackgroundUseCase2.j().getValue().intValue() == 2) {
                            i10 = 4;
                        }
                    }
                    if (cVar2.g().getValue().booleanValue() || (value = cVar2.b().getValue()) == null || b.a(value) || (VideoProfile.isBidirectional(cVar2.f().getValue().intValue()) && (Call.State.isConnectingOrDialing(cVar2.d().getValue().intValue()) || Call.State.isActiveOrHold(cVar2.d().getValue().intValue())))) {
                        i10 = 3;
                    } else {
                        i10 = 2;
                    }
                }
                if (i10 == 3 && ResponsiveConfigRepository.f18540a.a0().getValue().booleanValue()) {
                    i10 = 0;
                }
                Integer valueOf = Integer.valueOf(i10);
                Log.d("BackgroundViewModel", "backgroundState change " + a.f18720d.a(i10));
                return valueOf;
            }
        });
        this.f18671d = x10;
        this.f18672e = IgnoreEqualsLiveDataKt.A(IgnoreEqualsLiveDataKt.s(g.a(x10, responsiveConfigRepository.D1()), cVar.e()), null, true, new q<Integer, BitmapDrawable, C0968c, Drawable>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mBackgroundDrawable$1
            {
                super(3);
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
            
                if (r3 != 3) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final android.graphics.drawable.Drawable b(int r3, android.graphics.drawable.BitmapDrawable r4, e2.C0968c r5) {
                /*
                    r2 = this;
                    if (r3 == 0) goto L2d
                    r0 = 1
                    r1 = 0
                    if (r3 == r0) goto Lb
                    r2 = 3
                    if (r3 == r2) goto L3e
                L9:
                    r4 = r1
                    goto L3e
                Lb:
                    if (r5 == 0) goto L9
                    com.android.incallui.mvvm.view_model.BackgroundViewModel r2 = com.android.incallui.mvvm.view_model.BackgroundViewModel.this
                    android.graphics.drawable.LayerDrawable r3 = new android.graphics.drawable.LayerDrawable
                    android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable
                    int r5 = r5.a()
                    r4.<init>(r5)
                    android.content.Context r2 = r2.g()
                    int r5 = com.android.incallui.R.drawable.omoji_mask
                    android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
                    android.graphics.drawable.Drawable[] r2 = new android.graphics.drawable.Drawable[]{r4, r2}
                    r3.<init>(r2)
                    r4 = r3
                    goto L3e
                L2d:
                    android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable
                    com.android.incallui.mvvm.view_model.BackgroundViewModel r2 = com.android.incallui.mvvm.view_model.BackgroundViewModel.this
                    android.content.Context r2 = r2.g()
                    int r3 = com.android.incallui.R.color.incall_black_color
                    int r2 = r2.getColor(r3)
                    r4.<init>(r2)
                L3e:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "backgroundDrawable change "
                    r2.append(r3)
                    r2.append(r4)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = "BackgroundViewModel"
                    android.util.Log.d(r3, r2)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.mvvm.view_model.BackgroundViewModel$mBackgroundDrawable$1.b(int, android.graphics.drawable.BitmapDrawable, e2.c):android.graphics.drawable.Drawable");
            }

            @Override // v9.q
            public /* bridge */ /* synthetic */ Drawable d(Integer num, BitmapDrawable bitmapDrawable, C0968c c0968c) {
                return b(num.intValue(), bitmapDrawable, c0968c);
            }
        });
        y<Drawable> A10 = IgnoreEqualsLiveDataKt.A(IgnoreEqualsLiveDataKt.s(g.a(x10, cVar.b()), cVar.e()), null, true, new q<Integer, Drawable, C0968c, Drawable>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mSrcDrawable$1
            public final Drawable b(int i10, Drawable drawable, C0968c c0968c) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 4) {
                            drawable = VideoBackgroundUseCase.f18569a.l().getValue();
                        }
                        drawable = null;
                    }
                } else {
                    if (c0968c != null) {
                        drawable = c0968c.b();
                    }
                    drawable = null;
                }
                Log.d("BackgroundViewModel", "srcDrawable change " + drawable);
                return drawable;
            }

            @Override // v9.q
            public /* bridge */ /* synthetic */ Drawable d(Integer num, Drawable drawable, C0968c c0968c) {
                return b(num.intValue(), drawable, c0968c);
            }
        });
        this.f18673f = A10;
        this.f18674g = IgnoreEqualsLiveDataKt.A(IgnoreEqualsLiveDataKt.s(g.a(x10, cVar.d()), videoBackgroundUseCase.j()), null, true, new q<Integer, Integer, Integer, ColorDrawable>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mForegroundDrawable$1
            {
                super(3);
            }

            public final ColorDrawable b(int i10, int i11, int i12) {
                ColorDrawable colorDrawable;
                if (i10 != 0 && i10 != 4 && (i10 != 1 || !Call.State.isInComming(i11) || i12 == 2)) {
                    colorDrawable = new ColorDrawable(BackgroundViewModel.this.g().getColor(R.color.incall_background_foreground_color));
                } else {
                    colorDrawable = null;
                }
                Log.d("BackgroundViewModel", "foregroundDrawable change " + colorDrawable);
                return colorDrawable;
            }

            @Override // v9.q
            public /* bridge */ /* synthetic */ ColorDrawable d(Integer num, Integer num2, Integer num3) {
                return b(num.intValue(), num2.intValue(), num3.intValue());
            }
        });
        this.f18675h = IgnoreEqualsLiveDataKt.z(g.a(responsiveConfigRepository.c0(), A10), true, new p<Pair<? extends Integer, ? extends Integer>, Drawable, Matrix>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mMatrix$1
            {
                super(2);
            }

            @Override // v9.p
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Matrix invoke(Pair<Integer, Integer> pair, Drawable drawable) {
                i.f(pair, "<anonymous parameter 0>");
                int intValue = BackgroundViewModel.this.i().getValue().intValue();
                Log.d("BackgroundViewModel", ": matrix change start " + a.f18720d.a(intValue));
                Matrix matrix = null;
                if ((intValue == 1 || intValue == 4) && drawable != null) {
                    Point point = new Point();
                    Display display = BackgroundViewModel.this.g().getDisplay();
                    if (display != null) {
                        display.getRealSize(point);
                    }
                    int i10 = point.y;
                    int i11 = point.x;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    float f11 = i10;
                    float f12 = intrinsicHeight;
                    float f13 = (1.0f * f11) / f12;
                    if (intrinsicHeight > 0 && intrinsicWidth > 0) {
                        matrix = new Matrix();
                        matrix.setScale(f13, f13);
                        matrix.postTranslate((i11 - (intrinsicWidth * f13)) * 0.5f, (f11 - (f12 * f13)) * 0.5f);
                    }
                }
                Log.d("BackgroundViewModel", "src matrix change " + matrix);
                return matrix;
            }
        });
        this.f18676i = IgnoreEqualsLiveDataKt.z(g.a(x10, cVar.d()), true, new p<Integer, Integer, Boolean>() { // from class: com.android.incallui.mvvm.view_model.BackgroundViewModel$mIsBlur$1
            public final Boolean b(int i10, int i11) {
                boolean z10 = false;
                if (i10 != 4 && (i10 != 2 || !Call.State.isConnectingOrDialingOrIncomming(i11))) {
                    if (i10 != 1 || !Call.State.isInComming(i11)) {
                        z10 = true;
                    }
                    Log.d("BackgroundViewModel", "blurState change " + z10);
                }
                return Boolean.valueOf(z10);
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2) {
                return b(num.intValue(), num2.intValue());
            }
        });
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        Log.d("BackgroundViewModel", "onCleared: ");
        this.f18672e.o(null);
        this.f18673f.o(null);
        this.f18674g.o(null);
        this.f18675h.o(null);
    }

    public final y<Drawable> h() {
        return this.f18672e;
    }

    public final y<Integer> i() {
        return this.f18671d;
    }

    public final y<ColorDrawable> j() {
        return this.f18674g;
    }

    public final y<Boolean> k() {
        return this.f18676i;
    }

    public final y<Matrix> l() {
        return this.f18675h;
    }

    public final y<Drawable> m() {
        return this.f18673f;
    }
}
