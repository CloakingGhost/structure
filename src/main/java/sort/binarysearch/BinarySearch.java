package sort.binarysearch;

public class BinarySearch {
    public int search(int[] arr, int target) {
        //1. 데이터의 중간 인덱스 값을 찾는다.
        //2. 중간 인덱스 위치를 기준으로 arr 을 절반으로 나눈다.
        //3. 나눠진 절반의 리스트에서 target 값을 찾는다.

        int l = 0;
        int r = arr.length - 1;

        int m;
        while (l <= r) {
            //오버플로우 방지
            m = l + ((r - 1) / 2); // 작 + ((큰 - 작) / 2)
            if (arr[m] == target) {
                return m;
            }

            if (arr[m] < target) {
                //오른쪽을 탐색해야함
                l = m + 1;
            } else {
                // 왼쪽을 탐색 해야함
                r = m - 1;
            }
        }
        return -1;
    }
}
