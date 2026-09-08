package u0;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import w0.d;
import w0.e;

/* compiled from: FdnPresenter.java */
/* renamed from: u0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1600a extends d {

    /* compiled from: FdnPresenter.java */
    /* renamed from: u0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class AsyncTaskC0366a extends AsyncTask<String, Integer, String> {
        public AsyncTaskC0366a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            String str;
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return C1601b.c(C1600a.this.f37562b, str);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (H7.a.b()) {
                H7.b.e("FdnPresenter", "onPostExecute name:");
            }
            if (C1600a.this.f37561a != null && !TextUtils.isEmpty(str)) {
                C1600a.this.f37561a.y(str);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public C1600a(Context context, e eVar) {
        super(context, eVar);
    }

    @Override // w0.d
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            new AsyncTaskC0366a().execute(str);
        }
    }
}
