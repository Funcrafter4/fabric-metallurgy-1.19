package net.metallurgy.metallurgymod.recipe;

import net.metallurgy.metallurgymod.MetallurgyMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MetallurgyMod.MOD_ID, StoneSmelterRecipe.Serializer.ID),
                StoneSmelterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MetallurgyMod.MOD_ID, StoneSmelterRecipe.Type.ID),
                StoneSmelterRecipe.Type.INSTANCE);

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MetallurgyMod.MOD_ID, IronSmelterRecipe.Serializer.ID),
                IronSmelterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MetallurgyMod.MOD_ID, IronSmelterRecipe.Type.ID),
                IronSmelterRecipe.Type.INSTANCE);

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MetallurgyMod.MOD_ID, CrusherBlockRecipe.Serializer.ID),
                CrusherBlockRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MetallurgyMod.MOD_ID, CrusherBlockRecipe.Type.ID),
                CrusherBlockRecipe.Type.INSTANCE);

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MetallurgyMod.MOD_ID, CompressorBlockRecipe.Serializer.ID),
                CompressorBlockRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(MetallurgyMod.MOD_ID, CompressorBlockRecipe.Type.ID),
                CompressorBlockRecipe.Type.INSTANCE);
    }
}
