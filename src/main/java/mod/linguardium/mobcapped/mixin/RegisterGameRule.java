package mod.linguardium.mobcapped.mixin;

import net.minecraft.world.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;

import static mod.linguardium.mobcapped.NewGameRules.*;


@Mixin(GameRules.class)
public class RegisterGameRule{

 /*   @Invoker("register")
    public static <T extends GameRules.Rule<T>> GameRules.Key<T> MobCapped$create(String key, GameRules.Category category, GameRules.Type<T> type) {
        throw new NotImplementedException("GameRules mixin failed");
    }
    static {
        MobCapped$create(MOBCAP_MONSTERS, GameRules.Category.MOBS, IntegerGameRuleAccessor.MobCapped$create(70));
        MobCapped$create(MOBCAP_CREATURES, GameRules.Category.MOBS, IntegerGameRuleAccessor.MobCapped$create(10));
        MobCapped$create(MOBCAP_AMBIENT, GameRules.Category.MOBS, IntegerGameRuleAccessor.MobCapped$create(15));
        MobCapped$create(MOBCAP_AQUATIC_CREATURE, GameRules.Category.MOBS, IntegerGameRuleAccessor.MobCapped$create(5));
        MobCapped$create(MOBCAP_AQUATIC_AMBIENT, GameRules.Category.MOBS, IntegerGameRuleAccessor.MobCapped$create(20));

        MobCapped$create(PER_PLAYER_MOBCAP, GameRules.Category.MOBS, BooleanGameRuleAccessor.MobCapped$create(false));

   }*/
}