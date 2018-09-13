package ͳ�ƴ�Ƶ;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountTest {

	public static void main(String[] args) {
		// ����һ���ַ��������Լ���¼�룩
		Scanner input = new Scanner(System.in);
		System.out.println("�������ַ�����");
		String line = input.nextLine();

		/**
		 * ����һ��TreeMap���� ����Character ֵ��Integer
		 */
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		// ���ַ���ת��Ϊ�ַ�����
		char[] chs = line.toCharArray();

		// �����ַ����飬�õ�ÿһ���ַ�
		for (Character ch : chs) {
			Integer i = map.get(ch);

			/**
			 * �ѵõ����ַ���Ϊ������������ֵ��������ֵ ��null��˵���������ڣ��Ͱ��ַ���������1��Ϊֵ����
			 * ��null��˵�������ڣ��Ͱ�ֵ��1��Ȼ����д����ü���ֵ
			 */
			if (i == null) {
				map.put(ch, 1);
			} else {
				i++;
				map.put(ch, i);
			}
		}

		// �����ַ�������������
		StringBuilder sb = new StringBuilder();

		// �������ϣ��õ�����ֵ�����а���Ҫ��ƴ��
		Set<Character> set = map.keySet();
		for (Character key : set) {
			Integer value = map.get(key);

			sb.append(key).append("(").append(value).append(")");
		}
		// ���ַ�����������Ϊ�ַ������
		String result = sb.toString();
		System.out.println("result:" + result);

		input.close();
	}
}
