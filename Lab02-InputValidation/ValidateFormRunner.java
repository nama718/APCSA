

public class ValidateFormRunner extends ValidateForm
{
    public static void main (String[] args)
    {
        ValidateForm test = new ValidateForm();
        System.out.println(test.isAllAlpha("H754"));
        System.out.println(test.isNumeric("122273438"));

    }
}
