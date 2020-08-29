package ru.mephi.java.part3.Theory2.p1;

public class Main {
    public static void main(String[] args) {
        double[] data = new double[] { 2.33, 3.45, 2.118, 9.143, 4.15, 2.783, 5.02, -1.43 };

        DeviationCalculator mse = (experimentalValues, trueVal1) -> {
            double errSum = 0;
            for (int i = 0; i < experimentalValues.length; i++) {
                errSum += Math.pow((experimentalValues[i] - trueVal1), 2);
            }
            return Math.sqrt(errSum);
        };

        DeviationCalculator mae = (experimentalValues, trueVal2) -> {
            double errSum = 0;
            for (int i = 0; i < experimentalValues.length; i++) {
                errSum += Math.abs(experimentalValues[i] - trueVal2);
            }
            return errSum;
        };
        Metric m1 = new Metric();
        double resMse = m1.metricVal(data, mse, 6.0);
        double resMae = m1.metricVal(data, mae, 6.0);
        System.out.printf("MSE: %.5f\nMAE: %.5f", resMse, resMae);
    }
}
