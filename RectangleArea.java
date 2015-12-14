
public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        return areaA + areaB - commonArea(A, B, C, D, E, F, G, H);
    }
	public static int commonArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int hx = Math.min(C, G);
		int hy = Math.max(A, E);
		int wx = Math.min(D, H);
		int wy = Math.max(B, F);
		if (hx < hy || wx < wy) {
			return 0;
		} else {
			return (hx - hy) * (wx - wy);
		}
	}
	public static void main(String[] args) {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}
}
