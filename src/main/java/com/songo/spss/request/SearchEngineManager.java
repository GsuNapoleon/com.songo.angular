/**
 * 
 */
package com.songo.spss.request;

import java.util.ArrayList;
import java.util.List;

import com.songo.spss.model.SearchEngine;

/**
 * <p>decription:</p>
 * <p>date:2014年11月27日 上午11:44:07</p>
 * @author gsu·napoleon
 */
public class SearchEngineManager {

    public static String[] EMPYT = new String[0];

    private static List<SearchEngine> items = new ArrayList<SearchEngine>(10);

    public static String[] match(String url) {
        String[] result = EMPYT;

        for (int i = 0, c = items.size(); i < c; ++i) {
            SearchEngine se = items.get(i);
            String[] temp = se.match(url);
            if (temp.length == 2) {
                return temp;
            }
        }
        return result;
    }


    public static void clear() {
        items.clear();
    }

    public static void add(SearchEngine searchEngine) {
        items.add(searchEngine);
    }

    public static int size() {
        return items.size();
    }

    public static List<SearchEngine> getItems() {
        return items;
    }

    public static String[] matchQuick(String url) {
        String[] result = EMPYT;

        for (int i = 0, c = items.size(); i < c; ++i) {
            SearchEngine se = (SearchEngine)items.get(i);
            String[] temp = se.matchQuick(url);
            if (temp.length == 2) {
                return temp;
            }
        }
        return result;
    }

}
