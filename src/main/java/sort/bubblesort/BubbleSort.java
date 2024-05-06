package sort.bubblesort;

import sort.ISort;

public class BubbleSort implements ISort {
    //안정정렬
    // 인플레이스 정렬
    // arr.length - 1 이유는 다음값을 비교하기 때문에 마지막은 확인 하지 않아도 됨
    // 진행되면 마지막 인덱스에서 아웃오브 익셉션 발생
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// 전체 리스트
            for (int j = 0; j < arr.length - 1 - i; j++) {// 정렬된 리스트 제외
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
