package sort.mergesort;

import sort.ISort;

public class MergeSort implements ISort {
    public static void main(String[] args) {
        new MergeSort().sort(new int[]{8, 7, 6, 5, 4, 3, 2, 1});
    }

    //�����迭�� �״�� �����
    //�ε����� ���������� �ɰ���
    //�ε����� �ִ� ���Ҹ� ũ����ϴ� ��

    //in-place sort (out-of-place �� ����)
    // ���÷��̽��� ���̵� �� ����
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);// ���� ����
    }

    //����
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {// �߰����� �Ѿ�� ���� ������, �迭�� ���̰� 1�Ǵ� ������
            return;
        }
        int mid = low + ((high - low) / 2);// ���ݾ� ����, �߰���
        mergeSort(arr, low, mid); // ���ʺ��� �迭�� ���̰� 1�� �ɶ����� ����
        mergeSort(arr, mid + 1, high);// �״��� ������ �迭�� ���̰� 1�� �ɶ����� ����

        //���� ũ�⸦ ���ϸ� �պ�
        merge(arr, low, mid, high);
    }

    //�պ�
    private void merge(int[] arr, int low, int mid, int high) {
        //���ĵ� ����迭�� �����Ͽ� ���� �����迭
        int[] temp = new int[high - low + 1];// ���������� �迭�� ũ��� �����ϱ� ����
        int idx = 0;

        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx] = arr[left];
                left++;
            } else {
                temp[idx] = arr[right];
                right++;
            }
            idx++;
        }
        // ���� ����Ʈ�� ���� ���� ���
        while (left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }
        // ������ ����Ʈ�� ���� ���� ���
        while (right <= high) {
            temp[idx] = arr[right];
            idx++;
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    void s(int[] arr) {
        // ���� ����
        ms(arr, 0, arr.length - 1);
    }

    //����
    void ms(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) / 2);

        ms(arr, low, mid);
        ms(arr, mid + 1, high);

        m(arr, low, mid, high);
    }

    //�պ�
    void m(int[] arr, int low, int mid, int high) {
        //�ѷ� �ε����� �����Ͽ� ���� ���� ������ �迭
        int[] temp = new int[high - low + 1];// ���� �������� �������ϱ� + 1 �Ѵ�.
        int idx = 0;
        //��Һ񱳸� ���� �����ε��� �������ε��� ����
        int left = low;
        int right = mid + 1;

        while (left <= mid && right < high) {
            if (arr[left] <= arr[right]) {
                temp[idx] = arr[left];
                left++;
            } else {
                temp[idx] = arr[right];
                right++;
            }
            idx++;
        }
        //������ ���� ����� ���� ���� ������ temp �� �־��ش�
        while (left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }
        while (right <= high) {
            temp[idx] = arr[right];
            idx++;
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
