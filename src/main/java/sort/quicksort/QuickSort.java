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
        quickSort(arr, low, right); // 왼쪽, right 인 이유는 위 while 을 통해 교차되었기 때문
        quickSort(arr, left, high); // 오른쪽
    }

    private static void swap(int[] arr, int right, int left) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    void s(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    // 배열의 길이가 1이 될때 까지
    // 피벗인덱스을 기준으로
    // 피벗값보다 왼쪽 값 중 큰게 있으면 정지
    // 피벗보다 오른쪽 값 중 작은게 있으면 정지
    // 두값을 바꾼다
    // 반복, 언제까지? left <= right  교차하기 전까지
    // 사이클이 끝나면
    // 피벗 제외 왼쪽 오른쪽 정렬 메소드 호출(재귀 호출)
    //
    private void qs(int[] arr, int low, int high) {
        if (low >= high) return; // 배열의 길이가 1이됨

        int pivot = low + ((high - low) / 2);
        int pivotValue = arr[pivot];

        int left = low; // 인덱스
        int right = high; // 인덱스

        while (left <= right) { //
            while (arr[left] <= pivotValue) {
                left++;
            }
            while (arr[right] >= pivotValue) {
                right--;
            }
            if (left <= right) {// 위 while 떄문에 교차했을 수도 있기때문에
                //값 swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        qs(arr, low, right);
        qs(arr, left, high);
    }
}
