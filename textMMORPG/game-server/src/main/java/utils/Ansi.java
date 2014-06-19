package utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.main.ImportRoom;

public class Ansi {
	private static Logger logger = LoggerFactory.getLogger(Ansi.class);
	public static final String ESC = "";
	public static final String CSI = ESC + "[";
	/* Foreground Colors */

	public static final String BLK = ESC + "[30m"; /* Black */
	public static final String RED = ESC + "[31m"; /* Red */
	public static final String GRN = ESC + "[32m"; /* Green */
	public static final String YEL = ESC + "[33m"; /* Yellow */
	public static final String BLU = ESC + "[34m"; /* Blue */
	public static final String MAG = ESC + "[35m"; /* Magenta */
	public static final String CYN = ESC + "[36m"; /* Cyan */
	public static final String WHT = ESC + "[37m"; /* White */

	/* Hi Intensity Foreground Colors */

	public static final String HIR = ESC + "[1;31m"; /* Red */
	public static final String HIG = ESC + "[1;32m"; /* Green */
	public static final String HIY = ESC + "[1;33m"; /* Yellow */
	public static final String HIB = ESC + "[1;34m"; /* Blue */
	public static final String HIM = ESC + "[1;35m"; /* Magenta */
	public static final String HIC = ESC + "[1;36m"; /* Cyan */
	public static final String HIW = ESC + "[1;37m"; /* White */
	public static final String FLA = ESC + "[5m";
	/* High Intensity Background Colors */

	public static final String HBRED = ESC + "[41;1m"; /* Red */
	public static final String HBGRN = ESC + "[42;1m"; /* Green */
	public static final String HBYEL = ESC + "[43;1m"; /* Yellow */
	public static final String HBBLU = ESC + "[44;1m"; /* Blue */
	public static final String HBMAG = ESC + "[45;1m"; /* Magenta */
	public static final String HBCYN = ESC + "[46;1m"; /* Cyan */
	public static final String HBWHT = ESC + "[47;1m"; /* White */

	public static final String REDGRN = ESC + "[1;31;42m"; /* Magenta */
	public static final String REDYEL = ESC + "[1;31;43m";
	public static final String REDBLU = ESC + "[1;31;44m";
	public static final String REDMAG = ESC + "[1;31;45m";
	public static final String REDCYN = ESC + "[1;31;46m";
	public static final String REDWHT = ESC + "[1;31;47m";
	public static final String GRNRED = ESC + "[1;32;41m";
	public static final String GRNYEL = ESC + "[1;32;43m";
	public static final String GRNBLU = ESC + "[1;32;44m";
	public static final String GRNMAG = ESC + "[1;32;45m";
	public static final String GRNCYN = ESC + "[1;32;46m";
	public static final String GRNWHT = ESC + "[1;32;47m";
	public static final String YELRED = ESC + "[1;33;41m";
	public static final String YELGRN = ESC + "[1;33;42m";
	public static final String YELBLU = ESC + "[1;33;43m";
	public static final String YELMAG = ESC + "[1;33;45m";
	public static final String YELCYN = ESC + "[1;33;46m";
	public static final String YELWHT = ESC + "[1;33;47m";
	public static final String BLURED = ESC + "[1;34;41m";
	public static final String BLUGRN = ESC + "[1;34;42m";
	public static final String BLUYEL = ESC + "[1;34;43m";
	public static final String BLUMAG = ESC + "[1;34;45m";
	public static final String BLUCYN = ESC + "[1;34;46m";
	public static final String BLUWHT = ESC + "[1;34;47m";
	public static final String MAGRED = ESC + "[1;35;41m";
	public static final String MAGGRN = ESC + "[1;35;42m";
	public static final String MAGYEL = ESC + "[1;35;43m";
	public static final String MAGBLU = ESC + "[1;35;44m";
	public static final String MAGCYN = ESC + "[1;35;46m";
	public static final String MAGWHT = ESC + "[1;35;47m";
	public static final String CYNRED = ESC + "[1;36;41m";
	public static final String CYNGRN = ESC + "[1;36;42m";
	public static final String CYNYEL = ESC + "[1;36;43m";
	public static final String CYNBLU = ESC + "[1;36;44m";
	public static final String CYNMAG = ESC + "[1;36;45m";
	public static final String CYNWHT = ESC + "[1;36;47m";
	public static final String WHTRED = ESC + "[1;37;41m";
	public static final String WHTGRN = ESC + "[1;37;42m";
	public static final String WHTYEL = ESC + "[1;37;43m";
	public static final String WHTBLU = ESC + "[1;37;44m";
	public static final String WHTMAG = ESC + "[1;37;45m";
	public static final String WHTCYN = ESC + "[1;37;46m";
	/* Background Colors */

