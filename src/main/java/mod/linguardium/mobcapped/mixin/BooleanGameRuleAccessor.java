package mod.linguardium.mobcapped.mixin;

import net.minecraft.world.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.BooleanRule.class)
public interface BooleanGameRuleAccessor {

    @Invoker("create")
    public static GameRules.Type<GameRules.BooleanRule> MobCapped$create(boolean defaultValue) {
        throw new NotImplementedException("Mixin failed");
     }

}