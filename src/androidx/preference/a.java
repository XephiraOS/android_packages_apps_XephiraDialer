package androidx.preference;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* compiled from: EditTextPreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public class a extends f {
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private static final int SHOW_REQUEST_TIMEOUT = 1000;
    private EditText mEditText;
    private CharSequence mText;
    private final Runnable mShowSoftInputRunnable = new RunnableC0131a();
    private long mShowRequestTime = -1;

    /* compiled from: EditTextPreferenceDialogFragmentCompat.java */
    /* renamed from: androidx.preference.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0131a implements Runnable {
        public RunnableC0131a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.scheduleShowSoftInputInner();
        }
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    private boolean hasPendingShowSoftInputRequest() {
        long j10 = this.mShowRequestTime;
        if (j10 != -1 && j10 + 1000 > SystemClock.currentThreadTimeMillis()) {
            return true;
        }
        return false;
    }

    public static a newInstance(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void setPendingShowSoftInputRequest(boolean z10) {
        long j10;
        if (z10) {
            j10 = SystemClock.currentThreadTimeMillis();
        } else {
            j10 = -1;
        }
        this.mShowRequestTime = j10;
    }

    @Override // androidx.preference.f
    public boolean needInputMethod() {
        return true;
    }

    @Override // androidx.preference.f
    public void onBindDialogView(View view) {
        super.onBindDialogView(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.mEditText = editText;
        if (editText != null) {
            editText.requestFocus();
            this.mEditText.setText(this.mText);
            EditText editText2 = this.mEditText;
            editText2.setSelection(editText2.getText().length());
            getEditTextPreference().getOnBindEditTextListener();
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mText = getEditTextPreference().getText();
        } else {
            this.mText = bundle.getCharSequence(SAVE_STATE_TEXT);
        }
    }

    @Override // androidx.preference.f
    public void onDialogClosed(boolean z10) {
        if (z10) {
            String obj = this.mEditText.getText().toString();
            EditTextPreference editTextPreference = getEditTextPreference();
            if (editTextPreference.callChangeListener(obj)) {
                editTextPreference.setText(obj);
            }
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence(SAVE_STATE_TEXT, this.mText);
    }

    @Override // androidx.preference.f
    public void scheduleShowSoftInput() {
        setPendingShowSoftInputRequest(true);
        scheduleShowSoftInputInner();
    }

    public void scheduleShowSoftInputInner() {
        if (hasPendingShowSoftInputRequest()) {
            EditText editText = this.mEditText;
            if (editText != null && editText.isFocused()) {
                if (((InputMethodManager) this.mEditText.getContext().getSystemService("input_method")).showSoftInput(this.mEditText, 0)) {
                    setPendingShowSoftInputRequest(false);
                    return;
                } else {
                    this.mEditText.removeCallbacks(this.mShowSoftInputRunnable);
                    this.mEditText.postDelayed(this.mShowSoftInputRunnable, 50L);
                    return;
                }
            }
            setPendingShowSoftInputRequest(false);
        }
    }
}
