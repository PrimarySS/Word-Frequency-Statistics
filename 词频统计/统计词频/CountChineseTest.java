package 统计词频;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class CountChineseTest {

	private static HashMap<String, Integer> hmap; // 局部定义存储空间

	public static void main(String[] args) throws IOException {

		// 开始时间
		long startime = System.currentTimeMillis();

		// 输入需要统计的文本
		EncapsulatedInterface("中文.txt");

		// 调用接口输出搜索结果
		System.out.println("\n搜索一个词组：例中文“我国”的出现的次数: " + OutputInterface("国", "家"));

		// 结束时间
		long endtime = System.currentTimeMillis();

		System.out.printf("程序执行时间：%.6f s", ((float) endtime - (float) startime) / (float) 1000);

	}

	/**
	 * 功能：数据封装
	 * 
	 * @param str
	 *            所需封装的文本
	 * @throws IOException
	 *             异常处理
	 */
	public static void EncapsulatedInterface(String str) throws IOException {
		// 缓冲读取文件
		BufferedReader tx = new BufferedReader(new FileReader("C:\\Users\\10157\\Desktop\\暂记文本\\" + str));

		// 存储文章
		String article = null;

		// 存储每个单词
		String[] word = null;

		// 初始化集合存储空间
		hmap = new HashMap<String, Integer>();

		// 读取文件流,存储单词
		try {
			while ((article = tx.readLine()) != null) {
				// 分割字符串
				word = article.split("");

				// 遍历数组
				for (String s : word) {
					// 用单词来做键值，通过单词搜索存在的次数
					Integer wordCount = hmap.get(s);

					// 如果单词已经存在hmap集合中则在原基础上“出现值”+1，否则直接为1
					hmap.put(s, wordCount == null ? 1 : wordCount + 1);
				}
			}
		} catch (Exception e) {
			System.out.println("数据封装失败！！！");
		} finally {
			// 关闭资源
			tx.close();
		}
	}

	/**
	 * 功能：搜索数据封装的集合
	 * 
	 * @param str1
	 *            搜索关键字
	 * @param str2
	 *            搜索关键字
	 * @return 返回关键字出现次数
	 */
	public static int OutputInterface(String str1, String str2) {
		// 创建缓冲流
		StringBuffer sb = new StringBuffer();

		// 创建set对象
		Set<String> set = hmap.keySet();

		// 遍历键值，获得所有键值
		for (String key : set) {

			// 根据key获得value
			Integer value = hmap.get(key);

			// 格式化输出格式
			sb.append(key).append(" : ").append(value).append("\n");
		}

		// 格式化输出格式
		// String result = sb.toString();

		// 输出缓存的结果
		// System.out.println(result);

		int appear = 0; // 存储词组出现次数

		try {
			// 输出出现的中文词组
			int count1 = hmap.get(str1);
			int count2 = hmap.get(str2);

			Exception e = null;
			if (count1 == 0 || count2 == 0) {
				throw e; // 抛出异常
			} else {
				// 统计词组出现次数
				while (count1 > 0 && count2 > 0) {
					appear++;
					count1--;
					count2--;
				}
			}
		} catch (Exception e) {
			// 异常处理
			System.out.println("词组的出现次数为0！！！");
		}

		return appear;
	}

}
