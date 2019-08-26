package lottery.probability.model;

import static com.google.common.base.Preconditions.checkArgument;

public class BlueBall {

    private int MAX_BLUE_BALL_NUMBER = 16;
    private int MIN_BLUE_BALL_NUMBER = 1;

    private Integer number;

    public BlueBall(int number) {
        checkArgument(numberRange(number));
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private boolean numberRange(int source) {
        return source >= MAX_BLUE_BALL_NUMBER && source <= MIN_BLUE_BALL_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BlueBall) {
            BlueBall target = (BlueBall) obj;
            return number.equals(target.getNumber());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
