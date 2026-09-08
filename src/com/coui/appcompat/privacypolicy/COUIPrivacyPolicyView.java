package com.coui.appcompat.privacypolicy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIPrivacyPolicyView.kt */
/* loaded from: classes.dex */
public class COUIPrivacyPolicyView extends LinearLayout {

    /* compiled from: COUIPrivacyPolicyView.kt */
    /* loaded from: classes.dex */
    public static final class Section extends LinearLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Section(Context context) {
            super(context);
            i.f(context, "context");
        }

        @Override // android.view.ViewGroup
        public void addView(View child) {
            i.f(child, "child");
            COUIPrivacyPolicyViewKt.overrideChildLp(this, child);
            super.addView(child);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPrivacyPolicyView(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    @Override // android.view.View
    public final void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPrivacyPolicyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPrivacyPolicyView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUIPrivacyPolicyView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIPrivacyPolicyView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        setOrientation(1);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
    }
}
