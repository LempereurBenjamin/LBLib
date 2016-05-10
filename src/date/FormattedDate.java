package date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//FAIRE JAVADOC + Verifdate

public class FormattedDate {
    private int formatDate;
    private int formatHeure;
    private Locale localeDate;

    public FormattedDate() {
        formatDate = DateFormat.FULL;
        formatHeure = DateFormat.FULL;
        localeDate = Locale.getDefault();
    }

    public FormattedDate(int formatDate, int formatHeure, Locale localeDate) {
        this.formatDate = formatDate;
        this.formatHeure = formatHeure;
        this.localeDate = localeDate;
    }

    public String getFormattedDate() {
        return DateFormat.getDateTimeInstance(formatDate, formatHeure, localeDate).format(new Date());
    }

    public int getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(int formatDate) {
        this.formatDate = formatDate;
    }

    public int getFormatHeure() {
        return formatHeure;
    }

    public void setFormatHeure(int formatHeure) {
        this.formatHeure = formatHeure;
    }

    public Locale getLocaleDate() {
        return localeDate;
    }

    public void setLocaleDate(Locale localeDate) {
        this.localeDate = localeDate;
    }

    public static boolean dateValidator(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.setTime(date);
        try {
            cal.getTime();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FormattedDate: Date is not a valid date");
        }
    }
}
