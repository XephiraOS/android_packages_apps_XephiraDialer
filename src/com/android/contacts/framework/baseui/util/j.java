package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.text.TextPaint;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.statement.COUIStatementClickableSpan;

/* compiled from: LocalCOUIClickableSpan.kt */
/* loaded from: classes.dex */
public class j extends COUIStatementClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15933a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15934b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, boolean z10) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
        this.f15933a = context;
        this.f15934b = z10;
    }

    @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        kotlin.jvm.internal.i.f(ds, "ds");
        if (this.f15934b) {
            ds.setColor(COUIContextUtil.getAttrColor(this.f15933a, N0.c.f1848i));
        } else {
            super.updateDrawState(ds);
        }
    }
}
