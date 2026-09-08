package com.android.incallui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Chronometer;
import android.widget.TextView;
import com.android.incallui.ConferenceManagerPresenter;

/* loaded from: classes.dex */
public class OplusConferenceManagerFragment extends BaseFragment<ConferenceManagerPresenter, ConferenceManagerPresenter.ConferenceManagerUi> implements ConferenceManagerPresenter.ConferenceManagerUi {
    private static final float DEFAULT_ROTATION = 180.0f;
    private static final String LOG_TAG = "OplusConferenceManagerFragment";
    private View mButtonManageConferenceDone;
    private Chronometer mConferenceTime;
    private View mParentView;
    public boolean mIsEndCall = false;
    private ViewGroup[] mConferenceCallList = null;

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public final void displayCallerInfoForConferenceRow(int i10, String str, String str2, String str3) {
        TextView textView = (TextView) this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerName);
        TextView textView2 = (TextView) this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerNumber);
        textView.setTypeface(InCallUIAide.getInstance().getMediumType());
        Context context = getContext();
        int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(context);
        if (numberHideSettings != 0) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "displayCallerInfoForConferenceRow: numberHideSettings:" + numberHideSettings);
            }
            str2 = OplusPhoneUtils.getNumberMaskedStr(str2, numberHideSettings);
            str = OplusPhoneUtils.getHidedNumberInName(str, numberHideSettings, context);
        }
        textView.setText(str);
        textView2.setText(str2);
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void displayManageConferencePanel(boolean z10) {
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().displayManageConferencePanel(z10);
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public boolean getIsEndCall() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getIsEndCall isEndCall= " + this.mIsEndCall);
        }
        return this.mIsEndCall;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public ConferenceManagerPresenter.ConferenceManagerUi getUi() {
        return this;
    }

    public void initConferenceManagerStub() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "initConferenceManagerStub begin...");
        }
        ViewStub viewStub = (ViewStub) this.mParentView.findViewById(R.id.manage_conference_fragment_stub);
        if (viewStub != null) {
            viewStub.inflate();
            Chronometer chronometer = (Chronometer) this.mParentView.findViewById(R.id.manageConferencePanelHeader);
            this.mConferenceTime = chronometer;
            chronometer.setFormat(getActivity().getString(R.string.caller_manage_header));
            this.mConferenceCallList = new ViewGroup[getPresenter().getMaxCallersInConference()];
            int[] iArr = {R.id.caller0, R.id.caller1, R.id.caller2, R.id.caller3, R.id.caller4, R.id.caller5};
            for (int i10 = 0; i10 < getPresenter().getMaxCallersInConference(); i10++) {
                this.mConferenceCallList[i10] = (ViewGroup) this.mParentView.findViewById(iArr[i10]);
            }
            View findViewById = this.mParentView.findViewById(R.id.oplus_caller_manage_done_shourt_cut_button);
            this.mButtonManageConferenceDone = findViewById;
            if (OplusInCallApp.sIsRtlLanguage) {
                findViewById.setRotationY(DEFAULT_ROTATION);
            }
            this.mButtonManageConferenceDone.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.OplusConferenceManagerFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OplusConferenceManagerFragment.this.getPresenter().manageConferenceDoneClicked();
                }
            });
            return;
        }
        Log.e(LOG_TAG, "conferenceManagerStub is null, initConferenceManagerStub fail...");
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public boolean isFragmentVisible() {
        return isVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.oplus_conference_manager_fragment, viewGroup, false);
        this.mParentView = inflate;
        return inflate;
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public final void setCanSeparateButtonForRow(final int i10, boolean z10) {
        View findViewById = this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerSeparate);
        if (z10) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.OplusConferenceManagerFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OplusConferenceManagerFragment.this.getPresenter().separateConferenceConnection(i10);
                }
            });
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void setEndButtonEnable(int i10, boolean z10, Call call, int i11) {
        View findViewById = this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerDisconnect);
        if (findViewById != null) {
            if (OplusPhoneUtils.changeToVowifiIcon(call, i11)) {
                findViewById.setBackgroundResource(R.drawable.incall_btn_vowifi_conference_end);
            } else {
                findViewById.setBackgroundResource(R.drawable.incall_btn_conference_end_call);
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setEndButtonEnable: set " + z10);
            }
            findViewById.setEnabled(z10);
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void setRowVisible(int i10, boolean z10) {
        if (this.mConferenceCallList == null) {
            initConferenceManagerStub();
        }
        if (z10) {
            this.mConferenceCallList[i10].setVisibility(0);
        } else {
            this.mConferenceCallList[i10].setVisibility(8);
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void setSeparateButtonEnable(int i10, boolean z10) {
        View findViewById = this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerSeparate);
        if (findViewById != null) {
            findViewById.setEnabled(z10);
        }
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVisible  = " + z10);
        }
        if (z10) {
            getPresenter().init(getActivity(), CallList.getInstance());
            if (this.mConferenceCallList == null) {
                initConferenceManagerStub();
            }
            getView().setVisibility(0);
        } else {
            getView().setVisibility(8);
        }
        if (getInCallFragmentManager() != null) {
            getInCallFragmentManager().p(!z10);
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public final void setupEndButtonForRow(final int i10, Call call, int i11) {
        View findViewById = this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerDisconnect);
        if (findViewById != null) {
            if (OplusPhoneUtils.changeToVowifiIcon(call, i11)) {
                findViewById.setBackgroundResource(R.drawable.incall_btn_vowifi_conference_end);
            } else {
                findViewById.setBackgroundResource(R.drawable.incall_btn_conference_end_call);
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.OplusConferenceManagerFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OplusConferenceManagerFragment oplusConferenceManagerFragment = OplusConferenceManagerFragment.this;
                    oplusConferenceManagerFragment.mIsEndCall = true;
                    oplusConferenceManagerFragment.getPresenter().endConferenceConnection(i10);
                }
            });
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void setupEndButtonForRowWithUrl(int i10, String str) {
        this.mConferenceCallList[i10].findViewById(R.id.conferenceCallerDisconnect).setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.OplusConferenceManagerFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OplusConferenceManagerFragment.this.mIsEndCall = true;
            }
        });
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void startConferenceTime(long j10) {
        Chronometer chronometer = this.mConferenceTime;
        if (chronometer != null) {
            chronometer.setBase(j10);
            this.mConferenceTime.start();
        }
    }

    @Override // com.android.incallui.ConferenceManagerPresenter.ConferenceManagerUi
    public void stopConferenceTime() {
        Chronometer chronometer = this.mConferenceTime;
        if (chronometer != null) {
            chronometer.stop();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public ConferenceManagerPresenter createPresenter() {
        return new ConferenceManagerPresenter();
    }
}
