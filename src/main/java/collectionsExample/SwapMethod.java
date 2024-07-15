package collectionsExample;

import java.util.*;

public class SwapMethod {
  public static void main(String[] args) {
    CollectionsSwap1 collectionsSwap = new CollectionsSwap1();
    collectionsSwap.collectionSwap();

    CollectionsSwap2 collectionsSwap2 = new CollectionsSwap2();
    collectionsSwap2.collectionsSwap();

    CollectionsSwap3 collectionsSwap3 = new CollectionsSwap3();
    collectionsSwap3.collectionsSwap();
  }
}

class CollectionsSwap1 {
  public void collectionSwap() {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
    System.out.println("정수 List 요소 위치 변경 전 : " + arr);

    Collections.swap(arr, 2, 4);
    System.out.println("정수 List 요소 위치 변경 후 : " + arr);
  }
}

class CollectionsSwap2 {
  public void collectionsSwap() {
    String[] arr = {"a", "b", "c", "d", "e"};
    System.out.println("문자열 배열 요소 위치 변경 전 : " + Arrays.toString(arr));

    Collections.swap(Arrays.asList(arr), 2, 4);
    System.out.println("문자열 배열 요소 위치 변경 전 : " + Arrays.toString(arr));
  }
}

class CollectionsSwap3 {
  public void collectionsSwap() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> newArr = new ArrayList<>();
    System.out.println("정수 배열 요소 위치 변경 전 : " + Arrays.toString(arr));

    for (int i : arr) {
      newArr.add(i);
    }

    Collections.swap(newArr, 2, 4);
    System.out.println("정수 List로 변환, 요소 위치 변경 후 : " + newArr);
  }
}
