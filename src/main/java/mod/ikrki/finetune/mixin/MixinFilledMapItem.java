package mod.ikrki.finetune.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.item.FilledMapItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;

import java.util.Objects;

@Mixin(FilledMapItem.class)
public class MixinFilledMapItem{
	@Redirect(method = "updateColors",
	at=@At(value = "INVOKE",target = "Lnet/minecraft/block/BlockState;getMapColor(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/MapColor;"))
	public MapColor reMapColor(BlockState instance, BlockView blockView, BlockPos blockPos){
		if(Objects.equals(Registries.BLOCK.getId(instance.getBlock()).getPath(), "wheat")){
			return MapColor.GOLD;
		}
		else return instance.getMapColor(blockView,blockPos);
	}
}

