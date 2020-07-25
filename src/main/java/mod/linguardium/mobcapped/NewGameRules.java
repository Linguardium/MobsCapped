package mod.linguardium.mobcapped;


import mod.linguardium.mobcapped.mixin.IntegerGameRuleAccessor;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

import static mod.linguardium.mobcapped.Main.MOD_ID;

public class NewGameRules {
    public static CustomGameRuleCategory MobCapCategory = new CustomGameRuleCategory(new Identifier(MOD_ID,"rule_category"),new TranslatableText("gamerule."+MOD_ID+".rule_category").formatted(Formatting.BOLD).formatted(Formatting.YELLOW));
    public static String MOBCAP_MONSTERS = "mobCapMonsters";
    public static String MOBCAP_CREATURES = "mobCapCreatures";
    public static String MOBCAP_AMBIENT = "mobCapAmbient";
    public static String MOBCAP_MISC = "mobCapMisc";
    public static String MOBCAP_AQUATIC_CREATURE = "mobCapAquaticCreature";
    public static String MOBCAP_AQUATIC_AMBIENT = "mobCapAquaticAmbient";
    public static String PER_PLAYER_MOBCAP = "mobCapPerPlayer";

    public static GameRules.Key<GameRules.IntRule> MOBCAP_MONSTERS_KEY = GameRuleRegistry.register(MOBCAP_MONSTERS,MobCapCategory, GameRuleFactory.createIntRule(70));
    public static GameRules.Key<GameRules.IntRule> MOBCAP_CREATURES_KEY = GameRuleRegistry.register(MOBCAP_CREATURES,MobCapCategory, GameRuleFactory.createIntRule(10));
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AMBIENT_KEY = GameRuleRegistry.register(MOBCAP_AMBIENT,MobCapCategory, GameRuleFactory.createIntRule(15));
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_CREATURE_KEY = GameRuleRegistry.register(MOBCAP_AQUATIC_CREATURE,MobCapCategory, GameRuleFactory.createIntRule(5));
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_AMBIENT_KEY = GameRuleRegistry.register(MOBCAP_AQUATIC_AMBIENT,MobCapCategory, GameRuleFactory.createIntRule(20));
    public static GameRules.Key<GameRules.BooleanRule> PER_PLAYER_MOBCAP_KEY = GameRuleRegistry.register(PER_PLAYER_MOBCAP,MobCapCategory, GameRuleFactory.createBooleanRule(false));
    /*
    //    public static GameRules.Key<GameRules.IntRule> MOBCAP_MONSTERS_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_MONSTERS, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_CREATURES_KEY = new GameRules.Key<>(MOBCAP_CREATURES, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AMBIENT_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AMBIENT, GameRules.Category.MOBS);
    //public static GameRules.Key<GameRules.IntRule> MOBCAP_MISC_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_MISC, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_CREATURE_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AQUATIC_CREATURE, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_AMBIENT_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AQUATIC_AMBIENT, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.BooleanRule> PER_PLAYER_MOBCAP_KEY = new GameRules.Key<GameRules.BooleanRule>(PER_PLAYER_MOBCAP, GameRules.Category.MOBS);


     */

    public static void init() {

    }

}
