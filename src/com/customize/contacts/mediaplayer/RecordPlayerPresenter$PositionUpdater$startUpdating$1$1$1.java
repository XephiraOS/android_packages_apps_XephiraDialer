package com.customize.contacts.mediaplayer;

import E3.j;
import android.text.TextUtils;
import android.widget.TextView;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.util.C0801l;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Ref$ObjectRef<String> $durationText;
    final /* synthetic */ Ref$LongRef $seekBarMax;
    final /* synthetic */ Ref$LongRef $seekBarPositionMs;
    final /* synthetic */ Ref$ObjectRef<String> $seekbarText;
    int label;
    final /* synthetic */ RecordPlayerPresenter.PositionUpdater this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1(RecordPlayerPresenter.PositionUpdater positionUpdater, Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2, kotlin.coroutines.c<? super RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = positionUpdater;
        this.$seekBarMax = ref$LongRef;
        this.$seekBarPositionMs = ref$LongRef2;
        this.$seekbarText = ref$ObjectRef;
        this.$durationText = ref$ObjectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1(this.this$0, this.$seekBarMax, this.$seekBarPositionMs, this.$seekbarText, this.$durationText, cVar);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.Object, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        j.f fVar;
        COUISeekBar cOUISeekBar;
        j.f fVar2;
        COUISeekBar cOUISeekBar2;
        j.f fVar3;
        CharSequence charSequence;
        j.f fVar4;
        CharSequence charSequence2;
        j.f fVar5;
        TextView textView;
        j.f fVar6;
        TextView textView2;
        TextView textView3;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            fVar = this.this$0.f21675c;
            TextView textView4 = null;
            if (fVar != null) {
                cOUISeekBar = fVar.f597n;
            } else {
                cOUISeekBar = null;
            }
            if (cOUISeekBar != null) {
                cOUISeekBar.setMax((int) this.$seekBarMax.element);
            }
            fVar2 = this.this$0.f21675c;
            if (fVar2 != null) {
                cOUISeekBar2 = fVar2.f597n;
            } else {
                cOUISeekBar2 = null;
            }
            if (cOUISeekBar2 != null) {
                cOUISeekBar2.setProgress((int) this.$seekBarPositionMs.element);
            }
            Ref$ObjectRef<String> ref$ObjectRef = this.$seekbarText;
            ?? e10 = C0801l.e((int) this.$seekBarPositionMs.element);
            i.e(e10, "formatAsMinutesAndSecond…eekBarPositionMs.toInt())");
            ref$ObjectRef.element = e10;
            Ref$ObjectRef<String> ref$ObjectRef2 = this.$durationText;
            ?? e11 = C0801l.e((int) this.$seekBarMax.element);
            i.e(e11, "formatAsMinutesAndSeconds(seekBarMax.toInt())");
            ref$ObjectRef2.element = e11;
            String str = this.$durationText.element;
            fVar3 = this.this$0.f21675c;
            if (fVar3 != null && (textView3 = fVar3.f599p) != null) {
                charSequence = textView3.getText();
            } else {
                charSequence = null;
            }
            if (!TextUtils.equals(str, charSequence)) {
                fVar6 = this.this$0.f21675c;
                if (fVar6 != null) {
                    textView2 = fVar6.f599p;
                } else {
                    textView2 = null;
                }
                if (textView2 != null) {
                    textView2.setText(this.$durationText.element);
                }
            }
            String str2 = this.$seekbarText.element;
            fVar4 = this.this$0.f21675c;
            if (fVar4 != null && (textView = fVar4.f598o) != null) {
                charSequence2 = textView.getText();
            } else {
                charSequence2 = null;
            }
            if (!TextUtils.equals(str2, charSequence2)) {
                fVar5 = this.this$0.f21675c;
                if (fVar5 != null) {
                    textView4 = fVar5.f598o;
                }
                if (textView4 != null) {
                    textView4.setText(this.$seekbarText.element);
                }
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$PositionUpdater$startUpdating$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
