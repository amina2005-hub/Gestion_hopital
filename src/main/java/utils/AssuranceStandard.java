package utils;

public class AssuranceStandard implements StrategyFacturation {

    @Override
    public double appliquerReduction(double montant) {
        return montant * 0.8; // 20% réduction
    }
}
