package com.app;

public class TestBase {

    public void print(int[] datas) {
        if (datas == null) {
            System.out.println("null");
        } else if (datas.length == 0) {
            System.out.println("[]");
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int t : datas) {
                sb.append(t + ", ");
            }
            sb.replace(sb.length() - 2, sb.length(), "");
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

}
