package com.coui.appcompat.poplist;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.poplist.PreciseLongPressHelper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIContextMenu {
    private static final String TAG = "COUIContextMenu";
    private PreciseLongPressHelper mHelper;
    private MenuShowStateListener mMenuShowStateListener;
    private COUIPopupListWindow mPopup;

    /* loaded from: classes.dex */
    public interface MenuShowStateListener {
        void onDismiss();

        void onShow();
    }

    public COUIContextMenu(Context context) {
        this(context, null);
    }

    public void dismiss() {
        if (this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public COUIPopupListWindow getPopupListWindow() {
        return this.mPopup;
    }

    public void registerForContextMenu(View view, MenuBuilder menuBuilder) {
        if (menuBuilder.getNonActionItems().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        PopupListItem.Builder builder = new PopupListItem.Builder();
        for (int i10 = 0; i10 < menuBuilder.getNonActionItems().size(); i10++) {
            MenuItemImpl menuItemImpl = menuBuilder.getNonActionItems().get(i10);
            builder.setId(menuItemImpl.getItemId()).setIcon(menuItemImpl.getIcon()).setTitle(menuItemImpl.getTitle().toString()).setIsChecked(menuItemImpl.isChecked()).setIsEnable(menuItemImpl.isEnabled());
            arrayList.add(builder.build());
        }
        this.mPopup.setItemList(arrayList);
        view.setLongClickable(true);
        PreciseLongPressHelper preciseLongPressHelper = new PreciseLongPressHelper(view, new PreciseLongPressHelper.OnPreciseLongClickListener() { // from class: com.coui.appcompat.poplist.COUIContextMenu.1
            @Override // com.coui.appcompat.poplist.PreciseLongPressHelper.OnPreciseLongClickListener
            public void onLongClick(View view2, int i11, int i12) {
                COUIContextMenu.this.mPopup.show(view2, i11, i12);
                if (COUIContextMenu.this.mMenuShowStateListener != null) {
                    COUIContextMenu.this.mMenuShowStateListener.onShow();
                }
            }
        });
        this.mHelper = preciseLongPressHelper;
        preciseLongPressHelper.setup();
    }

    public void setMenuShowStateListener(MenuShowStateListener menuShowStateListener) {
        this.mMenuShowStateListener = menuShowStateListener;
        this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.poplist.COUIContextMenu.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (COUIContextMenu.this.mMenuShowStateListener != null) {
                    COUIContextMenu.this.mMenuShowStateListener.onDismiss();
                }
            }
        });
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mPopup.setOnItemClickListener(onItemClickListener);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        PreciseLongPressHelper preciseLongPressHelper = this.mHelper;
        if (preciseLongPressHelper != null) {
            preciseLongPressHelper.setTouchListenerTransfer(onTouchListener);
        } else {
            Log.e(TAG, "Please call registerForContextMenu first!");
        }
    }

    public COUIContextMenu(Context context, View view) {
        COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(context);
        this.mPopup = cOUIPopupListWindow;
        if (view != null) {
            cOUIPopupListWindow.setAnchorView(view);
        }
    }

    public void registerForContextMenu(View view, final COUIPopupListWindow cOUIPopupListWindow) {
        cOUIPopupListWindow.setDismissTouchOutside(true);
        view.setLongClickable(true);
        this.mHelper = new PreciseLongPressHelper(view, new PreciseLongPressHelper.OnPreciseLongClickListener() { // from class: com.coui.appcompat.poplist.COUIContextMenu.2
            @Override // com.coui.appcompat.poplist.PreciseLongPressHelper.OnPreciseLongClickListener
            public void onLongClick(View view2, int i10, int i11) {
                cOUIPopupListWindow.show(view2, i10, i11);
                if (COUIContextMenu.this.mMenuShowStateListener != null) {
                    COUIContextMenu.this.mMenuShowStateListener.onShow();
                }
            }
        });
        cOUIPopupListWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.poplist.COUIContextMenu.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (COUIContextMenu.this.mMenuShowStateListener != null) {
                    COUIContextMenu.this.mMenuShowStateListener.onDismiss();
                }
            }
        });
        this.mHelper.setup();
    }
}
