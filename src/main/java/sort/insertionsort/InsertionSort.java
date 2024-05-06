package sort.insertionsort;

import sort.ISort;

import java.util.Arrays;

public class InsertionSort implements ISort {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        new InsertionSort().sort(arr1);
        System.out.println(
                Arrays.toString(arr1)
        );

        System.out.println();
        int[] arr2 = {4, 3, 2, 1};
        new InsertionSort().s(arr2);
        System.out.println(
                Arrays.toString(arr2)
        );
    }

    //��������
    //���÷��̽�
    //int i = 1�� ���� 0�ε����� ���긮��Ʈ�� �����ϱ� ����
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {// 0 �ε����� ������ ��ü ����Ʈ
            int key = arr[i]; // ���� ��ġ�� ã���� ������
            int j = i - 1; // 0 - j ���ĵ� ���� ����Ʈ�� �ִ� �ε���
            while (j >= 0 && arr[j] > key) { // j�� -1�� �Ǹ� ó������ �����Ѱ���, key ���� ���긮��Ʈ ���� �� ū ���
                arr[j + 1] = arr[j]; // ���������� ����
                j--;// ���긮��Ʈ ���� ����, �������� �̵�
            }
            arr[j + 1] = key;// ������ j--�� �߱� ����
        }
    }

    void s(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];// �����͸� �����鼭 �̵��ϱ� ������ ���� ���� ���־���
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                }

            }
            arr[j + 1] = key;

        }
    }
}
