
public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int length = gas.length;
		int tank = 0;
		int index = 0;
		int total = 0;
		for (int i = 0; i < length; i++) {
			int cur = gas[i] - cost[i];
			tank += cur;
			if (tank < 0) {
				index = i + 1;
				tank = 0;
			}	
			total += cur;
		}
		return total >= 0 ? index : -1;
	}
	public static void main(String[] args) {
		int[] gas = {5, 1, 3};
		int[] cost = {4, 3, 2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
