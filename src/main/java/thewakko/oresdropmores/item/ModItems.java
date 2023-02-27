package thewakko.oresdropmores.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import thewakko.oresdropmores.OresDropMores;

public class ModItems {
    public static final Item ANCIENT_DEBRIS_SHARD = registerItem("ancient_debris_shard", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OresDropMores.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, ANCIENT_DEBRIS_SHARD);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        OresDropMores.LOGGER.info("Registering Mod Items for " + OresDropMores.MOD_ID);

        addItemsToItemGroup();
    }
}
