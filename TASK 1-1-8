public class CumulativeSum {

    public static void main(String[] args) {
        int[] values = {4, 5, 10};
        calculateCumulativeSum(values);
    }

    public static void calculateCumulativeSum(int... numbers) {
        int cumulativeSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            cumulativeSum += numbers[i];

            System.out.printf("Total for parameter %d: %d = ", i + 1, cumulativeSum);

            for (int j = 1; j <= numbers[i]; j++) {
                System.out.print(j);
                if (j < numbers[i]) {
                    System.out.print("+");
                }
            }

            System.out.println();
        }
    }
}
