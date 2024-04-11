package org.bukkit.craftbukkit.block.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import io.papermc.paper.generated.GeneratedFrom;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Fence;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.20.4")
@SuppressWarnings("unused")
public class CraftIronBars extends CraftBlockData implements Fence {
    private static final BooleanProperty WATERLOGGED = IronBarsBlock.WATERLOGGED;

    private static final Map<BlockFace, BooleanProperty> PROPERTY_BY_DIRECTION = Map.of(
        BlockFace.EAST, IronBarsBlock.EAST,
        BlockFace.NORTH, IronBarsBlock.NORTH,
        BlockFace.SOUTH, IronBarsBlock.SOUTH,
        BlockFace.WEST, IronBarsBlock.WEST
    );

    public CraftIronBars(BlockState state) {
        super(state);
    }

    @Override
    public boolean isWaterlogged() {
        return this.get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(final boolean waterlogged) {
        this.set(WATERLOGGED, waterlogged);
    }

    @Override
    public boolean hasFace(final BlockFace blockFace) {
        Preconditions.checkArgument(blockFace != null, "blockFace cannot be null!");
        BooleanProperty property = PROPERTY_BY_DIRECTION.get(blockFace);
        Preconditions.checkArgument(property != null, "Invalid blockFace, only %s are allowed!", PROPERTY_BY_DIRECTION.keySet().stream().map(Enum::name).collect(Collectors.joining(", ")));
        return this.get(property);
    }

    @Override
    public void setFace(final BlockFace blockFace, final boolean face) {
        Preconditions.checkArgument(blockFace != null, "blockFace cannot be null!");
        BooleanProperty property = PROPERTY_BY_DIRECTION.get(blockFace);
        Preconditions.checkArgument(property != null, "Invalid blockFace, only %s are allowed!", PROPERTY_BY_DIRECTION.keySet().stream().map(Enum::name).collect(Collectors.joining(", ")));
        this.set(property, face);
    }

    @Override
    public Set<BlockFace> getFaces() {
        ImmutableSet.Builder<BlockFace> faces = ImmutableSet.builder();
        for (Map.Entry<BlockFace, BooleanProperty> entry : PROPERTY_BY_DIRECTION.entrySet()) {
            if (this.get(entry.getValue())) {
                faces.add(entry.getKey());
            }
        }
        return faces.build();
    }

    @Override
    public Set<BlockFace> getAllowedFaces() {
        return Collections.unmodifiableSet(PROPERTY_BY_DIRECTION.keySet());
    }
}