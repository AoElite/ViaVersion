/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2024 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.viaversion.protocols.protocol1_20_5to1_20_3.data;

import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingData extends MappingDataBase {

    private KeyMappings items;
    private KeyMappings blocks;

    public MappingData() {
        super("1.20.3", "1.20.5");
    }

    @Override
    protected void loadExtras(final CompoundTag data) {
        super.loadExtras(data);

        final CompoundTag extraMappings = MappingDataLoader.INSTANCE.loadNBT("items-blocks-1.20.3.nbt");
        items = new KeyMappings(extraMappings.getListTag("items", StringTag.class));
        blocks = new KeyMappings(extraMappings.getListTag("blocks", StringTag.class));
    }

    public int itemId(final String name) {
        return items.keyToId(name);
    }

    public @Nullable String itemName(final int id) {
        return items.idToKey(id);
    }

    public int blockId(final String name) {
        return blocks.keyToId(name);
    }

    public @Nullable String blockName(final int id) {
        return blocks.idToKey(id);
    }
}
