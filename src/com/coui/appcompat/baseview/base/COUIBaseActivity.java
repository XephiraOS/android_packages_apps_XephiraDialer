package com.coui.appcompat.baseview.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.coui.appcompat.baseview.delegate.ActivityConfig;
import com.coui.appcompat.baseview.delegate.ActivityDelegate;
import com.coui.appcompat.baseview.util.SystemBarUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.i;

/* compiled from: COUIBaseActivity.kt */
/* loaded from: classes.dex */
public abstract class COUIBaseActivity extends AppCompatActivity implements ActivityConfig {
    private ActivityDelegate activityDelegate;

    @Override // com.coui.appcompat.baseview.delegate.ActivityConfig
    public boolean getNeedFoldObserver() {
        return true;
    }

    public abstract int getOrientation(int i10);

    public final View getStatusBarView() {
        return SystemBarUtil.getStatusBarView(this);
    }

    @Override // com.coui.appcompat.baseview.delegate.ActivityConfig
    public int getStatusType() {
        return 0;
    }

    @Override // com.coui.appcompat.baseview.delegate.ActivityConfig
    public boolean isHomeAsUpEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityDelegate activityDelegate = new ActivityDelegate(this);
        this.activityDelegate = activityDelegate;
        activityDelegate.onCreate();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityDelegate activityDelegate = this.activityDelegate;
        if (activityDelegate == null) {
            i.q("activityDelegate");
            activityDelegate = null;
        }
        activityDelegate.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        ActivityDelegate activityDelegate = this.activityDelegate;
        if (activityDelegate == null) {
            i.q("activityDelegate");
            activityDelegate = null;
        }
        activityDelegate.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        ActivityDelegate activityDelegate = this.activityDelegate;
        if (activityDelegate == null) {
            i.q("activityDelegate");
            activityDelegate = null;
        }
        activityDelegate.onRequestPermissionsResult(i10, permissions, grantResults);
    }

    public void permissionsGranted(ArrayList<String> permissionGrantedList) {
        i.f(permissionGrantedList, "permissionGrantedList");
    }

    public void permissionsNotGranted(ArrayList<String> permissionNotGrantedList) {
        i.f(permissionNotGrantedList, "permissionNotGrantedList");
    }

    public final void requestRuntimePermissions(String[] strArr) {
        ActivityDelegate activityDelegate = this.activityDelegate;
        if (activityDelegate == null) {
            i.q("activityDelegate");
            activityDelegate = null;
        }
        activityDelegate.requestPermissions(strArr);
    }

    public boolean shouldRequestPermission() {
        return false;
    }

    public void showPermissionRationale(ArrayList<String> permissionRationaleList) {
        i.f(permissionRationaleList, "permissionRationaleList");
    }

    public void onFoldModeChange(int i10) {
    }

    public void permissionAllGranted() {
    }
}
