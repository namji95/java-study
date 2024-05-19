package collectionFramework;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {
        System.out.println("-----------------Collection 인터페이스 예제-----------------");
        CollectionInterface collectionInterface = new CollectionInterface();
        collectionInterface.collectionExample();

        System.out.println("\n-----------------ArrayList 클래스 예제-----------------");
        ArrayListClass arrayListClass = new ArrayListClass();
        arrayListClass.arrayListExample();

        System.out.println("\n-----------------LinkedList 클래스 예제-----------------");
        LinkedListClass linkedListClass = new LinkedListClass();
        linkedListClass.linkedListExample();

        System.out.println("\n-----------------Vector 클래스 예제-----------------");
        VectorClass vectorClass = new VectorClass();
        vectorClass.vectorExample();

        System.out.println("\n-----------------Stack 클래스 예제-----------------");
        StackClass stackClass = new StackClass();
        stackClass.stackExample();

        System.out.println("\n-----------------PriorityQueue 클래스 예제-----------------");
        PriorityQueueClass priorityQueueClass = new PriorityQueueClass();
        priorityQueueClass.priorityQueueExample();

        System.out.println("\n-----------------ArrayDequeClass 클래스 예제-----------------");
        ArrayDequeClass arrayDequeClass = new ArrayDequeClass();
        arrayDequeClass.arrayDequeExample();

        System.out.println("\n-----------------QueueLinkedList 클래스 예제-----------------");
        QueueLinkedListClass queueLinkedListClass = new QueueLinkedListClass();
        queueLinkedListClass.queueLinkedListExample();

        System.out.println("\n-----------------hashSet 클래스 예제-----------------");
        HashSetClass hashSetClass = new HashSetClass();
        hashSetClass.hashSetExample();

        System.out.println("\n-----------------LinkedHashSetClass 클래스 예제-----------------");
        LinkedHashSetClass linkedHashSetClass = new LinkedHashSetClass();
        linkedHashSetClass.linkedHashSetExample();

        System.out.println("\n-----------------TreeSetClass 클래스 예제-----------------");
        TreeSetClass treeSetClass = new TreeSetClass();
        treeSetClass.treeSetExample();

        System.out.println("\n-----------------EnumSet 클래스 예제-----------------");
        EnumSetClass enumSetClass = new EnumSetClass();
        enumSetClass.EnumSetExample();

        System.out.println("\n-----------------MapEntry 인터페이스 예제-----------------");
        MapEntryInterface mapEntryInterface = new MapEntryInterface();
        mapEntryInterface.mapEntryExample();

        System.out.println("\n-----------------HashMap 클래스 예제-----------------");
        HashMapClass hashMapClass = new HashMapClass();
        hashMapClass.hashMapExample();

        System.out.println("\n-----------------LinkedHashMap 클래스 예제-----------------");
        LinkedHashMapClass linkedHashMapClass = new LinkedHashMapClass();
        linkedHashMapClass.linkedHashMapExample();

        System.out.println("\n-----------------TreeMap 클래스 예제-----------------");
        TreeMapClass treeMapClass = new TreeMapClass();
        treeMapClass.treeMapExample();

        System.out.println("\n-----------------HashTable 클래스 예제-----------------");
        HashTableClass hashTableClass = new HashTableClass();
        hashTableClass.HashTableExample();

        System.out.println("\n-----------------Properties 클래스 예제-----------------");
        PropertiesClass propertiesClass = new PropertiesClass();
        propertiesClass.propertiesExample();
    }
}

