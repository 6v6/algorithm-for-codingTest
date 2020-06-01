package baekjoon.ch2;

import java.util.Scanner;

public class ¥ı«œ±‚123_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();

		for (int i = 0; i < length; i++) {
			int n = sc.nextInt();
			int result = 0;
			for (int l1 = 1; l1 <= 3; l1++) {
				if (l1 == n)
					result += 1;
				for (int l2 = 1; l2 <= 3; l2++) {
					if (l1 + l2 == n)
						result += 1;
					for (int l3 = 1; l3 <= 3; l3++) {
						if (l1 + l2 + l3 == n)
							result += 1;
						for (int l4 = 1; l4 <= 3; l4++) {
							if (l1 + l2 + l3 + l4 == n)
								result += 1;
							for (int l5 = 1; l5 <= 3; l5++) {
								if (l1 + l2 + l3 + l4 + l5 == n)
									result += 1;
								for (int l6 = 1; l6 <= 3; l6++) {
									if (l1 + l2 + l3 + l4 + l5 + l6 == n)
										result += 1;
									for (int l7 = 1; l7 <= 3; l7++) {
										if (l1 + l2 + l3 + l4 + l5 + l6 + l7 == n)
											result += 1;
										for (int l8 = 1; l8 <= 3; l8++) {
											if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 == n)
												result += 1;
											for (int l9 = 1; l9 <= 3; l9++) {
												if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 == n)
													result += 1;
												for (int l10 = 1; l10 <= 3; l10++) {
													if (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 == n)
														result += 1;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
