package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.util.AttributeSet;
import com.android.incallui.oplus.widgets.ScaleImageView;
import g2.InterfaceC1038e;

/* compiled from: StaticAnswerImageView.kt */
/* loaded from: classes.dex */
public class StaticAnswerImageView extends ScaleImageView implements InterfaceC1038e {

    /* renamed from: g, reason: collision with root package name */
    public com.android.incallui.oplus.answerview.protocol.a f18797g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticAnswerImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // g2.InterfaceC1038e
    public com.android.incallui.oplus.answerview.protocol.a getMViewUserAction() {
        return this.f18797g;
    }

    @Override // g2.InterfaceC1038e
    public void setMViewUserAction(com.android.incallui.oplus.answerview.protocol.a aVar) {
        this.f18797g = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StaticAnswerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
