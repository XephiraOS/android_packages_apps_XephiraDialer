package com.android.incallui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oapm.perftest.PerfTest;

/* loaded from: classes.dex */
public class PostCharDialogFragment extends DialogFragment {
    private static final String BUNDLE_CALL_ID = "call_id";
    private static final String BUNDLE_POST_DIAL_STR = "post_dial_str";
    private String mCallId;
    private String mPostDialStr;

    public PostCharDialogFragment() {
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        TelecomAdapter.getInstance().postDialContinue(this.mCallId, false);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mCallId = arguments.getString(BUNDLE_CALL_ID);
            this.mPostDialStr = arguments.getString(BUNDLE_POST_DIAL_STR);
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(getActivity());
        cOUIAlertDialogBuilder.setTitle((CharSequence) (getResources().getText(R.string.wait_prompt_str) + this.mPostDialStr));
        cOUIAlertDialogBuilder.setPositiveButton(R.string.pause_prompt_yes, new DialogInterface.OnClickListener() { // from class: com.android.incallui.PostCharDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                TelecomAdapter.getInstance().postDialContinue(PostCharDialogFragment.this.mCallId, true);
            }
        });
        cOUIAlertDialogBuilder.setNegativeButton(R.string.pause_prompt_no, new DialogInterface.OnClickListener() { // from class: com.android.incallui.PostCharDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.cancel();
            }
        });
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        PerfTest.leakWatch(this);
    }

    public PostCharDialogFragment(String str, String str2) {
        this.mCallId = str;
        this.mPostDialStr = str2;
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_CALL_ID, this.mCallId);
        bundle.putString(BUNDLE_POST_DIAL_STR, this.mPostDialStr);
        setArguments(bundle);
    }
}
