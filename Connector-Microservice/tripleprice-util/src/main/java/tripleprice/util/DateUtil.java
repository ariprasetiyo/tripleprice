package tripleprice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ari.prasetiyo
 *
 */
public class DateUtil {
	private static DateUtil instance;
	private static SimpleDateFormat DDMMYYY = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat HHMMSS_DDMMYYY = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	private static SimpleDateFormat DD = new SimpleDateFormat("dd");
	private static SimpleDateFormat MM = new SimpleDateFormat("MM");
	private static SimpleDateFormat YYYY = new SimpleDateFormat("yyyy");

	private DateUtil() {
		super();
	}

	/**
	 * Thread safe type and make it faster with check instance == null
	 * 
	 * @return
	 */
	public static final DateUtil getInstanceThreadSafe() {
		if (instance == null) {
			synchronized (DateUtil.class) {
				if (instance == null) {
					instance = new DateUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * Non thread safe type
	 * 
	 * @return
	 */
	public static final DateUtil getInstanceLazy() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	public final String getDateDDMMYYYY(final Date date) {
		return DDMMYYY.format(date);
	}

	public final String getDateHHMMSSDDMMYYYY(final Date date) {
		return HHMMSS_DDMMYYY.format(date);
	}

	public final String getDateDD(final Date date) {
		return DD.format(date);
	}

	public final String getDateMM(final Date date) {
		return MM.format(date);
	}

	public final String getDateYYYY(final Date date) {
		return YYYY.format(date);
	}

}
