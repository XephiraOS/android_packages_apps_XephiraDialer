package com.coui.appcompat.edittext;

import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/* loaded from: classes.dex */
public class COUIEditFastDeleteWatcher implements TextWatcher {
    private static final int MIN_DELETE_TIME = 100;
    private static final String TAG = "COUIEditFastDeleteWatcher";
    private Editable mBeforeText;
    private EditText mEdittext;
    private boolean mEnable = true;
    private long mFirstDeleteTime;
    private boolean mIsDeleting;
    private long mLastDeleteTime;

    public COUIEditFastDeleteWatcher(COUIEditText cOUIEditText) {
        this.mEdittext = cOUIEditText;
        cOUIEditText.addTextChangedListener(this);
    }

    private void log(String str) {
        Log.d(TAG, str);
    }

    private void resetAllState() {
        this.mFirstDeleteTime = SystemClock.elapsedRealtime();
        this.mIsDeleting = true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!this.mEnable) {
            return;
        }
        if (editable.length() >= this.mBeforeText.length()) {
            this.mIsDeleting = false;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.mLastDeleteTime;
        if (elapsedRealtime - j10 > 1000 && j10 > 0) {
            this.mIsDeleting = false;
            this.mLastDeleteTime = 0L;
        }
        if (!this.mIsDeleting) {
            this.mIsDeleting = true;
            this.mFirstDeleteTime = SystemClock.elapsedRealtime();
        }
        if (elapsedRealtime - this.mFirstDeleteTime < 4000) {
            this.mLastDeleteTime = SystemClock.elapsedRealtime();
            return;
        }
        if (elapsedRealtime - this.mLastDeleteTime < 100) {
            int length = this.mBeforeText.length();
            int length2 = length - editable.length();
            this.mEnable = false;
            editable.append(this.mBeforeText.subSequence(length - length2, length));
            this.mEnable = true;
            return;
        }
        int length3 = editable.length();
        int i10 = 4;
        if (4 > length3) {
            i10 = length3;
        }
        this.mEnable = false;
        editable.delete(length3 - i10, length3);
        this.mLastDeleteTime = SystemClock.elapsedRealtime();
        this.mEnable = true;
        log("afterTextChanged done");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.mEnable) {
            return;
        }
        this.mBeforeText = new SpannableStringBuilder(charSequence.toString());
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
