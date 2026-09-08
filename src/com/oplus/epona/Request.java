package com.oplus.epona;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import j7.C1187a;
import k7.C1216a;

/* loaded from: classes3.dex */
public class Request implements Parcelable {
    private static final String CALLER_PACKAGE_NAME = "com.oplus.appplatform.CALLING_PACKAGE_NAME_KEY";
    public static final Parcelable.Creator<Request> CREATOR = new a();
    private final String mActionName;
    private final Bundle mBundle;
    private String mCallerPackageName;
    private final String mComponentName;
    private C1187a mRouteData;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<Request> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Request createFromParcel(Parcel parcel) {
            return new Request(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Request[] newArray(int i10) {
            return new Request[i10];
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f28131a;

        /* renamed from: b, reason: collision with root package name */
        public String f28132b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f28133c = new Bundle();

        public Request a() {
            return new Request(this.f28131a, this.f28132b, this.f28133c, null, null);
        }

        public b b(String str) {
            this.f28132b = str;
            return this;
        }

        public b c(String str) {
            this.f28131a = str;
            return this;
        }

        public b d(String str, int i10) {
            this.f28133c.putInt(str, i10);
            return this;
        }

        public b e(String str, long j10) {
            this.f28133c.putLong(str, j10);
            return this;
        }

        public b f(String str, Parcelable parcelable) {
            this.f28133c.putParcelable(str, parcelable);
            return this;
        }

        public b g(String str, String str2) {
            this.f28133c.putString(str, str2);
            return this;
        }
    }

    public /* synthetic */ Request(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean checkCallerPackageNameEmpty() {
        return TextUtils.isEmpty(this.mCallerPackageName);
    }

    private void setCallerPackageName() {
        String packageName;
        if (d.g() == null) {
            packageName = "";
        } else {
            packageName = d.g().getPackageName();
        }
        this.mCallerPackageName = packageName;
        this.mBundle.putString(CALLER_PACKAGE_NAME, packageName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActionName() {
        return this.mActionName;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public String getCallerPackageName() {
        if (checkCallerPackageNameEmpty()) {
            Bundle bundle = this.mBundle;
            if (bundle != null) {
                this.mCallerPackageName = bundle.getString(CALLER_PACKAGE_NAME);
            }
            if (checkCallerPackageNameEmpty()) {
                this.mCallerPackageName = C1216a.b(Binder.getCallingUid(), Binder.getCallingPid());
            }
        }
        return this.mCallerPackageName;
    }

    public String getComponentName() {
        return this.mComponentName;
    }

    public C1187a getRouteData() {
        return null;
    }

    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<QUERY> Calling package : [" + getCallerPackageName() + "]");
        sb.append("Component=");
        sb.append(this.mComponentName);
        sb.append(",Action=");
        sb.append(this.mActionName);
        for (String str : this.mBundle.keySet()) {
            sb.append(",key：");
            sb.append(str);
            sb.append(",value:");
            sb.append(this.mBundle.get(str));
        }
        return sb.toString();
    }

    public String toString() {
        return "CallerPackage:" + getCallerPackageName() + " ,componentName:" + this.mComponentName + " ,actionName:" + this.mActionName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mComponentName);
        parcel.writeString(this.mActionName);
        parcel.writeBundle(this.mBundle);
    }

    public /* synthetic */ Request(String str, String str2, Bundle bundle, C1187a c1187a, a aVar) {
        this(str, str2, bundle, c1187a);
    }

    private Request(String str, String str2, Bundle bundle, C1187a c1187a) {
        this.mComponentName = str;
        this.mActionName = str2;
        this.mBundle = bundle;
        setCallerPackageName();
    }

    private Request(Parcel parcel) {
        this.mComponentName = parcel.readString();
        this.mActionName = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }
}