class PropertiesClass {
    public void propertiesExample() {
        Properties properties = new Properties();

        // Properties 컬렉션에 String : String 구조의 데이터 추가
        properties.setProperty("Backend", "백엔드");
        properties.setProperty("Frontend", "프론트엔드");
        properties.setProperty("FullStack", "풀스택");

        // programming.properties 파일에 Properties 자료들을 저장
        Path propertiesFile = Paths.get("src/main/resources/programming.properties");


        try (Writer writer =
            new OutputStreamWriter(Files.newOutputStream(propertiesFile), StandardCharsets.UTF_8)) {
            properties.store(writer, "Properties File Test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HashTableClass {
    public void HashTableExample() {
        Map<String, String> hashTable = new HashMap<>();

        hashTable.put("JPA", "jpa");
        hashTable.put("QUERYDSL", "querydsl");
        hashTable.put("JPQL", "jpql");

        for (String key : hashTable.keySet()) {
            System.out.println(key + " : " + hashTable.get(key));
        }
    }
}

class TreeMapClass {
    public void treeMapExample() {
        Map<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "원");
        treeMap.put(2, "투");
        treeMap.put(3, "쓰리");

        for (Integer key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }
    }
}

class LinkedHashMapClass {
    public void linkedHashMapExample() {
        System.out.println("HashMap과 LinkedHashMap 비교");
        System.out.println("-------------HashMap-------------");

        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(10, "하나");
        hashMap.put(20, "둘");
        hashMap.put(30, "셋");

        for (Integer key : hashMap.keySet()) {
            System.out.println(key + " : " + hashMap.get(key));
            // 정렬 X
        }

        System.out.println("-------------LinkedHashMap-------------");

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(10, "하나");
        linkedHashMap.put(20, "둘");
        linkedHashMap.put(30, "셋");

        for (Integer key : linkedHashMap.keySet()) {
            System.out.println(key + " : " + linkedHashMap.get(key));
            // 정렬 O
        }
    }
}

class HashMapClass {
    public void hashMapExample() {
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("java", "자바");
        hashMap.put("Spring", "스프링");
        hashMap.put("Spring Boot", "스프링 부트");

        System.out.println("hashMap.get() : " + hashMap.get("Spring"));

        for (String key : hashMap.keySet()) {
            System.out.println(key + " : " + hashMap.get(key));
        }

        System.out.println("HashMap Result : " + hashMap);
    }
}

class MapEntryInterface {
    public void mapEntryExample() {
        Map<String, Integer> mapEntry = new HashMap<>();

        mapEntry.put("a", 1);
        mapEntry.put("b", 2);
        mapEntry.put("c", 3);

        // Map.Entry 인터페이스를 구현하고 있는
        // Key-Value 쌍을 가지고 있는 HashMap의 Node 객체들의 Set 집합을 반환
        Set<Map.Entry<String, Integer>> entry = mapEntry.entrySet();

        System.out.println(entry);

        // Set을 순회하면서 Map.Entry를 구현한 Node 객체에서 key와 value를 얻어 출력
        for (Map.Entry<String, Integer> e : entry) {
            System.out.printf("%s : %d \n", e.getKey(), e.getValue());
        }
    }
}

enum Color {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

class EnumSetClass {
    public void EnumSetExample() {
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);

        for (Color color : enumSet) {
            System.out.println("enumSet : " + color);
        }

        System.out.println("enumSet.size() : " + enumSet.size());

        System.out.println("enumSet Result : " + enumSet);
    }
}

class TreeSetClass {
    public void treeSetExample() {
        Random random = new Random();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 1; i <= 10; i++) {
            treeSet.add(random.nextInt(10) + 1);
        }

        System.out.println("treeSet : " + treeSet);
        // 램덤으로 값을 추가해도 순차로 정렬되어 출력되는 것을 확인할 수 있습니다.
    }
}

class LinkedHashSetClass {
    public void linkedHashSetExample() {
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        for (int i = 10; i <= 50; i += 10) {
            linkedHashSet.add(i);
        }
        System.out.println("linkedHashSet 데이터 추가 : " + linkedHashSet);

        linkedHashSet.add(30); // 중복 요소 추가
        System.out.println("중복 요소 추가 시 : " + linkedHashSet);

        System.out.println("linkedHashSet.size() : " + linkedHashSet.size());

        System.out.println("linkedHashSet Result : " + linkedHashSet);
    }
}

class HashSetClass {
    public void hashSetExample() {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 10; i <= 50; i += 10) {
            hashSet.add(i);
        }
        System.out.println("HashSet 데이터 추가 : " + hashSet);

        hashSet.add(30); // 중복 요소 추가
        System.out.println("중복 요소 추가 시 : " + hashSet);

        System.out.println("hashSet.size() : " + hashSet.size()); // 중복 카운트 X

