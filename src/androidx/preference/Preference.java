package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.preference.j;
import f.C0991a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private static final String CLIPBOARD_ID = "Preference";
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private final Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private b mListener;
    private c mOnChangeListener;
    private d mOnClickListener;
    private e mOnCopyListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;
    private androidx.preference.e mPreferenceDataStore;
    private j mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private f mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    /* loaded from: classes.dex */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<BaseSavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int i10) {
                return new BaseSavedState[i10];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.performClick(view);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Preference preference);

        void c(Preference preference);

        void e(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean k0(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean s0(Preference preference);
    }

    /* loaded from: classes.dex */
    public static class e implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Preference f10547a;

        public e(Preference preference) {
            this.f10547a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence summary = this.f10547a.getSummary();
            if (this.f10547a.isCopyingEnabled() && !TextUtils.isEmpty(summary)) {
                contextMenu.setHeaderTitle(summary);
                contextMenu.add(0, 0, 0, q.f10652a).setOnMenuItemClickListener(this);
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f10547a.getContext().getSystemService("clipboard");
            CharSequence summary = this.f10547a.getSummary();
            clipboardManager.setPrimaryClip(ClipData.newPlainText(Preference.CLIPBOARD_ID, summary));
            Toast.makeText(this.f10547a.getContext(), this.f10547a.getContext().getString(q.f10655d, summary), 0).show();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface f<T extends Preference> {
        CharSequence a(T t10);
    }

    public Preference(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        int i12 = p.f10649b;
        this.mLayoutResId = i12;
        this.mClickListener = new a();
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f10676J, i10, i11);
        this.mIconResId = A.k.n(obtainStyledAttributes, s.f10732h0, s.f10678K, 0);
        this.mKey = A.k.o(obtainStyledAttributes, s.f10741k0, s.f10690Q);
        this.mTitle = A.k.p(obtainStyledAttributes, s.f10757s0, s.f10686O);
        this.mSummary = A.k.p(obtainStyledAttributes, s.f10755r0, s.f10692R);
        this.mOrder = A.k.d(obtainStyledAttributes, s.f10745m0, s.f10694S, Integer.MAX_VALUE);
        this.mFragment = A.k.o(obtainStyledAttributes, s.f10729g0, s.f10704X);
        this.mLayoutResId = A.k.n(obtainStyledAttributes, s.f10743l0, s.f10684N, i12);
        this.mWidgetLayoutResId = A.k.n(obtainStyledAttributes, s.f10759t0, s.f10696T, 0);
        this.mEnabled = A.k.b(obtainStyledAttributes, s.f10726f0, s.f10682M, true);
        this.mSelectable = A.k.b(obtainStyledAttributes, s.f10749o0, s.f10688P, true);
        this.mPersistent = A.k.b(obtainStyledAttributes, s.f10747n0, s.f10680L, true);
        this.mDependencyKey = A.k.o(obtainStyledAttributes, s.f10720d0, s.f10698U);
        int i13 = s.f10711a0;
        this.mAllowDividerAbove = A.k.b(obtainStyledAttributes, i13, i13, this.mSelectable);
        int i14 = s.f10714b0;
        this.mAllowDividerBelow = A.k.b(obtainStyledAttributes, i14, i14, this.mSelectable);
        int i15 = s.f10717c0;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i15);
        } else {
            int i16 = s.f10700V;
            if (obtainStyledAttributes.hasValue(i16)) {
                this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i16);
            }
        }
        this.mShouldDisableView = A.k.b(obtainStyledAttributes, s.f10751p0, s.f10702W, true);
        int i17 = s.f10753q0;
        boolean hasValue = obtainStyledAttributes.hasValue(i17);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = A.k.b(obtainStyledAttributes, i17, s.f10706Y, true);
        }
        this.mIconSpaceReserved = A.k.b(obtainStyledAttributes, s.f10735i0, s.f10708Z, false);
        int i18 = s.f10738j0;
        this.mVisible = A.k.b(obtainStyledAttributes, i18, i18, true);
        int i19 = s.f10723e0;
        this.mCopyingEnabled = A.k.b(obtainStyledAttributes, i19, i19, false);
        obtainStyledAttributes.recycle();
    }

    private void dispatchSetInitialValue() {
        getPreferenceDataStore();
        if (shouldPersist() && getSharedPreferences().contains(this.mKey)) {
            onSetInitialValue(true, null);
            return;
        }
        Object obj = this.mDefaultValue;
        if (obj != null) {
            onSetInitialValue(false, obj);
        }
    }

    private void registerDependency() {
        if (TextUtils.isEmpty(this.mDependencyKey)) {
            return;
        }
        Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
        if (findPreferenceInHierarchy != null) {
            findPreferenceInHierarchy.registerDependent(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + ((Object) this.mTitle) + "\"");
    }

    private void registerDependent(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean z10) {
        view.setEnabled(z10);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z10);
            }
        }
    }

    private void tryCommit(SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.t()) {
            editor.apply();
        }
    }

    private void unregisterDependency() {
        Preference findPreferenceInHierarchy;
        String str = this.mDependencyKey;
        if (str != null && (findPreferenceInHierarchy = findPreferenceInHierarchy(str)) != null) {
            findPreferenceInHierarchy.unregisterDependent(this);
        }
    }

    private void unregisterDependent(Preference preference) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            list.remove(preference);
        }
    }

    public void assignParent(PreferenceGroup preferenceGroup) {
        if (preferenceGroup != null && this.mParentGroup != null) {
            throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
        }
        this.mParentGroup = preferenceGroup;
    }

    public boolean callChangeListener(Object obj) {
        c cVar = this.mOnChangeListener;
        if (cVar != null && !cVar.k0(this, obj)) {
            return false;
        }
        return true;
    }

    public final void clearWasDetached() {
        this.mWasDetached = false;
    }

    public void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.mKey)) != null) {
            this.mBaseMethodCalled = false;
            onRestoreInstanceState(parcelable);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (this.mBaseMethodCalled) {
                if (onSaveInstanceState != null) {
                    bundle.putParcelable(this.mKey, onSaveInstanceState);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
    }

    public <T extends Preference> T findPreferenceInHierarchy(String str) {
        j jVar = this.mPreferenceManager;
        if (jVar == null) {
            return null;
        }
        return (T) jVar.a(str);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        int i10;
        if (this.mIcon == null && (i10 = this.mIconResId) != 0) {
            this.mIcon = C0991a.b(this.mContext, i10);
        }
        return this.mIcon;
    }

    public long getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public c getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public d getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    public boolean getPersistedBoolean(boolean z10) {
        if (!shouldPersist()) {
            return z10;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getBoolean(this.mKey, z10);
    }

    public float getPersistedFloat(float f10) {
        if (!shouldPersist()) {
            return f10;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getFloat(this.mKey, f10);
    }

    public int getPersistedInt(int i10) {
        if (!shouldPersist()) {
            return i10;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getInt(this.mKey, i10);
    }

    public long getPersistedLong(long j10) {
        if (!shouldPersist()) {
            return j10;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getLong(this.mKey, j10);
    }

    public String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getString(this.mKey, str);
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        getPreferenceDataStore();
        return this.mPreferenceManager.l().getStringSet(this.mKey, set);
    }

    public androidx.preference.e getPreferenceDataStore() {
        j jVar = this.mPreferenceManager;
        if (jVar != null) {
            jVar.j();
        }
        return null;
    }

    public j getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager != null) {
            getPreferenceDataStore();
            return this.mPreferenceManager.l();
        }
        return null;
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().a(this);
        }
        return this.mSummary;
    }

    public final f getSummaryProvider() {
        return this.mSummaryProvider;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isCopyingEnabled() {
        return this.mCopyingEnabled;
    }

    public boolean isEnabled() {
        if (this.mEnabled && this.mDependencyMet && this.mParentDependencyMet) {
            return true;
        }
        return false;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().k()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public void notifyChanged() {
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    public void notifyDependencyChange(boolean z10) {
        List<Preference> list = this.mDependents;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).onDependencyChanged(this, z10);
        }
    }

    public void notifyHierarchyChanged() {
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void onAttached() {
        registerDependency();
    }

    public void onAttachedToHierarchy(j jVar) {
        this.mPreferenceManager = jVar;
        if (!this.mHasId) {
            this.mId = jVar.f();
        }
        dispatchSetInitialValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.preference.l r9) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.onBindViewHolder(androidx.preference.l):void");
    }

    public void onDependencyChanged(Preference preference, boolean z10) {
        if (this.mDependencyMet == z10) {
            this.mDependencyMet = !z10;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return null;
    }

    public void onParentChanged(Preference preference, boolean z10) {
        if (this.mParentDependencyMet == z10) {
            this.mParentDependencyMet = !z10;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onPrepareForRemoval() {
        unregisterDependency();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void onSetInitialValue(Object obj) {
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    public void performClick(View view) {
        performClick();
    }

    public boolean persistBoolean(boolean z10) {
        if (!shouldPersist()) {
            return false;
        }
        if (z10 == getPersistedBoolean(!z10)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putBoolean(this.mKey, z10);
        tryCommit(e10);
        return true;
    }

    public boolean persistFloat(float f10) {
        if (!shouldPersist()) {
            return false;
        }
        if (f10 == getPersistedFloat(Float.NaN)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putFloat(this.mKey, f10);
        tryCommit(e10);
        return true;
    }

    public boolean persistInt(int i10) {
        if (!shouldPersist()) {
            return false;
        }
        if (i10 == getPersistedInt(~i10)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putInt(this.mKey, i10);
        tryCommit(e10);
        return true;
    }

    public boolean persistLong(long j10) {
        if (!shouldPersist()) {
            return false;
        }
        if (j10 == getPersistedLong(~j10)) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putLong(this.mKey, j10);
        tryCommit(e10);
        return true;
    }

    public boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(str, getPersistedString(null))) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putString(this.mKey, str);
        tryCommit(e10);
        return true;
    }

    public boolean persistStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(getPersistedStringSet(null))) {
            return true;
        }
        getPreferenceDataStore();
        SharedPreferences.Editor e10 = this.mPreferenceManager.e();
        e10.putStringSet(this.mKey, set);
        tryCommit(e10);
        return true;
    }

    public void requireKey() {
        if (!TextUtils.isEmpty(this.mKey)) {
            this.mRequiresKey = true;
            return;
        }
        throw new IllegalStateException("Preference does not have a key assigned.");
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCopyingEnabled(boolean z10) {
        if (this.mCopyingEnabled != z10) {
            this.mCopyingEnabled = z10;
            notifyChanged();
        }
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        unregisterDependency();
        this.mDependencyKey = str;
        registerDependency();
    }

    public void setEnabled(boolean z10) {
        if (this.mEnabled != z10) {
            this.mEnabled = z10;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            this.mIconResId = 0;
            notifyChanged();
        }
    }

    public void setIconSpaceReserved(boolean z10) {
        if (this.mIconSpaceReserved != z10) {
            this.mIconSpaceReserved = z10;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (this.mRequiresKey && !hasKey()) {
            requireKey();
        }
    }

    public void setLayoutResource(int i10) {
        this.mLayoutResId = i10;
    }

    public final void setOnPreferenceChangeInternalListener(b bVar) {
        this.mListener = bVar;
    }

    public void setOnPreferenceChangeListener(c cVar) {
        this.mOnChangeListener = cVar;
    }

    public void setOnPreferenceClickListener(d dVar) {
        this.mOnClickListener = dVar;
    }

    public void setOrder(int i10) {
        if (i10 != this.mOrder) {
            this.mOrder = i10;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z10) {
        this.mPersistent = z10;
    }

    public void setSelectable(boolean z10) {
        if (this.mSelectable != z10) {
            this.mSelectable = z10;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z10) {
        if (this.mShouldDisableView != z10) {
            this.mShouldDisableView = z10;
            notifyChanged();
        }
    }

    public void setSingleLineTitle(boolean z10) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = z10;
    }

    public void setSummary(CharSequence charSequence) {
        if (getSummaryProvider() == null) {
            if (TextUtils.equals(this.mSummary, charSequence)) {
                return;
            }
            this.mSummary = charSequence;
            notifyChanged();
            return;
        }
        throw new IllegalStateException("Preference already has a SummaryProvider set.");
    }

    public final void setSummaryProvider(f fVar) {
        this.mSummaryProvider = fVar;
        notifyChanged();
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.mTitle)) {
            return;
        }
        this.mTitle = charSequence;
        notifyChanged();
    }

    public void setViewId(int i10) {
        this.mViewId = i10;
    }

    public final void setVisible(boolean z10) {
        if (this.mVisible != z10) {
            this.mVisible = z10;
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.c(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i10) {
        this.mWidgetLayoutResId = i10;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public boolean shouldPersist() {
        if (this.mPreferenceManager != null && isPersistent() && hasKey()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    public final boolean wasDetached() {
        return this.mWasDetached;
    }

    @Override // java.lang.Comparable
    public int compareTo(Preference preference) {
        int i10 = this.mOrder;
        int i11 = preference.mOrder;
        if (i10 != i11) {
            return i10 - i11;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    @Deprecated
    public void onSetInitialValue(boolean z10, Object obj) {
        onSetInitialValue(obj);
    }

    public void performClick() {
        j.c h10;
        if (isEnabled() && isSelectable()) {
            onClick();
            d dVar = this.mOnClickListener;
            if (dVar == null || !dVar.s0(this)) {
                j preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (h10 = preferenceManager.h()) == null || !h10.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public void setTitle(int i10) {
        setTitle(this.mContext.getString(i10));
    }

    public void onAttachedToHierarchy(j jVar, long j10) {
        this.mId = j10;
        this.mHasId = true;
        try {
            onAttachedToHierarchy(jVar);
        } finally {
            this.mHasId = false;
        }
    }

    public void setIcon(int i10) {
        setIcon(C0991a.b(this.mContext, i10));
        this.mIconResId = i10;
    }

    public void setSummary(int i10) {
        setSummary(this.mContext.getString(i10));
    }

    public void onClick() {
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(J.d dVar) {
    }

    public void setPreferenceDataStore(androidx.preference.e eVar) {
    }

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A.k.a(context, m.f10636h, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
