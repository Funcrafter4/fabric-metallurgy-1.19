package net.metallurgy.metallurgymod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    BRASS(MiningLevels.WOOD, 16, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.BRASS_INGOT)),
    HEPATIZON(MiningLevels.IRON, 301, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.HEPATIZON_INGOT)),
    STEEL(MiningLevels.DIAMOND, 751, 10.0f, 5f, 24, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    DAMASCUS_STEEL(MiningLevels.DIAMOND, 501, 10.0f, 4f, 24, () -> Ingredient.ofItems(ModItems.DAMASCUS_STEEL_INGOT)),
    ANGMALLEN(MiningLevels.IRON, 301, 10.0f, 4f, 24, () -> Ingredient.ofItems(ModItems.ANGMALLEN_INGOT)),
    SILVER(MiningLevels.IRON, 26, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    PLATINUM(MiningLevels.IRON, 101, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.PLATINUM_INGOT)),
    ELECTRUM(MiningLevels.IRON, 101, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.ELECTRUM_INGOT)),
    BRONZE(MiningLevels.IRON, 251, 10.0f, 3f, 24, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
