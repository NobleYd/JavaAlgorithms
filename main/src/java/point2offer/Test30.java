package point2offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: 鐜嬩繆瓒�
 * Date: 2015-06-10
 * Time: 13:32
 * Declaration: All Rights Reserved !!!
 */
public class Test30 {
    /**
     * 澶ч《鍫�
     *
     * @param <T> 鍙傛暟鍖栫被鍨�
     */
    private final static class MaxHeap<T extends Comparable<T>> {
        // 鍫嗕腑鍏冪礌瀛樻斁鐨勯泦鍚�
        private List<T> items;
        // 鐢ㄤ簬璁℃暟
        private int cursor;

        /**
         * 鏋勯�犱竴涓锛屽澶у皬鏄�32
         */
        public MaxHeap() {
            this(32);
        }

        /**
         * 閫犺涓�涓寚瀹氬垵濮嬪ぇ灏忕殑鍫�
         *
         * @param size 鍒濆澶у皬
         */
        public MaxHeap(int size) {
            items = new ArrayList<>(size);
            cursor = -1;
        }

        /**
         * 鍚戜笂璋冩暣鍫�
         *
         * @param index 琚笂绉诲厓绱犵殑璧峰浣嶇疆
         */
        public void siftUp(int index) {
            T intent = items.get(index); // 鑾峰彇寮�濮嬭皟鏁寸殑鍏冪礌瀵硅薄

            while (index > 0) { // 濡傛灉涓嶆槸鏍瑰厓绱�
                int parentIndex = (index - 1) / 2; // 鎵剧埗鍏冪礌瀵硅薄鐨勪綅缃�
                T parent = items.get(parentIndex);  // 鑾峰彇鐖跺厓绱犲璞�
                if (intent.compareTo(parent) > 0) { //涓婄Щ鐨勬潯浠讹紝瀛愯妭鐐规瘮鐖惰妭鐐瑰ぇ
                    items.set(index, parent); // 灏嗙埗鑺傜偣鍚戜笅鏀�
                    index = parentIndex; // 璁板綍鐖惰妭鐐逛笅鏀剧殑浣嶇疆
                } else { // 瀛愯妭鐐逛笉姣旂埗鑺傜偣澶э紝璇存槑鐖跺瓙璺緞宸茬粡鎸変粠澶у埌灏忔帓濂介『搴忎簡锛屼笉闇�瑕佽皟鏁翠簡
                    break;
                }
            }

            // index姝ゆ椂璁板綍鏄殑鏈�鍚庝竴涓涓嬫斁鐨勭埗鑺傜偣鐨勪綅缃紙涔熷彲鑳芥槸鑷韩锛夛紝鎵�浠ュ皢鏈�寮�濮嬬殑璋冩暣鐨勫厓绱犲�兼斁鍏ndex浣嶇疆鍗冲彲
            items.set(index, intent);
        }

        /**
         * 鍚戜笅璋冩暣鍫�
         *
         * @param index 琚笅绉荤殑鍏冪礌鐨勮捣濮嬩綅缃�
         */
        public void siftDown(int index) {
            T intent = items.get(index);  // 鑾峰彇寮�濮嬭皟鏁寸殑鍏冪礌瀵硅薄
            int leftIndex = 2 * index + 1; // // 鑾峰彇寮�濮嬭皟鏁寸殑鍏冪礌瀵硅薄鐨勫乏瀛愮粨鐐圭殑鍏冪礌浣嶇疆

            while (leftIndex < items.size()) { // 濡傛灉鏈夊乏瀛愮粨鐐�
                T maxChild = items.get(leftIndex); // 鍙栧乏瀛愮粨鐐圭殑鍏冪礌瀵硅薄锛屽苟涓斿亣瀹氬叾涓轰袱涓瓙缁撶偣涓渶澶х殑
                int maxIndex = leftIndex; // 涓や釜瀛愯妭鐐逛腑鏈�澶ц妭鐐瑰厓绱犵殑浣嶇疆锛屽亣瀹氬紑濮嬫椂涓哄乏瀛愮粨鐐圭殑浣嶇疆

                int rightIndex = leftIndex + 1;  // 鑾峰彇鍙冲瓙缁撶偣鐨勪綅缃�
                if (rightIndex < items.size()) {  // 濡傛灉鏈夊彸瀛愮粨鐐�
                    T rightChild = items.get(rightIndex);  // 鑾峰彇鍙冲瓙缁撶偣鐨勫厓绱犲璞�
                    if (rightChild.compareTo(maxChild) > 0) {  // 鎵惧嚭涓や釜瀛愯妭鐐逛腑鐨勬渶澶у瓙缁撶偣
                        maxChild = rightChild;
                        maxIndex = rightIndex;
                    }
                }

                // 濡傛灉鏈�澶у瓙鑺傜偣姣旂埗鑺傜偣澶э紝鍒欓渶瑕佸悜涓嬭皟鏁�
                if (maxChild.compareTo(intent) > 0) {
                    items.set(index, maxChild); // 灏嗗瓙鑺傜偣鍚戜笂绉�
                    index = maxIndex; // 璁板綍涓婄Щ鑺傜偣鐨勪綅缃�
                    leftIndex = index * 2 + 1; // 鎵惧埌涓婄Щ鑺傜偣鐨勫乏瀛愯妭鐐圭殑浣嶇疆
                } else { // 鏈�澶у瓙鑺傜偣涓嶆瘮鐖惰妭鐐瑰ぇ锛岃鏄庣埗瀛愯矾寰勫凡缁忔寜浠庡ぇ鍒板皬鎺掑ソ椤哄簭浜嗭紝涓嶉渶瑕佽皟鏁翠簡
                    break;
                }
            }

            // index姝ゆ椂璁板綍鏄殑鏈�鍚庝竴涓涓婄Щ鐨勫瓙鑺傜偣鐨勪綅缃紙涔熷彲鑳芥槸鑷韩锛夛紝鎵�浠ュ皢鏈�寮�濮嬬殑璋冩暣鐨勫厓绱犲�兼斁鍏ndex浣嶇疆鍗冲彲
            items.set(index, intent);
        }

