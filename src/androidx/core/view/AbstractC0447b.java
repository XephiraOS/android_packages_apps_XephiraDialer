package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0447b {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private a mSubUiVisibilityListener;
    private InterfaceC0110b mVisibilityListener;

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.view.b$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public AbstractC0447b(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(a aVar) {
        this.mSubUiVisibilityListener = aVar;
    }

    public void setVisibilityListener(InterfaceC0110b interfaceC0110b) {
        if (this.mVisibilityListener != null && interfaceC0110b != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = interfaceC0110b;
    }

    public void subUiVisibilityChanged(boolean z10) {
        a aVar = this.mSubUiVisibilityListener;
        if (aVar != null) {
            aVar.a(z10);
        }
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }
}
