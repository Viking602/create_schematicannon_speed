package com.viking.lantudapao.mixin;

import com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity;
import com.viking.lantudapao.config.LantuConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SchematicannonBlockEntity.class)
public abstract class SchematicannonBlockEntityMixin {

    @Shadow
    private int printerCooldown;

    /**
     * Intercept the assignment to printerCooldown and modify the delay value.
     * Original: printerCooldown = config().schematicannonDelay.get();
     * Modified: printerCooldown = max(minDelay, originalDelay / speedMultiplier);
     */
    @Redirect(
        method = "tickPrinter",
        at = @At(
            value = "FIELD",
            target = "Lcom/simibubi/create/content/schematics/cannon/SchematicannonBlockEntity;printerCooldown:I",
            opcode = org.objectweb.asm.Opcodes.PUTFIELD,
            ordinal = 0
        )
    )
    private void modifyPrinterCooldown(SchematicannonBlockEntity instance, int originalDelay) {
        int speedMultiplier = LantuConfig.getSpeedMultiplier();
        int minDelay = LantuConfig.getMinDelay();
        int modifiedDelay = Math.max(minDelay, originalDelay / speedMultiplier);
        this.printerCooldown = modifiedDelay;
    }
}
