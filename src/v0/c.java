package v0;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.android.contacts.cust.business.export.CustCustomizeFeature;
import t0.C1579c;
import w0.m;
import w0.n;

/* compiled from: SdnPresenter.java */
/* loaded from: classes.dex */
public class c extends m {

    /* compiled from: SdnPresenter.java */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, Integer, String> {

        /* renamed from: a, reason: collision with root package name */
        public int f37378a;

        public a(int i10) {
            this.f37378a = i10;
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
            b d10 = b.d(c.this.f37569b);
            if (d10 == null) {
                return "";
            }
            d10.e(str, this.f37378a, true);
            if (!d10.b(str, this.f37378a)) {
                return "";
            }
            try {
                return c.this.f37569b.getResources().getString(C1579c.f37133a);
            } catch (Exception e10) {
                H7.b.c("SdnPresenter", "QuerySdnAsyncTask error" + e10);
                return "";
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (H7.a.b()) {
                H7.b.b("SdnPresenter", "onPostExecute n:" + str);
            }
            if (c.this.f37568a != null) {
                CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
                if (custCustomizeFeature.i() || custCustomizeFeature.l()) {
                    c.this.f37568a.x(str);
                }
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

    public c(Context context, n nVar) {
        super(context, nVar);
    }

    @Override // w0.m
    public void b(String str, int i10) {
        if (!TextUtils.isEmpty(str) && i10 != -1) {
            new a(i10).execute(str);
        }
    }
}
