package 统计词频;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountTest {

	public static void main(String[] args) {
		// 定义一个字符串（可以键盘录入）
		Scanner input = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String line = input.nextLine();

		/**
		 * 定义一个TreeMap集合 健：Character 值：Integer
		 */
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		// 把字符串转换为字符数组
		char[] chs = line.toCharArray();

		// 遍历字符数组，得到每一个字符
		for (Character ch : chs) {
			Integer i = map.get(ch);

			/**
			 * 把得到的字符作为键到集合中找值，看返回值 是null：说明键不存在，就把字符当作键，1作为值储存
			 * 非null：说明键存在，就把值加1，然后重写储存该键和值
			 */
			if (i == null) {
				map.put(ch, 1);
			} else {
				i++;
				map.put(ch, i);
			}
		}

		// 定义字符串缓冲区变量
		StringBuilder sb = new StringBuilder();

		// 遍历集合，得到键和值，进行按照要求拼接
		Set<Character> set = map.keySet();
		for (Character key : set) {
			Integer value = map.get(key);

			sb.append(key).append("(").append(value).append(")");
		}
		// 把字符串缓冲区作为字符串输出
		String result = sb.toString();
		System.out.println("result:" + result);

		input.close();
	}
}
