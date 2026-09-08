package com.coui.appcompat.autocomplete;

import Z8.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.coui.appcompat.edittext.COUIEditText;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIAutoCompleteHelper {
    private static final int POPUP_WINDOW_DELAY_TIME = 300;
    private AutoCompleteTextChangeListener mAutoCompleteTextChangeListener;

    /* renamed from: com.coui.appcompat.autocomplete.COUIAutoCompleteHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements View.OnTouchListener {
        final /* synthetic */ EditText val$editText;
        final /* synthetic */ List val$historyDataList;
        final /* synthetic */ COUIAutoCompletePopupWindow val$popupWindow;

        public AnonymousClass2(EditText editText, COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow, List list) {
            this.val$editText = editText;
            this.val$popupWindow = cOUIAutoCompletePopupWindow;
            this.val$historyDataList = list;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 && this.val$editText.isCursorVisible()) {
                COUIAutoCompleteHelper.this.showPopupWindow(this.val$popupWindow, this.val$historyDataList, this.val$editText);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface AutoCompleteTextChangeListener {
        List<PopupListData> afterTextChanged(Editable editable);
    }

    /* loaded from: classes.dex */
    public static class PopupListData {
        private boolean mCanDel;
        private Drawable mIcon;
        private String mSummary;
        private String mTitle;

        public PopupListData(String str) {
            this(str, null);
        }

        public boolean getCanDel() {
            return this.mCanDel;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public String getSummary() {
            return this.mSummary;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public PopupListData(String str, String str2) {
            this(str, str2, null);
        }

        public PopupListData(String str, String str2, Drawable drawable) {
            this(str, str2, drawable, false);
        }

        public PopupListData(String str, String str2, Drawable drawable, boolean z10) {
            this.mTitle = str;
            this.mSummary = str2;
            this.mIcon = drawable;
            this.mCanDel = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow(final COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow, List<PopupListData> list, final EditText editText) {
        if (cOUIAutoCompletePopupWindow != null && !cOUIAutoCompletePopupWindow.isShowing()) {
            List<PopupListData> itemList = cOUIAutoCompletePopupWindow.getItemList();
            itemList.clear();
            itemList.addAll(list);
            cOUIAutoCompletePopupWindow.notifyAdapterChange();
            editText.postDelayed(new Runnable() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompleteHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!cOUIAutoCompletePopupWindow.isShowing() && cOUIAutoCompletePopupWindow.getItemList().size() > 0) {
                        cOUIAutoCompletePopupWindow.show(editText);
                    }
                }
            }, 300L);
        }
    }

    public COUIAutoCompletePopupWindow setAutoCompleteData(Context context, EditText editText, List<PopupListData> list) {
        return setAutoCompleteData(context, editText, null, list);
    }

    public void setAutoCompleteTextChangeListener(AutoCompleteTextChangeListener autoCompleteTextChangeListener) {
        this.mAutoCompleteTextChangeListener = autoCompleteTextChangeListener;
    }

    public COUIAutoCompletePopupWindow setAutoCompleteData(Context context, EditText editText, List<PopupListData> list, List<PopupListData> list2) {
        return setAutoCompleteData(context, editText, list, list2, null);
    }

    public COUIAutoCompletePopupWindow setAutoCompleteData(Context context, EditText editText, List<PopupListData> list, List<PopupListData> list2, View.OnFocusChangeListener onFocusChangeListener) {
        return setAutoCompleteData(context, editText, list, list2, onFocusChangeListener, true);
    }

    public COUIAutoCompletePopupWindow setAutoCompleteData(Context context, final EditText editText, final List<PopupListData> list, final List<PopupListData> list2, final View.OnFocusChangeListener onFocusChangeListener, boolean z10) {
        if (list2 == null || list2.isEmpty() || editText == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        final COUIAutoCompletePopupWindow cOUIAutoCompletePopupWindow = new COUIAutoCompletePopupWindow(context);
        cOUIAutoCompletePopupWindow.setOffset(0, context.getResources().getDimensionPixelOffset(c.f6014e), 0, context.getResources().getDimensionPixelOffset(c.f6012d));
        cOUIAutoCompletePopupWindow.setItemList(arrayList);
        cOUIAutoCompletePopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompleteHelper.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (i10 < cOUIAutoCompletePopupWindow.getItemList().size()) {
                    cOUIAutoCompletePopupWindow.setIsSetFromItemClick(true);
                    editText.setText(cOUIAutoCompletePopupWindow.getItemList().get(i10).mTitle);
                }
            }
        });
        View.OnFocusChangeListener onFocusChangeListener2 = new View.OnFocusChangeListener() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompleteHelper.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z11) {
                List list3;
                View.OnFocusChangeListener onFocusChangeListener3 = onFocusChangeListener;
                if (onFocusChangeListener3 != null) {
                    onFocusChangeListener3.onFocusChange(view, z11);
                }
                if (!z11 && cOUIAutoCompletePopupWindow.isShowing()) {
                    cOUIAutoCompletePopupWindow.dismiss();
                } else if (z11 && (list3 = list) != null && list3.size() > 0) {
                    COUIAutoCompleteHelper.this.showPopupWindow(cOUIAutoCompletePopupWindow, list, editText);
                }
            }
        };
        if (editText instanceof COUIEditText) {
            ((COUIEditText) editText).setEditFocusChangeListener(onFocusChangeListener2);
        } else {
            editText.setOnFocusChangeListener(onFocusChangeListener2);
        }
        if (z10) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompleteHelper.4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable.length() > 0) {
                        if (cOUIAutoCompletePopupWindow.getIsSetFromItemClick()) {
                            cOUIAutoCompletePopupWindow.setIsSetFromItemClick(false);
                            cOUIAutoCompletePopupWindow.dismiss();
                            return;
                        }
                        List<PopupListData> itemList = cOUIAutoCompletePopupWindow.getItemList();
                        itemList.clear();
                        if (COUIAutoCompleteHelper.this.mAutoCompleteTextChangeListener != null) {
                            itemList.addAll(COUIAutoCompleteHelper.this.mAutoCompleteTextChangeListener.afterTextChanged(editable));
                        } else {
                            for (PopupListData popupListData : list2) {
                                if (popupListData.getTitle().contains(editable.toString())) {
                                    itemList.add(popupListData);
                                }
                            }
                        }
                        cOUIAutoCompletePopupWindow.notifyAdapterChange();
                        if (!itemList.isEmpty()) {
                            if (cOUIAutoCompletePopupWindow.isShowing()) {
                                cOUIAutoCompletePopupWindow.show(editText, false);
                                return;
                            } else {
                                cOUIAutoCompletePopupWindow.show(editText);
                                return;
                            }
                        }
                        cOUIAutoCompletePopupWindow.dismiss();
                        return;
                    }
                    List list3 = list;
                    if (list3 != null && list3.size() > 0) {
                        List<PopupListData> itemList2 = cOUIAutoCompletePopupWindow.getItemList();
                        itemList2.clear();
                        itemList2.addAll(list);
                        cOUIAutoCompletePopupWindow.notifyAdapterChange();
                        if (cOUIAutoCompletePopupWindow.isShowing()) {
                            cOUIAutoCompletePopupWindow.show(editText, false);
                            return;
                        } else {
                            cOUIAutoCompletePopupWindow.show(editText);
                            return;
                        }
                    }
                    cOUIAutoCompletePopupWindow.dismiss();
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }
            });
        }
        return cOUIAutoCompletePopupWindow;
    }
}
