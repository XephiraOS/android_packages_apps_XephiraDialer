package com.coui.appcompat.calendar;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.coui.appcompat.calendar.COUIDateMonthView;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class COUICalendarDayPagerAdapter extends a {
    private static final int MONTHS_IN_YEAR = 12;
    private ColorStateList mCalendarTextColor;
    private final int mCalendarViewId;
    private int mCount;
    private ColorStateList mDayHighlightColor;
    private int mDayOfWeekTextAppearance;
    private int mDaySelectorColor;
    private int mDayTextAppearance;
    private int mFirstDayOfWeek;
    private final LayoutInflater mInflater;
    private final int mLayoutResId;
    private int mMonthTextAppearance;
    private OnDaySelectedListener mOnDaySelectedListener;
    private final Calendar mMinDate = Calendar.getInstance();
    private final Calendar mMaxDate = Calendar.getInstance();
    private final SparseArray<ViewHolder> mItems = new SparseArray<>();
    private Calendar mSelectedDay = null;
    private ArrayList<COUIDateMonthView> mCurrentViewList = new ArrayList<>();
    private final COUIDateMonthView.OnDayClickListener mOnDayClickListener = new COUIDateMonthView.OnDayClickListener() { // from class: com.coui.appcompat.calendar.COUICalendarDayPagerAdapter.1
        @Override // com.coui.appcompat.calendar.COUIDateMonthView.OnDayClickListener
        public void onDayClick(COUIDateMonthView cOUIDateMonthView, Calendar calendar) {
            if (calendar != null) {
                COUICalendarDayPagerAdapter.this.setSelectedDay(calendar);
                if (COUICalendarDayPagerAdapter.this.mOnDaySelectedListener != null) {
                    COUICalendarDayPagerAdapter.this.mOnDaySelectedListener.onDaySelected(COUICalendarDayPagerAdapter.this, calendar);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface OnDaySelectedListener {
        void onDaySelected(COUICalendarDayPagerAdapter cOUICalendarDayPagerAdapter, Calendar calendar);
    }

    /* loaded from: classes.dex */
    public static class ViewHolder {
        public final COUIDateMonthView calendar;
        public final View container;
        public final int position;

        public ViewHolder(int i10, View view, COUIDateMonthView cOUIDateMonthView) {
            this.position = i10;
            this.container = view;
            this.calendar = cOUIDateMonthView;
        }
    }

    public COUICalendarDayPagerAdapter(Context context, int i10, int i11) {
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutResId = i10;
        this.mCalendarViewId = i11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.colorControlHighlight});
        this.mDayHighlightColor = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
    }

    private int getMonthForPosition(int i10) {
        return (i10 + this.mMinDate.get(2)) % 12;
    }

    private int getPositionForDay(Calendar calendar) {
        if (calendar == null) {
            return Integer.MIN_VALUE;
        }
        return ((calendar.get(1) - this.mMinDate.get(1)) * 12) + (calendar.get(2) - this.mMinDate.get(2));
    }

    private int getYearForPosition(int i10) {
        return ((i10 + this.mMinDate.get(2)) / 12) + this.mMinDate.get(1);
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        viewGroup.removeView(((ViewHolder) obj).container);
        this.mItems.remove(i10);
    }

    public boolean getBoundsForDate(Calendar calendar, Rect rect) {
        ViewHolder viewHolder = this.mItems.get(getPositionForDay(calendar), null);
        if (viewHolder == null) {
            return false;
        }
        return viewHolder.calendar.getBoundsForDay(calendar.get(5), rect);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.mCount;
    }

    public ArrayList<COUIDateMonthView> getCurrentView() {
        return this.mCurrentViewList;
    }

    public int getDayOfWeekTextAppearance() {
        return this.mDayOfWeekTextAppearance;
    }

    public int getDayTextAppearance() {
        return this.mDayTextAppearance;
    }

    public int getFirstDayOfWeek() {
        return this.mFirstDayOfWeek;
    }

    @Override // androidx.viewpager.widget.a
    public int getItemPosition(Object obj) {
        return ((ViewHolder) obj).position;
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence getPageTitle(int i10) {
        COUIDateMonthView cOUIDateMonthView = this.mItems.get(i10).calendar;
        if (cOUIDateMonthView != null) {
            return cOUIDateMonthView.getMonthYearLabel();
        }
        return null;
    }

    public COUIDateMonthView getView(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((ViewHolder) obj).calendar;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = false;
        View inflate = this.mInflater.inflate(this.mLayoutResId, viewGroup, false);
        COUIDateMonthView cOUIDateMonthView = (COUIDateMonthView) inflate.findViewById(this.mCalendarViewId);
        cOUIDateMonthView.setOnDayClickListener(this.mOnDayClickListener);
        cOUIDateMonthView.setMonthTextAppearance(this.mMonthTextAppearance);
        cOUIDateMonthView.setDayOfWeekTextAppearance(this.mDayOfWeekTextAppearance);
        cOUIDateMonthView.setDayTextAppearance(this.mDayTextAppearance);
        int i14 = this.mDaySelectorColor;
        if (i14 != 0) {
            cOUIDateMonthView.setDaySelectorColor(i14);
        }
        ColorStateList colorStateList = this.mDayHighlightColor;
        if (colorStateList != null) {
            cOUIDateMonthView.setDayHighlightColor(colorStateList);
        }
        ColorStateList colorStateList2 = this.mCalendarTextColor;
        if (colorStateList2 != null) {
            cOUIDateMonthView.setMonthTextColor(colorStateList2);
            cOUIDateMonthView.setDayOfWeekTextColor(this.mCalendarTextColor);
            cOUIDateMonthView.setDayTextColor(this.mCalendarTextColor);
        }
        int monthForPosition = getMonthForPosition(i10);
        int yearForPosition = getYearForPosition(i10);
        Calendar calendar = this.mSelectedDay;
        if (calendar != null && calendar.get(2) == monthForPosition) {
            i11 = this.mSelectedDay.get(5);
        } else {
            i11 = Integer.MIN_VALUE;
        }
        int i15 = i11;
        if (this.mMinDate.get(2) == monthForPosition && this.mMinDate.get(1) == yearForPosition) {
            i12 = this.mMinDate.get(5);
        } else {
            i12 = 1;
        }
        if (this.mMaxDate.get(2) == monthForPosition && this.mMaxDate.get(1) == yearForPosition) {
            i13 = this.mMaxDate.get(5);
        } else {
            i13 = 31;
        }
        int i16 = i13;
        int i17 = this.mFirstDayOfWeek;
        Calendar calendar2 = this.mSelectedDay;
        if (calendar2 != null && yearForPosition == calendar2.get(1)) {
            z10 = true;
        }
        cOUIDateMonthView.setMonthParams(i15, monthForPosition, yearForPosition, i17, i12, i16, z10);
        ViewHolder viewHolder = new ViewHolder(i10, inflate, cOUIDateMonthView);
        this.mItems.put(i10, viewHolder);
        viewGroup.addView(inflate);
        return viewHolder;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        if (view == ((ViewHolder) obj).container) {
            return true;
        }
        return false;
    }

    public void setCalendarTextColor(ColorStateList colorStateList) {
        this.mCalendarTextColor = colorStateList;
        notifyDataSetChanged();
    }

    public void setDayOfWeekTextAppearance(int i10) {
        this.mDayOfWeekTextAppearance = i10;
        notifyDataSetChanged();
    }

    public void setDaySelectorColor(int i10) {
        this.mDaySelectorColor = i10;
        notifyDataSetChanged();
    }

    public void setDayTextAppearance(int i10) {
        this.mDayTextAppearance = i10;
        notifyDataSetChanged();
    }

    public void setFirstDayOfWeek(int i10) {
        this.mFirstDayOfWeek = i10;
        int size = this.mItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mItems.valueAt(i11).calendar.setFirstDayOfWeek(i10);
        }
    }

    public void setMonthTextAppearance(int i10) {
        this.mMonthTextAppearance = i10;
        notifyDataSetChanged();
    }

    public void setOnDaySelectedListener(OnDaySelectedListener onDaySelectedListener) {
        this.mOnDaySelectedListener = onDaySelectedListener;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        super.setPrimaryItem(viewGroup, i10, obj);
        this.mCurrentViewList.clear();
        int i11 = i10 - 1;
        if (this.mItems.get(i11) != null && this.mItems.get(i11).calendar != null) {
            this.mCurrentViewList.add(this.mItems.get(i11).calendar);
        }
        this.mCurrentViewList.add(this.mItems.get(i10).calendar);
        int i12 = i10 + 1;
        if (this.mItems.get(i12) != null && this.mItems.get(i12).calendar != null) {
            this.mCurrentViewList.add(this.mItems.get(i12).calendar);
        }
    }

    public void setRange(Calendar calendar, Calendar calendar2) {
        this.mMinDate.setTimeInMillis(calendar.getTimeInMillis());
        this.mMaxDate.setTimeInMillis(calendar2.getTimeInMillis());
        this.mCount = (this.mMaxDate.get(2) - this.mMinDate.get(2)) + ((this.mMaxDate.get(1) - this.mMinDate.get(1)) * 12) + 1;
        notifyDataSetChanged();
    }

    public void setSelectedDay(Calendar calendar) {
        ViewHolder viewHolder;
        int positionForDay = getPositionForDay(this.mSelectedDay);
        int positionForDay2 = getPositionForDay(calendar);
        if (positionForDay >= 1) {
            for (int i10 = positionForDay - 1; i10 <= positionForDay + 1; i10++) {
                ViewHolder viewHolder2 = this.mItems.get(i10, null);
                if (viewHolder2 != null) {
                    viewHolder2.calendar.setSelectedDay(Integer.MIN_VALUE, calendar.get(2), calendar.get(1));
                }
            }
        }
        if (positionForDay2 >= 0 && (viewHolder = this.mItems.get(positionForDay2, null)) != null) {
            viewHolder.calendar.setSelectedDay(calendar.get(5), calendar.get(2), calendar.get(1));
            viewHolder.calendar.setOldDay(this.mSelectedDay.get(5), this.mSelectedDay.get(2));
        }
        this.mSelectedDay = calendar;
    }

    public COUIDateMonthView getView(int i10) {
        if (i10 > this.mItems.size()) {
            return null;
        }
        return this.mItems.valueAt(i10).calendar;
    }
}
