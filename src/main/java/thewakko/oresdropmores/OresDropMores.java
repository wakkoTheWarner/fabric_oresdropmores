package thewakko.oresdropmores;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thewakko.oresdropmores.item.ModItems;
import thewakko.oresdropmores.util.LootTableModifiers;

public class OresDropMores implements ModInitializer {
    public static final String MOD_ID = "oresdropmores";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        LootTableModifiers.modifyLootTables();
    }
}
