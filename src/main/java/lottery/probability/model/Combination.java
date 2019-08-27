package lottery.probability.model;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class Combination {

    private final Set<RedBall> redBalls;
    private final BlueBall blueBall;

    private Combination(Builder builder) {
        redBalls = builder.redBalls;
        blueBall = builder.blueBall;
    }

    public static class Builder {

        private int MAX_REDBALL_COUNT = 6;

        private Set<RedBall> redBalls = new HashSet<>(9);
        private BlueBall blueBall;

        public Builder() {
        }

        public Builder addRedBall(RedBall redBall) {
            checkArgument(underRedBallRange(), "红球个数已经达到最大");
            redBalls.add(redBall);
            return this;
        }

        public Builder blueBall(BlueBall blueBall) {
            this.blueBall = blueBall;
            return this;
        }

        public Combination build() {
            return new Combination(this);
        }

        private boolean underRedBallRange() {
            return redBalls.size() <= MAX_REDBALL_COUNT;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Combination) {
            Combination target = (Combination) obj;
            return target.redBalls.equals(redBalls) && target.blueBall.equals(blueBall);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return redBalls.hashCode() + blueBall.hashCode();
    }
}
