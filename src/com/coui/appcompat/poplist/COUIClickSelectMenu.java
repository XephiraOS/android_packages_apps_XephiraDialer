package com.coui.appcompat.poplist;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.coui.appcompat.poplist.COUIClickSelectMenu;
import com.coui.appcompat.poplist.COUIContextMenu;
import com.coui.appcompat.poplist.PreciseClickHelper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIClickSelectMenu {
    private boolean mEnable;
    private PreciseClickHelper mHelper;
    private InputMethodManager mInputManager;
    private PreciseClickHelper.OnPreciseClickListener mListener;
    private COUIContextMenu.MenuShowStateListener mMenuShowStateListener;
    private final COUIPopupListWindow mPopup;

    /* renamed from: com.coui.appcompat.poplist.COUIClickSelectMenu$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements PreciseClickHelper.OnPreciseClickListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(View view, int i10, int i11) {
            COUIClickSelectMenu.this.setPopupShow(view, i10, i11);
        }

        @Override // com.coui.appcompat.poplist.PreciseClickHelper.OnPreciseClickListener
        public void onClick(final View view, final int i10, final int i11) {
            if (COUIClickSelectMenu.this.mListener != null) {
                COUIClickSelectMenu.this.mListener.onClick(view, i10, i11);
            }
            if (COUIClickSelectMenu.this.mInputManager != null && COUIClickSelectMenu.this.mInputManager.hideSoftInputFromWindow(view.getWindowToken(), 0)) {
                view.postDelayed(new Runnable() { // from class: com.coui.appcompat.poplist.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        COUIClickSelectMenu.AnonymousClass1.this.lambda$onClick$0(view, i10, i11);
                    }
                }, view.getContext().getResources().getInteger(X8.i.f4969h));
            } else {
                COUIClickSelectMenu.this.setPopupShow(view, i10, i11);
            }
        }
    }

    public COUIClickSelectMenu(Context context) {
        this(context, null);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public COUIPopupListWindow getPopup() {
        return this.mPopup;
    }

    public void registerForClickSelectItems(View view, ArrayList<PopupListItem> arrayList) {
        if (arrayList.size() <= 0) {
            return;
        }
        this.mPopup.setItemList(arrayList);
        view.setClickable(true);
        view.setLongClickable(true);
        this.mHelper = new PreciseClickHelper(view, new AnonymousClass1());
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z10) {
        COUIPopupListWindow cOUIPopupListWindow;
        if (this.mEnable && (cOUIPopupListWindow = this.mPopup) != null) {
            cOUIPopupListWindow.setEnableAddExtraWidth(z10);
        }
    }

    public void setHelperEnabled(boolean z10) {
        PreciseClickHelper preciseClickHelper = this.mHelper;
        if (preciseClickHelper != null) {
            this.mEnable = z10;
            if (z10) {
                preciseClickHelper.setup();
            } else {
                preciseClickHelper.unSet();
            }
        }
    }

    @Deprecated
    public void setMaxShowItemCount(int i10) {
        COUIPopupListWindow cOUIPopupListWindow = this.mPopup;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.setMaxShowItemCount(i10);
        }
    }

    public void setMenuShowStateListener(COUIContextMenu.MenuShowStateListener menuShowStateListener) {
        this.mMenuShowStateListener = menuShowStateListener;
        this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.poplist.COUIClickSelectMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (COUIClickSelectMenu.this.mMenuShowStateListener != null) {
                    COUIClickSelectMenu.this.mMenuShowStateListener.onDismiss();
                }
            }
        });
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mPopup.setOnItemClickListener(onItemClickListener);
    }

    public void setOnPreciseClickListener(PreciseClickHelper.OnPreciseClickListener onPreciseClickListener) {
        this.mListener = onPreciseClickListener;
    }

    public void setPopupShow(View view) {
        setPopupShow(view, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void setPopupState(boolean z10) {
        if (z10 && this.mEnable) {
            this.mPopup.show();
            COUIContextMenu.MenuShowStateListener menuShowStateListener = this.mMenuShowStateListener;
            if (menuShowStateListener != null) {
                menuShowStateListener.onShow();
                return;
            }
            return;
        }
        dismiss();
    }

    public void setSubMenuItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mPopup.setSubMenuClickListener(onItemClickListener);
    }

    public COUIClickSelectMenu(Context context, View view) {
        this.mEnable = true;
        COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(context);
        this.mPopup = cOUIPopupListWindow;
        if (view != null) {
            cOUIPopupListWindow.setAnchorView(view);
        }
        this.mInputManager = (InputMethodManager) context.getSystemService("input_method");
    }

    public void setPopupShow(View view, int i10, int i11) {
        if (this.mEnable) {
            this.mPopup.show(view, i10, i11);
            COUIContextMenu.MenuShowStateListener menuShowStateListener = this.mMenuShowStateListener;
            if (menuShowStateListener != null) {
                menuShowStateListener.onShow();
            }
        }
    }

    @Deprecated
    public void registerForClickSelectItems(View view, ArrayList<PopupListItem> arrayList, int i10) {
        registerForClickSelectItems(view, arrayList);
        this.mPopup.setSelectItemColor(i10);
    }
}
