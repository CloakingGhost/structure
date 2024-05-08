package sort.mergesort;

import sort.ISort;

public class MergeSort implements ISort {
    public static void main(String[] args) {
        new MergeSort().sort(new int[]{8, 7, 6, 5, 4, 3, 2, 1});
    }

    //원본배열을 그대로 들고가고
    //인덱스를 세부적으로 쪼개어
    //인덱스에 있는 원소를 크기비교하는 것

    //in-place sort (out-of-place 도 가능)
    // 인플레이스가 난이도 더 높음
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);// 분할 시작
    }

    //분할
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {// 중간값을 넘어가지 않을 때까지, 배열의 길이가 1되는 순간임
            return;
        }
        int mid = low + ((high - low) / 2);// 절반씩 분할, 중간값
        mergeSort(arr, low, mid); // 왼쪽부터 배열의 길이가 1이 될때까지 분할
        mergeSort(arr, mid + 1, high);// 그다음 오른쪽 배열의 길이가 1이 될때까지 분할

        //이제 크기를 비교하며 합병
        merge(arr, low, mid, high);
    }

    //합병
    private void merge(int[] arr, int low, int mid, int high) {
        //정렬된 서브배열를 정렬하여 담을 보조배열
        int[] temp = new int[high - low + 1];// 합쳐져야할 배열의 크기와 동일하기 때문
        int idx = 0;

        int left = low; // 왼쪽 배열의 시작 인덱스
        int right = mid + 1; // 오른쪽 배열의 시작 인덱스
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
        // 왼쪽 리스트의 값이 남은 경우
        while (left <= mid) {
            temp[idx] = arr[left];
            idx++;
            left++;
        }
        // 오른쪽 리스트의 값이 남은 경우
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
        // 정렬 범위
        ms(arr, 0, arr.length - 1);
    }

    //분할
    void ms(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) / 2);

        ms(arr, low, mid);
        ms(arr, mid + 1, high);

        m(arr, low, mid, high);
    }

    //합병
    void m(int[] arr, int low, int mid, int high) {
        //둘로 인덱스를 정렬하여 값을 받을 별도의 배열
        int[] temp = new int[high - low + 1];// 빼면 마지막이 없어지니까 + 1 한다.
        int idx = 0;
        //대소비교를 위해 왼쪽인덱스 오른쪽인덱스 생성
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
        //나머지 비교할 대상이 없어 남은 값들은 temp 에 넣어준다
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
