package com.app.pattern;

public class KMP {

	public static int[] getNext(String t) {
		int[] next = new int[t.length()];
		int j = 1;
		int k = 0;
		next[0] = -1;
		next[1] = 0;
		while (j < t.length() - 1) {
			if (t.charAt(j) == t.charAt(k)) {
				next[j + 1] = k + 1;
				System.out.println("j=" + j + "next[j]=" + next[j] + ", k=" + k);
				j++;
				k++;
			} else if (k == 0) {
				next[j + 1] = 0;
				j++;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public static int[] getNextVal(String t) {
		int[] nextVal = new int[t.length()];
		int j = 0;
		int k = -1;
		nextVal[0] = -1;
		while (j < t.length() - 1) {
			if (k == -1 || t.charAt(j) == t.charAt(k)) {
				j++;
				k++;
				if (t.charAt(j) != t.charAt(k)) {
					nextVal[j] = k;
				} else {
					nextVal[j] = nextVal[k];
				}
			} else {
				k = nextVal[k];
			}
		}
		return nextVal;
	}

	public static void main(String[] args) {
		getNext("abcsabacbacbacbbacbbabbcbbacbabcb");
	}

}
