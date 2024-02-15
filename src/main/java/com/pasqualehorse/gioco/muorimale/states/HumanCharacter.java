package com.pasqualehorse.gioco.muorimale.states;

import java.util.Map;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaEvaluator;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.IntegerNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class HumanCharacter extends DefaultCharacter {

	@Override
	public void apply(ActionResult actionResult) {
		Map<String, RelaxedComparator<?>> applyToContext = actionResult.getApplyToContext();
		applyToContext.forEach((key, value) -> {
			getGameContext().put(key, value);
		});
	}

	public HumanCharacter(HumanCharacterCustomizer customizer) {
		this.getGameContext().put(MONEY_KEY, customizer.getMoney());
		this.getGameContext().put(HIGH_KEY, customizer.getHigh());
		this.getGameContext().put(HP_KEY, customizer.getHp());
		this.getGameContext().put(KARMA_KEY, customizer.getKarma());
	}

	public static class HumanCharacterCustomizer {
		private FloatingPointNumber money;
		private IntegerNumber hp;
		private IntegerNumber high;
		private IntegerNumber karma;

		public static HumanCharacterCustomizer withDefault() {
			return new HumanCharacterCustomizer()
					.withHigh(IntegerNumber.from(0))
					.withHp(IntegerNumber.from(100))
					.withKarma(IntegerNumber.from(0))
					.withMoney(FloatingPointNumber.from(0d));
		}
		
		public HumanCharacter build() {
			return new HumanCharacter(this);
		}

		public HumanCharacterCustomizer withMoney(FloatingPointNumber money) {
			this.money = money;
			return this;
		}

		public HumanCharacterCustomizer withHp(IntegerNumber hp) {
			this.hp = hp;
			return this;
		}

		public HumanCharacterCustomizer withHigh(IntegerNumber high) {
			this.high = high;
			return this;
		}

		public HumanCharacterCustomizer withKarma(IntegerNumber karma) {
			this.karma = karma;
			return this;
		}

		public FloatingPointNumber getMoney() {
			return money;
		}

		public IntegerNumber getHp() {
			return hp;
		}

		public IntegerNumber getHigh() {
			return high;
		}

		public IntegerNumber getKarma() {
			return karma;
		}
	}

	@Override
	public boolean stillAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CriteriaEvaluator getCriteriaEvaluator() {
		return new 
	}
}