	public static final String BBLK = ESC + "[40m"; /* Black */
	public static final String BRED = ESC + "[41m"; /* Red */
	public static final String BGRN = ESC + "[42m"; /* Green */
	public static final String BYEL = ESC + "[43m"; /* Yellow */
	public static final String BBLU = ESC + "[44m"; /* Blue */
	public static final String BMAG = ESC + "[45m"; /* Magenta */
	public static final String BCYN = ESC + "[46m"; /* Cyan */
	public static final String BWHT = ESC + "[47m"; /* White */

	public static final String NOR = ESC + "[2;37;0m"; /*
														 * Puts= Everything back
														 * to normal
														 */

	/* Additional ansi= Esc codes added to ansi.h by Gothic april 23,1993 */
	/* Note, these are= Esc codes for VT100 terminals, and= Emmulators */
	/* and they may not all work within the mud */

	public static final String BOLD = ESC + "[1m"; /* Turn on bold mode */
	public static final String CLR = ESC + "[2J"; /* Clear the screen */
	public static final String HOME = ESC + "[H"; /* Send cursor to home position */
	public static final String REF = CLR + HOME; /* Clear screen and home cursor */
	public static final String BIGTOP = ESC + "#3"; /*
													 * Dbl height characters,
													 * top half
													 */
	public static final String BIGBOT = ESC + "#4"; /*
													 * Dbl height
													 * characters,bottem half
													 */
	public static final String SAVEC = ESC + "[s"; /* Save cursor position */
	public static final String REST = ESC + "[u"; /*
												 * Restore cursor to
												 * savedposition
												 */
	// public static final String REVINDEX= ESC+"M"; /* Scroll screen in
	// opposite direction */
	public static final String SINGW = ESC + "#5"; /*
													 * Normal, single-width
													 * characters
													 */
	public static final String DBL = ESC + "#6"; /*
												 * creates double-width
												 * characters
												 */
	public static final String FRTOP = ESC + "[2;25r"; /* Freeze top line */
	public static final String FRBOT = ESC + "[1;24r"; /* Freeze bottom line */
	public static final String UNFR = ESC + "[r"; /* Unfreeze top and bottom lines */
	public static final String BLINK = ESC + "[5m"; /* Initialize blink mode */
	public static final String U = ESC + "[4m"; /* Initialize underscore mode */
	public static final String REV = ESC + "[7m"; /* Turns reverse video mode on */
	public static final String HIREV = ESC + "[1,7m"; /* intensity reverse video */
	// public static final String SETDISPLAY(x,y)
	// (ESC+"["+x+";"+y+"f");/*Éè¶¨¹â±êÎ»ÖÃ*/
	public static final String DELLINE = ESC + "[K"; /* É¾³ý¹â±êËùÔÚµÄÐÐ */

	public static String replaceAnsi(String str) {
		try {
			Class<?> c = Class.forName("utils.Ansi");
			Field[] fields = c.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				str = str.replaceAll(fields[i].getName(), (String) fields[i].get(null));
			}
		} catch (Exception e) {
			logger.error("replaceAnsi failed:" + e.getMessage());
		}
		return null;
	}
}
