package mod.linguardium.mobcapped;


import net.minecraft.world.GameRules;

public class NewGameRules {
    public static String MOBCAP_MONSTERS = "mobCapMonsters";
    public static String MOBCAP_CREATURES = "mobCapCreatures";
    public static String MOBCAP_AMBIENT = "mobCapAmbient";
    public static String MOBCAP_MISC = "mobCapMisc";
    public static String MOBCAP_AQUATIC_CREATURE = "mobCapAquaticCreature";
    public static String MOBCAP_AQUATIC_AMBIENT = "mobCapAquaticAmbient";
    public static String PER_PLAYER_MOBCAP = "mobCapPerPlayer";

    public static GameRules.Key<GameRules.IntRule> MOBCAP_MONSTERS_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_MONSTERS, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_CREATURES_KEY = new GameRules.Key<>(MOBCAP_CREATURES, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AMBIENT_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AMBIENT, GameRules.Category.MOBS);
    //public static GameRules.Key<GameRules.IntRule> MOBCAP_MISC_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_MISC, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_CREATURE_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AQUATIC_CREATURE, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.IntRule> MOBCAP_AQUATIC_AMBIENT_KEY = new GameRules.Key<GameRules.IntRule>(MOBCAP_AQUATIC_AMBIENT, GameRules.Category.MOBS);
    public static GameRules.Key<GameRules.BooleanRule> PER_PLAYER_MOBCAP_KEY = new GameRules.Key<GameRules.BooleanRule>(PER_PLAYER_MOBCAP, GameRules.Category.MOBS);


    public static void init() {

    }

}