        /**
         * 鍚戝爢涓坊鍔犱竴涓厓绱�
         *
         * @param item 绛夊緟娣诲姞鐨勫厓绱�
         */
        public void add(T item) {
            items.add(item); // 灏嗗厓绱犳坊鍔犲埌鏈�鍚�
            siftUp(items.size() - 1); // 寰幆涓婄Щ锛屼互瀹屾垚閲嶆瀯
        }

        /**
         * 鍒犻櫎鍫嗛《鍏冪礌
         *
         * @return 鍫嗛《閮ㄧ殑鍏冪礌
         */
        public T deleteTop() {
            if (items.isEmpty()) { // 濡傛灉鍫嗗凡缁忎负绌猴紝灏辨姤鍑哄紓甯�
                throw new RuntimeException("The heap is empty.");
            }

            T maxItem = items.get(0); // 鑾峰彇鍫嗛《鍏冪礌
            T lastItem = items.remove(items.size() - 1); // 鍒犻櫎鏈�鍚庝竴涓厓绱�
            if (items.isEmpty()) { // 鍒犻櫎鍏冪礌鍚庯紝濡傛灉鍫嗕负绌虹殑鎯呭喌锛岃鏄庡垹闄ょ殑鍏冪礌涔熸槸鍫嗛《鍏冪礌
                return lastItem;
            }

            items.set(0, lastItem); // 灏嗗垹闄ょ殑鍏冪礌鏀惧叆鍫嗛《
            siftDown(0); // 鑷笂鍚戜笅璋冩暣鍫�
            return maxItem; // 杩斿洖鍫嗛《鍏冪礌
        }

        /**
         * 鑾峰彇涓嬩竴涓厓绱�
         *
         * @return 涓嬩竴涓厓绱犲璞�
         */
        public T next() {

            if (cursor >= items.size()) {
                throw new RuntimeException("No more element");
            }
            return items.get(cursor);

        }

        /**
         * 鍒ゆ柇鍫嗕腑鏄惁杩樻湁涓嬩竴涓厓绱�
         *
         * @return true鍫嗕腑杩樻湁涓嬩竴涓厓绱狅紝false鍫嗕腑鏃犱笅浜斿厓绱�
         */
        public boolean hasNext() {
            cursor++;
            return cursor < items.size();
        }

        /**
         * 鑾峰彇鍫嗕腑鐨勭涓�涓厓绱�
         *
         * @return 鍫嗕腑鐨勭涓�涓厓绱�
         */
        public T first() {
            if (items.size() == 0) {
                throw new RuntimeException("The heap is empty.");
            }
            return items.get(0);
        }

        /**
         * 鍒ゆ柇鍫嗘槸鍚︿负绌�
         *
         * @return true鏄紝false鍚�
         */
        public boolean isEmpty() {
            return items.isEmpty();
        }

        /**
         * 鑾峰彇鍫嗙殑澶у皬
         *
         * @return 鍫嗙殑澶у皬
         */
        public int size() {
            return items.size();
        }

        /**
         * 娓呯┖鍫�
         */
        public void clear() {
            items.clear();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }

    /**
     * 棰樼洰锛� 杈撳叆n涓暣鏁帮紝鎵惧嚭鍏朵腑鏈�灏忕殑k涓暟銆�
     * 銆愮浜岀瑙ｆ硶銆�
     * @param input  杈撳叆鏁扮粍
     * @param output 杈撳嚭鏁扮粍
     */
    public static void getLeastNumbers2(int[] input, int[] output) {
        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>(output.length);
        for (int i : input) {
            if (maxHeap.size() < output.length) {
                maxHeap.add(i);
            } else {
                int max = maxHeap.first();
                if (max > i) {
                    maxHeap.deleteTop();
                    maxHeap.add(i);
                }
            }
        }

        for (int i = 0; maxHeap.hasNext(); i++) {
            output[i] = maxHeap.next();
        }
    }


    /**
     * 棰樼洰锛� 杈撳叆n涓暣鏁帮紝鎵惧嚭鍏朵腑鏈�灏忕殑k涓暟銆�
     * 銆愮涓�绉嶈В娉曘��
     * @param input  杈撳叆鏁扮粍
     * @param output 杈撳嚭鏁扮粍
     */
    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * 鍒嗗尯绠楁硶
     *
     * @param input 杈撳叆鏁扮粍
     * @param start 寮�濮嬩笅鏍�
     * @param end   缁撴潫涓嬫爣
     * @return 鍒嗗尯浣嶇疆
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }


    public static void main(String[] args) {
        System.out.println("绗竴绉嶈В娉曪細");
        test1();
        System.out.println();
        System.out.println("绗簩绉嶈В娉曪細");
        test2();

    }

    private static void test1() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] output3 = new int[1];
        getLeastNumbers(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void test2() {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        int[] output = new int[4];
        getLeastNumbers2(data, output);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] output2 = new int[8];
        getLeastNumbers2(data, output2);
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] output3 = new int[1];
        getLeastNumbers2(data, output3);
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        int[] output4 = new int[2];
        getLeastNumbers2(data2, output4);
        for (int i : output4) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


