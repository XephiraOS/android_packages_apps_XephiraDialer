package com.android.incallui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.InterfaceC0519a;
import com.android.incallui.CallButtonPresenter;
import com.android.incallui.mvvm.view.OplusDialpadFragment;
import com.android.incallui.mvvm.view_model.CallButtonViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.incallui.oplus.widgets.OplusIncallUIImageView;
import j2.C1159a;
import l2.C1289a;
import y2.C1702a;

/* loaded from: classes.dex */
public class OplusCallButtonFragment extends BaseFragment<CallButtonPresenter, CallButtonPresenter.CallButtonUi> implements CallButtonPresenter.CallButtonUi, CompoundButton.OnCheckedChangeListener {
    private static final int COLUMN_COUNT = 3;
    private static final int END_CALL_DELAY_TIME = 200;
    private static final long END_CLICK_GUARD_TIME = 1500;
    private static final float HIDE_ALPHA = 0.0f;
    public static final String LOG_TAG = "OplusCallButtonFragment";
    private static final int MAX_NUM_RETRIES = 2;
    private static final int MSG_END_CALL = 1;
    private static final int MSG_RETRY_TIMEOUT = 2;
    private static final float SHOW_ALPHA = 1.0f;
    public static final String START_FROM_INCALLUI_BUTTON = "start_from_incallui_button";
    private View mBottomButtonsLayout;
    private C1159a mButtonController;
    public int mCallButtonAnimFlag;
    public CallButtonViewModel mCallButtonViewModel;
    public OplusIncallUIImageView mEndCallButton;
    private boolean mEndCallButtonPressed;
    public OplusInCallViewModel mInCallViewModel;
    private int mNumRetriesSoFar;
    private View mParentView;
    private RecyclerView mRecyclerButtonsView;
    private boolean mIsVideoCall = false;
    private long mLastNonResposePressedTime = 0;
    private final Handler mHandler = new Handler() { // from class: com.android.incallui.OplusCallButtonFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Log.sDebug) {
                OplusCallButtonFragment.this.log("msg.what = " + message.what);
            }
            int i10 = message.what;
            if (i10 == 1) {
                OplusCallButtonFragment.this.mNumRetriesSoFar = 0;
                if (!OplusCallButtonFragment.this.getPresenter().endCallClicked()) {
                    OplusCallButtonFragment.this.startRetryTimer();
                    return;
                }
                return;
            }
            if (i10 == 2) {
                OplusCallButtonFragment.this.onRetryTimeout();
            } else if (Log.sDebug) {
                Log.e(OplusCallButtonFragment.LOG_TAG, "error message...");
            }
        }
    };

    private void cancelAllViewsAnimation() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "cancelAllViewsAnimation");
        }
        OplusAnimationUtils.cancelViewAnimation(this.mRecyclerButtonsView);
        OplusAnimationUtils.cancelViewAnimation(this.mEndCallButton);
        if (getInCallFragmentManager() != null) {
            OplusAnimationUtils.cancelViewAnimation(getInCallFragmentManager().j(5));
        }
    }

    private void initDataBindingParams(View view) {
        O1.u i12 = O1.u.i1(view);
        i12.k1(this.mCallButtonViewModel);
        i12.b1(getViewLifecycleOwner());
        this.mCallButtonViewModel.i().i(getViewLifecycleOwner(), new androidx.lifecycle.w() { // from class: com.android.incallui.t
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                OplusCallButtonFragment.this.lambda$initDataBindingParams$0((Integer) obj);
            }
        });
    }

    private void initRecyclerView() {
        if (getActivity() == null) {
            Log.d(LOG_TAG, "initRecyclerView activity is null");
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.mParentView.findViewById(R.id.call_buttons);
        this.mRecyclerButtonsView = recyclerView;
        recyclerView.setVisibility(4);
        notifyActionButtonFragmentVisible(false);
        C1289a c1289a = new C1289a();
        this.mRecyclerButtonsView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        this.mRecyclerButtonsView.addItemDecoration(new l2.b(3, (int) getActivity().getResources().getDimension(R.dimen.recycler_view_call_horizontal_spacing), 0));
        this.mRecyclerButtonsView.setAdapter(c1289a);
        this.mButtonController = new C1159a(getActivity(), this.mRecyclerButtonsView, getPresenter(), c1289a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataBindingParams$0(Integer num) {
        for (int i10 = 0; i10 < this.mRecyclerButtonsView.getItemDecorationCount(); i10++) {
            RecyclerView.n itemDecorationAt = this.mRecyclerButtonsView.getItemDecorationAt(i10);
            if (itemDecorationAt instanceof l2.b) {
                ((l2.b) itemDecorationAt).d(num.intValue());
                this.mRecyclerButtonsView.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        Log.d(LOG_TAG, str);
    }

    private void notifyActionButtonFragmentVisible(boolean z10) {
        Log.d(LOG_TAG, "notifyActionButtonFragmentVisible: " + z10);
        View view = this.mParentView;
        boolean z11 = false;
        if (view != null && this.mRecyclerButtonsView != null) {
            if (z10 && view.getVisibility() == 0 && this.mRecyclerButtonsView.getVisibility() == 0) {
                z11 = true;
            }
            com.android.incallui.mvvm.utils.A.b(z11);
            return;
        }
        Log.d(LOG_TAG, "notifyActionButtonFragmentVisible: mParentView or mRecyclerButtonsView is null");
        com.android.incallui.mvvm.utils.A.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetryTimeout() {
        int i10 = this.mNumRetriesSoFar + 1;
        this.mNumRetriesSoFar = i10;
        if (i10 > 2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Retry for End Call hit MAX_NUM_RETRIES; giving up...");
            }
            this.mHandler.removeMessages(2);
            InCallPresenter.getInstance().tearDown();
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "- Scheduling another retry...");
        }
        if (!getPresenter().endCallClicked()) {
            startRetryTimer();
        } else {
            this.mHandler.removeMessages(2);
        }
    }

    private void regainResources() {
        if (this.mDrawableInited) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "regainResources: resources have been initialized, return.");
            }
        } else {
            OplusIncallUIImageView oplusIncallUIImageView = this.mEndCallButton;
            if (oplusIncallUIImageView != null) {
                oplusIncallUIImageView.setBackgroundResource(R.drawable.incall_btn_reject);
            }
            this.mDrawableInited = true;
        }
    }

    private void showButtonsWhenIncoming(boolean z10) {
        Log.d(LOG_TAG, "showButtonsWhenIncoming = " + z10);
        if (z10) {
            com.android.incallui.anim.b.c().k(this.mRecyclerButtonsView, false);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((OplusInCallViewModel) new androidx.lifecycle.K(activity).a(OplusInCallViewModel.class)).u().o(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRetryTimer() {
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 200L);
    }

    private void updateDialpadButton() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((OplusInCallViewModel) new androidx.lifecycle.K(activity).a(OplusInCallViewModel.class)).q().o(Boolean.valueOf(isDialpadVisible()));
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void displayCallControlButton(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "displayCallControlButton visible = " + z10);
        }
        if (z10) {
            this.mRecyclerButtonsView.setAlpha(1.0f);
            updateDialpadButton();
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void displayDialpad(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "displayDialpad = " + z10);
        }
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().displayDialpad(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void displayManageConferencePanel(boolean z10) {
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().displayManageConferencePanel(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableAddCall(boolean z10) {
        boolean z11;
        if (this.mButtonController != null) {
            if (!z10 || this.mEndCallButton.isEnabled()) {
                C1159a c1159a = this.mButtonController;
                if (z10 && !OplusPhoneUtils.isDeviceRestricted(getActivity())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                c1159a.b(6, z11);
            }
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableButton(int i10, boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.b(i10, z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableChangeToVideo(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.c(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableHold(boolean z10) {
        C1159a c1159a;
        if (!this.mEndCallButtonPressed && (c1159a = this.mButtonController) != null) {
            c1159a.b(3, z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableMute(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.b(8, z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableRecorder(boolean z10) {
        int oplusGetCallSize = ((OplusCallList) CallList.getInstance()).oplusGetCallSize();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "enableRecorder ...mEndCallButtonPressed = " + this.mEndCallButtonPressed + ", isEnabled = " + z10 + ", CallSize = " + oplusGetCallSize);
        }
        if (oplusGetCallSize > 1 && this.mEndCallButtonPressed) {
            this.mEndCallButtonPressed = false;
        }
        boolean z11 = this.mEndCallButtonPressed;
        if (z11 && z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "do not show mEndCallButton light");
            }
        } else {
            if (!z11 && !z10 && oplusGetCallSize > 1) {
                Log.d(LOG_TAG, "still has call, no need disable record");
                return;
            }
            C1159a c1159a = this.mButtonController;
            if (c1159a != null) {
                c1159a.e(z10);
            }
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void enableSwitchCamera(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.b(9, z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public C1159a getButtonController() {
        return this.mButtonController;
    }

    public boolean getIsVideoCall() {
        if (Log.sDebug) {
            log("getIsVideoCall isVideo = " + this.mIsVideoCall);
        }
        return this.mIsVideoCall;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public CallButtonPresenter.CallButtonUi getUi() {
        return this;
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void hideButtonsView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "hideButtonsViews");
        }
        notifyActionButtonFragmentVisible(false);
        if (this.mRecyclerButtonsView.getVisibility() == 8) {
            return;
        }
        this.mEndCallButton.setVisibility(8);
        this.mRecyclerButtonsView.setVisibility(8);
        updateDialpadButton();
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public boolean isDialpadVisible() {
        if (getInCallFragmentManager() != null) {
            return getInCallFragmentManager().isDialpadVisible();
        }
        return false;
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public boolean isManageConferencePanelVisible() {
        if (getInCallFragmentManager() != null) {
            return getInCallFragmentManager().f();
        }
        return false;
    }

    public void maybeSetCallsButtonMask() {
        if (this.mIsVideoCall && OplusPhoneUtils.needSetMaskForVideoCall()) {
            Log.d(Log.TAG, "startShowDialpadAnimation setCallsButtonMask");
            setCallsButtonMask(true, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mCallButtonViewModel = (CallButtonViewModel) new androidx.lifecycle.K(this).a(CallButtonViewModel.class);
        this.mInCallViewModel = (OplusInCallViewModel) new androidx.lifecycle.K(requireActivity()).a(OplusInCallViewModel.class);
    }

    public void onConferencePanelVisibilityChanged(boolean z10) {
        if (!z10) {
            ((OplusCallButtonPresenter) getPresenter()).conferencePanelHide();
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
        View inflate = layoutInflater.inflate(R.layout.oplus_call_button_fragment, viewGroup, false);
        this.mParentView = inflate;
        this.mBottomButtonsLayout = inflate.findViewById(R.id.bottomButtons);
        this.mCallButtonAnimFlag = 0;
        initRecyclerView();
        initDataBindingParams(this.mParentView);
        OplusIncallUIImageView oplusIncallUIImageView = (OplusIncallUIImageView) this.mParentView.findViewById(R.id.endButton);
        this.mEndCallButton = oplusIncallUIImageView;
        oplusIncallUIImageView.setVisibility(4);
        this.mEndCallButton.setContentDescription(getActivity().getString(R.string.notification_action_end_call));
        this.mEndCallButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.OplusCallButtonFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Log.sDebug) {
                    D2.g.b(OplusCallButtonFragment.LOG_TAG, "EndCallButton click!!!");
                }
                if (((OplusCallList) CallList.getInstance()).oplusGetDisconnectingCall() != null) {
                    if (Log.sDebug) {
                        D2.g.f(OplusCallButtonFragment.LOG_TAG, "EndCallButton click error, because a disconnecting Call exits, return!!!");
                        return;
                    }
                    return;
                }
                boolean hasCatchSwitchError = InCallPresenter.getInstance().realInstance().hasCatchSwitchError();
                Call currentCall = OplusCallButtonFragment.this.getPresenter().getCurrentCall();
                if (currentCall != null && currentCall.isFakeAnswerState() && !hasCatchSwitchError) {
                    if (Log.sDebug) {
                        D2.g.b(OplusCallButtonFragment.LOG_TAG, "EndCallButton click, end call is fake answer state return!");
                        return;
                    }
                    return;
                }
                if (((OplusTelecomAdapter) TelecomAdapter.getInstance()).hasMergedPendingCallAction()) {
                    return;
                }
                if (OplusCallButtonFragment.this.getPresenter() != null && ((OplusCallButtonPresenter) OplusCallButtonFragment.this.getPresenter()).canNotResposeEndClick()) {
                    if (Log.sDebug) {
                        D2.g.b(OplusCallButtonFragment.LOG_TAG, "EndCallButton click, canNotResposeEndClick return!");
                        return;
                    }
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - OplusCallButtonFragment.this.mLastNonResposePressedTime;
                if (elapsedRealtime < OplusCallButtonFragment.END_CLICK_GUARD_TIME) {
                    if (Log.sDebug) {
                        D2.g.b(OplusCallButtonFragment.LOG_TAG, "EndCallButton click, in caurd time return = " + elapsedRealtime);
                        return;
                    }
                    return;
                }
                OplusCallButtonFragment.this.mLastNonResposePressedTime = SystemClock.elapsedRealtime();
                OplusCallButtonFragment.this.mEndCallButton.setEnabled(false);
                OplusCallButtonFragment.this.setEnabled(false);
                OplusCallButtonFragment.this.enableRecorder(false);
                OplusCallButtonFragment.this.enableHold(false);
                OplusCallButtonFragment.this.enableChangeToVideo(false);
                if (CallList.getInstance().oplusCallList().oplusGetCallSize() != 0) {
                    OplusCallButtonFragment.this.mEndCallButtonPressed = true;
                }
                if (currentCall != null && currentCall.isFakeAnswerState() && hasCatchSwitchError) {
                    if (Log.sDebug) {
                        D2.g.b(OplusCallButtonFragment.LOG_TAG, "use rejectCall instead of endCall when it is fake answer state and catch switch error!");
                    }
                    TelecomAdapter.getInstance().rejectCall(currentCall.getId(), false, null);
                    return;
                }
                OplusCallButtonFragment.this.getPresenter().endCallClicked();
            }
        });
        this.mEndCallButtonPressed = false;
        return this.mParentView;
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (Log.sDebug) {
            log("onDestroyView ");
        }
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST) {
            C1702a.e().j();
        }
        this.mButtonController.a();
        super.onDestroyView();
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    public void onMuteClicked(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.o(z10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Log.d(LOG_TAG, "onResume...");
        if (getPresenter() != null) {
            getPresenter().refreshMuteState();
        }
        refreshCallButtonsVisibility();
        regainResources();
        super.onResume();
        if (!this.mEndCallButtonPressed) {
            this.mBottomButtonsLayout.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Log.d(LOG_TAG, "onStart...");
        super.onStart();
        regainResources();
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST) {
            C1702a.e().h(getActivity(), getPresenter());
        }
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setZ(2.0f);
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void refreshCallButtonsVisibility() {
        int activeSubId = CallList.getInstance().getActiveSubId();
        Call currentCall = getPresenter().getCurrentCall();
        showVowifiEndButton(OplusPhoneUtils.changeToVowifiIcon(currentCall, activeSubId));
        Log.d(LOG_TAG, "refreshCallButtonsVisibility, begin...");
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.q(currentCall);
        }
        Log.d(LOG_TAG, "mIsVideoCall = " + this.mIsVideoCall);
        if (OplusPhoneUtils.needSetMaskForVideoCall() && currentCall != null && currentCall.getState() == 3) {
            setCallsButtonMask(this.mIsVideoCall, isDialpadVisible());
        }
    }

    @Override // com.android.incallui.BaseFragment
    public void releaseResources() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "releaseResources");
        }
        super.releaseResources();
        cancelAllViewsAnimation();
        this.mInCallViewModel.u().o(Boolean.FALSE);
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_MTK && OplusFeatureOption.OPLUS_PHONE_VILTE_AUTO_TEST) {
            C1702a.e().j();
        }
    }

    public void setBottomButtonsEnable(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setBottomButtonsEnable: " + z10);
        }
        View view = this.mBottomButtonsLayout;
        if (view != null) {
            view.setEnabled(z10);
        }
    }

    public void setCallButtonWithoutAnim(boolean z10) {
        float f10;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.mRecyclerButtonsView.getLayoutManager();
        if (gridLayoutManager == null) {
            return;
        }
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        int itemCount = gridLayoutManager.getItemCount();
        for (int i10 = 0; i10 < itemCount; i10++) {
            View findViewByPosition = gridLayoutManager.findViewByPosition(i10);
            if (findViewByPosition != null) {
                findViewByPosition.setAlpha(f10);
            }
        }
    }

    public void setCallsButtonMask(boolean z10, boolean z11) {
        int i10;
        OplusDialpadFragment l10;
        View view;
        Log.d(LOG_TAG, "setCallsButtonMask show = " + z10 + ", isDialpad = " + z11);
        RecyclerView recyclerView = this.mRecyclerButtonsView;
        if (recyclerView == null) {
            Log.d(LOG_TAG, "setCallsButtonMask is null ");
            return;
        }
        Context context = recyclerView.getContext();
        if (z10) {
            i10 = R.color.calls_button_mask_color;
        } else {
            i10 = android.R.color.transparent;
        }
        int color = context.getColor(i10);
        this.mRecyclerButtonsView.setBackgroundColor(color);
        InterfaceC0519a inCallFragmentManager = getInCallFragmentManager();
        if (inCallFragmentManager != null && (l10 = inCallFragmentManager.l()) != null && (view = l10.getView()) != null) {
            view.setBackgroundColor(color);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((OplusInCallViewModel) new androidx.lifecycle.K(activity).a(OplusInCallViewModel.class)).o().o(Integer.valueOf(color));
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setDialpad(boolean z10) {
        if (z10) {
            displayCallControlButton(false);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setEnabled(boolean z10) {
        if (getView().getVisibility() != 0 && z10) {
            setVisible(true);
        }
        int oplusGetCallSize = ((OplusCallList) CallList.getInstance()).oplusGetCallSize();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setEnabled ...mEndCallButtonPressed = " + this.mEndCallButtonPressed + ", isEnabled = " + z10 + ", CallSize = " + oplusGetCallSize);
        }
        if (oplusGetCallSize > 1 && this.mEndCallButtonPressed) {
            this.mEndCallButtonPressed = false;
        }
        if (this.mEndCallButtonPressed && z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "do not show mEndCallButton light");
                return;
            }
            return;
        }
        this.mEndCallButton.setEnabled(z10);
        if (!this.mEndCallButtonPressed && oplusGetCallSize > 1 && !z10) {
            Log.d(LOG_TAG, "still has call, no need disable");
            return;
        }
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.y(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setEndCallButtonPressed(boolean z10) {
        if (Log.sDebug) {
            log("setEndCallButtonPressed: mEndCallButtonPressed = " + this.mEndCallButtonPressed + ", pressed = " + z10);
        }
        this.mEndCallButtonPressed = z10;
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setHold(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.E(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setIsVideoCall(boolean z10) {
        if (Log.sDebug) {
            log("setIsVideoCall isVideo = " + z10);
        }
        this.mIsVideoCall = z10;
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setMute(boolean z10) {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.I(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setVideoPaused(boolean z10) {
        enableSwitchCamera(!z10);
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.N(z10);
        }
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
        setVisible(z10, false);
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void showButtonsView(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showButtonsViews mBottomButtonsLayout.getVisibility() ==" + this.mRecyclerButtonsView.getVisibility() + "  isVideoCall = " + this.mIsVideoCall);
        }
        if (this.mRecyclerButtonsView.getVisibility() != 0) {
            this.mRecyclerButtonsView.setVisibility(0);
            notifyActionButtonFragmentVisible(true);
            if (z10) {
                showButtonsWhenIncoming(true);
            } else {
                displayCallControlButton(true);
            }
        }
    }

    public void showVowifiEndButton(boolean z10) {
        int i10;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.android.incallui.mvvm.utils.h<Integer> s10 = ((OplusInCallViewModel) new androidx.lifecycle.K(activity).a(OplusInCallViewModel.class)).s();
            if (z10) {
                i10 = R.drawable.incall_btn_vowifi_reject;
            } else {
                i10 = R.drawable.incall_btn_reject;
            }
            s10.o(Integer.valueOf(i10));
        }
    }

    public void startHideRecyclerButtonAnimation() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "startHideRecyclerButtonAnimation");
        }
        if (this.mRecyclerButtonsView == null) {
            return;
        }
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().j(5).setVisibility(0);
        }
        com.android.incallui.anim.b.c().j(this.mRecyclerButtonsView, false, this.mCallButtonAnimFlag, new AnimatorListenerAdapter() { // from class: com.android.incallui.OplusCallButtonFragment.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OplusCallButtonFragment.this.mCallButtonAnimFlag = 0;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                OplusCallButtonFragment.this.mCallButtonAnimFlag = 1;
            }
        });
    }

    public void startShowRecyclerButtonAnimation() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "startShowRecyclerButtonAnimation");
        }
        if (this.mRecyclerButtonsView == null) {
            return;
        }
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().n(2, false);
        }
        com.android.incallui.anim.b.c().j(this.mRecyclerButtonsView, true, this.mCallButtonAnimFlag, new AnimatorListenerAdapter() { // from class: com.android.incallui.OplusCallButtonFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OplusCallButtonFragment.this.mCallButtonAnimFlag = 0;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                OplusCallButtonFragment.this.mCallButtonAnimFlag = 1;
            }
        });
        if (this.mIsVideoCall && OplusPhoneUtils.needSetMaskForVideoCall()) {
            Log.d(Log.TAG, "startShowRecyclerButtonAnimation setCallsButtonMask");
            setCallsButtonMask(true, false);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void updateRecordButton() {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.R();
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void updateRecordText() {
        C1159a c1159a = this.mButtonController;
        if (c1159a != null) {
            c1159a.S();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public CallButtonPresenter createPresenter() {
        return new OplusCallButtonPresenter();
    }

    public void setVisible(boolean z10, boolean z11) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVisible on = " + z10 + " force = " + z11);
        }
        if (getView() == null) {
            Log.d(LOG_TAG, "view is null , return");
            return;
        }
        if (OplusPhoneUtils.noNeedHandleClickForCMCC()) {
            z10 = true;
        }
        if (!z11 && getPresenter() != null && CallUtils.isVideoCall(((OplusCallButtonPresenter) getPresenter()).getPrimaryCall()) && InCallPresenter.getInstance() != null && InCallPresenter.getInstance().getVideoCallPresenter() != null && InCallPresenter.getInstance().getVideoCallPresenter().oplusGetIsFullScreen()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setVisible : it's video full screen, just return");
            }
        } else {
            if (z10) {
                getView().setVisibility(0);
            } else {
                getView().setVisibility(4);
                cancelAllViewsAnimation();
            }
            notifyActionButtonFragmentVisible(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void displayDialpad(boolean z10, boolean z11) {
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().displayDialpad(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter.CallButtonUi
    public void setCameraSwitched(boolean z10) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
    }
}
