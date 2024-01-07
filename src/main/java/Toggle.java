
public class Toggle {

	public static int toggle(int i) {

		return i ^ 1;
	}

	public static void main(String[] args) {
		System.out.println(Toggle.toggle(1));
		System.out.println(Toggle.toggle(0));

//		System.out.println(1 + 1 + 1 + 1 + 1 == 5);
	}
}
