package com.coui.appcompat.unitconversionutil;

import X8.d;
import X8.m;
import android.content.Context;
import android.util.Log;
import com.coui.appcompat.log.COUILog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: classes3.dex */
public class COUIUnitConversionUtils {
    private static final boolean COUI_DEBUG;
    private static final double HUNDRED = 100.0d;
    private static final double MILLION = 1000000.0d;
    private static final String NOPOINT = "0";
    private static final String ONEPOINT = "0.0";
    private static final float ONE_MILLION = 1.0E-7f;
    private static final double POINT_NINE_EIGHT = 0.98d;
    private static final String SIXPOINT = "0.00000";
    private static final double SPECIAL = 1024.0d;
    private static final int SQUARE_FIVE = 5;
    private static final int SQUARE_FOUR = 4;
    private static final int SQUARE_THREE = 3;
    private static final String TAG = "COUIUnitConversionUtils";
    private static final double TEN = 10.0d;
    private static final double THOUSAND = 1000.0d;
    private static final String TWOPOINT = "0.00";
    private String mByteShort;
    private String mByteSpeed;
    private Context mContext;
    private String mGigaByteShort;
    private String mGigaByteSpeed;
    private boolean mIfShowNormal;
    private String mKiloByteShort;
    private String mKiloByteSpeed;
    private String mMegaByteShort;
    private String mMegaByteSpeed;
    private String mMoreDownLoad;
    private String mMostDownLoad;
    private String mPetaByteShort;
    private String mPetaByteSpeed;
    private String mSpecialPoint;
    private String mTeraByteShort;
    private String mTeraByteSpeed;

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
    }

    public COUIUnitConversionUtils(Context context) {
        this.mMoreDownLoad = null;
        this.mMostDownLoad = null;
        this.mSpecialPoint = "0.98";
        this.mContext = context;
        this.mIfShowNormal = context.getResources().getBoolean(d.f4423d);
        this.mMoreDownLoad = context.getResources().getString(m.f5025x);
        this.mMostDownLoad = context.getResources().getString(m.f5026y);
        this.mSpecialPoint = formatLocaleNumber(POINT_NINE_EIGHT, TWOPOINT);
        this.mByteShort = this.mContext.getResources().getString(m.f5002a);
        this.mKiloByteShort = this.mContext.getResources().getString(m.f5021t);
        this.mMegaByteShort = this.mContext.getResources().getString(m.f5024w);
        this.mGigaByteShort = this.mContext.getResources().getString(m.f5019r);
        this.mTeraByteShort = this.mContext.getResources().getString(m.f4998H);
        this.mPetaByteShort = this.mContext.getResources().getString(m.f4991A);
        this.mByteSpeed = this.mContext.getResources().getString(m.f5003b);
        this.mKiloByteSpeed = this.mContext.getResources().getString(m.f5020s);
        this.mMegaByteSpeed = this.mContext.getResources().getString(m.f5023v);
        this.mGigaByteSpeed = this.mContext.getResources().getString(m.f5018q);
        this.mTeraByteSpeed = this.mContext.getResources().getString(m.f4997G);
        this.mPetaByteSpeed = this.mContext.getResources().getString(m.f5027z);
    }

    private String formatLocaleNumber(double d10, String str) {
        return new DecimalFormat(str, new DecimalFormatSymbols(this.mContext.getResources().getConfiguration().locale)).format(d10);
    }

    private String formatNumber(double d10, String str, boolean z10) {
        DecimalFormat decimalFormat = new DecimalFormat(str, new DecimalFormatSymbols(Locale.CHINA));
        if (!z10) {
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        } else {
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        }
        return decimalFormat.format(d10);
    }

    private String getChineseDownloadValue(long j10) {
        if (0 <= j10 && j10 < 10000.0d) {
            if (j10 == 0) {
                j10++;
            }
            return j10 + " ";
        }
        double d10 = j10;
        if (10000.0d <= d10 && d10 < 100000.0d) {
            double doubleValue = Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue();
            int i10 = (int) doubleValue;
            if (doubleValue == i10) {
                return i10 + this.mMoreDownLoad;
            }
            return doubleValue + this.mMoreDownLoad;
        }
        if (100000.0d <= d10 && d10 < MILLION) {
            double doubleValue2 = Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue();
            int i11 = (int) doubleValue2;
            if (doubleValue2 == i11) {
                return i11 + this.mMoreDownLoad;
            }
            return doubleValue2 + this.mMoreDownLoad;
        }
        if (MILLION <= d10 && d10 < 1.0E7d) {
            return ((int) Double.valueOf(formatNumber(d10 / 10000.0d, TWOPOINT, true)).doubleValue()) + this.mMoreDownLoad;
        }
        if (1.0E7d <= d10 && d10 < 1.0E8d) {
            return ((int) Double.valueOf(formatNumber(d10 / 10000.0d, TWOPOINT, true)).doubleValue()) + this.mMoreDownLoad;
        }
        if (d10 >= 1.0E8d) {
            return formatNumber(Double.valueOf(formatNumber(d10 / 1.0E8d, SIXPOINT, true)).doubleValue(), ONEPOINT, false) + this.mMostDownLoad;
        }
        throw new IllegalArgumentException("the value of the incoming is wrong");
    }

    private String getChineseStripValue(long j10) {
        if (0 <= j10 && j10 < 10000.0d) {
            return j10 + " ";
        }
        double d10 = j10;
        if (10000.0d <= d10 && d10 < MILLION) {
            double doubleValue = Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue();
            int i10 = (int) doubleValue;
            if (doubleValue == i10) {
                return i10 + this.mMoreDownLoad;
            }
            return doubleValue + this.mMoreDownLoad;
        }
        if (MILLION <= d10 && d10 < 1.0E8d) {
            return formatNumber(d10 / 10000.0d, "0", true) + this.mMoreDownLoad;
        }
        throw new IllegalArgumentException("the value of the incoming is wrong");
    }

    private String getEnglishDownloadValue(long j10) {
        if (0 <= j10 && j10 < 10000.0d) {
            if (j10 == 0) {
                j10++;
            }
            return j10 + " ";
        }
        double d10 = j10;
        if (10000.0d <= d10 && d10 < 100000.0d) {
            return ((int) (Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue() * TEN)) + this.mMoreDownLoad;
        }
        if (100000.0d <= d10 && d10 < MILLION) {
            return ((int) (Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue() * TEN)) + this.mMoreDownLoad;
        }
        if (MILLION <= d10 && d10 < 1.0E7d) {
            String formatNumber = formatNumber(d10 / 10000.0d, TWOPOINT, true);
            double doubleValue = Double.valueOf(formatNumber).doubleValue() / HUNDRED;
            int i10 = (int) doubleValue;
            if (Math.abs(doubleValue - i10) < 1.0000000116860974E-7d) {
                return i10 + this.mMostDownLoad;
            }
            return Double.valueOf(formatNumber) + this.mMostDownLoad;
        }
        if (1.0E7d <= d10 && d10 < 1.0E8d) {
            String formatNumber2 = formatNumber(d10 / 10000.0d, TWOPOINT, true);
            double doubleValue2 = Double.valueOf(formatNumber2).doubleValue() / HUNDRED;
            int i11 = (int) doubleValue2;
            if (Math.abs(doubleValue2 - i11) < 1.0000000116860974E-7d) {
                return i11 + this.mMostDownLoad;
            }
            return Double.valueOf(formatNumber2) + this.mMostDownLoad;
        }
        if (d10 >= 1.0E8d) {
            return ((int) (Double.valueOf(formatNumber(Double.valueOf(formatNumber(d10 / 1.0E8d, SIXPOINT, true)).doubleValue(), ONEPOINT, false)).doubleValue() * HUNDRED)) + this.mMostDownLoad;
        }
        throw new IllegalArgumentException("the value of the incoming is wrong");
    }

    private String getEnglishStripValue(long j10) {
        if (0 <= j10 && j10 < 10000.0d) {
            return j10 + " ";
        }
        double d10 = j10;
        if (10000.0d <= d10 && d10 < MILLION) {
            return ((int) (Double.valueOf(formatNumber(d10 / 10000.0d, ONEPOINT, true)).doubleValue() * TEN)) + this.mMoreDownLoad;
        }
        if (MILLION <= d10 && d10 < 1.0E8d) {
            return ((int) (Double.valueOf(formatNumber(d10 / 10000.0d, "0", true)).doubleValue() * TEN)) + this.mMoreDownLoad;
        }
        throw new IllegalArgumentException("the value of the incoming is wrong");
    }

    private String getStringComposite(String str, String str2) {
        if (COUI_DEBUG) {
            Log.d(TAG, "getStringComposite content:" + str + ",unit:" + str + ",mIfShowNormal:" + this.mIfShowNormal);
        }
        if (this.mIfShowNormal) {
            return str + str2;
        }
        return str2 + " " + str;
    }

    private boolean isChinese() {
        String country = this.mContext.getResources().getConfiguration().locale.getCountry();
        if (country != null) {
            if (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String getDownLoadValue(long j10) {
        if (isChinese()) {
            return getChineseDownloadValue(j10);
        }
        return getEnglishDownloadValue(j10);
    }

    public String getSpeedValue(long j10) {
        if (0 <= j10) {
            double d10 = j10;
            if (d10 < THOUSAND) {
                String formatNumber = formatNumber(d10, "0", true);
                long parseLong = Long.parseLong(formatNumber);
                String formatLocaleNumber = formatLocaleNumber(Double.valueOf(formatNumber).doubleValue(), "0");
                double d11 = parseLong;
                if (THOUSAND <= d11 && d11 < SPECIAL) {
                    return getUnitValue(parseLong);
                }
                return formatLocaleNumber + this.mByteSpeed;
            }
        }
        double d12 = j10;
        if (THOUSAND <= d12 && d12 < 1024000.0d) {
            String formatNumber2 = formatNumber(d12 / SPECIAL, "0", true);
            long parseLong2 = Long.parseLong(formatNumber2) * 1024;
            String formatLocaleNumber2 = formatLocaleNumber(Double.valueOf(formatNumber2).doubleValue(), "0");
            double d13 = parseLong2;
            if (1024000.0d <= d13 && d13 < Math.pow(SPECIAL, 2.0d) * HUNDRED) {
                return getUnitValue(parseLong2);
            }
            return formatLocaleNumber2 + this.mKiloByteSpeed;
        }
        if (1024000.0d <= d12 && d12 < Math.pow(SPECIAL, 2.0d) * HUNDRED) {
            String formatNumber3 = formatNumber(d12 / Math.pow(SPECIAL, 2.0d), ONEPOINT, true);
            long doubleValue = (long) (Double.valueOf(formatNumber3).doubleValue() * Math.pow(SPECIAL, 2.0d));
            String formatLocaleNumber3 = formatLocaleNumber(Double.valueOf(formatNumber3).doubleValue(), ONEPOINT);
            double d14 = doubleValue;
            if (Math.pow(SPECIAL, 2.0d) * HUNDRED <= d14 && d14 < Math.pow(SPECIAL, 2.0d) * THOUSAND) {
                return getUnitValue(doubleValue);
            }
            return formatLocaleNumber3 + this.mMegaByteSpeed;
        }
        if (Math.pow(SPECIAL, 2.0d) * HUNDRED <= d12 && d12 < Math.pow(SPECIAL, 2.0d) * THOUSAND) {
            String formatNumber4 = formatNumber(d12 / Math.pow(SPECIAL, 2.0d), "0", true);
            long doubleValue2 = (long) (Double.valueOf(formatNumber4).doubleValue() * Math.pow(SPECIAL, 2.0d));
            String formatLocaleNumber4 = formatLocaleNumber(Double.valueOf(formatNumber4).doubleValue(), "0");
            double d15 = doubleValue2;
            if (Math.pow(SPECIAL, 2.0d) * THOUSAND <= d15 && d15 < Math.pow(SPECIAL, 3.0d)) {
                return getUnitValue(doubleValue2);
            }
            return formatLocaleNumber4 + this.mMegaByteSpeed;
        }
        if (Math.pow(SPECIAL, 2.0d) * THOUSAND <= d12 && d12 < Math.pow(SPECIAL, 3.0d)) {
            if (d12 > Math.pow(SPECIAL, 2.0d) * 1023.0d) {
                return getUnitValue((long) Math.pow(SPECIAL, 3.0d));
            }
            return this.mSpecialPoint + this.mGigaByteSpeed;
        }
        if (Math.pow(SPECIAL, 3.0d) <= d12 && d12 < Math.pow(SPECIAL, 3.0d) * TEN) {
            String formatNumber5 = formatNumber(d12 / Math.pow(SPECIAL, 3.0d), TWOPOINT, true);
            long doubleValue3 = (long) (Double.valueOf(formatNumber5).doubleValue() * Math.pow(SPECIAL, 3.0d));
            String formatLocaleNumber5 = formatLocaleNumber(Double.valueOf(formatNumber5).doubleValue(), TWOPOINT);
            double d16 = doubleValue3;
            if (Math.pow(SPECIAL, 3.0d) * TEN <= d16 && d16 < Math.pow(SPECIAL, 3.0d) * HUNDRED) {
                return getUnitValue(doubleValue3);
            }
            return formatLocaleNumber5 + this.mGigaByteSpeed;
        }
        if (Math.pow(SPECIAL, 3.0d) * TEN <= d12 && d12 < Math.pow(SPECIAL, 3.0d) * HUNDRED) {
            String formatNumber6 = formatNumber(d12 / Math.pow(SPECIAL, 3.0d), ONEPOINT, true);
            long doubleValue4 = (long) (Double.valueOf(formatNumber6).doubleValue() * Math.pow(SPECIAL, 3.0d));
            String formatLocaleNumber6 = formatLocaleNumber(Double.valueOf(formatNumber6).doubleValue(), ONEPOINT);
            double d17 = doubleValue4;
            if (Math.pow(SPECIAL, 3.0d) * HUNDRED <= d17 && d17 < Math.pow(SPECIAL, 3.0d) * THOUSAND) {
                return getUnitValue(doubleValue4);
            }
            return formatLocaleNumber6 + this.mGigaByteSpeed;
        }
        if (Math.pow(SPECIAL, 3.0d) * HUNDRED <= d12 && d12 < Math.pow(SPECIAL, 3.0d) * THOUSAND) {
            String formatNumber7 = formatNumber(d12 / Math.pow(SPECIAL, 3.0d), "0", true);
            long doubleValue5 = (long) (Double.valueOf(formatNumber7).doubleValue() * Math.pow(SPECIAL, 3.0d));
            String formatLocaleNumber7 = formatLocaleNumber(Double.valueOf(formatNumber7).doubleValue(), "0");
            double d18 = doubleValue5;
            if (Math.pow(SPECIAL, 3.0d) * THOUSAND <= d18 && d18 < Math.pow(SPECIAL, 4.0d)) {
                return getUnitValue(doubleValue5);
            }
            return formatLocaleNumber7 + this.mGigaByteSpeed;
        }
        if (Math.pow(SPECIAL, 3.0d) * THOUSAND <= d12 && d12 < Math.pow(SPECIAL, 4.0d)) {
            if (d12 > Math.pow(SPECIAL, 3.0d) * 1023.0d) {
                return getUnitValue((long) Math.pow(SPECIAL, 4.0d));
            }
            return this.mSpecialPoint + this.mTeraByteSpeed;
        }
        if (Math.pow(SPECIAL, 4.0d) <= d12 && d12 < Math.pow(SPECIAL, 4.0d) * TEN) {
            String formatNumber8 = formatNumber(d12 / Math.pow(SPECIAL, 4.0d), TWOPOINT, true);
            long doubleValue6 = (long) (Double.valueOf(formatNumber8).doubleValue() * Math.pow(SPECIAL, 4.0d));
            String formatLocaleNumber8 = formatLocaleNumber(Double.valueOf(formatNumber8).doubleValue(), TWOPOINT);
            double d19 = doubleValue6;
            if (Math.pow(SPECIAL, 4.0d) * TEN <= d19 && d19 < Math.pow(SPECIAL, 4.0d) * HUNDRED) {
                return getUnitValue(doubleValue6);
            }
            return formatLocaleNumber8 + this.mTeraByteSpeed;
        }
        if (Math.pow(SPECIAL, 4.0d) * TEN <= d12 && d12 < Math.pow(SPECIAL, 4.0d) * HUNDRED) {
            String formatNumber9 = formatNumber(d12 / Math.pow(SPECIAL, 4.0d), ONEPOINT, true);
            long doubleValue7 = (long) (Double.valueOf(formatNumber9).doubleValue() * Math.pow(SPECIAL, 4.0d));
            String formatLocaleNumber9 = formatLocaleNumber(Double.valueOf(formatNumber9).doubleValue(), ONEPOINT);
            double d20 = doubleValue7;
            if (Math.pow(SPECIAL, 4.0d) * HUNDRED <= d20 && d20 < Math.pow(SPECIAL, 4.0d) * THOUSAND) {
                return getUnitValue(doubleValue7);
            }
            return formatLocaleNumber9 + this.mTeraByteSpeed;
        }
        if (Math.pow(SPECIAL, 4.0d) * HUNDRED <= d12 && d12 < Math.pow(SPECIAL, 4.0d) * THOUSAND) {
            String formatNumber10 = formatNumber(d12 / Math.pow(SPECIAL, 4.0d), "0", true);
            long doubleValue8 = (long) (Double.valueOf(formatNumber10).doubleValue() * Math.pow(SPECIAL, 4.0d));
            double d21 = doubleValue8;
            if (Math.pow(SPECIAL, 4.0d) * THOUSAND <= d21 && d21 < Math.pow(SPECIAL, 5.0d)) {
                return getUnitValue(doubleValue8);
            }
            return formatNumber10 + this.mTeraByteSpeed;
        }
        if (Math.pow(SPECIAL, 4.0d) * THOUSAND <= d12 && d12 < Math.pow(SPECIAL, 5.0d)) {
            if (d12 > Math.pow(SPECIAL, 4.0d) * 1023.0d) {
                return getUnitValue((long) Math.pow(SPECIAL, 5.0d));
            }
            return this.mSpecialPoint + this.mPetaByteSpeed;
        }
        if (Math.pow(SPECIAL, 5.0d) <= d12 && d12 < Math.pow(SPECIAL, 5.0d) * TEN) {
            String formatNumber11 = formatNumber(d12 / Math.pow(SPECIAL, 5.0d), TWOPOINT, true);
            long doubleValue9 = (long) (Double.valueOf(formatNumber11).doubleValue() * Math.pow(SPECIAL, 5.0d));
            String formatLocaleNumber10 = formatLocaleNumber(Double.valueOf(formatNumber11).doubleValue(), TWOPOINT);
            double d22 = doubleValue9;
            if (Math.pow(SPECIAL, 5.0d) * TEN <= d22 && d22 < Math.pow(SPECIAL, 5.0d) * HUNDRED) {
                return getUnitValue(doubleValue9);
            }
            return formatLocaleNumber10 + this.mPetaByteSpeed;
        }
        if (Math.pow(SPECIAL, 5.0d) * TEN > d12 || d12 >= Math.pow(SPECIAL, 5.0d) * HUNDRED) {
            if (Math.pow(SPECIAL, 5.0d) * HUNDRED <= d12 && d12 < Math.pow(SPECIAL, 5.0d) * THOUSAND) {
                return formatLocaleNumber(d12 / Math.pow(SPECIAL, 5.0d), "0") + this.mPetaByteSpeed;
            }
            throw new IllegalArgumentException("the value of the incoming is wrong");
        }
        String formatNumber12 = formatNumber(d12 / Math.pow(SPECIAL, 5.0d), ONEPOINT, true);
        long doubleValue10 = (long) (Double.valueOf(formatNumber12).doubleValue() * Math.pow(SPECIAL, 5.0d));
        String formatLocaleNumber11 = formatLocaleNumber(Double.valueOf(formatNumber12).doubleValue(), ONEPOINT);
        double d23 = doubleValue10;
        if (Math.pow(SPECIAL, 5.0d) * HUNDRED <= d23 && d23 < Math.pow(SPECIAL, 5.0d) * THOUSAND) {
            return getUnitValue(doubleValue10);
        }
        return formatLocaleNumber11 + this.mPetaByteSpeed;
    }

    public String getStripValue(long j10) {
        if (isChinese()) {
            return getChineseStripValue(j10);
        }
        return getEnglishStripValue(j10);
    }

    public String getTransformUnitValue(long j10, double d10) {
        double d11;
        if (0 <= j10) {
            double d12 = j10;
            if (d12 < THOUSAND) {
                String formatNumber = formatNumber(d12, "0", true);
                long parseLong = Long.parseLong(formatNumber);
                String formatLocaleNumber = formatLocaleNumber(Double.valueOf(formatNumber).doubleValue(), "0");
                double d13 = parseLong;
                if (THOUSAND <= d13 && d13 < SPECIAL) {
                    return getUnitValue(parseLong);
                }
                return getStringComposite(formatLocaleNumber, this.mByteShort);
            }
        }
        double d14 = j10;
        if (THOUSAND <= d14 && d14 < 1024000.0d) {
            String formatNumber2 = formatNumber(d14 / d10, "0", true);
            long parseLong2 = Long.parseLong(formatNumber2) * ((long) d10);
            String formatLocaleNumber2 = formatLocaleNumber(Double.valueOf(formatNumber2).doubleValue(), "0");
            double d15 = parseLong2;
            if (1024000.0d <= d15 && d15 < Math.pow(SPECIAL, 2.0d) * HUNDRED) {
                return getTransformUnitValue(parseLong2, d10);
            }
            return getStringComposite(formatLocaleNumber2, this.mKiloByteShort);
        }
        if (1024000.0d <= d14 && d14 < Math.pow(SPECIAL, 2.0d) * HUNDRED) {
            String formatNumber3 = formatNumber(d14 / Math.pow(d10, 2.0d), ONEPOINT, true);
            long doubleValue = (long) (Double.valueOf(formatNumber3).doubleValue() * Math.pow(d10, 2.0d));
            String formatLocaleNumber3 = formatLocaleNumber(Double.valueOf(formatNumber3).doubleValue(), ONEPOINT);
            double d16 = doubleValue;
            if (Math.pow(SPECIAL, 2.0d) * HUNDRED <= d16 && d16 < Math.pow(SPECIAL, 2.0d) * THOUSAND) {
                return getTransformUnitValue(doubleValue, d10);
            }
            return getStringComposite(formatLocaleNumber3, this.mMegaByteShort);
        }
        double d17 = SPECIAL;
        if (Math.pow(SPECIAL, 2.0d) * HUNDRED <= d14) {
            if (d14 < Math.pow(SPECIAL, 2.0d) * THOUSAND) {
                String formatNumber4 = formatNumber(d14 / Math.pow(d10, 2.0d), "0", true);
                long doubleValue2 = (long) (Double.valueOf(formatNumber4).doubleValue() * Math.pow(d10, 2.0d));
                String formatLocaleNumber4 = formatLocaleNumber(Double.valueOf(formatNumber4).doubleValue(), "0");
                double d18 = doubleValue2;
                if (Math.pow(SPECIAL, 2.0d) * THOUSAND <= d18 && d18 < Math.pow(SPECIAL, 3.0d)) {
                    return getTransformUnitValue(doubleValue2, d10);
                }
                return getStringComposite(formatLocaleNumber4, this.mMegaByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 2.0d) * THOUSAND <= d14) {
            if (d14 < Math.pow(d17, 3.0d)) {
                if (d10 == THOUSAND) {
                    String formatNumber5 = formatNumber(d14 / Math.pow(d10, 3.0d), TWOPOINT, true);
                    Double.valueOf(formatNumber5).doubleValue();
                    Math.pow(d10, 3.0d);
                    return getStringComposite(formatLocaleNumber(Double.valueOf(formatNumber5).doubleValue(), TWOPOINT), this.mGigaByteShort);
                }
                if (d10 == SPECIAL) {
                    if (d14 > Math.pow(SPECIAL, 2.0d) * 1023.0d) {
                        return getUnitValue((long) Math.pow(SPECIAL, 3.0d));
                    }
                    return getStringComposite(this.mSpecialPoint, this.mGigaByteShort);
                }
                return null;
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 3.0d) <= d14) {
            if (d14 < Math.pow(d17, 3.0d) * TEN) {
                String formatNumber6 = formatNumber(d14 / Math.pow(d10, 3.0d), TWOPOINT, true);
                long doubleValue3 = (long) (Double.valueOf(formatNumber6).doubleValue() * Math.pow(d10, 3.0d));
                String formatLocaleNumber5 = formatLocaleNumber(Double.valueOf(formatNumber6).doubleValue(), TWOPOINT);
                double d19 = doubleValue3;
                if (Math.pow(SPECIAL, 3.0d) * TEN <= d19 && d19 < Math.pow(SPECIAL, 3.0d) * HUNDRED) {
                    return getTransformUnitValue(doubleValue3, d10);
                }
                return getStringComposite(formatLocaleNumber5, this.mGigaByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 3.0d) * TEN <= d14) {
            if (d14 < Math.pow(d17, 3.0d) * HUNDRED) {
                String formatNumber7 = formatNumber(d14 / Math.pow(d10, 3.0d), ONEPOINT, true);
                long doubleValue4 = (long) (Double.valueOf(formatNumber7).doubleValue() * Math.pow(d10, 3.0d));
                String formatLocaleNumber6 = formatLocaleNumber(Double.valueOf(formatNumber7).doubleValue(), ONEPOINT);
                double d20 = doubleValue4;
                if (Math.pow(SPECIAL, 3.0d) * HUNDRED <= d20 && d20 < Math.pow(SPECIAL, 3.0d) * THOUSAND) {
                    return getTransformUnitValue(doubleValue4, d10);
                }
                return getStringComposite(formatLocaleNumber6, this.mGigaByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 3.0d) * HUNDRED <= d14) {
            if (d14 < Math.pow(d17, 3.0d) * THOUSAND) {
                String formatNumber8 = formatNumber(d14 / Math.pow(d10, 3.0d), "0", true);
                long doubleValue5 = (long) (Double.valueOf(formatNumber8).doubleValue() * Math.pow(d10, 3.0d));
                String formatLocaleNumber7 = formatLocaleNumber(Double.valueOf(formatNumber8).doubleValue(), "0");
                double d21 = doubleValue5;
                if (Math.pow(SPECIAL, 3.0d) * THOUSAND <= d21 && d21 < Math.pow(SPECIAL, 4.0d)) {
                    return getTransformUnitValue(doubleValue5, d10);
                }
                return getStringComposite(formatLocaleNumber7, this.mGigaByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 3.0d) * THOUSAND <= d14) {
            if (d14 < Math.pow(d17, 4.0d)) {
                if (d10 == THOUSAND) {
                    String formatNumber9 = formatNumber(d14 / Math.pow(d10, 4.0d), TWOPOINT, true);
                    Double.valueOf(formatNumber9).doubleValue();
                    Math.pow(d10, 4.0d);
                    return getStringComposite(formatLocaleNumber(Double.valueOf(formatNumber9).doubleValue(), TWOPOINT), this.mTeraByteShort);
                }
                if (d10 == SPECIAL) {
                    if (d14 > Math.pow(SPECIAL, 3.0d) * 1023.0d) {
                        return getUnitValue((long) Math.pow(SPECIAL, 4.0d));
                    }
                    return getStringComposite(this.mSpecialPoint, this.mTeraByteShort);
                }
                return null;
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 4.0d) <= d14) {
            if (d14 < Math.pow(d17, 4.0d) * TEN) {
                String formatNumber10 = formatNumber(d14 / Math.pow(d10, 4.0d), TWOPOINT, true);
                long doubleValue6 = (long) (Double.valueOf(formatNumber10).doubleValue() * Math.pow(d10, 4.0d));
                String formatLocaleNumber8 = formatLocaleNumber(Double.valueOf(formatNumber10).doubleValue(), TWOPOINT);
                double d22 = doubleValue6;
                if (Math.pow(SPECIAL, 4.0d) * TEN <= d22 && d22 < Math.pow(SPECIAL, 4.0d) * HUNDRED) {
                    return getTransformUnitValue(doubleValue6, d10);
                }
                return getStringComposite(formatLocaleNumber8, this.mTeraByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 4.0d) * TEN <= d14) {
            if (d14 < Math.pow(d17, 4.0d) * HUNDRED) {
                String formatNumber11 = formatNumber(d14 / Math.pow(d10, 4.0d), ONEPOINT, true);
                long doubleValue7 = (long) (Double.valueOf(formatNumber11).doubleValue() * Math.pow(d10, 4.0d));
                String formatLocaleNumber9 = formatLocaleNumber(Double.valueOf(formatNumber11).doubleValue(), ONEPOINT);
                double d23 = doubleValue7;
                if (Math.pow(SPECIAL, 4.0d) * HUNDRED <= d23 && d23 < Math.pow(SPECIAL, 4.0d) * THOUSAND) {
                    return getTransformUnitValue(doubleValue7, d10);
                }
                return getStringComposite(formatLocaleNumber9, this.mTeraByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 4.0d) * HUNDRED <= d14) {
            if (d14 < Math.pow(d17, 4.0d) * THOUSAND) {
                String formatNumber12 = formatNumber(d14 / Math.pow(d10, 4.0d), "0", true);
                long doubleValue8 = (long) (Double.valueOf(formatNumber12).doubleValue() * Math.pow(d10, 4.0d));
                String formatLocaleNumber10 = formatLocaleNumber(Double.valueOf(formatNumber12).doubleValue(), "0");
                double d24 = doubleValue8;
                if (Math.pow(SPECIAL, 4.0d) * THOUSAND <= d24 && d24 < Math.pow(SPECIAL, 5.0d)) {
                    return getTransformUnitValue(doubleValue8, d10);
                }
                return getStringComposite(formatLocaleNumber10, this.mTeraByteShort);
            }
            d17 = SPECIAL;
        }
        if (Math.pow(d17, 4.0d) * THOUSAND <= d14) {
            if (d14 < Math.pow(d17, 5.0d)) {
                if (d10 == THOUSAND) {
                    String formatNumber13 = formatNumber(d14 / Math.pow(d10, 5.0d), TWOPOINT, true);
                    Double.valueOf(formatNumber13).doubleValue();
                    Math.pow(d10, 5.0d);
                    return getStringComposite(formatLocaleNumber(Double.valueOf(formatNumber13).doubleValue(), TWOPOINT), this.mPetaByteShort);
                }
                if (d10 == SPECIAL) {
                    if (d14 > Math.pow(SPECIAL, 4.0d) * 1023.0d) {
                        return getUnitValue((long) Math.pow(SPECIAL, 5.0d));
                    }
                    return getStringComposite(this.mSpecialPoint, this.mPetaByteShort);
                }
                return null;
            }
            d11 = SPECIAL;
        } else {
            d11 = d17;
        }
        if (Math.pow(d11, 5.0d) <= d14 && d14 < Math.pow(d11, 5.0d) * TEN) {
            String formatNumber14 = formatNumber(d14 / Math.pow(d11, 5.0d), TWOPOINT, true);
            long doubleValue9 = (long) (Double.valueOf(formatNumber14).doubleValue() * Math.pow(d11, 5.0d));
            String formatLocaleNumber11 = formatLocaleNumber(Double.valueOf(formatNumber14).doubleValue(), TWOPOINT);
            double d25 = doubleValue9;
            if (Math.pow(d11, 5.0d) * TEN <= d25 && d25 < Math.pow(d11, 5.0d) * HUNDRED) {
                return getUnitValue(doubleValue9);
            }
            return getStringComposite(formatLocaleNumber11, this.mPetaByteShort);
        }
        if (Math.pow(d11, 5.0d) * TEN <= d14 && d14 < Math.pow(d11, 5.0d) * HUNDRED) {
            String formatNumber15 = formatNumber(d14 / Math.pow(d11, 5.0d), ONEPOINT, true);
            long doubleValue10 = (long) (Double.valueOf(formatNumber15).doubleValue() * Math.pow(d11, 5.0d));
            String formatLocaleNumber12 = formatLocaleNumber(Double.valueOf(formatNumber15).doubleValue(), ONEPOINT);
            double d26 = doubleValue10;
            if (Math.pow(d11, 5.0d) * HUNDRED <= d26 && d26 < Math.pow(d11, 5.0d) * THOUSAND) {
                return getUnitValue(doubleValue10);
            }
            return getStringComposite(formatLocaleNumber12, this.mPetaByteShort);
        }
        if (Math.pow(d11, 5.0d) * HUNDRED <= d14 && d14 < Math.pow(d11, 5.0d) * THOUSAND) {
            return formatLocaleNumber(d14 / Math.pow(d11, 5.0d), "0") + this.mPetaByteShort;
        }
        throw new IllegalArgumentException("the value of the incoming is wrong");
    }

    public String getUnitThousandValue(long j10) {
        return getTransformUnitValue(j10, THOUSAND);
    }

    public String getUnitValue(long j10) {
        return getTransformUnitValue(j10, SPECIAL);
    }

    public String getDownLoadValue(long j10, Locale locale) {
        String country = locale != null ? locale.getCountry() : null;
        if (country != null && (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK"))) {
            return getChineseDownloadValue(j10);
        }
        if (country != null) {
            return getEnglishDownloadValue(j10);
        }
        return null;
    }

    public String getStripValue(long j10, Locale locale) {
        String country = locale != null ? locale.getCountry() : null;
        if (country != null && (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK"))) {
            return getChineseStripValue(j10);
        }
        if (country != null) {
            return getEnglishStripValue(j10);
        }
        return null;
    }
}
