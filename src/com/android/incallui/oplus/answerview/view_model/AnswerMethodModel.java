package com.android.incallui.oplus.answerview.view_model;

import com.android.incallui.AnswerPresenter;
import com.android.incallui.InCallPresenter;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: AnswerMethodModel.kt */
/* loaded from: classes.dex */
public abstract class AnswerMethodModel extends BaseViewModel {

    /* renamed from: d, reason: collision with root package name */
    public final AnswerPresenter f18856d;

    /* renamed from: e, reason: collision with root package name */
    public final y<Boolean> f18857e;

    public AnswerMethodModel() {
        AnswerPresenter answerPresenter = InCallPresenter.getInstance().getAnswerPresenter();
        i.e(answerPresenter, "getInstance().answerPresenter");
        this.f18856d = answerPresenter;
        h<Boolean> hVar = answerPresenter.mUiIsShowing;
        i.e(hVar, "mAnswerPresenter.mUiIsShowing");
        this.f18857e = IgnoreEqualsLiveDataKt.C(hVar, false, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.answerview.view_model.AnswerMethodModel$mUiIsShowing$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Boolean bool) {
                return bool;
            }
        }, 1, null);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18857e.q(this.f18856d.mUiIsShowing);
    }

    public final AnswerPresenter h() {
        return this.f18856d;
    }

    public final y<Boolean> i() {
        return this.f18857e;
    }
}
