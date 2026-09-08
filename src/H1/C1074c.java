package h1;

import android.content.Context;
import android.os.AsyncTask;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.widget.TextView;

/* compiled from: PhoneNumberFormatter.java */
/* renamed from: h1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1074c {

    /* compiled from: PhoneNumberFormatter.java */
    /* renamed from: h1.c$a */
    /* loaded from: classes.dex */
    public static class a extends AsyncTask<Void, Void, PhoneNumberFormattingTextWatcher> {

        /* renamed from: a, reason: collision with root package name */
        public final String f32038a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f32039b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f32040c;

        public a(String str, TextView textView, boolean z10) {
            this.f32038a = str;
            this.f32039b = textView;
            this.f32040c = z10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhoneNumberFormattingTextWatcher doInBackground(Void... voidArr) {
            return new PhoneNumberFormattingTextWatcher(this.f32038a);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(PhoneNumberFormattingTextWatcher phoneNumberFormattingTextWatcher) {
            if (phoneNumberFormattingTextWatcher != null && !isCancelled()) {
                this.f32039b.addTextChangedListener(phoneNumberFormattingTextWatcher);
                CharSequence text = this.f32039b.getText();
                if (!TextUtils.isEmpty(text)) {
                    if (this.f32040c) {
                        phoneNumberFormattingTextWatcher.afterTextChanged(this.f32039b.getEditableText());
                    } else {
                        this.f32039b.setText(text);
                    }
                }
            }
        }
    }

    public static String a(String str, String str2, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (C1072a.f(str)) {
            return str;
        }
        return PhoneNumberUtils.formatNumber(str, str2, b(context));
    }

    public static String b(Context context) {
        return C7.c.b(context).a();
    }

    public static String c(Context context, String str, String str2, String str3) {
        if (str != null && str.contains("@")) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str3 == null) {
            str3 = C7.c.b(context).a();
        }
        String formatNumberToE164 = PhoneNumberUtils.formatNumberToE164(str, str3);
        if (formatNumberToE164 == null) {
            return "";
        }
        return formatNumberToE164;
    }

    public static void d(Context context, TextView textView) {
        e(context, textView, false);
    }

    public static void e(Context context, TextView textView, boolean z10) {
        new a(b(context), textView, z10).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }
}
