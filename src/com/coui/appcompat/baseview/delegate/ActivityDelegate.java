package com.coui.appcompat.baseview.delegate;

import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.core.view.V;
import com.coui.appcompat.baseview.base.COUIBaseActivity;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.coui.appcompat.baseview.util.SystemBarUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C1229j;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ActivityDelegate.kt */
/* loaded from: classes.dex */
public final class ActivityDelegate {
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_PERMISSION_CODE = 1000;
    private final COUIBaseActivity activity;
    private FoldModeObserver observer;
    private final ArrayList<String> permissionNotGrantedList;
    private final ArrayList<String> permissionRationaleList;
    private final ArrayList<String> permissionRequestList;

    /* compiled from: ActivityDelegate.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: ActivityDelegate.kt */
    /* loaded from: classes.dex */
    public static final class FoldModeObserver implements FoldSettingsHelper.FoldSettingsObserver {
        private final WeakReference<COUIBaseActivity> reference;

        public FoldModeObserver(COUIBaseActivity activity) {
            i.f(activity, "activity");
            this.reference = new WeakReference<>(activity);
        }

        @Override // com.coui.appcompat.baseview.util.FoldSettingsHelper.FoldSettingsObserver
        public void observe(int i10) {
            COUIBaseActivity cOUIBaseActivity = this.reference.get();
            if (cOUIBaseActivity != null) {
                cOUIBaseActivity.setRequestedOrientation(cOUIBaseActivity.getOrientation(i10));
                cOUIBaseActivity.onFoldModeChange(i10);
            }
        }
    }

    public ActivityDelegate(COUIBaseActivity activity) {
        i.f(activity, "activity");
        this.activity = activity;
        this.permissionNotGrantedList = new ArrayList<>();
        this.permissionRequestList = new ArrayList<>();
        this.permissionRationaleList = new ArrayList<>();
    }

    private final boolean checkAndRequestPermissions(String[] strArr) {
        List<String> K10;
        K10 = C1229j.K(strArr);
        for (String str : K10) {
            if (b.a(this.activity, str) == -1) {
                this.permissionNotGrantedList.add(str);
            }
        }
        return this.permissionNotGrantedList.isEmpty();
    }

    private final boolean checkPermissionRationale() {
        List<String> M10;
        M10 = CollectionsKt___CollectionsKt.M(this.permissionNotGrantedList);
        for (String str : M10) {
            if (a.t(this.activity, str)) {
                this.permissionRationaleList.add(str);
            } else {
                this.permissionRequestList.add(str);
            }
        }
        return this.permissionRequestList.isEmpty();
    }

    private final void showPermissionRationale() {
        this.activity.showPermissionRationale(this.permissionRationaleList);
    }

    public final void onCreate() {
        int statusType = this.activity.getStatusType();
        if (statusType != 0) {
            if (statusType == 1) {
                V.b(this.activity.getWindow(), false);
                this.activity.getWindow().setStatusBarColor(0);
            }
        } else {
            SystemBarUtil.setStatusBarTransparentAndBlackFont(this.activity);
            ActionBar supportActionBar = this.activity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.t(this.activity.isHomeAsUpEnabled());
            }
        }
        COUIThemeOverlay.getInstance().applyThemeOverlays(this.activity);
        if (this.activity.getNeedFoldObserver()) {
            FoldSettingsHelper foldSettingsHelper = FoldSettingsHelper.INSTANCE;
            foldSettingsHelper.init(this.activity);
            if (foldSettingsHelper.isSupportFoldScreen()) {
                COUIBaseActivity cOUIBaseActivity = this.activity;
                cOUIBaseActivity.setRequestedOrientation(cOUIBaseActivity.getOrientation(foldSettingsHelper.getFoldStatus()));
                FoldModeObserver foldModeObserver = new FoldModeObserver(this.activity);
                this.observer = foldModeObserver;
                foldSettingsHelper.registerFoldObserver(foldModeObserver);
            }
        }
    }

    public final void onDestroy() {
        if (this.activity.getNeedFoldObserver()) {
            FoldSettingsHelper foldSettingsHelper = FoldSettingsHelper.INSTANCE;
            if (foldSettingsHelper.isSupportFoldScreen()) {
                FoldModeObserver foldModeObserver = this.observer;
                if (foldModeObserver == null) {
                    i.q("observer");
                    foldModeObserver = null;
                }
                foldSettingsHelper.unregisterFoldObserver(foldModeObserver);
            }
        }
    }

    public final void onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() == 16908332) {
            this.activity.finish();
        }
    }

    public final void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        boolean z10;
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        if (i10 == 1000) {
            if (grantResults.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                int length = permissions.length;
                for (int i11 = 0; i11 < length; i11++) {
                    if (grantResults[i11] == 0) {
                        arrayList.add(permissions[i11]);
                    } else {
                        arrayList2.add(permissions[i11]);
                    }
                }
                this.activity.permissionsGranted(arrayList);
                this.activity.permissionsNotGranted(arrayList2);
            }
        }
        showPermissionRationale();
    }

    public final void requestPermissions(String[] strArr) {
        if (strArr != null && strArr.length != 0 && this.activity.shouldRequestPermission()) {
            if (checkAndRequestPermissions(strArr)) {
                this.activity.permissionAllGranted();
            } else if (checkPermissionRationale()) {
                showPermissionRationale();
            } else {
                a.q(this.activity, (String[]) this.permissionRequestList.toArray(new String[0]), 1000);
            }
        }
    }
}
