/**
 * 
 */
package com.songo.spss.request;


/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午9:26:45</p>
 * @author gsu·napoleon
 */
public class ApplicationManager {

    private static String site;
    private static String wapStr = "3g.";  // xxx.3g.pconine.com.cn 这一类也包含进站内

    public static String getSite() {
        return site;
    }

    public static void setSite(String site) {
        ApplicationManager.site = site;
    }

    public static boolean matchSite(String url) {
        int pos = url.indexOf(site);
        int pos2 = url.indexOf('.');
        
        int pos3g = url.indexOf(wapStr + site);

        if (pos == -1) return false;
        if (pos > 30) return false;
        if (pos > pos2 + 1 && pos3g > pos2 + 1) return false;

        return true;
    }

}
