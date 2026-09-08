package com.coui.appcompat.preference;

import X8.g;
import X8.n;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.i;
import androidx.core.content.b;
import androidx.core.view.K;
import androidx.preference.c;
import b9.C0533c;
import b9.C0535e;
import b9.C0537g;
import b9.C0539i;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.coui.appcompat.version.COUIVersionUtil;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class COUIActivityDialogFragment extends c {
    private int mClickedDialogEntryIndex;
    private i mDialog;

    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public COUIActivityDialogPreference getListPreference() {
        return (COUIActivityDialogPreference) getPreference();
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return -1;
    }

    private View getStatusBarView(Context context) {
        int statusBarHeight = getStatusBarHeight(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, statusBarHeight));
        return imageView;
    }

    public static COUIActivityDialogFragment newInstance(String str) {
        COUIActivityDialogFragment cOUIActivityDialogFragment = new COUIActivityDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cOUIActivityDialogFragment.setArguments(bundle);
        return cOUIActivityDialogFragment;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        int i10;
        final i iVar = new i(getActivity(), n.f5042n) { // from class: com.coui.appcompat.preference.COUIActivityDialogFragment.1
            @Override // android.app.Dialog, android.view.Window.Callback
            public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
                if (menuItem.getItemId() == 16908332) {
                    dismiss();
                    return true;
                }
                return super.onMenuItemSelected(i11, menuItem);
            }
        };
        this.mDialog = iVar;
        if (iVar.getWindow() != null) {
            Window window = iVar.getWindow();
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(1024);
            window.setStatusBarColor(0);
            int systemUiVisibility = decorView.getSystemUiVisibility();
            int oSVersionCode = COUIVersionUtil.getOSVersionCode();
            boolean z10 = getResources().getBoolean(C0533c.f12362b);
            if (oSVersionCode >= 6 || oSVersionCode == 0) {
                window.addFlags(Integer.MIN_VALUE);
                if (COUIDarkModeUtil.isNightMode(iVar.getContext())) {
                    i10 = systemUiVisibility & (-8209);
                } else if (!z10) {
                    i10 = systemUiVisibility | 8192;
                } else {
                    i10 = systemUiVisibility | 256;
                }
                decorView.setSystemUiVisibility(i10);
            }
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(C0539i.f12509k, (ViewGroup) null);
        COUIToolbar cOUIToolbar = (COUIToolbar) inflate.findViewById(C0537g.f12465N);
        cOUIToolbar.setNavigationIcon(b.e(cOUIToolbar.getContext(), g.f4850c));
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIActivityDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                COUIActivityDialogFragment.this.mDialog.dismiss();
            }
        });
        final AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(C0537g.f12472a);
        final ListView listView = (ListView) inflate.findViewById(C0537g.f12486o);
        View findViewById = inflate.findViewById(C0537g.f12492u);
        if (getResources().getBoolean(C0533c.f12361a)) {
            findViewById.setVisibility(8);
        }
        K.y0(listView, true);
        View statusBarView = getStatusBarView(appBarLayout.getContext());
        appBarLayout.addView(statusBarView, 0, statusBarView.getLayoutParams());
        appBarLayout.post(new Runnable() { // from class: com.coui.appcompat.preference.COUIActivityDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (!COUIActivityDialogFragment.this.isAdded()) {
                    return;
                }
                int measuredHeight = appBarLayout.getMeasuredHeight() + COUIActivityDialogFragment.this.getResources().getDimensionPixelSize(C0535e.f12442x0);
                View view = new View(appBarLayout.getContext());
                view.setVisibility(4);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
                listView.addHeaderView(view);
            }
        });
        if (getListPreference() != null) {
            this.mClickedDialogEntryIndex = getListPreference().findIndexOfValue(getListPreference().getValue());
            cOUIToolbar.setTitle(getListPreference().getDialogTitle());
            listView.setAdapter((ListAdapter) new CheckedItemAdapter(getActivity(), C0539i.f12510l, C0537g.f12479h, getListPreference().getEntries()) { // from class: com.coui.appcompat.preference.COUIActivityDialogFragment.4
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                public View getView(final int i11, View view, ViewGroup viewGroup) {
                    View view2 = super.getView(i11, view, viewGroup);
                    if (i11 == COUIActivityDialogFragment.this.mClickedDialogEntryIndex) {
                        ListView listView2 = listView;
                        listView2.setItemChecked(listView2.getHeaderViewsCount() + i11, true);
                    }
                    View findViewById2 = view2.findViewById(C0537g.f12452A);
                    int count = getCount();
                    if (findViewById2 != null) {
                        if (count != 1 && i11 != count - 1) {
                            findViewById2.setVisibility(0);
                        } else {
                            findViewById2.setVisibility(8);
                        }
                    }
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIActivityDialogFragment.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            COUIActivityDialogFragment.this.mClickedDialogEntryIndex = i11;
                            COUIActivityDialogFragment.this.onClick(null, -1);
                            iVar.dismiss();
                        }
                    });
                    COUICardListHelper.setItemCardBackground(view2, COUICardListHelper.getPositionInGroup(COUIActivityDialogFragment.this.getListPreference().getEntries().length, i11));
                    return view2;
                }
            });
        }
        listView.setChoiceMode(1);
        iVar.setContentView(inflate);
        return iVar;
    }

    @Override // androidx.preference.c, androidx.preference.f
    public void onDialogClosed(boolean z10) {
        COUIActivityDialogPreference listPreference = getListPreference();
        if (z10 && this.mClickedDialogEntryIndex >= 0) {
            String charSequence = getListPreference().getEntryValues()[this.mClickedDialogEntryIndex].toString();
            if (listPreference.callChangeListener(charSequence)) {
                listPreference.setValue(charSequence);
            }
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getPreference() == null) {
            dismiss();
        }
    }
}
