package com.oplus.foundation.appsupport.ui.widget.recyclerview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.i;
import m7.g;

/* compiled from: AppSupportRecyclerView.kt */
/* loaded from: classes3.dex */
public class AppSupportRecyclerView extends PercentWidthRecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f28222a;

    /* renamed from: b, reason: collision with root package name */
    public int f28223b;

    /* renamed from: c, reason: collision with root package name */
    public int f28224c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28225d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppSupportRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent action) {
        i.f(action, "action");
        try {
            Result.a aVar = Result.f34166a;
            if (this.f28222a) {
                return false;
            }
            return super.dispatchTouchEvent(action);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(b.a(th)));
            if (d10 != null) {
                H7.b.c("AppSupportRecyclerView", "e = " + d10);
            }
            return false;
        }
    }

    @Override // com.coui.appcompat.grid.COUIPercentWidthRecyclerView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f28223b > 0) {
            Object systemService = getContext().getSystemService("window");
            i.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            this.f28224c = ((WindowManager) systemService).getCurrentWindowMetrics().getBounds().width();
        }
    }

    @Override // android.view.View
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        i.f(event, "event");
        boolean onFilterTouchEventForSecurity = super.onFilterTouchEventForSecurity(event);
        if (this.f28223b > 0 && this.f28224c > 0 && onFilterTouchEventForSecurity) {
            int action = event.getAction() & 255;
            if (action == 0 || action == 5) {
                float x10 = event.getX();
                if (x10 < this.f28223b || x10 > this.f28224c - r0) {
                    return false;
                }
            }
            return true;
        }
        return onFilterTouchEventForSecurity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        try {
            Result.a aVar = Result.f34166a;
            if (!this.f28225d) {
                super.onSaveInstanceState();
                return null;
            }
            return super.onSaveInstanceState();
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Throwable d10 = Result.d(Result.b(b.a(th)));
            if (d10 != null) {
                H7.b.e("AppSupportRecyclerView", "e = " + d10);
            }
            return null;
        }
    }

    public final void setDisallowReceiveTouchEvent(boolean z10) {
        if (z10) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent event = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            event.setSource(4098);
            i.e(event, "event");
            dispatchTouchEvent(event);
            event.recycle();
        }
        this.f28222a = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSupportRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f28225d = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f35452v);
        i.e(obtainStyledAttributes, "context.obtainStyledAttr…e.AppSupportRecyclerView)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(g.f35464x, 0);
        this.f28223b = dimensionPixelSize;
        if (dimensionPixelSize > 0) {
            Object systemService = context.getSystemService("window");
            i.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            this.f28224c = ((WindowManager) systemService).getCurrentWindowMetrics().getBounds().width();
        }
        this.f28225d = obtainStyledAttributes.getBoolean(g.f35458w, true);
        obtainStyledAttributes.recycle();
    }
}
