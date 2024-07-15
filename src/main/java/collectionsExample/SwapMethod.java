package collectionsExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwapMethod {
  public static void main(String[] args) {
    CollectionsSwap1 collectionsSwap = new CollectionsSwap1();
    collectionsSwap.collectionSwap();

    CollectionsSwap2 collectionsSwap2 = new CollectionsSwap2();
    collectionsSwap2.collectionsSwap();
  }
}

class CollectionsSwap1 {
  public void collectionSwap() {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);

    Collections.swap(arr, 2, 4);
    System.out.println(arr);
  }
}

class CollectionsSwap2 {
  public void collectionsSwap() {
    String[] arr = {"a", "b", "c", "d", "e"};

    Collections.swap(Arrays.asList(arr), 2, 4);
    System.out.println(Arrays.toString(arr));
  }
}
