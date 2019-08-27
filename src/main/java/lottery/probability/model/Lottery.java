package lottery.probability.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;

public class Lottery {

    private Double MAX_COMBINATION = 17721088D;
    private Double firstRewardRate = 1D / MAX_COMBINATION;
    private Double secondRewardRate = 15D / MAX_COMBINATION;
    private Double thirdRewardRate = 162D / MAX_COMBINATION;
    private Double fourthRewardRate = 7695D / MAX_COMBINATION;
    private Double fifthRewardRate = 137475D / MAX_COMBINATION;
    private Double sixthRewardRate = 1043640D / MAX_COMBINATION;

    private Set<Combination> combinations;

    public Lottery(Set<Combination> combinations) {
        this.combinations = combinations;
    }

    public void winRate() {
        DecimalFormat df = new DecimalFormat("0.00000000‱");
        int totalCombination = combinations.size();
        BigDecimal firstReward = new BigDecimal(totalCombination * firstRewardRate);
        BigDecimal secondReward = new BigDecimal(totalCombination * secondRewardRate);
        BigDecimal thirdReward = new BigDecimal(totalCombination * thirdRewardRate);
        BigDecimal fourthReward = new BigDecimal(totalCombination * fourthRewardRate);
        BigDecimal fifthReward = new BigDecimal(totalCombination * fifthRewardRate);
        BigDecimal sixthReward = new BigDecimal(totalCombination * sixthRewardRate);
        BigDecimal totalReward = firstReward.add(secondReward).add(thirdReward).add(fourthReward).add(fifthReward).add(sixthReward);
        StringBuilder sb = new StringBuilder();
        sb.append("您的彩票综合中奖率为：").append(df.format(totalReward)).append(";\n\r")
                .append("您中一等奖的概率为：").append(df.format(firstReward)).append(";\n\r")
                .append("您中二等奖的概率为：").append(df.format(secondReward)).append(";\n\r")
                .append("您中三等奖的概率为：").append(df.format(thirdReward)).append(";\n\r")
                .append("您中四等奖的概率为：").append(df.format(fourthReward)).append(";\n\r")
                .append("您中五等奖的概率为：").append(df.format(fifthReward)).append(";\n\r")
                .append("您中六等奖的概率为：").append(df.format(sixthReward)).append(";\n\r");
        System.out.println(sb);
    }
}
