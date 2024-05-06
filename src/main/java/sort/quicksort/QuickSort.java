package sort.quicksort;

import sort.ISort;

public class QuickSort implements ISort {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivot = low + ((high - low) / 2);
        int pivotValue = arr[pivot];

        int left = low;
        int right = high;
        while (left <= right) {
            while (arr[left] < pivotValue) {
                left++;
            }
            while (arr[right] > pivotValue) {
                right--;
            }
            if (left <= right) {
                swap(arr, right, left);
                left++;
                right--;
            }
        }
        quickSort(arr, low, right); // ����, right �� ������ �� while �� ���� �����Ǿ��� ����
        quickSort(arr, left, high); // ������
    }

    private static void swap(int[] arr, int right, int left) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    void s(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    // �迭�� ���̰� 1�� �ɶ� ����
    // �ǹ��ε����� ��������
    // �ǹ������� ���� �� �� ū�� ������ ����
    // �ǹ����� ������ �� �� ������ ������ ����
    // �ΰ��� �ٲ۴�
    // �ݺ�, ��������? left <= right  �����ϱ� ������
    // ����Ŭ�� ������
    // �ǹ� ���� ���� ������ ���� �޼ҵ� ȣ��(��� ȣ��)
    //
    private void qs(int[] arr, int low, int high) {
        if (low >= high) return; // �迭�� ���̰� 1�̵�

        int pivot = low + ((high - low) / 2);
        int pivotValue = arr[pivot];

        int left = low; // �ε���
        int right = high; // �ε���

        while (left <= right) { //
            while (arr[left] <= pivotValue) {
                left++;
            }
            while (arr[right] >= pivotValue) {
                right--;
            }
            if (left <= right) {// �� while ������ �������� ���� �ֱ⶧����
                //�� swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        qs(arr, low, right);
        qs(arr, left, high);
    }
}
