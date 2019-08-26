package lottery.probability.model;

import static com.google.common.base.Preconditions.checkArgument;

public class RedBall {

    private int MAX_RED_BALL_NUMBER = 33;
    private int MIN_RED_BALL_NUMBER = 1;

    private Integer number;

    public RedBall(int number) {
        checkArgument(numberRange(number));
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private boolean numberRange(int source) {
        return source >= MAX_RED_BALL_NUMBER && source <= MIN_RED_BALL_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RedBall) {
            RedBall target = (RedBall) obj;
            return number.equals(target.getNumber());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
