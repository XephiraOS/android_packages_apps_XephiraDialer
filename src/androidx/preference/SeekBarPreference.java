package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public int f10551a;

    /* renamed from: b, reason: collision with root package name */
    public int f10552b;

    /* renamed from: c, reason: collision with root package name */
    public int f10553c;

    /* renamed from: d, reason: collision with root package name */
    public int f10554d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10555e;

    /* renamed from: f, reason: collision with root package name */
    public SeekBar f10556f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f10557g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10558h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10559i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10560j;

    /* renamed from: k, reason: collision with root package name */
    public final SeekBar.OnSeekBarChangeListener f10561k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnKeyListener f10562l;

    /* loaded from: classes.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.f10560j || !seekBarPreference.f10555e) {
                    seekBarPreference.d(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.e(i10 + seekBarPreference2.f10552b);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f10555e = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f10555e = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f10552b != seekBarPreference.f10551a) {
                seekBarPreference.d(seekBar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.f10558h && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f10556f;
            if (seekBar == null) {
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
            return seekBar.onKeyDown(i10, keyEvent);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f10561k = new a();
        this.f10562l = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f10673H0, i10, i11);
        this.f10552b = obtainStyledAttributes.getInt(s.f10679K0, 0);
        setMax(obtainStyledAttributes.getInt(s.f10675I0, 100));
        a(obtainStyledAttributes.getInt(s.f10681L0, 0));
        this.f10558h = obtainStyledAttributes.getBoolean(s.f10677J0, true);
        this.f10559i = obtainStyledAttributes.getBoolean(s.f10683M0, false);
        this.f10560j = obtainStyledAttributes.getBoolean(s.f10685N0, false);
        obtainStyledAttributes.recycle();
    }

    public final void a(int i10) {
        if (i10 != this.f10554d) {
            this.f10554d = Math.min(this.f10553c - this.f10552b, Math.abs(i10));
            notifyChanged();
        }
    }

    public void b(int i10) {
        c(i10, true);
    }

    public final void c(int i10, boolean z10) {
        int i11 = this.f10552b;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.f10553c;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.f10551a) {
            this.f10551a = i10;
            e(i10);
            persistInt(i10);
            if (z10) {
                notifyChanged();
            }
        }
    }

    public void d(SeekBar seekBar) {
        int progress = this.f10552b + seekBar.getProgress();
        if (progress != this.f10551a) {
            if (callChangeListener(Integer.valueOf(progress))) {
                c(progress, false);
            } else {
                seekBar.setProgress(this.f10551a - this.f10552b);
                e(this.f10551a);
            }
        }
    }

    public void e(int i10) {
        TextView textView = this.f10557g;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        lVar.itemView.setOnKeyListener(this.f10562l);
        this.f10556f = (SeekBar) lVar.e(o.f10644c);
        TextView textView = (TextView) lVar.e(o.f10645d);
        this.f10557g = textView;
        if (this.f10559i) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.f10557g = null;
        }
        SeekBar seekBar = this.f10556f;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f10561k);
        this.f10556f.setMax(this.f10553c - this.f10552b);
        int i10 = this.f10554d;
        if (i10 != 0) {
            this.f10556f.setKeyProgressIncrement(i10);
        } else {
            this.f10554d = this.f10556f.getKeyProgressIncrement();
        }
        this.f10556f.setProgress(this.f10551a - this.f10552b);
        e(this.f10551a);
        this.f10556f.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f10551a = savedState.f10563a;
            this.f10552b = savedState.f10564b;
            this.f10553c = savedState.f10565c;
            notifyChanged();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f10563a = this.f10551a;
        savedState.f10564b = this.f10552b;
        savedState.f10565c = this.f10553c;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        b(getPersistedInt(((Integer) obj).intValue()));
    }

    public final void setMax(int i10) {
        int i11 = this.f10552b;
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 != this.f10553c) {
            this.f10553c = i10;
            notifyChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f10563a;

        /* renamed from: b, reason: collision with root package name */
        public int f10564b;

        /* renamed from: c, reason: collision with root package name */
        public int f10565c;

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

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f10563a = parcel.readInt();
            this.f10564b = parcel.readInt();
            this.f10565c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f10563a);
            parcel.writeInt(this.f10564b);
            parcel.writeInt(this.f10565c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f10638j);
    }
}
