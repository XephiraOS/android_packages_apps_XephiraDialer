package com.android.incallui.foldscreen.presentation.model;

import J1.e;
import J1.f;
import J1.g;
import androidx.lifecycle.LiveData;
import com.android.incallui.Log;
import com.android.incallui.clean.domain.bean.CallUiType;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: FoldScreenControllerModel.kt */
/* loaded from: classes.dex */
public final class FoldScreenControllerModel {

    /* renamed from: f, reason: collision with root package name */
    public static final a f18443f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final g f18444a;

    /* renamed from: b, reason: collision with root package name */
    public final J1.a f18445b;

    /* renamed from: c, reason: collision with root package name */
    public final f f18446c;

    /* renamed from: d, reason: collision with root package name */
    public final e f18447d;

    /* renamed from: e, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18448e;

    /* compiled from: FoldScreenControllerModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public FoldScreenControllerModel() {
        Y1.a aVar = Y1.a.f5520a;
        g g10 = aVar.g();
        this.f18444a = g10;
        this.f18445b = aVar.a();
        f e10 = aVar.e();
        this.f18446c = e10;
        this.f18447d = aVar.d();
        this.f18448e = new NonNullObservableField<>(new LiveData[]{e10.b()}, new NonNullObservableField[]{g10.d()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.foldscreen.presentation.model.FoldScreenControllerModel$activityLaunchTrigger$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                f fVar;
                g gVar;
                boolean z11;
                fVar = FoldScreenControllerModel.this.f18446c;
                boolean b10 = i.b(fVar.b().getValue(), Boolean.TRUE);
                gVar = FoldScreenControllerModel.this.f18444a;
                CallUiType s02 = gVar.d().s0();
                Log.d("FoldScreenControllerModel", "activityLaunchTrigger: isFlipped = " + b10 + ", uiType = " + s02);
                if (b10 && s02 != CallUiType.TYPE_DEFAULT) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
    }

    public final NonNullObservableField<Boolean> c() {
        return this.f18448e;
    }

    public final void d() {
        this.f18447d.a().b();
        this.f18444a.a().b();
        this.f18446c.a().b();
        this.f18445b.a().b();
    }
}
