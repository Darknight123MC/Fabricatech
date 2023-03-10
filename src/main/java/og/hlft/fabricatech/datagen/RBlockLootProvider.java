package og.hlft.fabricatech.datagen;

import static og.hlft.fabricatech.Fabricatech.asId;

import java.util.function.BiConsumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import og.hlft.fabricatech.common.materials.RMaterial;
import og.hlft.fabricatech.common.materials.RMaterialPart;
import og.hlft.fabricatech.init.RMaterials;

public class RBlockLootProvider extends SimpleFabricLootTableProvider {

    private static BiConsumer<Identifier, LootTable.Builder> consumer;

    public RBlockLootProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> builderBiConsumer) {
        consumer = builderBiConsumer;

        lootMaterial(RMaterials.TIN);
        lootMaterial(RMaterials.LEAD);
        lootMaterial(RMaterials.NICKEL);
        lootMaterial(RMaterials.SILVER);
    }

    protected static void lootMaterial(RMaterial material) {
        for (RMaterialPart part : material.getBlockParts()) {
            if (part == RMaterialPart.ORE || part == RMaterialPart.DEEPSLATE_ORE)
                continue;
            consumer.accept(asId(material.makeRID(part)),
                    LootTable.builder()
                            .pool(LootPool.builder().with(ItemEntry.builder(material.getPartBlock(part)))
                                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
                                    .apply(ExplosionDecayLootFunction.builder())));
        }
    }

}
