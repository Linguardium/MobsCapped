package mod.linguardium.mobcapped.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mod.linguardium.mobcapped.helpers.SpawnHelperInfoInterface;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnHelper.Info.class)
public abstract class SpawnHelperInfoMixin implements SpawnHelperInfoInterface {

    @Shadow protected abstract boolean isBelowCap(SpawnGroup group);

    @Shadow
    @Final
    private int spawningChunkCount;

    @Shadow
    @Final
    private Object2IntOpenHashMap<SpawnGroup> groupToCount;

    @Shadow
    protected abstract boolean test(EntityType<?> type, BlockPos pos, Chunk chunk);
    @Shadow
    protected abstract void run(MobEntity entity, Chunk chunk);

    @Override
    public boolean MobCapped$checkBelowMobCap(SpawnGroup spawnGroup) {
        return isBelowCap(spawnGroup);
    }

    @Override
    public boolean MobCapped$isBelowCap$CustomCapacity(SpawnGroup group, int capacity, int chunkArea) {
        int i = capacity * this.spawningChunkCount / chunkArea;
        return this.groupToCount.getInt(group) < i;
    }

    @Override
    public boolean PublicTest(EntityType<?> type, BlockPos pos, Chunk chunk) {
        return this.test(type,pos,chunk);
    }

    @Override
    public void PublicRun(MobEntity entity, Chunk chunk) {
        this.run(entity,chunk);
    }
}
