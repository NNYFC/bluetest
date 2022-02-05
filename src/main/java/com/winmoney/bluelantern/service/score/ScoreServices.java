package com.winmoney.bluelantern.service.score;

import com.winmoney.bluelantern.dto.ScoreDtao;
import com.winmoney.bluelantern.model.Scoreepreuve;
import com.winmoney.bluelantern.model.Scorequiz;

public interface ScoreServices {
    Scorequiz addScorequiz(ScoreDtao scoreDtao);
    Scorequiz listScorequizByUserIdUserId(long id);
    Scoreepreuve addScoreepreuve(ScoreDtao scoreDtao);
    Scoreepreuve listScoreepreuveByUserId(long id);
}
