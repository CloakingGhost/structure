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

    //안정정렬
    //인플레이스
    //int i = 1인 이유 0인덱스를 서브리스트로 간주하기 위함
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {// 0 인덱스를 제외한 전체 리스트
            int key = arr[i]; // 삽입 위치를 찾아줄 데이터
            int j = i - 1; // 0 - j 정렬된 서브 리스트의 최대 인덱스
            while (j >= 0 && arr[j] > key) { // j가 -1이 되면 처음까지 도달한거임, key 보다 서브리스트 값이 더 큰 경우
                arr[j + 1] = arr[j]; // 오른쪽으로 덮음
                j--;// 서브리스트 역순 진행, 안쪽으로 이동
            }
            arr[j + 1] = key;// 위에서 j--를 했기 때문
        }
    }

    void s(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];// 데이터를 덮으면서 이동하기 때문에 따라 값을 빼둬야함
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
