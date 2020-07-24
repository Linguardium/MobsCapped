package mod.linguardium.mobcapped.mixin;

import mod.linguardium.mobcapped.helpers.SpawnHelperInfoInterface;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameRules;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static mod.linguardium.mobcapped.NewGameRules.*;
import static net.minecraft.world.SpawnHelper.spawnEntitiesInChunk;

@Mixin(SpawnHelper.class)
public abstract class SpawnHelperMixin {

    @Shadow
    @Final
    private static int CHUNK_AREA;

    @Shadow @Final private static SpawnGroup[] SPAWNABLE_GROUPS;

    @Shadow
    private static Biome.SpawnEntry pickRandomSpawnEntry(ServerWorld serverWorld, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, SpawnGroup spawnGroup, Random random, BlockPos blockPos) {
        return null;
    }
    @ModifyConstant(method="spawn",constant = @Constant(intValue = 0, ordinal = 0))
    private static int DisableVanillaMobSpawn(int zero) {
        return SPAWNABLE_GROUPS.length;
    }

    @Inject(at=@At(value="INVOKE",target="Lnet/minecraft/util/profiler/Profiler;pop()V"),method="spawn")
    private static void spawngroups(ServerWorld world, WorldChunk chunk, SpawnHelper.Info helperInfo, boolean spawnAnimals, boolean spawnMonsters, boolean shouldSpawnAnimals, CallbackInfo info) {
        boolean perPlayerMobCap = world.getGameRules().getBoolean(PER_PLAYER_MOBCAP_KEY);
        for (SpawnGroup spawnGroup : SPAWNABLE_GROUPS) {
            GameRules.Key<GameRules.IntRule> capKey = null;
            switch(spawnGroup) {
                case MONSTER:
                    capKey=MOBCAP_MONSTERS_KEY;
                    break;
                case CREATURE:
                    capKey=MOBCAP_CREATURES_KEY;
                    break;
                case AMBIENT:
                    capKey=MOBCAP_AMBIENT_KEY;
                    break;
                case WATER_CREATURE:
                    capKey=MOBCAP_AQUATIC_CREATURE_KEY;
                    break;
                case WATER_AMBIENT:
                    capKey=MOBCAP_AQUATIC_AMBIENT_KEY;
                    break;
            }
            if (capKey == null)
                continue;
            int mobcap = world.getGameRules().getInt(capKey);
            if ((spawnAnimals || !spawnGroup.isPeaceful()) && (spawnMonsters || spawnGroup.isPeaceful()) && (shouldSpawnAnimals || !spawnGroup.isAnimal()) && ( ((SpawnHelperInfoInterface)helperInfo).MobCapped$isBelowCap$CustomCapacity(spawnGroup,mobcap,CHUNK_AREA) || perPlayerMobCap)) {
                spawnEntitiesInChunk(spawnGroup, world, chunk, ((SpawnHelperInfoInterface) helperInfo)::PublicTest, ((SpawnHelperInfoInterface) helperInfo)::PublicRun);
            }
        }
    }

    @Redirect(at=@At(value="INVOKE",target="Lnet/minecraft/world/SpawnHelper;pickRandomSpawnEntry(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/world/gen/chunk/ChunkGenerator;Lnet/minecraft/entity/SpawnGroup;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$SpawnEntry;"),method="spawnEntitiesInChunk(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/SpawnHelper$Checker;Lnet/minecraft/world/SpawnHelper$Runner;)V")
    private static Biome.SpawnEntry playerCap(ServerWorld serverWorld, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, SpawnGroup spawnGroup, Random random, BlockPos blockPos) {
        if (serverWorld.getGameRules().getBoolean(PER_PLAYER_MOBCAP_KEY)) {
            GameRules.Key<GameRules.IntRule> capKey = null;
            switch(spawnGroup) {
                case MONSTER:
                    capKey=MOBCAP_MONSTERS_KEY;
                    break;
                case CREATURE:
                    capKey=MOBCAP_CREATURES_KEY;
                    break;
                case AMBIENT:
                    capKey=MOBCAP_AMBIENT_KEY;
                    break;
                case WATER_CREATURE:
                    capKey=MOBCAP_AQUATIC_CREATURE_KEY;
                    break;
                case WATER_AMBIENT:
                    capKey=MOBCAP_AQUATIC_AMBIENT_KEY;
                    break;
            }
            if (capKey != null) {
                int mobCap = serverWorld.getGameRules().getInt(capKey);
                double despawnRange = spawnGroup.getImmediateDespawnRange();
                for (ServerPlayerEntity player : serverWorld.getPlayers(player -> player.squaredDistanceTo(blockPos.getX(), blockPos.getY(), blockPos.getZ()) < despawnRange*despawnRange)) {
                    Box searchBox = new Box(player.getBlockPos()).expand(spawnGroup.getImmediateDespawnRange());


                    if (serverWorld.getEntities((Entity)null,searchBox, entity -> (entity instanceof MobEntity) && entity.getType().getSpawnGroup().equals(spawnGroup) && player.getBlockPos().getSquaredDistance(entity.getX(),entity.getY(),entity.getZ(),false) < despawnRange * despawnRange && !((MobEntity) entity).isPersistent()).size() >= mobCap) {
                        return null;
                    }
                }
            }
        }
        return pickRandomSpawnEntry(serverWorld, structureAccessor, chunkGenerator, spawnGroup, serverWorld.random, blockPos);
    }
}
