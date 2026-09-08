package com.android.incallui;

import A2.c;
import O1.AbstractC0397c;
import O1.AbstractC0399e;
import O1.AbstractC0403i;
import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.incallui.Call;
import com.android.incallui.CallCardPresenter;
import com.android.incallui.mvvm.view_model.CallCardViewModel;
import com.android.incallui.oplus.widgets.LineFeedTextView;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.imageview.COUIRoundImageView;
import m2.C1327a;

/* loaded from: classes.dex */
public class OplusCallCardFragment extends BaseFragment<CallCardPresenter, CallCardPresenter.CallCardUi> implements CallCardPresenter.CallCardUi, View.OnClickListener, c.b {
    private static final int ANIM_FLAG_IS_ANIMATING_IN = 3;
    private static final int ANIM_FLAG_IS_ANIMATING_OUT = 2;
    private static final int ANIM_FLAG_NEEDLESS = 0;
    private static final int ANIM_FLAG_PREPARED = 1;
    private static final long DELAY_HIDE_FOR_CALL_CARD = 67;
    private static final long DELAY_HIDE_FOR_CALL_STATE = 133;
    private static final int DIALPAD_ANIM_FLAG_IS_ANIMATING = 1;
    private static final int DIALPAD_ANIM_FLAG_NOT_ANIMATING = 0;
    private static final long DURATION_HIDE_FOR_DIALPAD = 200;
    private static final long DURATION_SHOW_FOR_DIALPAD = 400;
    private static final String LOG_TAG = "OplusCallCardFragment";
    public static final int MSG_DISMISS_CALL_STATUS_PROMPT = 1001;
    private static final float SCALE_FOR_CALL_CARD = 0.98f;
    private static final float SCALE_FOR_CALL_STATE = 0.92f;
    private ConstraintLayout mCallCardInfoLayout;
    private CallCardViewModel mCallCardViewModel;
    private TextView mConferenceParticipantTextView;
    private LinearLayout mEmergencyLocationLayout;
    private TextView mEmergencyLocationTextView;
    private ImageView mPrimaryAvatarImageView;
    private LinearLayout mPrimaryCallStateLayout;
    private ImageView mPrimaryCardIconImageView;
    private ImageView mPrimaryHdIconImageView;
    LineFeedTextView mPrimaryLocationTextView;
    private TextView mPrimaryNameTextView;
    private TextView mPrimaryNumberTextView;
    private TextView mSecondaryCallConnectionLabelTextView;
    protected ImageView mSecondaryIconImageView;
    private LinearLayout mSecondaryInfoLayout;
    private TextView mSecondaryNameTextView;
    private TextView mVerifiedStatus;
    protected m2.c mSecondaryInfo = new m2.c();
    private final U5.b mRealImpl = U5.a.a();
    private boolean mIsOnlyShowCallStateFlag = false;
    private final PathInterpolator mPathInterpolator = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private m2.b mPrimaryInfo = new m2.b();
    private C1327a mPrimaryCallState = new C1327a();
    private boolean mIsResumed = false;
    private int mCallCardAnimFlag = 0;
    private int mDialpadAnimFlag = 0;
    private boolean mDialpadShowingFlag = isDialpadShow();
    private int mCallCardAnimationFlag = 0;
    private int mCallStateAnimationFlag = 0;
    private final Handler mHandler = new Handler() { // from class: com.android.incallui.OplusCallCardFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001 && OplusCallCardFragment.this.mCallCardViewModel != null) {
                OplusCallCardFragment.this.mCallCardViewModel.q().o("");
            }
        }
    };

    private void animateCallCardRefresh() {
        if (!getManageConferencePanelVisible() && !isDialpadShow() && this.mDialpadAnimFlag != 1) {
            final View view = getView();
            if (view == null) {
                return;
            }
            Log.d(LOG_TAG, "animateCallCardRefresh: ");
            this.mCallCardAnimFlag = 2;
            OplusAnimationUtils.fadeOut(view).setListener(new Animator.AnimatorListener() { // from class: com.android.incallui.OplusCallCardFragment.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.d(OplusCallCardFragment.LOG_TAG, "onAnimationCancel: fadeOut cancel");
                    if (OplusCallCardFragment.this.getManageConferencePanelVisible() || OplusCallCardFragment.this.isDialpadShow() || OplusCallCardFragment.this.mDialpadAnimFlag == 1) {
                        OplusCallCardFragment.this.updateCallCardContent();
                    }
                    View view2 = view;
                    if (view2 != null) {
                        view2.setAlpha(1.0f);
                    }
                    OplusCallCardFragment.this.mCallCardAnimFlag = 0;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).withEndAction(new Runnable() { // from class: com.android.incallui.C
                @Override // java.lang.Runnable
                public final void run() {
                    OplusCallCardFragment.this.lambda$animateCallCardRefresh$4(view);
                }
            }).start();
            return;
        }
        updateCallCardContent();
        this.mCallCardAnimFlag = 0;
    }

    private void changeToLoading() {
        setEmergencyCanPressed(false);
        this.mEmergencyLocationTextView.setText(R.string.em_loading_location);
    }

    private void changeToRetry() {
        setEmergencyCanPressed(true);
        this.mEmergencyLocationTextView.setText(R.string.em_retry_request_location);
    }

    private String getNumberViewDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("\u200e")) {
            return str.replaceAll("\u200e", "");
        }
        return str;
    }

    private boolean hasIncomingCall() {
        if (CallList.getInstance().oplusCallList().oplusGetIncomingCall() != null) {
            return true;
        }
        return false;
    }

    private void initConferenceParticipantTextView() {
        Log.d(LOG_TAG, "initConferenceParticipantTextView: ");
        View view = getView();
        if (view != null && this.mConferenceParticipantTextView == null) {
            int i10 = R.id.call_card_conference_participant;
            ViewStub viewStub = (ViewStub) view.findViewById(i10);
            if (viewStub != null) {
                viewStub.inflate();
                TextView textView = (TextView) view.findViewById(i10);
                this.mConferenceParticipantTextView = textView;
                textView.setOnClickListener(this);
            }
        }
    }

    private void initDataBindingParams(View view) {
        AbstractC0403i i12 = AbstractC0403i.i1(view);
        CallCardViewModel callCardViewModel = (CallCardViewModel) new androidx.lifecycle.K(this).a(CallCardViewModel.class);
        this.mCallCardViewModel = callCardViewModel;
        i12.k1(callCardViewModel);
        i12.b1(getViewLifecycleOwner());
        i12.f2571G.f2529J.l(new ViewStub.OnInflateListener() { // from class: com.android.incallui.y
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view2) {
                OplusCallCardFragment.this.lambda$initDataBindingParams$0(viewStub, view2);
            }
        });
        i12.f2571G.f2534O.l(new ViewStub.OnInflateListener() { // from class: com.android.incallui.z
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view2) {
                OplusCallCardFragment.this.lambda$initDataBindingParams$1(viewStub, view2);
            }
        });
    }

    private void initSecondaryInfoLayout() {
        Log.d(LOG_TAG, "initSecondaryInfoLayout: ");
        View view = getView();
        if (view != null && this.mSecondaryInfoLayout == null) {
            int i10 = R.id.call_card_secondary_info;
            ViewStub viewStub = (ViewStub) view.findViewById(i10);
            if (viewStub != null) {
                viewStub.inflate();
                this.mSecondaryInfoLayout = (LinearLayout) view.findViewById(i10);
                this.mSecondaryNameTextView = (TextView) view.findViewById(R.id.call_card_secondary_info_name);
                this.mSecondaryIconImageView = (ImageView) view.findViewById(R.id.call_card_secondary_sim_icon);
                this.mSecondaryCallConnectionLabelTextView = (TextView) view.findViewById(R.id.call_card_secondary_info_connectionLabel);
                this.mSecondaryInfoLayout.setOnClickListener(this);
            }
        }
    }

    private boolean isPrimaryCallVideo() {
        Call primaryCall = ((OplusCallCardPresenter) getPresenter()).getPrimaryCall();
        if (primaryCall != null && CallUtils.isBidirectionalVideoCall(primaryCall)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateCallCardRefresh$3() {
        this.mCallCardAnimFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateCallCardRefresh$4(final View view) {
        this.mCallCardAnimFlag = 3;
        updateCallCardContent();
        if (view == null) {
            this.mCallCardAnimFlag = 0;
        } else {
            OplusAnimationUtils.fadeIn(view).setListener(new Animator.AnimatorListener() { // from class: com.android.incallui.OplusCallCardFragment.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Log.d(OplusCallCardFragment.LOG_TAG, "onAnimationCancel: fadeIn cancel");
                    View view2 = view;
                    if (view2 != null) {
                        view2.setAlpha(1.0f);
                    }
                    OplusCallCardFragment.this.mCallCardAnimFlag = 0;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).withEndAction(new Runnable() { // from class: com.android.incallui.x
                @Override // java.lang.Runnable
                public final void run() {
                    OplusCallCardFragment.this.lambda$animateCallCardRefresh$3();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataBindingParams$0(ViewStub viewStub, View view) {
        ((AbstractC0397c) androidx.databinding.g.a(view)).b1(getViewLifecycleOwner());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataBindingParams$1(ViewStub viewStub, View view) {
        ((AbstractC0399e) androidx.databinding.g.a(view)).b1(getViewLifecycleOwner());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(Drawable drawable) {
        int i10;
        if (this.mCallCardAnimFlag == 0) {
            if (f2.c.f31677a.b().getValue() != this.mPrimaryInfo.a()) {
                Log.d(LOG_TAG, "primary avatar different return");
                return;
            }
            ImageView imageView = this.mPrimaryAvatarImageView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                ImageView imageView2 = this.mPrimaryAvatarImageView;
                if (drawable != null) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                imageView2.setVisibility(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCallCardFadeAnimation$5() {
        this.mCallCardAnimationFlag = 0;
        startCallStateShowAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCallCardShowAnimation$8() {
        this.mDialpadAnimFlag = 0;
        this.mCallCardAnimationFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCallStateFadeAnimation$7() {
        this.mCallStateAnimationFlag = 0;
        startCallCardShowAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCallStateShowAnimation$6() {
        this.mDialpadAnimFlag = 0;
        this.mCallStateAnimationFlag = 0;
    }

    private void layoutCallStateCenter() {
        this.mCallCardInfoLayout.setVisibility(8);
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.n().o(Boolean.FALSE);
        }
    }

    private void layoutCallStateDefault() {
        this.mCallCardInfoLayout.setVisibility(0);
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.n().o(Boolean.TRUE);
        }
    }

    private void layoutDefault() {
        Log.d(LOG_TAG, "layoutDefault: ");
        if (isDialpadShow()) {
            layoutCallStateCenter();
        } else {
            layoutCallStateDefault();
        }
        this.mPrimaryCallStateLayout.requestLayout();
    }

    private boolean needOnlyShowCallState(C1327a c1327a) {
        if (c1327a.j() && Call.State.isActiveOrHold(c1327a.f()) && this.mSecondaryInfo.g()) {
            return true;
        }
        return false;
    }

    private void prepareAnimFlagForPrimaryCallState(C1327a c1327a) {
        if (this.mIsResumed && !getManageConferencePanelVisible()) {
            if (this.mCallCardAnimFlag == 0 && needOnlyShowCallState(c1327a) != this.mIsOnlyShowCallStateFlag) {
                this.mCallCardAnimFlag = 1;
                return;
            }
            return;
        }
        this.mCallCardAnimFlag = 0;
    }

    private void prepareAnimFlagForPrimaryInfo(m2.b bVar, m2.b bVar2) {
        if (this.mIsResumed && !getManageConferencePanelVisible()) {
            if (this.mCallCardAnimFlag == 0 && !m2.b.f35077n.a(bVar, bVar2)) {
                this.mCallCardAnimFlag = 1;
                return;
            }
            return;
        }
        this.mCallCardAnimFlag = 0;
    }

    private void prepareAnimFlagForSecondaryInfo(m2.c cVar, m2.c cVar2) {
        if (this.mIsResumed && !getManageConferencePanelVisible()) {
            if (this.mCallCardAnimFlag != 0) {
                return;
            }
            if (cVar.g() != cVar2.g() || !m2.c.f35091g.a(cVar, cVar2)) {
                this.mCallCardAnimFlag = 1;
                return;
            }
            return;
        }
        this.mCallCardAnimFlag = 0;
    }

    private void setEmergencyCanPressed(boolean z10) {
        LinearLayout linearLayout = this.mEmergencyLocationLayout;
        if (linearLayout != null) {
            linearLayout.setEnabled(z10);
        }
    }

    private void setSecondaryContent(m2.c cVar) {
        String d10;
        int i10;
        if (this.mSecondaryInfoLayout == null) {
            return;
        }
        if (cVar.e()) {
            d10 = cVar.f();
        } else {
            d10 = cVar.d();
        }
        boolean z10 = !TextUtils.isEmpty(d10);
        LinearLayout linearLayout = this.mSecondaryInfoLayout;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.z().o(Boolean.valueOf(z10));
        }
        if (z10) {
            this.mSecondaryNameTextView.setText(d10);
            this.mSecondaryCallConnectionLabelTextView.setText(cVar.b());
        }
    }

    private void setTextToTextView(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    private void startCallCardFadeAnimation() {
        View view = getView();
        if (view == null) {
            return;
        }
        this.mDialpadShowingFlag = true;
        this.mDialpadAnimFlag = 1;
        this.mCallCardAnimationFlag = 1;
        view.animate().setDuration(200L).scaleX(SCALE_FOR_CALL_CARD).scaleY(SCALE_FOR_CALL_CARD).alpha(0.0f).translationZ(100.0f).setStartDelay(DELAY_HIDE_FOR_CALL_CARD).setInterpolator(this.mPathInterpolator).withEndAction(new Runnable() { // from class: com.android.incallui.w
            @Override // java.lang.Runnable
            public final void run() {
                OplusCallCardFragment.this.lambda$startCallCardFadeAnimation$5();
            }
        }).start();
    }

    private void startCallCardShowAnimation() {
        View view = getView();
        if (view == null) {
            this.mDialpadAnimFlag = 0;
            return;
        }
        if (this.mCallCardAnimFlag == 0) {
            view.setAlpha(0.0f);
            view.setScaleX(SCALE_FOR_CALL_CARD);
            view.setScaleY(SCALE_FOR_CALL_CARD);
            this.mPrimaryCallStateLayout.setAlpha(1.0f);
            this.mPrimaryCallStateLayout.setScaleY(1.0f);
            this.mPrimaryCallStateLayout.setScaleX(1.0f);
            layoutCallStateDefault();
            this.mPrimaryCallStateLayout.requestLayout();
        }
        this.mCallCardAnimationFlag = 1;
        view.animate().cancel();
        view.animate().setDuration(DURATION_SHOW_FOR_DIALPAD).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).withEndAction(new Runnable() { // from class: com.android.incallui.B
            @Override // java.lang.Runnable
            public final void run() {
                OplusCallCardFragment.this.lambda$startCallCardShowAnimation$8();
            }
        }).setInterpolator(this.mPathInterpolator).start();
    }

    private void startCallStateFadeAnimation() {
        LinearLayout linearLayout = this.mPrimaryCallStateLayout;
        if (linearLayout == null) {
            return;
        }
        this.mDialpadShowingFlag = false;
        this.mDialpadAnimFlag = 1;
        this.mCallStateAnimationFlag = 1;
        linearLayout.animate().setDuration(200L).alpha(0.0f).scaleX(SCALE_FOR_CALL_STATE).scaleY(SCALE_FOR_CALL_STATE).setInterpolator(this.mPathInterpolator).setStartDelay(DELAY_HIDE_FOR_CALL_STATE).withEndAction(new Runnable() { // from class: com.android.incallui.A
            @Override // java.lang.Runnable
            public final void run() {
                OplusCallCardFragment.this.lambda$startCallStateFadeAnimation$7();
            }
        }).start();
    }

    private void startCallStateShowAnimation() {
        View view = getView();
        if (view == null) {
            this.mDialpadAnimFlag = 0;
            return;
        }
        layoutCallStateCenter();
        this.mPrimaryCallStateLayout.requestLayout();
        if (this.mCallStateAnimationFlag == 0) {
            this.mPrimaryCallStateLayout.setAlpha(0.0f);
            this.mPrimaryCallStateLayout.setScaleX(SCALE_FOR_CALL_STATE);
            this.mPrimaryCallStateLayout.setScaleY(SCALE_FOR_CALL_STATE);
        }
        this.mCallStateAnimationFlag = 1;
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationZ(1.0f);
        this.mPrimaryCallStateLayout.animate().setDuration(DURATION_SHOW_FOR_DIALPAD).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(this.mPathInterpolator).withEndAction(new Runnable() { // from class: com.android.incallui.u
            @Override // java.lang.Runnable
            public final void run() {
                OplusCallCardFragment.this.lambda$startCallStateShowAnimation$6();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCallCardContent() {
        Log.d(LOG_TAG, "updateCallCardContent: ");
        updateCallTime();
        setPrimaryContent(this.mPrimaryInfo);
        setSecondaryContent(this.mSecondaryInfo);
        setCallStateContent(this.mPrimaryCallState);
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void displayManageConferencePanel(boolean z10) {
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().displayManageConferencePanel(z10);
        }
    }

    public boolean getManageConferencePanelVisible() {
        if (getInCallFragmentManager() != null) {
            return getInCallFragmentManager().f();
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public CallCardPresenter.CallCardUi getUi() {
        return this;
    }

    public boolean isDialpadShow() {
        if (getInCallFragmentManager() == null) {
            return false;
        }
        return getInCallFragmentManager().isDialpadVisible();
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public boolean isManageConferenceVisible() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.call_card_conference_participant) {
            getPresenter().manageConferenceButtonClicked();
            return;
        }
        if (id == R.id.call_card_primary_info_name) {
            TextView textView = this.mConferenceParticipantTextView;
            if (textView != null && textView.getVisibility() == 0) {
                getPresenter().manageConferenceButtonClicked();
                return;
            }
            return;
        }
        if (id == R.id.call_card_secondary_info) {
            getPresenter().secondaryInfoClicked();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onCreate...");
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onCreateView...");
        }
        super.onCreateView(layoutInflater, viewGroup, bundle);
        A2.c.d().b(this);
        View inflate = layoutInflater.inflate(R.layout.incall_call_card_layout, viewGroup, false);
        initDataBindingParams(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.n().o(Boolean.TRUE);
        }
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "onDestroyView ...");
        A2.c.d().f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsResumed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateCallTime();
        this.mIsResumed = true;
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mCallCardInfoLayout = (ConstraintLayout) view.findViewById(R.id.call_card_info_layout);
        this.mPrimaryAvatarImageView = (COUIRoundImageView) view.findViewById(R.id.call_card_primary_info_avatar);
        this.mPrimaryNameTextView = (TextView) view.findViewById(R.id.call_card_primary_info_name);
        this.mPrimaryNumberTextView = (TextView) view.findViewById(R.id.call_card_primary_info_number);
        this.mPrimaryLocationTextView = (LineFeedTextView) view.findViewById(R.id.call_card_primary_info_location);
        this.mPrimaryHdIconImageView = (ImageView) view.findViewById(R.id.call_card_primary_call_state_hd_icon);
        this.mPrimaryCallStateLayout = (LinearLayout) view.findViewById(R.id.call_card_primary_call_state);
        this.mVerifiedStatus = (TextView) view.findViewById(R.id.oplus_call_card_verification);
        this.mPrimaryNameTextView.setOnClickListener(this);
        this.mCallCardViewModel.h().i(getViewLifecycleOwner(), new androidx.lifecycle.w() { // from class: com.android.incallui.v
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusCallCardFragment.this.lambda$onViewCreated$2((Drawable) obj);
            }
        });
        this.mPrimaryCardIconImageView = (ImageView) view.findViewById(R.id.call_card_primary_call_state_card_icon);
        view.setZ(1.0f);
        getPresenter().init(getActivity(), CallList.getInstance().getFirstCall());
        super.onViewCreated(view, bundle);
    }

    @Override // com.android.incallui.BaseFragment
    public void releaseResources() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "releaseResources...");
        }
        super.releaseResources();
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setCallState(C1327a c1327a) {
        prepareAnimFlagForPrimaryCallState(c1327a);
        if (!TextUtils.equals(c1327a.d(), this.mPrimaryCallState.d()) || c1327a.i() != this.mPrimaryCallState.i()) {
            updateCallStatusPrompt("");
        }
        this.mPrimaryCallState = c1327a;
        Log.d(LOG_TAG, "setCallState: mAnimFlag=" + this.mCallCardAnimFlag + ", mCallState=" + this.mPrimaryCallState);
        int i10 = this.mCallCardAnimFlag;
        if (i10 == 1) {
            animateCallCardRefresh();
        } else if (i10 != 2) {
            setCallStateContent(this.mPrimaryCallState);
        }
    }

    public void setCallStateContent(C1327a c1327a) {
        String d10;
        boolean z10 = !this.mSecondaryInfo.g();
        boolean isRing = Call.State.isRing(c1327a.f());
        if (z10 && !isRing) {
            this.mPrimaryLocationTextView.setMaxItemForOriginText(1);
        } else {
            this.mPrimaryLocationTextView.setMaxItemForOriginText(Integer.MAX_VALUE);
        }
        int e10 = c1327a.e();
        c1327a.j();
        if (needOnlyShowCallState(c1327a)) {
            if (!this.mIsOnlyShowCallStateFlag) {
                layoutCallStateCenter();
            }
            this.mIsOnlyShowCallStateFlag = true;
        } else {
            if (this.mIsOnlyShowCallStateFlag) {
                layoutDefault();
            }
            this.mIsOnlyShowCallStateFlag = false;
        }
        if (e10 == -1) {
            this.mPrimaryHdIconImageView.setVisibility(8);
        } else {
            this.mPrimaryHdIconImageView.setImageResource(e10);
            this.mPrimaryHdIconImageView.setVisibility(0);
        }
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.w().o(Boolean.valueOf(c1327a.i()));
            com.android.incallui.mvvm.utils.h<String> l10 = this.mCallCardViewModel.l();
            if (c1327a.d() == null) {
                d10 = "";
            } else {
                d10 = c1327a.d();
            }
            l10.o(d10);
        }
        if (c1327a.h()) {
            if (c1327a.a()) {
                initConferenceParticipantTextView();
                TextView textView = this.mConferenceParticipantTextView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                int b10 = c1327a.b();
                if (getView() != null) {
                    setTextToTextView(this.mConferenceParticipantTextView, getView().getResources().getQuantityString(R.plurals.incall_conference_participant, b10, Integer.valueOf(b10)));
                }
            } else {
                TextView textView2 = this.mConferenceParticipantTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
        } else {
            setTextToTextView(this.mConferenceParticipantTextView, null);
        }
        CallCardViewModel callCardViewModel2 = this.mCallCardViewModel;
        if (callCardViewModel2 != null) {
            callCardViewModel2.v().o(Boolean.valueOf(Call.State.isRing(this.mPrimaryCallState.f())));
        }
        InCallPresenter.getInstance().realInstance().setIsShowSingleCallView(!c1327a.g());
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setDialpad(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "   mIsOnlyShowTimeForVideo = " + this.mIsOnlyShowCallStateFlag);
        }
        if (this.mIsOnlyShowCallStateFlag) {
            return;
        }
        if (z10 && this.mCallStateAnimationFlag == 1) {
            startCallStateShowAnimation();
            return;
        }
        if (z10 && this.mCallCardAnimationFlag == 1) {
            startCallCardFadeAnimation();
            return;
        }
        if (!z10 && this.mCallStateAnimationFlag == 1) {
            startCallStateFadeAnimation();
            return;
        }
        if (!z10 && this.mCallCardAnimationFlag == 1) {
            startCallCardShowAnimation();
        } else if (z10) {
            startCallCardFadeAnimation();
        } else {
            startCallStateFadeAnimation();
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setPrimary(m2.b bVar) {
        prepareAnimFlagForPrimaryInfo(this.mPrimaryInfo, bVar);
        this.mPrimaryInfo = bVar;
        Log.d(LOG_TAG, "setPrimary: mAnimFlag=" + this.mCallCardAnimFlag + ", primaryInfo=" + bVar);
        int i10 = this.mCallCardAnimFlag;
        if (i10 == 1) {
            animateCallCardRefresh();
        } else if (i10 != 2) {
            setPrimaryContent(this.mPrimaryInfo);
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setPrimaryCallElapsedTime(boolean z10, long j10) {
    }

    public void setPrimaryContent(m2.b bVar) {
        String str;
        int i10 = 8;
        if (bVar.i()) {
            this.mPrimaryNumberTextView.setVisibility(8);
            setTextToTextView(this.mPrimaryNameTextView, bVar.j());
            this.mPrimaryNameTextView.setContentDescription(getNumberViewDescription(bVar.j()));
        } else {
            setTextToTextView(this.mPrimaryNameTextView, bVar.h());
            setTextToTextView(this.mPrimaryNumberTextView, bVar.j());
            this.mPrimaryNumberTextView.setContentDescription(getNumberViewDescription(bVar.j()));
            this.mPrimaryNameTextView.setContentDescription(bVar.h());
        }
        if (bVar.l() && getContext() != null) {
            if (OplusPhoneUtils.isTelstraVoiceMail()) {
                str = getString(R.string.telstra_voice_mail);
            } else {
                str = getString(R.string.voice_mail);
            }
        } else {
            str = null;
        }
        this.mPrimaryLocationTextView.setText(new String[]{bVar.f(), bVar.g(), bVar.c(), bVar.e(), str});
        int b10 = bVar.b();
        if (b10 == -1) {
            this.mPrimaryCardIconImageView.setVisibility(8);
        } else {
            this.mPrimaryCardIconImageView.setImageResource(b10);
            this.mPrimaryCardIconImageView.setVisibility(0);
            if (getContext() != null) {
                if (b10 == R.drawable.incall_ic_callcard_card_sim1) {
                    this.mPrimaryCardIconImageView.setContentDescription(getString(R.string.oplus_card_1));
                } else if (b10 == R.drawable.incall_ic_callcard_card_sim2) {
                    this.mPrimaryCardIconImageView.setContentDescription(getString(R.string.oplus_card_2));
                }
            }
        }
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.u().o(Boolean.valueOf(bVar.k()));
            Drawable value = this.mCallCardViewModel.h().getValue();
            this.mPrimaryAvatarImageView.setImageDrawable(value);
            ImageView imageView = this.mPrimaryAvatarImageView;
            if (value != null) {
                i10 = 0;
            }
            imageView.setVisibility(i10);
        }
        T5.a d10 = BrandCenter.f19187a.a().d();
        if (d10 != null) {
            d10.A(getContext(), this.mVerifiedStatus, false);
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setSecondary(m2.c cVar) {
        if (!cVar.g()) {
            initSecondaryInfoLayout();
        }
        prepareAnimFlagForSecondaryInfo(this.mSecondaryInfo, cVar);
        this.mSecondaryInfo = cVar;
        Log.d(LOG_TAG, "setSecondary: mAnimFlag=" + this.mCallCardAnimFlag + ", setSecondary: " + this.mSecondaryInfo);
        int i10 = this.mCallCardAnimFlag;
        if (i10 == 1) {
            animateCallCardRefresh();
        } else if (i10 != 2) {
            setSecondaryContent(this.mSecondaryInfo);
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setSecondaryConnectionLabel(String str) {
        this.mSecondaryInfo.i(str);
        this.mSecondaryCallConnectionLabelTextView.setText(str);
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
        setVisible(z10, false);
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void showLocationUi() {
        U5.b bVar;
        Log.d(LOG_TAG, "showLocationUi");
        View view = getView();
        if (view != null && (bVar = this.mRealImpl) != null && bVar.c()) {
            CallCardViewModel callCardViewModel = this.mCallCardViewModel;
            if (callCardViewModel != null) {
                callCardViewModel.t().o(Boolean.TRUE);
            }
            this.mRealImpl.a(view, getActivity());
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void updateCallStatusPrompt(String str) {
        updateCallStatusPrompt(str, 0L);
    }

    @Override // A2.c.b
    public void updateCallTime() {
        if (this.mPrimaryCallState.c() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mPrimaryCallState.c();
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.k().o(Long.valueOf(currentTimeMillis));
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void updateSecondaryIcon(boolean z10) {
        int a10 = this.mSecondaryInfo.a();
        Log.d(LOG_TAG, "updateSecondaryIcon:needShowIcon " + z10);
        if (z10 && a10 != -1) {
            this.mSecondaryIconImageView.setImageResource(a10);
            this.mSecondaryIconImageView.setVisibility(0);
            if (getContext() != null) {
                if (a10 == R.drawable.incall_call_card_secondary_icon_sim1) {
                    this.mSecondaryIconImageView.setContentDescription(getString(R.string.oplus_card_1));
                    return;
                } else {
                    if (a10 == R.drawable.incall_call_card_secondary_icon_sim2) {
                        this.mSecondaryIconImageView.setContentDescription(getString(R.string.oplus_card_2));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.mSecondaryIconImageView.setVisibility(8);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public CallCardPresenter createPresenter() {
        return new OplusCallCardPresenter();
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setPrimaryCallElapsedTime(boolean z10, String str, String str2) {
    }

    public void setVisible(boolean z10, boolean z11) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVisible on = " + z10 + " force = " + z11);
        }
        if (getView() == null) {
            Log.i(LOG_TAG, "view is null, return ...");
            return;
        }
        if (!z11 && isPrimaryCallVideo() && InCallPresenter.getInstance() != null && InCallPresenter.getInstance().getVideoCallPresenter() != null && InCallPresenter.getInstance().getVideoCallPresenter().oplusGetIsFullScreen()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setVisible : it's video full screen, just return");
                return;
            }
            return;
        }
        boolean hasIncomingCall = hasIncomingCall();
        if (z10 && getManageConferencePanelVisible() && !hasIncomingCall) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setVisible on: it's conference panel, just return");
            }
        } else if (z10) {
            getView().setVisibility(0);
        } else {
            getView().setVisibility(4);
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void updateCallStatusPrompt(String str, long j10) {
        if (this.mHandler.hasMessages(1001)) {
            this.mHandler.removeMessages(1001);
        }
        CallCardViewModel callCardViewModel = this.mCallCardViewModel;
        if (callCardViewModel != null) {
            callCardViewModel.q().o(str);
        }
        if (j10 > 0) {
            this.mHandler.sendEmptyMessageDelayed(1001, j10);
        }
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void sendAccessibilityAnnouncement() {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setCallCardVisible(boolean z10) {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setProgressSpinnerVisible(boolean z10) {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setSecondaryInfoVisible(boolean z10) {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void showManageConferenceCallButton(boolean z10) {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setEndCallButtonEnabled(boolean z10, boolean z11) {
    }

    @Override // com.android.incallui.CallCardPresenter.CallCardUi
    public void setPrimaryImage(Drawable drawable, boolean z10) {
    }
}
