package calculator.operator;

public class MultiplyOperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return a * b;
    }
}
