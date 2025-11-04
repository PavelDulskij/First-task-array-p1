package by.dulskij.taskarray.entity;

public class CustomArrayParameters {
    private int minValue;
    private int maxValue;
    private double avgValue;
    private int arraySum;


    public CustomArrayParameters(int minValue, int maxValue,
                                 double avgValue, int arraySum) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.avgValue = avgValue;
        this.arraySum = arraySum;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public double getAvgValue() {
        return avgValue;
    }

    public int getArraySum() {
        return arraySum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CustomArrayParameters that = (CustomArrayParameters) o;
        return minValue == that.minValue &&
                maxValue == that.maxValue &&
                Double.compare(avgValue, that.avgValue) == 0 &&
                arraySum == that.arraySum;
    }

    @Override
    public int hashCode() {
        int result = minValue;
        result = 31 * result + maxValue;
        result = 31 * result + Double.hashCode(avgValue);
        result = 31 * result + arraySum;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArrayParameters{");
        sb.append("minValue=").append(minValue);
        sb.append(", maxValue=").append(maxValue);
        sb.append(", avgValue=").append(avgValue);
        sb.append(", arraySum=").append(arraySum);
        sb.append('}');
        return sb.toString();
    }
}
