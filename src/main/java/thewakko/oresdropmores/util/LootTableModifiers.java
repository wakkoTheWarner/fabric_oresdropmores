package thewakko.oresdropmores.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import thewakko.oresdropmores.item.ModItems;

public class LootTableModifiers {
    private static final Identifier COAL_ORE_ID = new Identifier("minecraft", "blocks/coal_ore");
    private static final Identifier DEEPSLATE_COAL_ORE_ID = new Identifier("minecraft", "blocks/deepslate_coal_ore");

    private static final Identifier COPPER_ORE_ID = new Identifier("minecraft", "blocks/copper_ore");
    private static final Identifier DEEPSLATE_COPPER_ORE_ID = new Identifier("minecraft", "blocks/deepslate_copper_ore");

    private static final Identifier LAPIS_ORE_ID = new Identifier("minecraft", "blocks/lapis_ore");
    private static final Identifier DEEPSLATE_LAPIS_ORE_ID = new Identifier("minecraft", "blocks/deepslate_lapis_ore");

    private static final Identifier IRON_ORE_ID = new Identifier("minecraft", "blocks/iron_ore");
    private static final Identifier DEEPSLATE_IRON_ORE_ID = new Identifier("minecraft", "blocks/deepslate_iron_ore");

    private static final Identifier REDSTONE_ORE_ID = new Identifier("minecraft", "blocks/redstone_ore");
    private static final Identifier DEEPSLATE_REDSTONE_ORE_ID = new Identifier("minecraft", "blocks/deepslate_redstone_ore");

    private static final Identifier GOLD_ORE_ID = new Identifier("minecraft", "blocks/gold_ore");
    private static final Identifier DEEPSLATE_GOLD_ORE_ID = new Identifier("minecraft", "blocks/deepslate_gold_ore");

    private static final Identifier DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/deepslate_diamond_ore");

    private static final Identifier EMERALD_ORE_ID = new Identifier("minecraft", "blocks/emerald_ore");
    private static final Identifier DEEPSLATE_EMERALD_ORE_ID = new Identifier("minecraft", "blocks/deepslate_emerald_ore");

    private static final Identifier NETHER_GOLD_ORE_ID = new Identifier("minecraft", "blocks/nether_gold_ore");

    private static final Identifier NETHER_QUARTZ_ORE_ID = new Identifier("minecraft", "blocks/nether_quartz_ore");

    private static final Identifier ANCIENT_DEBRIS_ID = new Identifier("minecraft", "blocks/ancient_debris");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (COAL_ORE_ID.equals(id) || DEEPSLATE_COAL_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.COAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (COPPER_ORE_ID.equals(id) || DEEPSLATE_COPPER_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.RAW_COPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.RAW_COPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.RAW_COPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.RAW_COPPER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (LAPIS_ORE_ID.equals(id) || DEEPSLATE_LAPIS_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.LAPIS_LAZULI))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (IRON_ORE_ID.equals(id) || DEEPSLATE_IRON_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.RAW_IRON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.RAW_IRON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.RAW_IRON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.RAW_IRON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (REDSTONE_ORE_ID.equals(id) || DEEPSLATE_REDSTONE_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.REDSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.REDSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.REDSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.REDSTONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (GOLD_ORE_ID.equals(id) || DEEPSLATE_GOLD_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.RAW_GOLD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.RAW_GOLD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.RAW_GOLD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.RAW_GOLD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (DIAMOND_ORE_ID.equals(id) || DEEPSLATE_DIAMOND_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (EMERALD_ORE_ID.equals(id) || DEEPSLATE_EMERALD_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.EMERALD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.EMERALD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.EMERALD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.EMERALD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (NETHER_GOLD_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (NETHER_QUARTZ_ORE_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Items.QUARTZ))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f, 2.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(Items.QUARTZ))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(Items.QUARTZ))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 2.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(Items.QUARTZ))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }

            if (ANCIENT_DEBRIS_ID.equals(id)) {
                LootPool.Builder regularPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))).invert())
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(ModItems.ANCIENT_DEBRIS_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                LootPool.Builder silkPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(0))))))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(0))))).invert())
                        .with(ItemEntry.builder(Blocks.ANCIENT_DEBRIS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                LootPool.Builder fortuneOnePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(1))))))
                        .with(ItemEntry.builder(ModItems.ANCIENT_DEBRIS_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                LootPool.Builder fortuneTwoPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(2))))))
                        .with(ItemEntry.builder(ModItems.ANCIENT_DEBRIS_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 3.0f)).build());
                LootPool.Builder fortuneThreePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .conditionally(MatchToolLootCondition.builder((ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.exactly(3))))))
                        .with(ItemEntry.builder(ModItems.ANCIENT_DEBRIS_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f)).build());

                tableBuilder.pool(regularPoolBuilder.build());
                tableBuilder.pool(silkPoolBuilder.build());
                tableBuilder.pool(fortuneOnePoolBuilder.build());
                tableBuilder.pool(fortuneTwoPoolBuilder.build());
                tableBuilder.pool(fortuneThreePoolBuilder.build());
            }
        });
    }
}