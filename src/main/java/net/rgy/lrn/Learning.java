package net.rgy.lrn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.rgy.lrn.block.ModBlocks;
import net.rgy.lrn.component.ModDataComponentTypes;
import net.rgy.lrn.item.ModItemGroups;
import net.rgy.lrn.item.ModItems;
import net.rgy.lrn.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Learning implements ModInitializer {

	public static final String MOD_ID = "lrn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerModDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,988);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}