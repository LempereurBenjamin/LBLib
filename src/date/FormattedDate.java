package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <b>FormattedDate is a class used to get formatted dates.</b>
 *
 * @author Lempereur
 *
 * @version 1.0
 */
public class FormattedDate {
    /**
     * The date format.
     *
     * @see FormattedDate#FormattedDate()
     * @see FormattedDate#FormattedDate(int, int, Locale)
     */
    private int formatDate;

    /**
     * The time format.
     *
     * @see FormattedDate#FormattedDate()
     * @see FormattedDate#FormattedDate(int, int, Locale)
     */
    private int formatTime;

    /**
     * The Locale.
     *
     * @see FormattedDate#FormattedDate()
     * @see FormattedDate#FormattedDate(int, int, Locale)
     */
    private Locale locale;

    /**
     * FormattedDate default Constructor.
     * <p>
     *     Formats are set to FULL and the locale is set to the default Locale.
     * </p>
     */
    public FormattedDate() {
        formatDate = DateFormat.FULL;
        formatTime = DateFormat.FULL;
        locale = Locale.getDefault();
    }

    /**
     * FormattedDate Constructor.
     *
     * @param formatDate
     *          The date format.
     * @param formatTime
     *          The time format.
     * @param locale
     *          The Locale.
     */
    public FormattedDate(int formatDate, int formatTime, Locale locale) {
        this.formatDate = formatDate;
        this.formatTime = formatTime;
        this.locale = locale;
    }

    /**
     * Return the formatted datetime.
     *
     * @return The formatted datetime.
     */
    public String getFormattedDateTime() {
        return DateFormat.getDateTimeInstance(formatDate, formatTime, locale).format(new Date());
    }

    /**
     * Return the formatted date.
     *
     * @return The formatted date.
     */
    public String getFormattedDate() {
        return DateFormat.getDateInstance(formatDate, locale).format(new Date());
    }

    /**
     * Return the formatted time.
     *
     * @return The formatted time.
     */
    public String getFormattedTime() {
        return DateFormat.getTimeInstance(formatTime, locale).format(new Date());
    }

    /**
     * Return the format of the date.
     *
     * @return The format of the date.
     */
    public int getFormatDate() {
        return formatDate;
    }

    /**
     * Updates the format of the date.
     *
     * @param formatDate
     *          The new format of the date.
     */
    public void setFormatDate(int formatDate) {
        this.formatDate = formatDate;
    }

    /**
     * Return the format of the time.
     *
     * @return The format of the time.
     */
    public int getFormatTime() {
        return formatTime;
    }

    /**
     * Updates the format of the time.
     *
     * @param formatTime
     *          The new format of the time.
     */
    public void setFormatTime(int formatTime) {
        this.formatTime = formatTime;
    }

    /**
     * Return the locale of the datetime.
     *
     * @return The lcoale of the datetime.
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Updates the locale of the datetime.
     *
     * @param locale
     *          The new locale of the datetime.
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Method used to check if a date is valid with a format.
     *
     * @param dateToValidate
     *       The date to validate.
     * @param format
     *       The format.
     *
     * @return The result of the validation.
     */
    public static boolean dateValidator(String dateToValidate, String format) {
        if(dateToValidate == null)
            return false;

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {
            throw new RuntimeException("FormattedDate: Date is not a valid date : " + e);
        }

        return true;
    }
}
