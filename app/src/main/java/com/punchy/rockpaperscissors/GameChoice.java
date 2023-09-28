package com.punchy.rockpaperscissors;

public enum GameChoice {
    ROCK, PAPER, SCISSORS;

    public static GameOutcome calculateGameOutcome(GameChoice playerChoice, GameChoice computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return GameOutcome.TIE;
        } else if (playerWinningConditions(playerChoice, computerChoice)) {
            return GameOutcome.WON;
        } else {
            return GameOutcome.LOST;
        }
    }

    private static boolean playerWinningConditions(GameChoice playerChoice, GameChoice computerChoice) {
        return (playerChoice.equals(ROCK) && computerChoice.equals(SCISSORS)) ||
                (playerChoice.equals(SCISSORS) && computerChoice.equals(PAPER)) ||
                (playerChoice.equals(PAPER) && computerChoice.equals(ROCK));
    }
}
