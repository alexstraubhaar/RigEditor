package alex.rigeditor.data;

/**
 * Created by Alex on 12.11.2015.
 */
public class Control
{
    // Constructor
    public Control(String name, double value, ControlType controlType)
    {
        this.name = name;
        this.value = value;
        this.controlType = controlType;
    }

    //Attributes
    String name;
    double value;
    ControlType controlType;
}