        System.out.println("hashSet Result : " + hashSet);
    }
}

class QueueLinkedListClass {
    public void queueLinkedListExample() {
        Queue<String> queueLinkedList = new LinkedList<>();

        queueLinkedList.offer("hello");
        queueLinkedList.offer("java");
        queueLinkedList.offer("LinkedList");
        System.out.println("queueLinkedList : " + queueLinkedList);

        queueLinkedList.poll();
        System.out.println("queueLinkedList.poll() : " + queueLinkedList);

        System.out.println("queueLinkedList Result : " + queueLinkedList);
    }
}

class ArrayDequeClass {
    public void arrayDequeExample() {
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.offerLast(30);
        System.out.println("마지막에 데이터 입력 : " + arrayDeque);
        arrayDeque.offerFirst(20);
        System.out.println("첫 번째 자리에 데이터 입력 : " + arrayDeque);
        arrayDeque.offerFirst(10);
        System.out.println("첫 번째 자리에 데이터 입력 : " + arrayDeque);
        arrayDeque.offerLast(40);
        System.out.println("마지막에 데이터 입력 : " + arrayDeque);

        arrayDeque.pollFirst();
        System.out.println("첫 번째 데이터 제외 : " + arrayDeque);
        arrayDeque.pollLast();
        System.out.println("마지막 데이터 제외 : " + arrayDeque);
        arrayDeque.pollFirst();
        System.out.println("첫 번째 데이터 제외 : " + arrayDeque);
        arrayDeque.pollLast();
        System.out.println("마지막 데이터 제외 : " + arrayDeque);
    }
}

class Student implements Comparable<Student> {
    String name; // 학생 이름
    int priority; // 우선순위 값

    public Student(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Student user) {
        // Student의 priority 필드값을 비교하여 우선순위를 결정하여 정렬
        return Integer.compare(this.priority, user.priority);
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", priority=" + priority +
            '}';
    }
}

class PriorityQueueClass {
    public void priorityQueueExample() {
        Queue<Student> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Student("jpa", 5));
        priorityQueue.add(new Student("querydsl", 7));
        priorityQueue.add(new Student("java", 1));
        priorityQueue.add(new Student("spring", 3));

        // 우선순위 대로 정렬되어 있음
        System.out.println("PriorityQueue : " + priorityQueue);

        // 우선순위가 가장 높은 값을 참조
        System.out.println("우선 순위 첫 번째 : " + priorityQueue.peek());

        // 차례대로 꺼내기
        int index = 1;
        for (Student student : priorityQueue) {
            System.out.println("우선 순위 " + (index++) + " 번째 : " + student);
        }
    }
}

class StackClass {
    public void stackExample() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        System.out.println("for문으로 첫번째 원소부터 가져올 때");

        for (Integer value : stack) {
            System.out.println("stack의 " + value + "번째 원소" + value);
        }

        System.out.println("\n" + "pop으로 가져올 때 -> 마지막 값부터 조회");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class VectorClass {
    public void vectorExample() {
        List<Integer> vector = new Vector<>();

        for (int i = 1; i <= 5; i++) {
            vector.add(i);
            System.out.println("vector.get(" + (i-1) + ") : " + vector.get(i-1));
        }

        System.out.println("vectorExample : " + vector);
    }
}

class LinkedListClass {
    public void linkedListExample() {
        List<String> linkedList = new LinkedList<>();

        linkedList.add("Hello");
        linkedList.add("LinkedList");

        System.out.println("LinkedListExample : " + linkedList);
        System.out.println("linkedList.get(0) : " + linkedList.get(0));
        System.out.println("linkedList.get(1) : " + linkedList.get(1));
    }
}

class ArrayListClass {
    public void arrayListExample() {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("hello");
        arrayList.add(" ArrayList");

        System.out.println("arrayListExample : " + arrayList);
        System.out.println("arrayList.get(0) : " + arrayList.get(0));
        System.out.println("arrayList.get(1) : " + arrayList.get(1));
    }
}

class CollectionInterface {
    public void collectionExample() {
        Collection<Number> collection = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            collection.add(i);
        }
        System.out.println("CollectionInterface: " + collection);
    }
}
