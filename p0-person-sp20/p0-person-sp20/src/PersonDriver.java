
public class PersonDriver {
	public static void main(String[] args) {
		Person p = new Person();
		Person q = new Person("Sam",21);

		System.out.println(p.getName());
		System.out.println(q.getName());
		System.out.println(p.getAge());
		System.out.println(q.getAge());
		System.out.println(p);
		System.out.println(q);
	}
}
