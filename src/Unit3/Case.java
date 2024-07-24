package Unit3;

abstract class Case {
    public boolean settlement;
    public int lawyersOnCase;

    public boolean isSettlementOrTrial() {
        return settlement;
    }

    public void setSettlement(boolean settlement) {
        this.settlement = settlement;
    }

    public int getLawyersOnCase() {
        return lawyersOnCase;
    }

    public void setLawyersOnCase(int lawyersOnCase) {
        this.lawyersOnCase = lawyersOnCase;
    }

    public Case() {
        settlement = false;
        lawyersOnCase = 0;
    }

    public Case(boolean settlement, int lawyersOnCase) {
        this.settlement = settlement;
        this.lawyersOnCase = lawyersOnCase;
    }

    public abstract String outputService();
}