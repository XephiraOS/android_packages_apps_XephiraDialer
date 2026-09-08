package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import f.C0991a;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;

    /* loaded from: classes.dex */
    public interface a {
        <T extends Preference> T findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f10737j, i10, i11);
        String o10 = A.k.o(obtainStyledAttributes, s.f10758t, s.f10740k);
        this.mDialogTitle = o10;
        if (o10 == null) {
            this.mDialogTitle = getTitle();
        }
        this.mDialogMessage = A.k.o(obtainStyledAttributes, s.f10756s, s.f10742l);
        this.mDialogIcon = A.k.c(obtainStyledAttributes, s.f10752q, s.f10744m);
        this.mPositiveButtonText = A.k.o(obtainStyledAttributes, s.f10762v, s.f10746n);
        this.mNegativeButtonText = A.k.o(obtainStyledAttributes, s.f10760u, s.f10748o);
        this.mDialogLayoutResId = A.k.n(obtainStyledAttributes, s.f10754r, s.f10750p, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        getPreferenceManager().u(this);
    }

    public void setDialogIcon(Drawable drawable) {
        this.mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i10) {
        this.mDialogLayoutResId = i10;
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.mDialogMessage = charSequence;
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.mDialogTitle = charSequence;
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.mNegativeButtonText = charSequence;
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.mPositiveButtonText = charSequence;
    }

    public void setDialogIcon(int i10) {
        this.mDialogIcon = C0991a.b(getContext(), i10);
    }

    public void setDialogMessage(int i10) {
        setDialogMessage(getContext().getString(i10));
    }

    public void setDialogTitle(int i10) {
        setDialogTitle(getContext().getString(i10));
    }

    public void setNegativeButtonText(int i10) {
        setNegativeButtonText(getContext().getString(i10));
    }

    public void setPositiveButtonText(int i10) {
        setPositiveButtonText(getContext().getString(i10));
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A.k.a(context, m.f10630b, R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }
}
