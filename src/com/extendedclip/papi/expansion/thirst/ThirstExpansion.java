package com.extendedclip.papi.expansion.thirst;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.hmmcrunchy.thirst.Thirst;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class ThirstExpansion extends PlaceholderExpansion {
	
	private Thirst thirst;
	
	@Override
	public boolean canRegister() {
		return (thirst = (Thirst) Bukkit.getPluginManager().getPlugin(getRequiredPlugin())) != null;
	}
	
	@Override
	public String getAuthor() {
		return "clip";
	}
	
	@Override
	public String getIdentifier() {
		return "thirst";
	}
	
	@Override
	public String getRequiredPlugin() {
		return "Thirst";
	}
	
	@Override
	public String getVersion() {
		return "1.2.1";
	}
	
	@Override
	public String onRequest(OfflinePlayer offline, String s) {
		if (offline == null || !offline.isOnline()) {
			return "";
		}
		if (this.thirst == null) {
			return "0";
		}
		try {
			return String.valueOf(this.thirst.checkthirst((Player) offline));
		} catch (Exception ex) {
		}
		return "0";
	}
}
