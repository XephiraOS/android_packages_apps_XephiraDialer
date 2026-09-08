package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.ShowableListMenu;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f7609i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final C0430d f7610a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7611b;

    /* renamed from: c, reason: collision with root package name */
    public x f7612c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f7613d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7614e;

    /* renamed from: f, reason: collision with root package name */
    public g f7615f;

    /* renamed from: g, reason: collision with root package name */
    public int f7616g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f7617h;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f7618a;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f7618a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f7618a = parcel.readByte() != 0;
        }
    }

    /* loaded from: classes.dex */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f7619a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, f fVar) {
            super(view);
            this.f7619a = fVar;
        }

        @Override // androidx.appcompat.widget.x
        public ShowableListMenu getPopup() {
            return this.f7619a;
        }

        @Override // androidx.appcompat.widget.x
        public boolean onForwardingStarted() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!I.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements g, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f7622a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f7623b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f7624c;

        public d() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int b() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void c(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence d() {
            return this.f7624c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f7622a;
            if (bVar != null) {
                bVar.dismiss();
                this.f7622a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public Drawable e() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void f(CharSequence charSequence) {
            this.f7624c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void g(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void h(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10, int i11) {
            if (this.f7623b == null) {
                return;
            }
            b.a aVar = new b.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f7624c;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.b create = aVar.setSingleChoiceItems(this.f7623b, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.f7622a = create;
            ListView c10 = create.c();
            c10.setTextDirection(i10);
            c10.setTextAlignment(i11);
            this.f7622a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public boolean isShowing() {
            androidx.appcompat.app.b bVar = this.f7622a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int j() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void k(ListAdapter listAdapter) {
            this.f7623b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f7623b.getItemId(i10));
            }
            dismiss();
        }
    }

    /* loaded from: classes.dex */
    public static class e implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f7626a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f7627b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f7626a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f7627b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    c.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof G) {
                    G g10 = (G) spinnerAdapter;
                    if (g10.getDropDownViewTheme() == null) {
                        g10.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f7627b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter != null && spinnerAdapter.hasStableIds()) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f7627b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f7626a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends ListPopupWindow implements g {

        /* renamed from: L, reason: collision with root package name */
        public CharSequence f7628L;

        /* renamed from: M, reason: collision with root package name */
        public ListAdapter f7629M;

        /* renamed from: N, reason: collision with root package name */
        public final Rect f7630N;

        /* renamed from: O, reason: collision with root package name */
        public int f7631O;

        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppCompatSpinner f7633a;

            public a(AppCompatSpinner appCompatSpinner) {
                this.f7633a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    AppCompatSpinner.this.performItemClick(view, i10, fVar.f7629M.getItemId(i10));
                }
                f.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f fVar = f.this;
                if (!fVar.R(AppCompatSpinner.this)) {
                    f.this.dismiss();
                } else {
                    f.this.P();
                    f.super.show();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f7636a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f7636a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f7636a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f7630N = new Rect();
            y(AppCompatSpinner.this);
            F(true);
            L(0);
            H(new a(AppCompatSpinner.this));
        }

        public void P() {
            int i10;
            int Q10;
            Drawable e10 = e();
            if (e10 != null) {
                e10.getPadding(AppCompatSpinner.this.f7617h);
                if (S.b(AppCompatSpinner.this)) {
                    i10 = AppCompatSpinner.this.f7617h.right;
                } else {
                    i10 = -AppCompatSpinner.this.f7617h.left;
                }
            } else {
                Rect rect = AppCompatSpinner.this.f7617h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i11 = appCompatSpinner.f7616g;
            if (i11 == -2) {
                int a10 = appCompatSpinner.a((SpinnerAdapter) this.f7629M, e());
                int i12 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f7617h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (a10 > i13) {
                    a10 = i13;
                }
                A(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                A((width - paddingLeft) - paddingRight);
            } else {
                A(i11);
            }
            if (S.b(AppCompatSpinner.this)) {
                Q10 = i10 + (((width - paddingRight) - u()) - Q());
            } else {
                Q10 = i10 + paddingLeft + Q();
            }
            c(Q10);
        }

        public int Q() {
            return this.f7631O;
        }

        public boolean R(View view) {
            if (view.isAttachedToWindow() && view.getGlobalVisibleRect(this.f7630N)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence d() {
            return this.f7628L;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void f(CharSequence charSequence) {
            this.f7628L = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void h(int i10) {
            this.f7631O = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            P();
            E(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            listView.setTextDirection(i10);
            listView.setTextAlignment(i11);
            M(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                G(new c(bVar));
            }
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.g
        public void k(ListAdapter listAdapter) {
            super.k(listAdapter);
            this.f7629M = listAdapter;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(Drawable drawable);

        int b();

        void c(int i10);

        CharSequence d();

        void dismiss();

        Drawable e();

        void f(CharSequence charSequence);

        void g(int i10);

        void h(int i10);

        void i(int i10, int i11);

        boolean isShowing();

        int j();

        void k(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30097O);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f7617h);
            Rect rect = this.f7617h;
            return i11 + rect.left + rect.right;
        }
        return i11;
    }

    public void b() {
        this.f7615f.i(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            c0430d.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f7615f;
        if (gVar != null) {
            return gVar.b();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f7615f;
        if (gVar != null) {
            return gVar.j();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f7615f != null) {
            return this.f7616g;
        }
        return super.getDropDownWidth();
    }

    public final g getInternalPopup() {
        return this.f7615f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f7615f;
        if (gVar != null) {
            return gVar.e();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f7611b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f7615f;
        if (gVar != null) {
            return gVar.d();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            return c0430d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            return c0430d.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f7615f;
        if (gVar != null && gVar.isShowing()) {
            this.f7615f.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f7615f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f7618a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        g gVar = this.f7615f;
        if (gVar != null && gVar.isShowing()) {
            z10 = true;
        } else {
            z10 = false;
        }
        savedState.f7618a = z10;
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        x xVar = this.f7612c;
        if (xVar != null && xVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f7615f;
        if (gVar != null) {
            if (!gVar.isShowing()) {
                b();
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            c0430d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            c0430d.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        g gVar = this.f7615f;
        if (gVar != null) {
            gVar.h(i10);
            this.f7615f.c(i10);
        } else {
            super.setDropDownHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        g gVar = this.f7615f;
        if (gVar != null) {
            gVar.g(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f7615f != null) {
            this.f7616g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f7615f;
        if (gVar != null) {
            gVar.a(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(C0991a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f7615f;
        if (gVar != null) {
            gVar.f(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            c0430d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0430d c0430d = this.f7610a;
        if (c0430d != null) {
            c0430d.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f7614e) {
            this.f7613d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f7615f != null) {
            Context context = this.f7611b;
            if (context == null) {
                context = getContext();
            }
            this.f7615f.k(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
