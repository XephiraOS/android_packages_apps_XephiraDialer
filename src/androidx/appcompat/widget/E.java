package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.incallui.OplusPhoneUtils;
import e.C0961a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
public class E extends androidx.cursoradapter.widget.c implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public final SearchView f7684d;

    /* renamed from: e, reason: collision with root package name */
    public final SearchableInfo f7685e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f7686f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f7687g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7688h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7689i;

    /* renamed from: j, reason: collision with root package name */
    public int f7690j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f7691k;

    /* renamed from: l, reason: collision with root package name */
    public int f7692l;

    /* renamed from: m, reason: collision with root package name */
    public int f7693m;

    /* renamed from: n, reason: collision with root package name */
    public int f7694n;

    /* renamed from: o, reason: collision with root package name */
    public int f7695o;

    /* renamed from: p, reason: collision with root package name */
    public int f7696p;

    /* renamed from: q, reason: collision with root package name */
    public int f7697q;

    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f7698a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f7699b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f7700c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f7701d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f7702e;

        public a(View view) {
            this.f7698a = (TextView) view.findViewById(R.id.text1);
            this.f7699b = (TextView) view.findViewById(R.id.text2);
            this.f7700c = (ImageView) view.findViewById(R.id.icon1);
            this.f7701d = (ImageView) view.findViewById(R.id.icon2);
            this.f7702e = (ImageView) view.findViewById(e.f.f30232s);
        }
    }

    public E(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f7689i = false;
        this.f7690j = 1;
        this.f7692l = -1;
        this.f7693m = -1;
        this.f7694n = -1;
        this.f7695o = -1;
        this.f7696p = -1;
        this.f7697q = -1;
        this.f7684d = searchView;
        this.f7685e = searchableInfo;
        this.f7688h = searchView.getSuggestionCommitIconResId();
        this.f7686f = context;
        this.f7687g = weakHashMap;
    }

    public static String e(Cursor cursor, String str) {
        return m(cursor, cursor.getColumnIndex(str));
    }

    public static String m(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    public final Drawable a(String str) {
        Drawable.ConstantState constantState = this.f7687g.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence b(CharSequence charSequence) {
        if (this.f7691k == null) {
            TypedValue typedValue = new TypedValue();
            this.f7686f.getTheme().resolveAttribute(C0961a.f30099Q, typedValue, true);
            this.f7691k = this.f7686f.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f7691k, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    @Override // androidx.cursoradapter.widget.a
    public void bindView(View view, Context context, Cursor cursor) {
        int i10;
        CharSequence m10;
        a aVar = (a) view.getTag();
        int i11 = this.f7697q;
        if (i11 != -1) {
            i10 = cursor.getInt(i11);
        } else {
            i10 = 0;
        }
        if (aVar.f7698a != null) {
            p(aVar.f7698a, m(cursor, this.f7692l));
        }
        if (aVar.f7699b != null) {
            String m11 = m(cursor, this.f7694n);
            if (m11 != null) {
                m10 = b(m11);
            } else {
                m10 = m(cursor, this.f7693m);
            }
            if (TextUtils.isEmpty(m10)) {
                TextView textView = aVar.f7698a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f7698a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f7698a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f7698a.setMaxLines(1);
                }
            }
            p(aVar.f7699b, m10);
        }
        ImageView imageView = aVar.f7700c;
        if (imageView != null) {
            o(imageView, j(cursor), 4);
        }
        ImageView imageView2 = aVar.f7701d;
        if (imageView2 != null) {
            o(imageView2, k(cursor), 8);
        }
        int i12 = this.f7690j;
        if (i12 != 2 && (i12 != 1 || (i10 & 1) == 0)) {
            aVar.f7702e.setVisibility(8);
            return;
        }
        aVar.f7702e.setVisibility(0);
        aVar.f7702e.setTag(aVar.f7698a.getText());
        aVar.f7702e.setOnClickListener(this);
    }

    public final Drawable c(ComponentName componentName) {
        PackageManager packageManager = this.f7686f.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public void changeCursor(Cursor cursor) {
        if (this.f7689i) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f7692l = cursor.getColumnIndex("suggest_text_1");
                this.f7693m = cursor.getColumnIndex("suggest_text_2");
                this.f7694n = cursor.getColumnIndex("suggest_text_2_url");
                this.f7695o = cursor.getColumnIndex("suggest_icon_1");
                this.f7696p = cursor.getColumnIndex("suggest_icon_2");
                this.f7697q = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public CharSequence convertToString(Cursor cursor) {
        String e10;
        String e11;
        if (cursor == null) {
            return null;
        }
        String e12 = e(cursor, "suggest_intent_query");
        if (e12 != null) {
            return e12;
        }
        if (this.f7685e.shouldRewriteQueryFromData() && (e11 = e(cursor, "suggest_intent_data")) != null) {
            return e11;
        }
        if (!this.f7685e.shouldRewriteQueryFromText() || (e10 = e(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return e10;
    }

    public final Drawable d(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f7687g.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f7687g.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f7686f.getResources());
        }
        Drawable c10 = c(componentName);
        if (c10 != null) {
            constantState = c10.getConstantState();
        }
        this.f7687g.put(flattenToShortString, constantState);
        return c10;
    }

    public final Drawable f() {
        Drawable d10 = d(this.f7685e.getSearchActivity());
        if (d10 != null) {
            return d10;
        }
        return this.f7686f.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable g(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return h(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f7686f.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    return Drawable.createFromStream(openInputStream, null);
                } finally {
                    try {
                        openInputStream.close();
                    } catch (IOException e10) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e10);
                    }
                }
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e11) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
        return null;
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View newDropDownView = this.newDropDownView(this.f7686f, this.getCursor(), viewGroup);
            if (newDropDownView != null) {
                ((a) newDropDownView.getTag()).f7698a.setText(e10.toString());
            }
            return newDropDownView;
        }
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View newView = this.newView(this.f7686f, this.getCursor(), viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).f7698a.setText(e10.toString());
            }
            return newView;
        }
    }

    public Drawable h(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f7686f.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable i(String str) {
        if (str == null || str.isEmpty() || OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f7686f.getPackageName() + "/" + parseInt;
            Drawable a10 = a(str2);
            if (a10 != null) {
                return a10;
            }
            Drawable e10 = androidx.core.content.b.e(this.f7686f, parseInt);
            q(str2, e10);
            return e10;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable a11 = a(str);
            if (a11 != null) {
                return a11;
            }
            Drawable g10 = g(Uri.parse(str));
            q(str, g10);
            return g10;
        }
    }

    public final Drawable j(Cursor cursor) {
        int i10 = this.f7695o;
        if (i10 == -1) {
            return null;
        }
        Drawable i11 = i(cursor.getString(i10));
        if (i11 != null) {
            return i11;
        }
        return f();
    }

    public final Drawable k(Cursor cursor) {
        int i10 = this.f7696p;
        if (i10 == -1) {
            return null;
        }
        return i(cursor.getString(i10));
    }

    public Cursor l(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f7686f.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void n(int i10) {
        this.f7690j = i10;
    }

    @Override // androidx.cursoradapter.widget.c, androidx.cursoradapter.widget.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(e.f.f30232s)).setImageResource(this.f7688h);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        r(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        r(getCursor());
    }

    public final void o(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f7684d.onQueryRefine((CharSequence) tag);
        }
    }

    public final void p(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void q(String str, Drawable drawable) {
        if (drawable != null) {
            this.f7687g.put(str, drawable.getConstantState());
        }
    }

    public final void r(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (this.f7684d.getVisibility() == 0 && this.f7684d.getWindowVisibility() == 0) {
            try {
                Cursor l10 = l(this.f7685e, charSequence2, 50);
                if (l10 != null) {
                    l10.getCount();
                    return l10;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }
}
