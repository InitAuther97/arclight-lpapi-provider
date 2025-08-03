package io.github.initauther97.arclight_lpapi;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArclightLPAPIProvider implements ModInitializer {
	public static final String MOD_ID = "arclight-lpapi";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Arclight LPAPI Provider initializing");
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			Plugin luckperms = Bukkit.getPluginManager().getPlugin("LuckPerms");
			if (luckperms == null) {
				LOGGER.error("Arclight LPAPI Provider cannot find LuckPerms Bukkit plugin. It usually means the plugin is not installed or failed to load correctly.");
				LOGGER.error("Cannot proceed. Shutting down the server.");
				server.stop(false);
			} else {
				LOGGER.info("Find LuckPerms plugin: {}", luckperms);
			}
		});
	}
}