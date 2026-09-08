package U7;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.coui.appcompat.clickablespan.COUIClickableSpan;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: SpanUtils.kt */
/* loaded from: classes3.dex */
public final class d {

    /* compiled from: SpanUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1637a<q> f3874a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f3875b;

        public a(InterfaceC1637a<q> interfaceC1637a, Integer num) {
            this.f3874a = interfaceC1637a;
            this.f3875b = num;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            i.f(view, "view");
            this.f3874a.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            i.f(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.f3875b.intValue());
            ds.setUnderlineText(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final SpannableString b(Context context, CharSequence contentText, CharSequence clickText, Integer num, final InterfaceC1637a<q> onClick) {
        a aVar;
        int J10;
        i.f(context, "context");
        i.f(contentText, "contentText");
        i.f(clickText, "clickText");
        i.f(onClick, "onClick");
        SpannableString spannableString = new SpannableString(contentText);
        if (num == null) {
            COUIClickableSpan cOUIClickableSpan = new COUIClickableSpan(context);
            cOUIClickableSpan.setStatusBarClickListener(new COUIClickableSpan.SpannableStrClickListener() { // from class: U7.c
                @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
                public final void onClick() {
                    d.c(InterfaceC1637a.this);
                }
            });
            aVar = cOUIClickableSpan;
        } else {
            aVar = new a(onClick, num);
        }
        J10 = StringsKt__StringsKt.J(contentText, clickText.toString(), 0, false, 6, null);
        spannableString.setSpan(aVar, J10, clickText.length() + J10, 33);
        return spannableString;
    }

    public static final void c(InterfaceC1637a onClick) {
        i.f(onClick, "$onClick");
        onClick.invoke();
    }
}
