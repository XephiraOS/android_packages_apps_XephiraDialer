package com.android.contacts.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.b;
import com.android.contacts.scenecard.C0671e;
import com.android.contacts.util.w;
import com.customize.contacts.FeatureOption;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class RequestPermissionsActivity extends RequestPermissionsActivityBase {

    /* renamed from: E, reason: collision with root package name */
    public b f13643E;

    /* renamed from: F, reason: collision with root package name */
    public final BroadcastReceiver f13644F = new a();

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.android.contacts.action.SCENE_GRANT_DONE".equals(intent.getAction())) {
                H7.b.e("RequestPermissionsActivityBase", "ACTION_SCENE_GRANT_DONE");
                RequestPermissionsActivity.this.finish();
            }
        }
    }

    public static boolean p2(Activity activity) {
        if (activity.isFinishing()) {
            return true;
        }
        return RequestPermissionsActivityBase.m2(activity, w.g(), RequestPermissionsActivity.class);
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase
    public String[] N1() {
        return w.g();
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase
    public String[] O1() {
        Set<String> f10 = w.f();
        List<String> a10 = com.android.contacts.framework.api.permission.a.a();
        if (a10 != null) {
            f10.addAll(a10);
        }
        return (String[]) f10.toArray(new String[0]);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean R0() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 999) {
            if (w.l(this, N1())) {
                f2();
                return;
            }
            if (FeatureOption.o()) {
                if (shouldShowRequestPermissionRationale("android.permission.WRITE_CONTACTS") || (CommonFeatureOption.j() && shouldShowRequestPermissionRationale("android.permission.CALL_PHONE"))) {
                    g2();
                    return;
                }
            } else {
                for (String str : N1()) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        g2();
                        return;
                    }
                }
            }
            this.f13643E = w.C(this, false, null, null, N1());
        }
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C0671e.a(this, this.f13650o)) {
            this.f13649D = false;
            H7.b.e("RequestPermissionsActivityBase", "onCreate redirectSceneIntent");
        }
        X.a.b(this).c(this.f13644F, new IntentFilter("com.android.contacts.action.SCENE_GRANT_DONE"));
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        X.a.b(this).e(this.f13644F);
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (C0671e.a(this, this.f13650o)) {
            this.f13649D = false;
            H7.b.e("RequestPermissionsActivityBase", "onNewIntent redirectSceneIntent");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (strArr.length > 0 && P1(strArr, iArr)) {
            H7.b.e("RequestPermissionsActivityBase", "onRequestPermissionsResult: all granted");
            f2();
        } else {
            this.f13643E = w.C(this, false, null, null, N1());
        }
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivityBase, android.app.Activity
    public void onRestart() {
        super.onRestart();
        b bVar = this.f13643E;
        if (bVar != null && bVar.isShowing() && w.l(this, N1())) {
            f2();
        }
    }
}
