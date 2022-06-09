package com.duckblade.osrs.dpscalc.calc.maxhit;

import com.duckblade.osrs.dpscalc.calc.model.Prayer;
import com.duckblade.osrs.dpscalc.calc.util.EffectiveLevelComputable;
import com.duckblade.osrs.dpscalc.calc.model.CombatStyle;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import javax.inject.Singleton;
import net.runelite.api.Skill;

@Singleton
public class MeleeEffectiveStrengthLevelComputable extends EffectiveLevelComputable
{

	@Override
	protected Skill getBaseSkill()
	{
		return Skill.STRENGTH;
	}

	@Override
	protected Prayer.PrayerGroup getPrayerGroup()
	{
		return Prayer.PrayerGroup.MELEE;
	}

	@Override
	protected ToDoubleFunction<Prayer> getPrayerMultiplier()
	{
		return Prayer::getStrengthMod;
	}

	@Override
	protected int getBaseBonus()
	{
		return 8;
	}

	@Override
	protected Map<CombatStyle, Integer> getCombatFocusBonuses()
	{
		return ImmutableMap.of(
			CombatStyle.AGGRESSIVE, 3,
			CombatStyle.CONTROLLED, 1
		);
	}
}