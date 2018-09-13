package ͳ�ƴ�Ƶ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class CountChineseTest {

	private static HashMap<String, Integer> hmap; // �ֲ�����洢�ռ�

	public static void main(String[] args) throws IOException {

		// ��ʼʱ��
		long startime = System.currentTimeMillis();

		// ������Ҫͳ�Ƶ��ı�
		EncapsulatedInterface("����.txt");

		// ���ýӿ�����������
		System.out.println("\n����һ�����飺�����ġ��ҹ����ĳ��ֵĴ���: " + OutputInterface("��", "��"));

		// ����ʱ��
		long endtime = System.currentTimeMillis();

		System.out.printf("����ִ��ʱ�䣺%.6f s", ((float) endtime - (float) startime) / (float) 1000);

	}

	/**
	 * ���ܣ����ݷ�װ
	 * 
	 * @param str
	 *            �����װ���ı�
	 * @throws IOException
	 *             �쳣����
	 */
	public static void EncapsulatedInterface(String str) throws IOException {
		// �����ȡ�ļ�
		BufferedReader tx = new BufferedReader(new FileReader("C:\\Users\\10157\\Desktop\\�ݼ��ı�\\" + str));

		// �洢����
		String article = null;

		// �洢ÿ������
		String[] word = null;

		// ��ʼ�����ϴ洢�ռ�
		hmap = new HashMap<String, Integer>();

		// ��ȡ�ļ���,�洢����
		try {
			while ((article = tx.readLine()) != null) {
				// �ָ��ַ���
				word = article.split("");

				// ��������
				for (String s : word) {
					// �õ���������ֵ��ͨ�������������ڵĴ���
					Integer wordCount = hmap.get(s);

					// ��������Ѿ�����hmap����������ԭ�����ϡ�����ֵ��+1������ֱ��Ϊ1
					hmap.put(s, wordCount == null ? 1 : wordCount + 1);
				}
			}
		} catch (Exception e) {
			System.out.println("���ݷ�װʧ�ܣ�����");
		} finally {
			// �ر���Դ
			tx.close();
		}
	}

	/**
	 * ���ܣ��������ݷ�װ�ļ���
	 * 
	 * @param str1
	 *            �����ؼ���
	 * @param str2
	 *            �����ؼ���
	 * @return ���عؼ��ֳ��ִ���
	 */
	public static int OutputInterface(String str1, String str2) {
		// ����������
		StringBuffer sb = new StringBuffer();

		// ����set����
		Set<String> set = hmap.keySet();

		// ������ֵ��������м�ֵ
		for (String key : set) {

			// ����key���value
			Integer value = hmap.get(key);

			// ��ʽ�������ʽ
			sb.append(key).append(" : ").append(value).append("\n");
		}

		// ��ʽ�������ʽ
		// String result = sb.toString();

		// �������Ľ��
		// System.out.println(result);

		int appear = 0; // �洢������ִ���

		try {
			// ������ֵ����Ĵ���
			int count1 = hmap.get(str1);
			int count2 = hmap.get(str2);

			Exception e = null;
			if (count1 == 0 || count2 == 0) {
				throw e; // �׳��쳣
			} else {
				// ͳ�ƴ�����ִ���
				while (count1 > 0 && count2 > 0) {
					appear++;
					count1--;
					count2--;
				}
			}
		} catch (Exception e) {
			// �쳣����
			System.out.println("����ĳ��ִ���Ϊ0������");
		}

		return appear;
	}

}
