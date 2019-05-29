package _1_基础.RezingArrayQueueOfStrings;


// 使用可以调整大小的数组实现队列
public class RezingArrayQueueOfStrings {

	private String[] strings;
	private int N; // 记载实际的元素数量，而不是数组的长度
	private int qHead = 0; // 第一个元素的位置

	public RezingArrayQueueOfStrings(int cap) {
		strings = new String[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int newLength) {
		String[] tempStr = new String[newLength];
		for (int i = 0; i < N; i++) {
			tempStr[i] = strings[i + qHead];
		}
		qHead = 0; // 每次resize
		strings = tempStr;
	}

	public void enqueue(String s) {
		if (N == strings.length) resize(N * 2);
		strings[N++ + qHead] = s;
	}

	public String dequeue() {
		String res = strings[qHead++];
		N--;
		if (N <= strings.length / 4) resize(N * 2);
		return res;
	}

	public static void main(String[] args) {
		RezingArrayQueueOfStrings rezingArrayQueueOfStrings = new RezingArrayQueueOfStrings(2);
		rezingArrayQueueOfStrings.enqueue("1");
		rezingArrayQueueOfStrings.enqueue("2");
		rezingArrayQueueOfStrings.enqueue("3");
		rezingArrayQueueOfStrings.enqueue("4");
		rezingArrayQueueOfStrings.enqueue("5");
		rezingArrayQueueOfStrings.enqueue("6");
		rezingArrayQueueOfStrings.enqueue("7");
		rezingArrayQueueOfStrings.enqueue("8");
		rezingArrayQueueOfStrings.enqueue("9");
		while (!rezingArrayQueueOfStrings.isEmpty()) {
			System.out.println(rezingArrayQueueOfStrings.dequeue());
		}
	}
}
