/**
 * @(#)MyTest.java, 7月 19, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.sun.deploy.util.StringUtils;

/**
 * @author fucf
 */
public class MyTest {

    public static void main(String[] args) {
        String s = "Contains Duplicate II";
        s = StringUtils.trimWhitespace(s);
        String[] strings = s.split(" ");
        String res = "";

        for (String str : strings) {
            res += str.replace(str.charAt(0), Character.toUpperCase(str.charAt(0)));
        }

        System.out.println(res);
    }

}