
public class Runner extends StringMethods {
    public static void main (String[] args)
    {
        StringMethods test = new StringMethods();
        test.unusualHello("Ron");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.evenFooBar("foobar"));
        System.out.println(test.evenFooBar("candybar"));
        System.out.println(test.sumString("Hi 5 there are 2 or 3 numbers in this String"));
        System.out.println(test.decode("six perfect quality black jewels amazed the governor",
"35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49"));

    }
    
}