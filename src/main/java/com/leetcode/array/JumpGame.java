package com.leetcode.array;

import java.util.PriorityQueue;

public class JumpGame {

	public int maxResult(int[] nums, int k) {

		int len = nums.length;

		if (len == 0) {
			return 0;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		int max = nums[0];

		pq.offer(new int[] { 0, nums[0] });

		for (int i = 1; i < len; i++) {

			while (i - pq.peek()[0] > k) {
				pq.poll();
			}

			max = nums[i] + pq.peek()[1];
			pq.offer(new int[] { i, max });
		}

		return max;
	}

	private void execute() {
		System.out.println(maxResult(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
		System.out.println(maxResult(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
		System.out.println(maxResult(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));
		System.out.println(maxResult(new int[] { -5582, -5317, 6711, -639, 1001, 1845, 1728, -4575, -6066, -7770, 128,
				-3254, 7281, 3966, 6857, 5477, 8968, -1771, 9986, -6267, 9010, -764, 8413, -8154, 1087, -1107, 4183,
				3033, 58, 659, 4625, 2825, 5031, 6811, 5657, 3229, 8597, -5772, 8869, 5723, 2960, 4040, 7222, 4841,
				-1014, 581, -2830, 3881, -3800, 577, -7396, -611, -6944, 8461, 3294, 6297, 9713, -2246, -3441, 3831,
				-5754, 6716, 6040, -6715, 5763, 8611, 5412, -7630, 6216, 260, 2595, 6852, -8956, 2101, 6722, 1579, 3820,
				7827, -3369, 7144, 1974, 7310, -5369, -6755, 3010, 5789, 1563, -3330, 5373, -2770, 4503, -4065, 8177,
				-3333, -4726, -2131, 2763, 9012, -4755, 2382, 3642, -5284, -7174, -9815, 6392, 9729, -1943, -8749, 5343,
				1036, 8508, 1484, 919, 4225, 3733, 8036, -6346, -2088, 475, 9378, 4271, -5906, 9327, 9399, -1582, 3845,
				3499, -8912, -4671, -1143, -5081, -1621, -1287, 5995, 4963, 5071, 5118, -1966, -6249, 663, -2296, -8148,
				-4668, -6919, 334, -6609, 2888, -4161, 118, -1867, 5629, 8588, -5325, -7853, -4868, -1487, -6544, -9697,
				-7038, 6422, -5545, 3376, -8656, 8800, -7698, -2928, 2279, -9739, 4198, 6236, -9087, 9010, -9894, 2145,
				7353, -92, 3205, 5431, 5913, 1619, -250, 4728, -7164, -5619, -4721, -9284, -9645, 146, 7131, -6501,
				4261, 2016, 2880, 4944, -8768, -6339, -3574, 539, 4633, 9188, 7227, -1549, 9271, 7110, 5706, 4968,
				-1275, 5545, -5844, -1985, 9560, 1560, 4630, 3169, 6076, -9433, 7007, 9927, -8385, -4557, -114, 9543,
				2884, 8978, -6447, 3664, -7499, -4643, -5993, -5321, 3250, -2945, 6216, -1606, 5569, 7326, -6027, 9723,
				-6997, -543, -8298, -4647, 2563, 1493, 9574, 1087, -9433, -7749, -7159, -2682, 6626, 2787, -2845, -7907,
				-223, -8142, -5403, -3460, -2534, 5289, 999, 9404, -1958, 641, 4669, -2892, -2921, -7001, -1403, -2353,
				-7976, -5885, 4958, -8117, 8785, -654, 5918, 5533, 8704, 5827, -7478, -3696, 2640, 1612, -500, 5694,
				-1973, 5308, 5272, 3358, 9190, 4648, -7836, 658, -3407, 6733, 1061, -2010, -2707, -1920, 1272, 3944,
				-6537, -6090, -7429, -640, 836, 1904, -4031, 814, -1886, 8040, -8312, -9407, -1395, -9944, -2074, -6814,
				2672, 1360, 8990, 5465, -2131, 3838, 799, -3472, 1086, -583, 6302, 3032, 9138, -7778, 4538, -5337, 2087,
				2870, -3005, 3401, 122, -819, -8074, 9630, -698, 5326, 2650, -9355, 6487, 3801, -3209, 8293, 662, -8318,
				-7863, -3814, -2557, -5685, -7952, 6224, -7010, 2935, 5557, -1287, 9528, -9218, -5108, -2085, 17, 4870,
				-8686, -8854, -9657, 8848, -1883, -4535, 83, 9711, 4593, -3440, -6938, 3407, -6894, -6213, -883, 4552,
				-731, 1485, -7740, -3300, 3897, -7629, -4076, 7589, 3142, -1010, 2466, -592, -391, 3961, -7049, 7654,
				5758, 6983, 6048, -4369, -5878, 3756, 2940, 9149, 8625, 8937, 5706, 6658, 9213, -5226, 284, -4524,
				-1577, -5296, 6423, 9977, -1805, 5462, 7587, 476, -6424, 976, -3925, 8819, 1821, 3603, -842, -9618,
				-7130, -6253, 2562, -7596, 3522, 6282, -3801, -3896, 6924, 441, 5944, 8535, 1253, -6154, 6872, -9548,
				-5358, 1604, 9593, -9256, -701, 1023, -1446, -1307, -6809, 9542, 3673, 1813, 8717, -6847, -5289, 5222,
				-7266, 4231, 218, -9633, -4696, 5494, 9681, 1173, -4606, 2174, -1155, -8595, -3640, -6550, -7003, 4244,
				-2543, 5241, 2831, 2690, 8950, -6609, -9724, 7562, -4096, 8878, 9962, 7179, -1170, 7826, -146, -2759,
				-5249, 253, 6206, 3205, -7708, 9448, 4622, 9260, -2853, 2486, 122, -8880, -769, -8922, 648, 7358, -6503,
				-6382, -4260, 3988, -5107, -6363, 2415, 8563, -9070, -5026, 2078, -2558, -2027, -7489, -4978, 5024,
				4155, -9737, -221, 9930, -9472, 1052, -268, 6221, 2726, -1310, -8708, 3482, -5488, -6506, 5389, -7048,
				553, -886, 2752, 85, -3938, 5940, -5112, 5855, -7295, 3735, 2657, 3269, 6231, 4771, 3229, -2009, -5748,
				7256, 746, -4301, 752, -241, -6151, -2390, 9911, 825, -7679, -4960, -7224, -2739, -566, -5770, 6774,
				6243, 3166, -783, -4303, -9016, 5555, -1866, -536, 8872, -3927, 4269, -3807, 1933, 9972, 981, 9256,
				6857, -208, 3645, -3725, 5961, 1105, 6320, -4702, -8419, -4904, -4935, 8378, -2994, 5831, 5296, 4730,
				-9170, -4229, -3911, -160, 8757, -5301, -3775, 1121, 9434, -9880, 2689, 2340, -7879, 3667, -5219, -6116,
				-1670, 7595, 6900, 3990, 4444, 6385, -2924, 8968, -2673, -6182, 7503, 5209, 6030, 802, -3464, 1922,
				-8187, 1617, 4769, -4866, -3518, 5830, 3862, -7512, 5236, -5164, 6324, -5107, 6864, -7364, -1375, 5762,
				-275, 4975, -7448, 5719, -3162, -1546, -2776, -9411, -1845, -4913, -3474, 2550, 5643, -5527, 2946, 7158,
				1938, 5125, -8015, 2475, -1461, -4900, -5151, -4031, 9362, 8571, 9815, -8438, -6519, 1980, -8031, 9615,
				7079, -3573, -883, 4217, 1079, 5918, 1767, 8670, -5651, -6625, 1057, 7897, -7104, -4186, 851, -6333,
				-4108, -3250, 7899, 9628, -6904, -3939, 4587, 1227, 3813, -7449, -7692, -8098, -9813, 8862, -2888,
				-1048, -3564, 3074, 1437, -2291, 3974, 3164, 4921, -8958, 9007, -3938, 2042, 7454, -910, -998, -4450,
				-1103, -237, 8182, -1391, -4255, -3482, -2918, 4053, 2280, -7403, 4319, -9457, 7157, -6315, -7533, 6309,
				2211, -9145, 443, 4255, -8847, -5557, -9089, 1752, -5784, -2399, -8296, -8400, 8170, 4628, -4583, 937,
				-7067, -3503, -549, -1194, 1576, 5004, -6963, -8837, 5567, 870, 3954, 5489, -8949, -7673, 8542, -9040,
				-7689, -4171, -889, 5552, -6836, -4393, 513, 3177, 6664, -5646, 2492, 9421, -342, 2570, 8816, 2869,
				-6820, -3389, -1903, -3332, 138, 6618, 293, -9130, 3503, -2327, -9728, 7632, 5881, 540, 9678, -7629,
				8804, -2816, 7205, 7473, -5518, 7311, 3457, 9066, -1224, 2097, 7857, 6612, 186, 6759, -4516, -3491,
				-8268, -8928, -7412, 7162, 6274, 5463, 2157, -4131, -7061, -8476, -5584, 7300, -4348, -5940, -8592,
				-302, -5817, 3151, -4124, 1694, -5114, -3252, -2319, -2157, -293, 7724, -5673, 6105, 9535, 4333, 6353,
				1290, 8710, -5035, 8995, -5865, 9746, 4708, -6387, -8937, 3096, -9716, -7124, 2531, -660, -4619, -8035,
				3747, -7821, 8793, -727, 8242, 4957, -7175, 4064, -9911, 4995, 9725, 1634, -4275, 788, -4920, 3831,
				-3525, -4467, 2909, -1200, 5377, -4905, -3077, -1763, 4443, -3518, 3134, -5595, 5409, 5943, 6757, 3485,
				2883, -9261, -7221, 654, 2001, -926, 7840, -5568, 2715, -7053, -2082, -2005, 7607, -9511, 7545, 7564,
				2380, -7257, 1449, -3918, -3240, -1928, -6555, -4784, 1550, 2745, -5316 }, 56));
	}

	public static void main(String[] args) {
		new JumpGame().execute();
	}
}
