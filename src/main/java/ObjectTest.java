import java.lang.annotation.Retention;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Objects;
import jdk.jshell.Snippet.Status;

public class ObjectTest {
  // toString()
  public static void main(String[] args) {
    ObjectTest objectTest = new ObjectTest();

    objectTest.toStringRun();
    objectTest.toStringOverriding();
    objectTest.equalsRun();
  }

  private void toStringRun() {
    String myName = "namji";
    System.out.println("myName = " + myName);
    // 컴파일 경고 발생
    // this object (which is already a string!) is itself returned.
    System.out.println("myName = " + myName.toString());
    /**
     * 출력 :
     * myName = namji
     * myName = namji
     */

    int[] intArr = new int[]{1,2,3,4,5};
    System.out.println("intArr = " + intArr);
    System.out.println("intArr = " + Arrays.toString(intArr));
    /**
     * 출력 :
     * intArr = [I@23fc625e
     * intArr = [1, 2, 3, 4, 5]
     */
  }

  private void toStringOverriding() {
    // onlineClass 객체 생성
    OnlineClass onlineClass1 = new OnlineClass(1, "SpringBoot", true);
    OnlineClass onlineClass2 = new OnlineClass(2, "SpringFrameWork", true);

    // class toString 메서드 호출
    // .toString() 하지 않아도 println 메서드가 String으로 변환하여 출력하기 때문에 결과는 동일합니다.
    System.out.println("onlineClass1.toString() = " + onlineClass1.toString());
    System.out.println("onlineClass1 = " + onlineClass1);
    System.out.println("onlineClass2 = " + onlineClass2);

    /**
     * 출력1 : 기본 toString()
     * onlineClass1.toString() = ObjectTest$OnlineClass@4f023edb
     * onlineClass1 = ObjectTest$OnlineClass@4f023edb
     * onlineClass2 = ObjectTest$OnlineClass@3a71f4dd
     *
     * 출력2 : 사용자 재정으 toString()
     * onlineClass1.toString() = OnlineClass{id=1, title='SpringBoot', cloesd=true}
     * onlineClass1 = OnlineClass{id=1, title='SpringBoot', cloesd=true}
     * onlineClass2 = OnlineClass{id=2, title='SpringFrameWork', cloesd=true}
     *
     * 출력3 : Lombok 제공 toStirng()
     * onlineClass1 = ObjectTests.OnlineClass(id=1, title=spring boot, closed=true)
     * onlineClass1 = ObjectTests.OnlineClass(id=1, title=spring boot, closed=true)
     * onlineClass2 = ObjectTests.OnlineClass(id=2, title=spring data jpa, closed=true)
     */
  }

  static class OnlineClass {
    // Getter
    public int getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public boolean isCloesd() {
      return cloesd;
    }

    // Setter
    public void setId(int id) {
      this.id = id;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public void setCloesd(boolean cloesd) {
      this.cloesd = cloesd;
    }

    // 생성자
    public OnlineClass(int id, String title, boolean cloesd) {
      this.id = id;
      this.title = title;
      this.cloesd = cloesd;
    }

    // toString
    @Override
    public String toString() {
      return "OnlineClass{" +
          "id=" + id +
          ", title='" + title + '\'' +
          ", cloesd=" + cloesd +
          '}';
    }

    private int id;
    private String title;
    private boolean cloesd;
  }

  private void equalsRun() {
    Member member1 = new Member("namji");
    Member member2 = new Member("namji");

    System.out.println("member1 = " + member1);
    System.out.println("member2 = " + member2);
    System.out.println("member1 == member2 = " + (member1 == member2));
    System.out.println("member1.equals(member2) = " + member1.equals(member2));

    /**
     * 출력1 : 기본 equals()
     * member1 = com.study.java8.object.ObjectTests$Member@71f4dd@name: namji
     * member2 = com.study.java8.object.ObjectTests$Member@df9f5f@name: namji
     * false
     * false
     *
     * member1 = com.study.java8.object.ObjectTests$Member@71f4dd@name: namji
     * member2 = com.study.java8.object.ObjectTests$Member@df9f5f@name: namji
     * false
     * true
      */

  }

  static class Member {

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }

    public Member(String name) {
      this.name = name;
    }


    private String name;

    @Override
    public boolean equals (Object object) {
      // 1. equals의 인자가 자기 자신인지 확인
      if (this == object) return true;
      // 2. equals의 인자가 null인지 확인
      if (object == null) return false;
      // 3. instanceof 연산자로 인자의 자료형이 정확한지 확인
      if (!(object instanceof Member)) return false;

      Member m = (Member) object;
      // 4. 값이 null일 경우도 고려하여 리턴
      return (name == null ? m.getName() == null : name.equals(m.getName()));
    }

    @Override
    public String toString() {
      return super.toString() + "@name = " + name;
    }
  }
}
