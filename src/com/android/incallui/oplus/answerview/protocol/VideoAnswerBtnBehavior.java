package com.android.incallui.oplus.answerview.protocol;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import g2.InterfaceC1034a;
import kotlin.jvm.internal.i;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: AnswerViewBehavior.kt */
/* loaded from: classes.dex */
public final class VideoAnswerBtnBehavior implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final VideoAnswerBtnBehavior f18755a;

    /* renamed from: b, reason: collision with root package name */
    public static final VideoAnswerBtnBehavior f18756b;

    /* renamed from: c, reason: collision with root package name */
    public static final VideoAnswerBtnBehavior f18757c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ VideoAnswerBtnBehavior[] f18758d;
    private final int mBGColorRes;
    private final int mImageRes;

    static {
        int i10 = R.drawable.incall_btn_video_answer;
        int i11 = R.color.incallAnswerViewGreenTintControlNormal;
        f18755a = new VideoAnswerBtnBehavior("VIDEO_ANSWER_IN_VIDEO_MODE", 0, i10, i11);
        f18756b = new VideoAnswerBtnBehavior("VIDEO_ANSWER_IN_VOWIFI_MODE", 1, R.drawable.incall_btn_vowifi_video_answer, i11);
        f18757c = new VideoAnswerBtnBehavior("VIDEO_ANSWER_IN_BLUETOOTH_MODE", 2, R.drawable.incall_btn_bluetooth_video_answer, i11);
        f18758d = c();
    }

    public VideoAnswerBtnBehavior(String str, int i10, int i11, int i12) {
        this.mImageRes = i11;
        this.mBGColorRes = i12;
    }

    public static final /* synthetic */ VideoAnswerBtnBehavior[] c() {
        return new VideoAnswerBtnBehavior[]{f18755a, f18756b, f18757c};
    }

    public static VideoAnswerBtnBehavior valueOf(String str) {
        return (VideoAnswerBtnBehavior) Enum.valueOf(VideoAnswerBtnBehavior.class, str);
    }

    public static VideoAnswerBtnBehavior[] values() {
        return (VideoAnswerBtnBehavior[]) f18758d.clone();
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
        i.f(context, "context");
        if (interfaceC1034a != null) {
            interfaceC1034a.onAnswer(3, context, i10);
        }
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void b(View view) {
        ImageView imageView;
        SwipeAnswerImageView swipeAnswerImageView = null;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setImageResource(this.mImageRes);
        }
        if (view instanceof SwipeAnswerImageView) {
            swipeAnswerImageView = (SwipeAnswerImageView) view;
        }
        if (swipeAnswerImageView != null) {
            swipeAnswerImageView.p(this.mBGColorRes);
        }
    }
}
