package com.pasqualehorse.gioco.muorimale.states;

import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaEvaluator;
import com.pasqualehorse.gioco.muorimale.criteria.DefaultCriteriaEvaluator;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class HumanCharacter extends DefaultCharacter {

	public HumanCharacter(HumanCharacterCustomizer customizer) {
		this.getGameContext().put(MONEY_KEY, customizer.getMoney());
		this.getGameContext().put(HIGH_KEY, customizer.getHigh());
		this.getGameContext().put(HP_KEY, customizer.getHp());
		this.getGameContext().put(KARMA_KEY, customizer.getKarma());
	}

	public final GameContext gameContext = new GameContext();

	public static class HumanCharacterCustomizer {
		private FloatingPointNumber money;
		private FloatingPointNumber hp;
		private FloatingPointNumber high;
		private FloatingPointNumber karma;

		public static HumanCharacterCustomizer withDefault() {
			return new HumanCharacterCustomizer().withHigh(FloatingPointNumber.from(0d))
					.withHp(FloatingPointNumber.from(100d)).withKarma(FloatingPointNumber.from(100d))
					.withMoney(FloatingPointNumber.from(100d));
		}

		public HumanCharacter build() {
			return new HumanCharacter(this);
		}

		public HumanCharacterCustomizer withMoney(FloatingPointNumber money) {
			this.money = money;
			return this;
		}

		public HumanCharacterCustomizer withHp(FloatingPointNumber hp) {
			this.hp = hp;
			return this;
		}

		public HumanCharacterCustomizer withHigh(FloatingPointNumber high) {
			this.high = high;
			return this;
		}

		public HumanCharacterCustomizer withKarma(FloatingPointNumber karma) {
			this.karma = karma;
			return this;
		}

		public FloatingPointNumber getMoney() {
			return money;
		}

		public FloatingPointNumber getHp() {
			return hp;
		}

		public FloatingPointNumber getHigh() {
			return high;
		}

		public FloatingPointNumber getKarma() {
			return karma;
		}
	}

	@Override
	public CriteriaEvaluator getCriteriaEvaluator() {
		return DefaultCriteriaEvaluator.instance();
	}

	@Override
	public GameContext getGameContext() {
		return this.gameContext;
	}

	@Override
	public void apply(ActionResult actionResult) {
		for (Entry<String, RelaxedComparator<?>> entry : actionResult.getApplyToContext().entrySet()) {
			this.getGameContext().get(entry.getKey()).applyChanges(entry.getValue());
		}
	}

	@Override
	public void printStats() {
		for (Entry<String, RelaxedComparator<?>> entry : this.gameContext.entrySet()) {
			System.out.println(entry.getKey() + "="+ entry.getValue().getValue());
		}
	}

}
