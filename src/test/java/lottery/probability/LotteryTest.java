/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lottery.probability;

import lottery.probability.model.BlueBall;
import lottery.probability.model.Combination;
import lottery.probability.model.Lottery;
import lottery.probability.model.RedBall;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class LotteryTest {

    @Test
    public void testLottery() {
        Set<Combination> combinations = generateCombination(100);
        Lottery lottery = new Lottery(combinations);
        lottery.winRate();
    }

    private Set<Combination> generateCombination(int count) {
        Set<Combination> lotteryCombination = new HashSet<>();
        Random random = new Random();
        IntStream.rangeClosed(1, count).forEach(each -> {
            Combination.Builder builder = new Combination.Builder();
            IntStream.rangeClosed(1, 6).forEach(redBallLoop -> {
                RedBall redBall = new RedBall(random.nextInt(33) + 1);
                builder.addRedBall(redBall);
            });
            BlueBall blueBall = new BlueBall(random.nextInt(16) + 1);
            Combination combination = builder.blueBall(blueBall).build();
            lotteryCombination.add(combination);
        });
        return lotteryCombination;
    }

}
