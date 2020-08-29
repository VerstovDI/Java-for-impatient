package ru.mephi.java.part3.Theory2.p1;


public class Metric {
    public double metricVal(double[] experimentalValues, DeviationCalculator calcDeviation, double trueValue) {
        double errSum = calcDeviation.error(experimentalValues, trueValue);
        return errSum/experimentalValues.length;
    }
}
