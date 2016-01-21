package alex.rigeditor.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by User on 05.11.2015.
 */
public class Rig implements Serializable
{
    // Constructor
    public Rig(String title)
    {
        this.title = title;
        elements = new TreeMap<String, Element>();
    }

    // Public Methods
    public void addElement(String name, Element newElement)
    {
        elements.put(name, newElement);
    }

    public void delElement(String name)
    {
        elements.remove(name);
    }

    public Map<String, Element> getElements()
    {
        return elements;
    }

    // Attributes
    private String title;
    private Map<String, Element> elements;
}
