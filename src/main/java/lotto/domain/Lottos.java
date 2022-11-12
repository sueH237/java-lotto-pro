package lotto.domain;

import java.util.*;

public class Lottos{
    List<Lotto> lottoList;
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Map<Rank, Integer> calculateWinResult(Lotto winLotto, LottoNumber bonus) {
        Map<Rank, Integer> rewardMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            Rank rewardType = lotto.findRank(winLotto, bonus);
            rewardMap.put(rewardType, rewardMap.getOrDefault(rewardType, 0) + 1);
        }
        return rewardMap;
    }

    public int size() {
        return lottoList.size();
    }

    public static Lottos buyAutoLottos(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.createLotto());
        }
        return new Lottos(lottoList);
    }

    public static Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> totalLottos = new ArrayList<>();
        totalLottos.addAll(manualLottos.getLottosAsUnmodifiableList());
        totalLottos.addAll(autoLottos.getLottosAsUnmodifiableList());
        return new Lottos(totalLottos);
    }

    public List<Lotto> getLottosAsUnmodifiableList() {
        return Collections.unmodifiableList(lottoList);
    }
}
