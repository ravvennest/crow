package org.bukkit.craftbukkit.block.impl;

import io.papermc.paper.generated.GeneratedFrom;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.bukkit.block.data.Snowable;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.20.4")
@SuppressWarnings("unused")
public class CraftSnowyDirt extends CraftBlockData implements Snowable {
    private static final BooleanProperty SNOWY = SnowyDirtBlock.SNOWY;

    public CraftSnowyDirt(BlockState state) {
        super(state);
    }

    @Override
    public boolean isSnowy() {
        return this.get(SNOWY);
    }

    @Override
    public void setSnowy(final boolean snowy) {
        this.set(SNOWY, snowy);
    }
}