package com.markwillisford.jpsbase.objects.enums;

import net.minecraft.util.IStringSerializable;

public enum StepOrientation implements IStringSerializable {
	BN("bn"),
	BE("be"),
	BS("bs"),
	BW("bw"),
	TN("tn"),
	TE("te"),
	TS("ts"),
	TW("tw"),
	NE("ne"),
	NW("nw"),
	SE("se"),
	SW("sw");

	private final String name;

	private StepOrientation(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}
}
