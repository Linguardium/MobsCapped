package mod.linguardium.mobcapped.mixin;

import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules;

@Mixin(GameRules.IntRule.class)
public interface IntegerGameRuleAccessor {
/*
    @Invoker("create")
    public static GameRules.Type<GameRules.IntRule> MobCapped$create(int defaultValue) {
        throw new NotImplementedException("Mixin failed");
     }
*/
}