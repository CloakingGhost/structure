package sort.binarysearch;

public class BinarySearch {
    public int search(int[] arr, int target) {
        //1. �������� �߰� �ε��� ���� ã�´�.
        //2. �߰� �ε��� ��ġ�� �������� arr �� �������� ������.
        //3. ������ ������ ����Ʈ���� target ���� ã�´�.

        int l = 0;
        int r = arr.length - 1;

        int m;
        while (l <= r) {
            //�����÷ο� ����
            m = l + ((r - 1) / 2); // ū������ ������ ��ŭ�� ���� �ֱ� ������ �������� �ѻ� ����
            if (arr[m] == target) {
                return m;
            }

            if (arr[m] < target) {
                //�������� Ž���ؾ���
                l = m + 1;
            } else {
                // ������ Ž�� �ؾ���
                r = m - 1;
            }
        }


        return -1;
    }
}
