package com.android.incallui.oplus.answerview.protocol;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.SwipeAnswerImageView;
import g2.InterfaceC1034a;
import kotlin.jvm.internal.f;
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
public final class VoiceAnswerBtnBehavior implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18759a;

    /* renamed from: b, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18760b;

    /* renamed from: c, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18761c;

    /* renamed from: d, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18762d;

    /* renamed from: e, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18763e;

    /* renamed from: f, reason: collision with root package name */
    public static final VoiceAnswerBtnBehavior f18764f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ VoiceAnswerBtnBehavior[] f18765g;
    private final int mBGColorRes;
    private final int mContentDescription;
    private final int mImageRes;
    private final boolean mIsNeedRotation;
    private final boolean mIsNeedWaveAnimation;

    static {
        int i10 = R.drawable.incall_btn_voice_answer;
        int i11 = R.color.incallAnswerViewGreenTintControlNormal;
        int i12 = R.string.description_target_answer;
        boolean z10 = false;
        f18759a = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VOICE_MODE", 0, i10, i11, i12, true, z10, 16, null);
        int i13 = R.drawable.incall_btn_as_voice_answer;
        int i14 = R.color.incallAsVoiceAnswerViewTranslucentGreenTintControlNormal;
        int i15 = R.string.description_target_answer_audio_call;
        int i16 = 24;
        f fVar = null;
        boolean z11 = false;
        boolean z12 = false;
        f18760b = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VIDEO_MODE", 1, i13, i14, i15, z11, z12, i16, fVar);
        f18761c = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VOICE_VOWIFI_MODE", 2, R.drawable.incall_btn_vowifi_voice_answer, i11, i12, z11, z12, i16, fVar);
        int i17 = 24;
        f fVar2 = null;
        boolean z13 = false;
        f18762d = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VIDEO_VOWIFI_MODE", 3, R.drawable.incall_btn_vowifi_as_voice_answer, i14, i15, z10, z13, i17, fVar2);
        f18763e = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VOICE_BLUETOOTH_MODE", 4, R.drawable.incall_btn_bluetooth_voice_answer, i11, i12, z11, z12, i16, fVar);
        f18764f = new VoiceAnswerBtnBehavior("VOICE_ANSWER_IN_VIDEO_BLUETOOTH_MODE", 5, R.drawable.incall_btn_bluetooth_as_voice_answer, i14, i15, z10, z13, i17, fVar2);
        f18765g = c();
    }

    public VoiceAnswerBtnBehavior(String str, int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        this.mImageRes = i11;
        this.mBGColorRes = i12;
        this.mContentDescription = i13;
        this.mIsNeedWaveAnimation = z10;
        this.mIsNeedRotation = z11;
    }

    public static final /* synthetic */ VoiceAnswerBtnBehavior[] c() {
        return new VoiceAnswerBtnBehavior[]{f18759a, f18760b, f18761c, f18762d, f18763e, f18764f};
    }

    public static VoiceAnswerBtnBehavior valueOf(String str) {
        return (VoiceAnswerBtnBehavior) Enum.valueOf(VoiceAnswerBtnBehavior.class, str);
    }

    public static VoiceAnswerBtnBehavior[] values() {
        return (VoiceAnswerBtnBehavior[]) f18765g.clone();
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
        i.f(context, "context");
        if (interfaceC1034a != null) {
            interfaceC1034a.onAnswer(0, context, i10);
        }
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void b(View view) {
        ImageView imageView;
        String str;
        SwipeAnswerImageView swipeAnswerImageView = null;
        if (view != null) {
            Context context = view.getContext();
            if (context != null) {
                str = context.getString(this.mContentDescription);
            } else {
                str = null;
            }
            view.setContentDescription(str);
        }
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

    public final boolean d() {
        return this.mIsNeedRotation;
    }

    public final boolean e() {
        return this.mIsNeedWaveAnimation;
    }

    public /* synthetic */ VoiceAnswerBtnBehavior(String str, int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14, f fVar) {
        this(str, i10, i11, i12, (i14 & 4) != 0 ? R.string.description_target_answer : i13, (i14 & 8) != 0 ? false : z10, (i14 & 16) != 0 ? false : z11);
    }
}
