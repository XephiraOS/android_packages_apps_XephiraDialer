package com.customize.contacts.util;

import android.os.AsyncTask;
import android.widget.TextView;

/* compiled from: EmailFormatter.java */
/* loaded from: classes3.dex */
public final class A {

    /* compiled from: EmailFormatter.java */
    /* loaded from: classes3.dex */
    public static class a extends AsyncTask<Void, Void, B> {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f21858a;

        public a(TextView textView) {
            this.f21858a = textView;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public B doInBackground(Void... voidArr) {
            return new B();
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(B b10) {
            if (b10 != null && !isCancelled()) {
                this.f21858a.addTextChangedListener(b10);
                this.f21858a.setText(this.f21858a.getText());
            }
        }
    }

    public static final void a(TextView textView) {
        new a(textView).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }
}
