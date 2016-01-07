package alex.rigeditor.data;

import android.graphics.Bitmap;

/**
 * Created by Alex on 05.11.2015.
 */
public class Element
{
    // Constructor
    public Element(String brand, String model, Bitmap picture, ElementType elementType)
    {
        this.brand = brand;
        this.model = model;
        this.picture = picture;
        this.elementType = elementType;
    }

    // Attributes
    private String brand;
    private String model;
    private Bitmap picture;
    private ElementType elementType;
}
