package gigaherz.guidebook.guidebook.conditions;

import com.google.common.collect.Maps;
import gigaherz.guidebook.guidebook.BookDocument;
import net.minecraftforge.common.crafting.IConditionFactory;
import org.w3c.dom.Node;

import java.util.Map;

public class ConditionManager
{
    public static final Map<String, IDisplayConditionFactory> REGISTRY = Maps.newHashMap();

    public static void register(String id, IDisplayConditionFactory factory)
    {
        REGISTRY.put(id, factory);
    }

    public static IDisplayCondition parseCondition(BookDocument document, Node node)
    {
        IDisplayConditionFactory factory = REGISTRY.get(node.getNodeName());
        if (factory == null)
            return null;
        return factory.parse(document, node);
    }
}
