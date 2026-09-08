package com.android.contacts.util;

import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/* compiled from: WeakAsyncTask.java */
/* loaded from: classes.dex */
public abstract class D<Params, Progress, Result, WeakTarget> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<WeakTarget> f17554a;

    public D(WeakTarget weaktarget) {
        this.f17554a = new WeakReference<>(weaktarget);
    }

    public abstract Result a(WeakTarget weaktarget, Params... paramsArr);

    public abstract void b(WeakTarget weaktarget, Result result);

    @Override // android.os.AsyncTask
    public final Result doInBackground(Params... paramsArr) {
        WeakTarget weaktarget = this.f17554a.get();
        if (weaktarget != null) {
            return a(weaktarget, paramsArr);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Result result) {
        WeakTarget weaktarget = this.f17554a.get();
        if (weaktarget != null) {
            b(weaktarget, result);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        WeakTarget weaktarget = this.f17554a.get();
        if (weaktarget != null) {
            c(weaktarget);
        }
    }

    public void c(WeakTarget weaktarget) {
    }
}
