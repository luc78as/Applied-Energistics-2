package appeng.bootstrap;


import java.util.function.BiConsumer;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import appeng.api.definitions.IBlockDefinition;
import appeng.core.features.AEFeature;


public interface IBlockBuilder
{

	IBlockBuilder preInit( BiConsumer<Block, Item> callback );

	IBlockBuilder init( BiConsumer<Block, Item> callback );

	IBlockBuilder postInit( BiConsumer<Block, Item> callback );

	IBlockBuilder features( AEFeature... features );

	IBlockBuilder addFeatures( AEFeature... features );

	IBlockBuilder rendering( BlockRenderingCustomizer callback );

	/**
	 * Forces this block's item to uses a custom model, instead of using the default block state as the item model.
	 * The model has the same name as the registry name.
	 */
	IBlockBuilder useCustomItemModel();

	IBlockBuilder item( Function<Block, ItemBlock> factory );

	<T extends IBlockDefinition> T build();
}