package utils;

public class AssurancePremium implements StrategyFacturation {

    @Override
    public double appliquerReduction(double montant) {
        return montant * 0.5; // 50% réduction
    }
}
